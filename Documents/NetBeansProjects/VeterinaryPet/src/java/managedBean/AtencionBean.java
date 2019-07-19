
package managedBean;

import dao.ClienteDao;
import dao.PersonalDao;
import dao.AtencionDao;
import dao.MascotaDao;
//import dao.MascotaPorClienteDao;
import dao.TipoAtencionDao;
import entidades.Cliente;
import entidades.Personal;
import entidades.Atencion;
import entidades.Mascota;
//import entidades.Mascotaporcliente;
//import entidades.MascotaporclienteId;
import entidades.Tipoatencion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;


@ManagedBean
@ViewScoped
public class AtencionBean implements Serializable{
    
    private Atencion atencion;
    private Mascota mascota;
    private Tipoatencion tipoatencion;
    private Personal personal;
    private Cliente cliente;
    
    private ArrayList listaclientes;
   // private ArrayList listaMascotapor;
    private ArrayList listamascotas;
   // private ArrayList listaCliente;
    private ArrayList listarPersonal;
    private ArrayList  listartipoatencion;
    
    private boolean banderaSelect = false;
    private final Date date=new Date();
    private int idPersonal;
    private int idCliente;
    private int idMascota;
    private int idTipoAtencion;
    
    //private Mascotaporcliente mascotaporcliente;
  //  private MascotaporclienteId mascotaporclienteid;
    
    public void ListarCombos(){
      //  MascotaPorClienteDao mascotaPorClienteDao=new MascotaPorClienteDao();
        PersonalDao personaldao= new PersonalDao();
        MascotaDao mascotaDao=new MascotaDao();
        ClienteDao clientedao= new ClienteDao();
        TipoAtencionDao tipoAtencionDao=new TipoAtencionDao();
        
        listarPersonal= personaldao.listarPersonal();
        listaclientes= clientedao.listarCliente();
        listamascotas=mascotaDao.listarMascotas();
        listartipoatencion=tipoAtencionDao.listarTipoAtencion();
       // listaMascota=mascotaPorClienteDao.listarMascotaPorClientes();
      
    }
    
    public AtencionBean() {
        this.atencion = new Atencion();
      //  mascotaporcliente = new Mascotaporcliente();
      //  mascotaporclienteid = new MascotaporclienteId();
        
        listaclientes=new ArrayList();
        listarPersonal = new ArrayList();
        listamascotas=new ArrayList();
        listartipoatencion=new ArrayList();
        personal = new Personal();
        cliente = new Cliente();
        mascota=new Mascota();
        tipoatencion=new Tipoatencion();
        
        ListarCombos();
    }

    public Atencion getAtencion() {
        return atencion;
    }

    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }

    public String guardarAtencion() {
        try {

            AtencionDao atencionDao = new AtencionDao();
        //    mascotaporclienteid.setClienteIdCliente(idCliente);
            personal.setIdPersonal(idPersonal);
           // mascotaporclienteid.setMascotaIdMascota(idMascota);
            tipoatencion.setIdTipoAtencion(idTipoAtencion);
         //   mascotaporcliente.setId(mascotaporclienteid);
            atencion.setHoraAtencion(date);
            atencion.setTipoatencion(tipoatencion);
          //  atencion.setMascotaporcliente(mascotaporcliente);
            atencion.setPersonal(personal);
           
            
            boolean respuesta = atencionDao.guardarAtencion(atencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/Atencion";
    }

    public String actualizarAtencion() {
        try {
            AtencionDao atencionDao = new AtencionDao();
            boolean respuesta = atencionDao.actualizarAtencion(atencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/Atencion";

    }

    public ArrayList<Atencion> listarAtencions() {
        ArrayList<Atencion> lista = new ArrayList<>();
        AtencionDao atencionDao = new AtencionDao();
        lista = atencionDao.listarAtencion();
        return lista;
    }

    public String eliminar() {
        AtencionDao atencionDao = new AtencionDao();
        boolean respuesta = atencionDao.eliminarAtencion(atencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/Atencion";
    }
    
    public String limpiar() {
        return "/Atencion";
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

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   // public ArrayList getListaCliente() {
  //      return listaCliente;
  //  }

  //  public void setListaCliente(ArrayList listaCliente) {
  //      this.listaCliente = listaCliente;
 //   }

    public ArrayList getListarPersonal() {
        return listarPersonal;
    }

    public void setListarPersonal(ArrayList listaPersonal) {
        this.listarPersonal = listaPersonal;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

  //  public MascotaporclienteId getMascotaporclienteid() {
  //      return mascotaporclienteid;
  //  }

  //  public void setMascotaporclienteid(MascotaporclienteId mascotaporclienteid) {
  //      this.mascotaporclienteid = mascotaporclienteid;
  //  }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }

    public ArrayList getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList listaclientes) {
        this.listaclientes = listaclientes;
    }

    public ArrayList getListamascotas() {
        return listamascotas;
    }

    public void setListamascotas(ArrayList listamascotas) {
        this.listamascotas = listamascotas;
    }

    public ArrayList getListartipoatencion() {
        return listartipoatencion;
    }

    public void setListartipoatencion(ArrayList listartipoatencion) {
        this.listartipoatencion = listartipoatencion;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdTipoAtencion() {
        return idTipoAtencion;
    }

    public void setIdTipoAtencion(int idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }

  //  public Mascotaporcliente getMascotaporcliente() {
   //     return mascotaporcliente;
  //  }

  //  public void setMascotaporcliente(Mascotaporcliente mascotaporcliente) {
  //      this.mascotaporcliente = mascotaporcliente;
  //  }

   // public ArrayList getListaMascotapor() {
  //      return listaMascotapor;
   // }

   // public void setListaMascotapor(ArrayList listaMascotapor) {
   //     this.listaMascotapor = listaMascotapor;
   // }
    
}
