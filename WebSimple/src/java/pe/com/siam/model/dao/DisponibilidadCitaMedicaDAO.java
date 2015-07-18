/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.siam.model.dao;

import org.hibernate.Query;
import pe.com.siam.model.pojo.Tdisponibilidadcitamedica;
import pe.com.siam.model.pojo.TdisponibilidadcitamedicaId;

/**
 *
 * @author bperez
 */
public class DisponibilidadCitaMedicaDAO extends GenericDAO<Tdisponibilidadcitamedica>{
    
    
    public Tdisponibilidadcitamedica obtenerPorId(TdisponibilidadcitamedicaId id){
        Query query = getHibernateTemplate().getNamedQuery("HQLDisponibilidadCitaMedica")
                .setParameter("codMedi", id.getTmedCodMedico()).setParameter("codDispo", id.getTdisCodDispo());
        return (Tdisponibilidadcitamedica)query.uniqueResult();
    }

}
