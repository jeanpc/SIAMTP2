/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.siam.model.dao;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pe.com.siam.model.pojo.Tpaciente;

/**
 *
 * @author bperez
 */
public class PacienteDAO extends GenericDAO<Tpaciente>{
   
    public Tpaciente obtenerPorNumHistoria(int num_historia){
        Criteria criPac = getHibernateTemplate().createCriteria(Tpaciente.class);
        Criteria prdCriPac = criPac.createCriteria("thistoriaclinica");
        prdCriPac.add(Restrictions.eq("numHistoria", num_historia));
        List results = prdCriPac.list();
        Iterator iter = results.iterator();
        if(!iter.hasNext()){
            session.getTransaction().commit();
            return null;
        }
        session.getTransaction().commit();
        return (Tpaciente)iter.next();
    } 
}
