/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.siam.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pe.com.siam.model.business.AdminClinica;
import pe.com.siam.model.pojo.Tpaciente;

/**
 *
 * @author Jean
 */
@ManagedBean
@SessionScoped
public class MBeanBuscarPaciente {
    private int filtro;
    private int numHxorD;
    private List<Tpaciente> pacientes;
    private AdminClinica admClinica;
    public MBeanBuscarPaciente() {
        System.out.println("Intancia: "+this.getClass().getName());
        admClinica = new AdminClinica();
    }
    
    public void buscarPaciente(){
            pacientes = admClinica.cargarPacientes(filtro, numHxorD);
    }

    
    public int getFiltro() {
        return filtro;
    }

    public void setFiltro(int filtro) {
        this.filtro = filtro;
    }

    public int getNumHxorD() {
        return numHxorD;
    }

    public void setNumHxorD(int numHxorD) {
        this.numHxorD = numHxorD;
    }

    public List<Tpaciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Tpaciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    
}
