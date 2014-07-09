/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxlivraria.view;

import java.util.List;
import javafxlivraria.model.Cliente;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author casn
 */
@XmlRootElement(name = "clientes")
public class ClienteListWrapper {
    private List<Cliente> clientes;
    
    @XmlElement(name = "cliente")
    public List<Cliente> getClientes(){
        return clientes;
    }
    
    public void setClientes(List<Cliente> clientes){
        this.clientes = clientes;
    }
    
}
