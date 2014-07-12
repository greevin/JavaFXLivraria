package javafxlivraria.model;

import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafxlivraria.LivrariaLogger;

/**
 * Classe com informações sobre o Cliente *
 */
public class Cliente {

    private StringProperty nome;
    private String dataDeCadastro;
    private String dataDeAniversario;
    private Endereco enderecoDeEntrega;
    private Endereco enderecoDeFaturamento;
    private static final Logger logger = LivrariaLogger.getInstance(false);

    /**
     *
     * @param nome
     * @param dataDeCadastro
     * @param dataDeAniversario
     * @param enderecoDeEntrega
     * @param enderecoDeFaturamento
     */
    public Cliente(String nome, String dataDeCadastro, String dataDeAniversario, Endereco enderecoDeEntrega,
            Endereco enderecoDeFaturamento) {
        this.nome = new SimpleStringProperty(nome);
        this.dataDeAniversario = dataDeAniversario;
        this.dataDeCadastro = dataDeCadastro;
        this.enderecoDeEntrega = enderecoDeEntrega;
        this.enderecoDeFaturamento = enderecoDeFaturamento;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome.set(nome);
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome.get();
    }

    /**
     *
     * @return
     */
    public StringProperty nomeProperty() {
        return nome;
    }

    /**
     *
     * @param dataDeAniversario
     */
    public void setDataDeAniversario(String dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    /**
     *
     * @return
     */
    public String getDataDeAniversario() {
        return dataDeAniversario;
    }

    /**
     *
     * @param dataDeCadastro
     */
    public void setDataDeCadastro(String dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    /**
     *
     * @return
     */
    public String getDataDeCadastro() {
        return dataDeCadastro;
    }

    /**
     *
     * @return
     */
    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    /**
     *
     * @param enderecoDeEntrega
     */
    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    /**
     *
     * @return
     */
    public Endereco getEnderecoDeFaturamento() {
        return enderecoDeFaturamento;
    }

    /**
     *
     * @param enderecoDeFaturamento
     */
    public void setEnderecoDeFaturamento(Endereco enderecoDeFaturamento) {
        this.enderecoDeFaturamento = enderecoDeFaturamento;
    }

}
