/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.siam.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;
import pe.com.siam.model.business.AdminClinica;
import pe.com.siam.model.pojo.Tespecialidad;
import pe.com.siam.model.pojo.Tpaciente;

/**
 *
 * @author Jean
 */
@ManagedBean
@SessionScoped
public class MBeanReservarCitaMedica {
    private int filtro;
    private String nomxtipo;    
    private Tpaciente p;
    private String nomApe;
    private Integer numh;
    private Integer dni;
    //detalle cita
    private Integer numTurno;
    private String fecha;
    private String horario;
    private Integer codMedico;
    private String especialidad;
    private Double costo;
    private String medico;
    private Integer codDispo;
    private AdminClinica admClinica;
    private String msgOut;
    private String estiloCSS;
    private String estiloIMG;    
    
    @ManagedProperty("#{mBeanConsultarHorario}")
    private MBeanConsultarHorario mbHorarioMedico;
    private List vista;
    
    public MBeanReservarCitaMedica() {
        admClinica = new AdminClinica();
        setNomxtipo("Registrar cita");
        filtro=0;
    }

    public void actualizarBoton(){
        if(filtro==1)nomxtipo="Registrar y cobrar";
        if(filtro==0)nomxtipo="Registrar cita";
    }
    
    public void reservarCita(){
        int dia = mbHorarioMedico.getDiaCal().get(Calendar.DAY_OF_MONTH);
        int mes = (int)(mbHorarioMedico.getDiaCal().get(Calendar.MONTH)+1);
        int ano = mbHorarioMedico.getDiaCal().get(Calendar.YEAR);
        
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String cadenafecha = ano+"-"+mes+"-"+dia;
        Date fechNaci = null;
        try {
            fechNaci = formatDate.parse(cadenafecha);
            msgOut = admClinica.insertarNuevaCita(dni,codDispo,codMedico,new Date(),numTurno,filtro,0,fechNaci,costo);
            
        } catch (ParseException ex) {
            Logger.getLogger(AdminClinica.class.getName()).log(Level.SEVERE, null, ex);
            msgOut = "1Error en conversión de fecha";
        }
        procesarMensaje();
    }
    
    public void cargarPaciente(SelectEvent eventSelect){
        System.out.println("cargandoPaciente");
        Tpaciente pacien;
        pacien = (Tpaciente)eventSelect.getObject();
        nomApe = pacien.getNombres()+" "+pacien.getApellidos();
        numh = pacien.getThistoriaclinica().getNumHistoria();
        dni = pacien.getDni();
//        listOrdeFabr = modeSoli.listarOrdeFabr(numSoli);
//        System.out.print("el # "+numSoli);
//        detalleRender=1;
        System.out.println("dni: "+dni);
        System.out.println("historia: "+numh);
        //System.out.println("num: "+p.getThistoriaclinica().getNumHistoria());
    }
    
    public void cargarDetaCita(SelectEvent eventS){
        System.out.println("cargando detalles de cita");
        System.out.println("Dia DATE: "+mbHorarioMedico.getDia());
        System.out.println("m "+vista.get(0));
        System.out.println("hora "+vista.get(1));
        System.out.println("vacante "+vista.get(2));
        System.out.println("turno: "+vista.get(3));        
        
        vista = (List)eventS.getObject();
        long t =(long)vista.get(3) + 1;
        numTurno = Integer.valueOf(""+t);
        //fecha = ""+mbHorarioMedico.getDia().getDate()+mbHorarioMedico.getDia().g+mbHorarioMedico.getDia().getYear();
        fecha = ""+mbHorarioMedico.getDiaCal().get(Calendar.DAY_OF_MONTH)+"/"+(int)(mbHorarioMedico.getDiaCal().get(Calendar.MONTH)+1)+"/"+mbHorarioMedico.getDiaCal().get(Calendar.YEAR);
        horario = (String) vista.get(1);
        codMedico = (Integer) vista.get(4);
        medico = (String) vista.get(0);
        
        for(Tespecialidad esp:mbHorarioMedico.getEspeList())
            if(esp.getCodEspe() == mbHorarioMedico.getEspe())
                especialidad = esp.getNombre();
        costo = (Double) vista.get(5);
        //De una vez...
        codDispo = (Integer) vista.get(6);
    }
    //Metodos Auxiliares
    public void limpiar(){
        limpiarP();limpiarC();
    }
    public void limpiarP(){
        nomApe="";numh=null;dni=null;
    }
    public void limpiarC(){
        filtro=0;
        numTurno=null;fecha="";horario="";codMedico=null;
        especialidad="";costo=null;medico="";codDispo=null;            
    }
    
    //Setters & Getters
    public int getFiltro() {
        return filtro;
    }

    public void setFiltro(int filtro) {
        this.filtro = filtro;
    }

    public String getNomxtipo() {
        return nomxtipo;
    }

    public void setNomxtipo(String nomxtipo) {
        this.nomxtipo = nomxtipo;
    }

    public Tpaciente getP() {
        return p;
    }

    public void setP(Tpaciente p) {
        this.p = p;
    }

    public String getNomApe() {
        return nomApe;
    }

    public void setNomApe(String nomApe) {
        this.nomApe = nomApe;
    }

    public Integer getNumh() {
        return numh;
    }

    public void setNumh(Integer numh) {
        this.numh = numh;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public MBeanConsultarHorario getMbHorarioMedico() {
        return mbHorarioMedico;
    }

    public void setMbHorarioMedico(MBeanConsultarHorario mbHorarioMedico) {
        this.mbHorarioMedico = mbHorarioMedico;
    }

    public List getVista() {
        return vista;
    }

    public void setVista(List vista) {
        this.vista = vista;
    }

    public Integer getNumTurno() {
        return numTurno;
    }

    public void setNumTurno(Integer numTurno) {
        this.numTurno = numTurno;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String Horario) {
        this.horario = Horario;
    }

    public Integer getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(Integer codMedico) {
        this.codMedico = codMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Integer getCodDispo() {
        return codDispo;
    }

    public void setCodDispo(Integer codDispo) {
        this.codDispo = codDispo;
    }

    public String getMsgOut() {
        return msgOut;
    }

    public void setMsgOut(String msgOut) {
        this.msgOut = msgOut;
    }

    public String getEstiloCSS() {
        return estiloCSS;
    }

    public void setEstiloCSS(String estiloCSS) {
        this.estiloCSS = estiloCSS;
    }

    public String getEstiloIMG() {
        return estiloIMG;
    }

    public void setEstiloIMG(String estiloIMG) {
        this.estiloIMG = estiloIMG;
    }
    
    public void procesarMensaje(){
        System.out.println("Con num: "+msgOut);
        if(msgOut.charAt(0) == '1'){
                System.out.println("Es de error :"+msgOut.charAt(0));
                estiloCSS="error";
                estiloIMG="/resources/images/dedoAbajo.png";
        }
        if(msgOut.charAt(0) == '0'){
                System.out.println("Es de acierto :"+msgOut.charAt(0));
                estiloCSS="noError";
                estiloIMG="/resources/images/dedoArriba.png";
        }
        msgOut = msgOut.substring(1);
        System.out.println("SIN num: "+msgOut);
    }
}
