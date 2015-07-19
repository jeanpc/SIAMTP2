/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.siam.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pe.com.siam.model.pojo.Tpaciente;

/**
 *
 * @author Jean
 */
@ManagedBean
@SessionScoped
public class MBeanRegistrarResultadoExamen {
  
    private String nomxtipo;    
    private Tpaciente p;
    
    public MBeanRegistrarResultadoExamen() {
     
               
    }
    public void cargarPaciente(){
        System.out.println("cargandoPaciente");

        System.out.println("dni: "+p.getDni());   
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
}
  