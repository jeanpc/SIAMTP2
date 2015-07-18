/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.siam.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pe.com.siam.model.business.AdminClinica;

/**
 *
 * @author bperez
 */
@ManagedBean
@SessionScoped
public class MBeanAperturarHistoriaClinica implements Serializable{
    private String nomb;
    private String apellPate;
    private String apellMate;
    private int dni;
    private String sexo;
    private String estaCivil;
    private Date fechNaci;
    private String dia;
    private String mes;
    private String ano;
    private String lugaNaci;
    private String direccion;
    private long numHistoria;
    private int celular;
    private String msgOut;
    private String estiloCSS;
    private String estiloIMG;
    
    AdminClinica admClinica;
    
    public MBeanAperturarHistoriaClinica() {
        admClinica = new AdminClinica();
        limpiar();
        setNumHistoria(admClinica.nuevoNumHis());
        System.out.println("EL nUm Historia es... "+numHistoria);
    }

    public void registrarPaciente(){
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            String cadenafecha = (ano+"-"+"-"+mes+"-"+dia);
            fechNaci = formatDate.parse(cadenafecha);
            System.out.println("Dia: "+dia);
            System.out.println("Mes: "+mes);
            System.out.println("Año: "+ano);
            System.out.println("Sexo: "+sexo);
            System.out.println("ECivil: "+estaCivil);
            System.out.println("FECHA PARSEADA: "+fechNaci.toString());
            msgOut = admClinica.insertarNuevoPaciente(nomb, apellPate, apellMate, dni, sexo,
                    estaCivil, fechNaci, lugaNaci, direccion, celular);
        } catch (ParseException ex) {
            msgOut = "1Error en registro de fecha";//msgOut = "1Error en registro de fecha";
            Logger.getLogger(MBeanAperturarHistoriaClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        //msgOut = msgOut.substring(1);
        procesarMensaje();
    }
    
    public void mostrarPaciente(){
        System.out.println("Entre al Controlador");
        admClinica.recuperarPacienteSimple();
    }
    //Metodos Auxiliares
    public void limpiar(){
        nomb="";apellPate="";apellMate="";dni=0;
        sexo="";estaCivil="";dia="";mes="";ano="";
        lugaNaci="";direccion="";numHistoria=0;celular=0;
    }

    //Getters & Setters
    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getApellPate() {
        return apellPate;
    }

    public void setApellPate(String apellPate) {
        this.apellPate = apellPate;
    }

    public String getApellMate() {
        return apellMate;
    }

    public void setApellMate(String apellMate) {
        this.apellMate = apellMate;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstaCivil() {
        return estaCivil;
    }

    public void setEstaCivil(String estaCivil) {
        this.estaCivil = estaCivil;
    }

    public Date getFechNaci() {
        return fechNaci;
    }

    public void setFechNaci(Date fechNaci) {
        this.fechNaci = fechNaci;
    }

        public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getLugaNaci() {
        return lugaNaci;
    }

    public void setLugaNaci(String lugaNaci) {
        this.lugaNaci = lugaNaci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getNumHistoria() {
        return numHistoria;
    }

    public void setNumHistoria(long numHistoria) {
        this.numHistoria = numHistoria;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
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