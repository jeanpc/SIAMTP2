package pe.com.siam.model.pojo;
// Generated 12/07/2015 07:32:20 PM by Hibernate Tools 4.3.1



/**
 * Tusuario generated by hbm2java
 */
public class Tusuario  implements java.io.Serializable {


     private String idtusuario;
     private Trol trol;
     private String password;

    public Tusuario() {
    }

	
    public Tusuario(String idtusuario, Trol trol) {
        this.idtusuario = idtusuario;
        this.trol = trol;
    }
    public Tusuario(String idtusuario, Trol trol, String password) {
       this.idtusuario = idtusuario;
       this.trol = trol;
       this.password = password;
    }
   
    public String getIdtusuario() {
        return this.idtusuario;
    }
    
    public void setIdtusuario(String idtusuario) {
        this.idtusuario = idtusuario;
    }
    public Trol getTrol() {
        return this.trol;
    }
    
    public void setTrol(Trol trol) {
        this.trol = trol;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


