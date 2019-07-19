
package managedBean;

import dao.VacunaDao;
import entidades.Vacunas;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author SINQUIA
 */
@ManagedBean
@ViewScoped
public class VacunasBean {
    
    private Vacunas vacunas;
    private VacunaDao vacunaDao;
    private boolean respuesta;
    private boolean banderaSelect = false;
    
     public VacunasBean() {
         this.vacunas = new Vacunas();
    }
    
    public void banderaSelect(){
        banderaSelect = true;
    }
    
    public ArrayList<Vacunas> listarVacunas() {

        ArrayList<Vacunas> list = new ArrayList<>();
        vacunaDao = new VacunaDao();
        list = vacunaDao.listarVacuna();
        return list;

    }

    public String InsertarVacuna() {

        vacunaDao = new VacunaDao();
        respuesta = vacunaDao.InsertarVacuna(vacunas);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar"));
        }
        return "/IVacunas";

    }

    public String clean() {
        return "/IVacunas";
    }

    public String GuardarVacuna() {

        vacunaDao = new VacunaDao();
        respuesta = vacunaDao.GuardarVacuna(vacunas);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al guardar"));
        }
        return "/IVacunas";

    }

    public String EliminarVacuna(Vacunas vacunas) {

        vacunaDao = new VacunaDao();
        respuesta = vacunaDao.EliminarVacuna(vacunas);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al eliminar"));
        }
        return "/IVacuna";

    }

    public Vacunas getVacuna() {
        return vacunas;
    }

    public void setVacuna(Vacunas vacunas) {
        this.vacunas = vacunas;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
    
}
