package pe.com.siam.model.pojo;
// Generated 12/07/2015 07:32:20 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Toperacion generated by hbm2java
 */
public class Toperacion  implements java.io.Serializable {


     private int idtoperacion;
     private String nombre;
     private Set trols = new HashSet(0);

    public Toperacion() {
    }

	
    public Toperacion(int idtoperacion) {
        this.idtoperacion = idtoperacion;
    }
    public Toperacion(int idtoperacion, String nombre, Set trols) {
       this.idtoperacion = idtoperacion;
       this.nombre = nombre;
       this.trols = trols;
    }
   
    public int getIdtoperacion() {
        return this.idtoperacion;
    }
    
    public void setIdtoperacion(int idtoperacion) {
        this.idtoperacion = idtoperacion;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getTrols() {
        return this.trols;
    }
    
    public void setTrols(Set trols) {
        this.trols = trols;
    }




}


