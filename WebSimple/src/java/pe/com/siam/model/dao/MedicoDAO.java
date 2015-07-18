/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.siam.model.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import pe.com.siam.model.pojo.Tmedico;

/**
 *
 * @author bperez
 */
public class MedicoDAO extends GenericDAO<Tmedico>{
    public List<Tmedico> obtenerMedicoXEspeXDia(int codEsp, String dia){
        String HQL = "select med from Tmedico med inner join med.tdisponibilidadcitamedicas "
                + "meddispcita inner join meddispcita.tdisponibilidad disp with disp.dia = '"+dia+"'\n" +
                "inner join meddispcita.tespecialidad esp with esp.codEspe="+codEsp;
        Query query = getHibernateTemplate().createQuery(HQL);
        session.getTransaction().commit();
        return query.list();
    }
    
    public List<List> infodisponibilidadMedico(int esp,String dia,String fprog){
         String HQL = "select new list (m.nombres || ' ' || m.apellidos , d.horaIni || '-' || d.horaFin , count (cm) || '/' || dcm.capacidad, count(cm), m.codMedico, e.costo, d.codDispo)"
                + "from Tmedico m inner join m.tdisponibilidadcitamedicas dcm inner join dcm.tdisponibilidad d with d.dia  ='"+dia+"'\n" +
                "inner join dcm.tespecialidad e with e.codEspe ="+esp+" left join dcm.tcitamedicas cm with cm.fechaCitaProg = '"+fprog+"'\n" +
                "group by m ";
        Query query = getHibernateTemplate().createQuery(HQL);
        session.getTransaction().commit();
        return query.list();
    }
}
