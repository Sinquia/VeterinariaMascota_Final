
package interfaces;

import entidades.Mascotaporcliente;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public interface IMascotaPorCliente{

    public abstract boolean guardarMascotaPorCliente(Mascotaporcliente mascotaPorCliente);

    public abstract ArrayList<Mascotaporcliente> listarMascotaPorClientes();

    public abstract boolean actualizarMascotaPorCliente(Mascotaporcliente mascotaPorCliente);

    public abstract boolean eliminarMascotaPorCliente(Mascotaporcliente mascotaPorCliente);

}
