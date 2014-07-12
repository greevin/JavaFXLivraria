package javafxlivraria.model;

import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafxlivraria.LivrariaLogger;

/**
 *
 * @author casn
 */
public class Filial {

    private final StringProperty razaoSocial;
    private Endereco enderecoFisico;
    private Gerente gerente;
    private Estoque estoque;
    private static final Logger logger = LivrariaLogger.getInstance(false);

    /**
     *
     * @param razaoSocial
     * @param enderecoFisico
     * @param gerente
     * @param estoque
     */
    public Filial(String razaoSocial, Endereco enderecoFisico, Gerente gerente, Estoque estoque) {
        super();
        this.razaoSocial = new SimpleStringProperty(razaoSocial);
        this.enderecoFisico = enderecoFisico;
        this.gerente = gerente;
        this.estoque = estoque;
    }

    /**
     *
     * @param razaoSocial
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial.set(razaoSocial);
    }

    /**
     *
     * @return
     */
    public String getRazaoSocial() {
        return razaoSocial.get();
    }

    /**
     *
     * @return
     */
    public StringProperty razaoSocialProperty() {
        return razaoSocial;
    }

    /**
     *
     * @param enderecoFisico
     */
    public void setEnderecoFisico(Endereco enderecoFisico) {
        this.enderecoFisico = enderecoFisico;
    }

    /**
     *
     * @return
     */
    public Endereco getEnderecoFisico() {
        return enderecoFisico;
    }

    /**
     *
     * @param gerente
     */
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    /**
     *
     * @return
     */
    public Gerente getGerente() {
        return gerente;
    }

    /**
     *
     * @return
     */
    public Estoque getEstoque() {
        return estoque;
    }

    /**
     *
     * @param estoque
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
