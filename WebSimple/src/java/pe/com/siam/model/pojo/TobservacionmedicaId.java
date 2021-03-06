package pe.com.siam.model.pojo;
// Generated 06/06/2015 01:03:46 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * TobservacionmedicaId generated by hbm2java
 */
public class TobservacionmedicaId  implements java.io.Serializable {


     private Date tdhFechaAtencion;
     private int tdhThistoriaPacienteDni;

    public TobservacionmedicaId() {
    }

    public TobservacionmedicaId(Date tdhFechaAtencion, int tdhThistoriaPacienteDni) {
       this.tdhFechaAtencion = tdhFechaAtencion;
       this.tdhThistoriaPacienteDni = tdhThistoriaPacienteDni;
    }
   
    public Date getTdhFechaAtencion() {
        return this.tdhFechaAtencion;
    }
    
    public void setTdhFechaAtencion(Date tdhFechaAtencion) {
        this.tdhFechaAtencion = tdhFechaAtencion;
    }
    public int getTdhThistoriaPacienteDni() {
        return this.tdhThistoriaPacienteDni;
    }
    
    public void setTdhThistoriaPacienteDni(int tdhThistoriaPacienteDni) {
        this.tdhThistoriaPacienteDni = tdhThistoriaPacienteDni;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TobservacionmedicaId) ) return false;
		 TobservacionmedicaId castOther = ( TobservacionmedicaId ) other; 
         
		 return ( (this.getTdhFechaAtencion()==castOther.getTdhFechaAtencion()) || ( this.getTdhFechaAtencion()!=null && castOther.getTdhFechaAtencion()!=null && this.getTdhFechaAtencion().equals(castOther.getTdhFechaAtencion()) ) )
 && (this.getTdhThistoriaPacienteDni()==castOther.getTdhThistoriaPacienteDni());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTdhFechaAtencion() == null ? 0 : this.getTdhFechaAtencion().hashCode() );
         result = 37 * result + this.getTdhThistoriaPacienteDni();
         return result;
   }   


}


