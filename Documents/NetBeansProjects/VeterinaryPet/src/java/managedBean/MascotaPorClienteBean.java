
package managedBean;

import dao.ClienteDao;
import dao.MascotaDao;
import dao.MascotaPorClienteDao;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class MascotaPorClienteBean {

    private ArrayList listaclientes;
    private ArrayList listamascotas;
    
    private int idCliente;
    private int idMascota;
    
    private Mascotaporcliente mascotaporcliente;
    MascotaporclienteId mascotaporclienteid;

    public MascotaPorClienteBean() {
        listaclientes = new ArrayList();
        mascotaporcliente = new Mascotaporcliente();
        mascotaporclienteid = new MascotaporclienteId();
        listarCombos();
    }
    
    public void listarCombos() {
        ClienteDao clientedao = new ClienteDao();
        MascotaDao mascotadao = new MascotaDao();
        
        listaclientes = clientedao.listarCliente();     
        listamascotas = mascotadao.listarMascotas();
    }
    public String guardar(){
        MascotaPorClienteDao dao= new MascotaPorClienteDao();
        mascotaporclienteid.getIdCliente(idCliente);
        mascotaporclienteid.setIdMascota(idMascota);
        mascotaporcliente.setId(mascotaporclienteid);
        dao.guardarMascotaPorCliente(mascotaporcliente);
        return "/guardarMascotaPorCliente";
    }

    public ArrayList getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList listaclientes) {
        this.listaclientes = listaclientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList getListamascotas() {
        return listamascotas;
    }

    public void setListamascotas(ArrayList listamascotas) {
        this.listamascotas = listamascotas;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public Mascotaporcliente getMascotaporcliente() {
        return mascotaporcliente;
    }

    public void setMascotaporcliente(Mascotaporcliente mascotaporcliente) {
        this.mascotaporcliente = mascotaporcliente;
    }
    
}
