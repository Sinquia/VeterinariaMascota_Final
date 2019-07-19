package interfaces;

import entidades.Vacunas;
import java.util.ArrayList;

public interface IVacunas {
    
    public abstract ArrayList<Vacunas> listarVacuna();
    
    public abstract boolean InsertarVacuna(Vacunas vacunas);
    
    public abstract boolean GuardarVacuna (Vacunas vacunas);
    
    public abstract boolean EliminarVacuna(Vacunas vacunas);
    
}
