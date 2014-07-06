package javafxlivraria.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Filial {
    
    private final StringProperty razaoSocial;
    private Endereco enderecoFisico;
    private Gerente gerente;
    private Estoque estoque;

    public Filial(String razaoSocial, Endereco enderecoFisico, Gerente gerente, Estoque estoque) {
        super();
        this.razaoSocial = new SimpleStringProperty(razaoSocial);
        this.enderecoFisico = enderecoFisico;
        this.gerente = gerente;
        this.estoque = estoque;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial.set(razaoSocial);
    }

    public String getRazaoSocial() {
        return razaoSocial.get();
    }
    
    public StringProperty razaoSocialProperty() {
        return razaoSocial;
    }

    public void setEnderecoFisico(Endereco enderecoFisico) {
        this.enderecoFisico = enderecoFisico;
    }

    public Endereco getEnderecoFisico() {
        return enderecoFisico;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Gerente getGerente() {
        return gerente;
    } 

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
