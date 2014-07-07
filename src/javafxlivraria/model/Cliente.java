package javafxlivraria.model;

import java.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/** 
 * Classe com informações sobre o Cliente
 * **/
public class Cliente {
    
    private StringProperty nome;
    private String dataDeCadastro;
    private String dataDeAniversario;
    private Endereco enderecoDeEntrega;
    private Endereco enderecoDeFaturamento;

    public Cliente(String nome, String dataDeCadastro, String dataDeAniversario, Endereco enderecoDeEntrega,
                   Endereco enderecoDeFaturamento) {
        this.nome = new SimpleStringProperty(nome);
        this.dataDeAniversario = dataDeAniversario;
        this.dataDeCadastro = dataDeCadastro;
        this.enderecoDeEntrega = enderecoDeEntrega;
        this.enderecoDeFaturamento = enderecoDeFaturamento;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getNome() {
        return nome.get();
    }
    
    public StringProperty nomeProperty() {
        return nome;
    }

    public void setDataDeAniversario(String dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    public String getDataDeAniversario() {
        return dataDeAniversario;
    }
    
    public void setDataDeCadastro(String dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }

    /**
     * @return the enderecoDeEntrega
     */
    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    /**
     * @param enderecoDeEntrega the enderecoDeEntrega to set
     */
    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    /**
     * @return the enderecoDeFaturamento
     */
    public Endereco getEnderecoDeFaturamento() {
        return enderecoDeFaturamento;
    }

    /**
     * @param enderecoDeFaturamento the enderecoDeFaturamento to set
     */
    public void setEnderecoDeFaturamento(Endereco enderecoDeFaturamento) {
        this.enderecoDeFaturamento = enderecoDeFaturamento;
    }
    
    
}
