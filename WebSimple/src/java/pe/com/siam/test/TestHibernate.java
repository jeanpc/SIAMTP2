/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.siam.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.HibernateException;
import pe.com.siam.model.dao.CitaMedicaDAO;
import pe.com.siam.model.dao.DisponibilidadCitaMedicaDAO;
import pe.com.siam.model.dao.EnfermedadDAO;
import pe.com.siam.model.dao.PacienteDAO;
import pe.com.siam.model.pojo.Tcitamedica;
import pe.com.siam.model.pojo.TcitamedicaId;
import pe.com.siam.model.pojo.Tdisponibilidadcitamedica;
import pe.com.siam.model.pojo.TdisponibilidadcitamedicaId;
import pe.com.siam.model.pojo.Tenfermedad;
import pe.com.siam.model.pojo.Tpaciente;

/**
 *
 * @author bperez
 */
public class TestHibernate {
   
    public static void recuperarPacienteSimple(){
        PacienteDAO pacdao = new PacienteDAO();

        Tpaciente pac = pacdao.obtenerObjeto(45891391);
        //if(pac instanceof Tpaciente)System.out.println("Se encontro: "+pac.getClass().getName());
        //else System.out.println("No se encontro: "+pac.getClass().getName());
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
    
    public static void registrarEnfermedades(String nom,String dsc){
        EnfermedadDAO enfDAO = new EnfermedadDAO();
        Tenfermedad enf = new Tenfermedad(nom, dsc);
        enfDAO.agregarObjeto(enf);
    }
    
    public static void main(String[] args) throws ParseException {
        Tcitamedica cita = new Tcitamedica();
        CitaMedicaDAO citaDAO = new CitaMedicaDAO();
//        DisponibilidadCitaMedicaDAO dcmDAO = new DisponibilidadCitaMedicaDAO();
//        Tdisponibilidadcitamedica dcm;
//        TdisponibilidadcitamedicaId dispId = new TdisponibilidadcitamedicaId(1, 1);
//
//        dcm = dcmDAO.obtenerPorId(dispId);
        TcitamedicaId citaId = new TcitamedicaId(45891391, 1, 2, new Date());
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String cadenafecha = ("2015-06-30");
        Date fechNaci = formatDate.parse(cadenafecha);
        
        cita.setId(citaId);
        cita.setCosto(10.0);
        cita.setEstadoAtencion(0);
        cita.setEstadoPago(1);
        cita.setFechaCitaProg(fechNaci);
        cita.setNumTurno(5);
        
        citaDAO.agregarObjeto(cita);
//        
//        System.out.println("capacidad: "+dcm.getCapacidad());
//        System.out.println("...por Id: "+dcm.getId().getTdisCodDispo());
//        System.out.println("...por Medico: "+dcm.getTmedico().getCodMedico());
        
        
        
        
        
        
        
        //dis
        
        /*String fecha = "09:00:00-13:00:00";   
        fecha = fecha.substring(0, 5) + fecha.substring(8, 14);//muy bueno soy CsM :v
        System.out.println("F: "+fecha);*/
//        String nom = "Psoriasis2";
//        String dsc = "La psoriasis es una enfermedad de la piel "
//                + "que causa descamación e inflamación (dolor, hinchazón, "
//                + "calentamiento y coloración).";        
//        
//        //registrarEnfermedades(nom, dsc);    
//        recuperarPacienteSimple();
    }    
}
