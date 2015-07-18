package pe.com.siam.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pe.com.siam.model.business.AdminClinica;
import pe.com.siam.model.pojo.Tespecialidad;
import pe.com.siam.model.pojo.Tmedico;

/**
 *
 * @author bperez
 */
@ManagedBean
@SessionScoped
public class MBeanConsultarHorario {

    private Integer espe;
    private String medi;
    private Date dia;
    private Calendar diaCal = Calendar.getInstance();
    private AdminClinica admClinica;
    private List<List> infoDisp;

    private List<Tespecialidad> espeList;
    
    public MBeanConsultarHorario() {
        admClinica = new AdminClinica();
        //cargarEspecialidades();
    }
    //Probando el postConstruct
    @PostConstruct
    public void cargarEspecialidades(){
        espeList = admClinica.obtenerEspecialidades();
    }
    
    public void cargarTabla(){
        System.out.println("La espe elegida: "+espe);
        //System.out.println("Dia elegido1:"+dia);
        diaCal.setTime(dia);
        System.out.println("Dia elegido2:"+diaCal.toString());
        System.out.println("Dia elegido3:"+diaCal.getCalendarType());
        System.out.println("el dia D: "+(diaCal.get(Calendar.DAY_OF_WEEK)-1));
        System.out.println("el mes M: "+(diaCal.get(Calendar.MONTH)+1));
        System.out.println("el año Y: "+diaCal.get(Calendar.YEAR));
        
//        List<Tmedico> mediList = admClinica.obtenerMedicos(espe,diaCal.get(Calendar.DAY_OF_WEEK)-1);
//        for(Tmedico m:mediList)
//            listMedi.put(m.getApellidos(),""+m.getCodMedico());
        infoDisp = admClinica.infoDisponibilidadMedico(espe,diaCal);
        for(List o:infoDisp){
            System.out.println("Nombre: "+o.get(0));
        }
    }

    public Integer getEspe() {
        return espe;
    }

    public void setEspe(Integer espe) {
        this.espe = espe;
    }

    public String getMedi() {
        return medi;
    }

    public void setMedi(String medi) {
        this.medi = medi;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public List<List> getInfoDisp() {
        return infoDisp;
    }

    public void setInfoDisp(List<List> infoDisp) {
        this.infoDisp = infoDisp;
    }

    public Calendar getDiaCal() {
        return diaCal;
    }

    public void setDiaCal(Calendar diaCal) {
        this.diaCal = diaCal;
    }

    public List<Tespecialidad> getEspeList() {
        return espeList;
    }

    public void setEspeList(List<Tespecialidad> espeList) {
        this.espeList = espeList;
    }

    
}
