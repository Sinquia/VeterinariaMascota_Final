package entidades;
// Generated 17/07/2019 08:10:08 PM by Hibernate Tools 4.3.1


import java.util.Date;


public class Reservacita  implements java.io.Serializable {


     private int idReservaCita;
     private Cliente cliente;
     private Tiporeserva tiporeserva;
     private Usuario usuario;
     private Date fecha;

    public Reservacita() {
    }

    public Reservacita(int idReservaCita, Cliente cliente, Tiporeserva tiporeserva, Usuario usuario, Date fecha) {
       this.idReservaCita = idReservaCita;
       this.cliente = cliente;
       this.tiporeserva = tiporeserva;
       this.usuario = usuario;
       this.fecha = fecha;
    }
   
    public int getIdReservaCita() {
        return this.idReservaCita;
    }
    
    public void setIdReservaCita(int idReservaCita) {
        this.idReservaCita = idReservaCita;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Tiporeserva getTiporeserva() {
        return this.tiporeserva;
    }
    
    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


