package casn.livrariafx.model.wrapper;

import java.util.List;
import casn.livrariafx.model.Cliente;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author casn
 */
@XmlRootElement(name = "clientes")
public class ClienteListWrapper {

    private List<Cliente> clientes;

    /**
     *
     * @return
     */
    @XmlElement(name = "cliente")
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     *
     * @param clientes
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
