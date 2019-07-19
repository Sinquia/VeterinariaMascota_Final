
package managedBean;


import dao.TipoAtencionDao;
import entidades.Tipoatencion;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author SINQUIA
 */
@ManagedBean
@ViewScoped
public class TipoAtencionBean implements Serializable {

  
    private Tipoatencion tipoatencion;
    private boolean banderaSelect = false;

    public TipoAtencionBean() {
        this.tipoatencion = new Tipoatencion();

  
    }

    public String guardarTipoAtencion() {
        try {

            TipoAtencionDao tipoatencionDao = new TipoAtencionDao();
            boolean respuesta = tipoatencionDao.guardarTipoAtencion(tipoatencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/TipoAtencion";
    }

    public String actualizarTipoAtencion() {
        try {
            TipoAtencionDao tipoatencionDao = new TipoAtencionDao();
            boolean respuesta = tipoatencionDao.actualizarTipoAtencion(tipoatencion);
            if (respuesta){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/TipoAtencion";

    }

    public ArrayList<Tipoatencion> listarTipoAtencions() {
        ArrayList<Tipoatencion> lista = new ArrayList<>();
        TipoAtencionDao tipoatencionDao = new TipoAtencionDao();
        lista = tipoatencionDao.listarTipoAtencion();
        return lista;
    }

    public String eliminar() {
        TipoAtencionDao tipoatencionDao = new TipoAtencionDao();
        boolean respuesta = tipoatencionDao.eliminarTipoAtencion(tipoatencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/TipoAtencion";
    }

    public String limpiar() {
        return "/TipoAtencion";
    }
    
    public void selectBandera(){
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }


}
