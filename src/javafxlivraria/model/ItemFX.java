package javafxlivraria.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemFX{

    private StringProperty nome;
    private StringProperty editora;
    private IntegerProperty edicao;
    private StringProperty idioma;
    private StringProperty dataDePublicacao;
    private IntegerProperty numeroDePaginas;
    private IntegerProperty codigoDeBarras;
    private DoubleProperty preco;
    private IntegerProperty quantidade;

    public ItemFX(String nome, String editora) {
        this.nome = new SimpleStringProperty(nome);
        this.editora = new SimpleStringProperty(editora);
        this.edicao = new SimpleIntegerProperty(2302);
        this.idioma = new SimpleStringProperty("Portugues");
        this.dataDePublicacao = new SimpleStringProperty("10/05/2014");
        this.numeroDePaginas = new SimpleIntegerProperty(550);
        this.codigoDeBarras = new SimpleIntegerProperty(555555454);
        this.preco = new SimpleDoubleProperty(550.00);
        this.quantidade = new SimpleIntegerProperty(50);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome.get();
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora.get();
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora.set(editora);
    }

    public StringProperty editoraProperty() {
        return editora;
    }

    /**
     * @return the edicao
     */
    public int getEdicao() {
        return edicao.get();
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(int edicao) {
        this.edicao.set(edicao);
    }

    public IntegerProperty edicaoProperty() {
        return edicao;
    }

    /**
     * @return the idioma
     */
    public StringProperty getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(StringProperty idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the dataDePublicacao
     */
    public StringProperty getDataDePublicacao() {
        return dataDePublicacao;
    }

    /**
     * @param dataDePublicacao the dataDePublicacao to set
     */
    public void setDataDePublicacao(StringProperty dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    /**
     * @return the numeroDePaginas
     */
    public IntegerProperty getNumeroDePaginas() {
        return numeroDePaginas;
    }

    /**
     * @param numeroDePaginas the numeroDePaginas to set
     */
    public void setNumeroDePaginas(IntegerProperty numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    /**
     * @return the codigoDeBarras
     */
    public IntegerProperty getCodigoDeBarras() {
        return codigoDeBarras;
    }

    /**
     * @param codigoDeBarras the codigoDeBarras to set
     */
    public void setCodigoDeBarras(IntegerProperty codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    /**
     * @return the preco
     */
    public DoubleProperty getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(DoubleProperty preco) {
        this.preco = preco;
    }

    /**
     * @return the quantidade
     */
    public IntegerProperty getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(IntegerProperty quantidade) {
        this.quantidade = quantidade;
    }

}
