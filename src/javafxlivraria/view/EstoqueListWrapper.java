package javafxlivraria.view;

import java.util.List;
import javafxlivraria.model.Estoque;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author casn
 */
@XmlRootElement(name = "estoques")
public class EstoqueListWrapper {

    private List<Estoque> estoque;

    @XmlElement(name = "cliente")
    public List<Estoque> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Estoque> estoque) {
        this.estoque = estoque;
    }
}
