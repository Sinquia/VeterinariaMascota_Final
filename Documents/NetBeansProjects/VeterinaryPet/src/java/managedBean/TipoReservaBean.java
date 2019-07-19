
package managedBean;

import dao.TiporeservaDao;
import entidades.Tiporeserva;
import entidades.Tiporeserva;
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
public class TipoReservaBean implements Serializable {

  
    private Tiporeserva tiporeserva;
    private boolean banderaSelect = false;

    public TipoReservaBean() {
        this.tiporeserva = new Tiporeserva();

  
    }

    public String guardarTiporeserva() {
        try {

            TiporeservaDao tiporeservaDao = new TiporeservaDao();
            boolean respuesta = tiporeservaDao.guardarTiporeserva(tiporeserva);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/TipoReserva";
    }

    public String actualizarTiporeserva() {
        try {
            TiporeservaDao tiporeservaDao = new TiporeservaDao();
            boolean respuesta = tiporeservaDao.actualizarTiporeserva(tiporeserva);
            if (respuesta){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/TipoReserva";

    }

    public ArrayList<Tiporeserva> listarTiporeservas() {
        ArrayList<Tiporeserva> lista = new ArrayList<>();
        TiporeservaDao tiporeservaDao = new TiporeservaDao();
        lista = tiporeservaDao.listarTiporeserva();
        return lista;
    }

    public String eliminar() {
        TiporeservaDao tiporeservaDao = new TiporeservaDao();
        boolean respuesta = tiporeservaDao.eliminarTiporeserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/TipoReserva";
    }

    public String limpiar() {
        return "/TipoReserva";
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

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

}
