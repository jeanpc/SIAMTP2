/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.siam.model.dao;

import java.util.List;
import org.hibernate.Query;
import pe.com.siam.model.pojo.Tespecialidad;

/**
 *
 * @author bperez
 */
public class EspecialidadDAO extends GenericDAO<Tespecialidad>{
    
    public List<Tespecialidad> obtenerEspecialidadDisponible(){
        Query query = getHibernateTemplate().getNamedQuery("HQLEspecialidadDisponible");
        session.getTransaction().commit();
        return query.list();
    }
}
