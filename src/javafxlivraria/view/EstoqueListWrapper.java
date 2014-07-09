/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlivraria.view;

import java.util.List;
import javafx.collections.ObservableList;
import javafxlivraria.model.Filial;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author casn
 */
@XmlRootElement(name = "clientes")
public class EstoqueListWrapper {

    private List<Filial> filial;

    @XmlElement(name = "cliente")
    public List<Filial> getFilial() {
        return filial;
    }

    public void setFilial(List<Filial> filial) {
        this.filial = filial;
    }

    public void setEstoque(ObservableList<Filial> filialComboBoxData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
