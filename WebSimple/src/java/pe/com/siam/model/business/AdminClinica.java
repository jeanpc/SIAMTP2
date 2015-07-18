/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.siam.model.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import pe.com.siam.model.dao.CitaMedicaDAO;
import pe.com.siam.model.dao.EspecialidadDAO;
import pe.com.siam.model.dao.HistoriaClinicaDAO;
import pe.com.siam.model.dao.MedicoDAO;
import pe.com.siam.model.dao.PacienteDAO;
import pe.com.siam.model.pojo.Tcitamedica;
import pe.com.siam.model.pojo.TcitamedicaId;
import pe.com.siam.model.pojo.Tenfermedad;
import pe.com.siam.model.pojo.Tespecialidad;
import pe.com.siam.model.pojo.Thistoriaclinica;
import pe.com.siam.model.pojo.Tmedico;
import pe.com.siam.model.pojo.Tpaciente;

/**
 *
 * @author bperez
 */
public class AdminClinica {
    
    public AdminClinica() {
    }

    public String insertarNuevaCita(int dni, int codD, int codM,Date fcrea,int numT,int stdPago, int stdAten,
            Date fcitaProg,Double costo){
        CitaMedicaDAO citaDAO = new CitaMedicaDAO();
        TcitamedicaId citaId = new TcitamedicaId(dni, codD, codM, fcrea); 
        Tcitamedica cita = new Tcitamedica(citaId, numT, stdPago, stdAten, fcitaProg,costo);
        
        if(!citaDAO.agregarObjeto(cita))
            return "1Error en creación de cita";//return "1Error en creación de cita";
        return "0Se ha creado una nueva cita correctamente";//return "Se ha creado una nueva cita correctamente";
    }
    
    public String insertarNuevoPaciente(String n, String ap, String am, int dni,String sx, String ec,
                                Date fn, String ln,String dir, int cel){
        //pendiente, ingreso de parametros.
        PacienteDAO pacDAO = new PacienteDAO();
        HistoriaClinicaDAO hisDAO = new HistoriaClinicaDAO();
        
        Tpaciente pa = new Tpaciente();
        pa.setNombres(n);pa.setApellidos(ap+" "+am);pa.setDni(dni);
        pa.setSexo(sx);pa.setEstadoCivil(ec);pa.setFechaNac(fn);
        pa.setLugarNac(ln);pa.setDireccion(dir);pa.setCelular(cel);
        //Creamos la tabla Thistoriaclinica que es dependiente de paciente
        Thistoriaclinica his = new Thistoriaclinica(pa,new Date());
        //pa.setThistoriaclinica(his);No es necesario la relacion bidireccional
        if(!pacDAO.agregarObjeto(pa))
            return "1Este paciente ya se encuentra registrado";//Es necesario insertar ambas tablas manualmente
        hisDAO.agregarObjeto(his);//Es necesario insertar ambas tablas manualmente
        //return "0Paciente registrado correctamente";
        return "0Paciente registrado correctamente";
    }
    
    public List<Tpaciente> cargarPacientes(int filtro,int num){
        PacienteDAO pacDAO = new PacienteDAO();
        List<Tpaciente> listPac = new ArrayList<>();
        if(filtro == 1){
            listPac.add(pacDAO.obtenerPorNumHistoria(num));
            return listPac;
        }
        if(filtro == 2){
            listPac.add(pacDAO.obtenerObjeto(num));
            return listPac;
        }
        if(filtro == 3)
            return pacDAO.obtenerListaObjetos();
        return null;
    }
    
    public void recuperarPacienteSimple(){
        System.out.println("Entre al modelo");
        PacienteDAO pacdao = new PacienteDAO();
        System.out.println("Cree un PacienteDAO");
        Tpaciente pac = pacdao.obtenerObjeto(45891391);
        System.out.println("Obtengo el paciente");
        try {
            System.out.println("naci en: "+pac.getLugarNac());
            System.out.println("me registre el: "+pac.getThistoriaclinica().getFechaCreacion());
            Set efrmds = pac.getThistoriaclinica().getTenfermedads();
            Iterator<Tenfermedad> it = efrmds.iterator();
            while (it.hasNext()) {
                System.out.println("padesco de: "+it.next().getNombre());   
            }            
        } catch (HibernateException HEx) {
            System.out.println("Paciente no encontrado");
        }
    }
    
    public List<Tespecialidad> obtenerEspecialidades(){
        EspecialidadDAO espDAO = new EspecialidadDAO();
        return espDAO.obtenerEspecialidadDisponible();
    }
    
    public List<Tmedico> obtenerMedicos(String espe, int dia){
        
        MedicoDAO medDAO = new MedicoDAO();
        return medDAO.obtenerMedicoXEspeXDia(Integer.parseInt(espe),""+dia);
        //return medDAO.obtenerListaObjetos();
    }
    
    public List<List> infoDisponibilidadMedico(int espe, Calendar fprog){
        MedicoDAO medDAO = new MedicoDAO();
        String f = fprog.get(Calendar.YEAR)+"-"+(fprog.get(Calendar.MONTH)+1)+"-"+fprog.get(Calendar.DAY_OF_MONTH);
        List<List> list = medDAO.infodisponibilidadMedico(espe,""+(fprog.get(Calendar.DAY_OF_WEEK)-1),f);
        int cont=0;
        for(List l:list){
            String auxf = (String) l.get(1);
            auxf = auxf.substring(0, 5) + auxf.substring(8, 14);
            list.get(cont).set(1, auxf);
            cont++;
        }
        return list;
    }
    
    public long nuevoNumHis(){
        long num;
        PacienteDAO pacDAO = new PacienteDAO();
        num = pacDAO.tamañoLista()+1;
        System.out.println("Historia!!! "+num);
        return num;
    }
}
