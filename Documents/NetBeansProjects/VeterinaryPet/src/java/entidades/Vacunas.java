package entidades;
// Generated 17/07/2019 08:10:08 PM by Hibernate Tools 4.3.1



/**
 * Vacunas generated by hbm2java
 */
public class Vacunas  implements java.io.Serializable {


     private int idVacunas;
     private String tipoVacuna;
     private Integer edadMascota;
     private String precio;

    public Vacunas() {
    }

	
    public Vacunas(int idVacunas) {
        this.idVacunas = idVacunas;
    }
    public Vacunas(int idVacunas, String tipoVacuna, Integer edadMascota, String precio) {
       this.idVacunas = idVacunas;
       this.tipoVacuna = tipoVacuna;
       this.edadMascota = edadMascota;
       this.precio = precio;
    }
   
    public int getIdVacunas() {
        return this.idVacunas;
    }
    
    public void setIdVacunas(int idVacunas) {
        this.idVacunas = idVacunas;
    }
    public String getTipoVacuna() {
        return this.tipoVacuna;
    }
    
    public void setTipoVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }
    public Integer getEdadMascota() {
        return this.edadMascota;
    }
    
    public void setEdadMascota(Integer edadMascota) {
        this.edadMascota = edadMascota;
    }
    public String getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(String precio) {
        this.precio = precio;
    }




}


