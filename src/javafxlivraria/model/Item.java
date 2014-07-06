package javafxlivraria.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {

    private StringProperty nome;
    private StringProperty editora;
    private IntegerProperty edicao;
    private StringProperty idioma;
    private StringProperty dataDePublicacao;
    private IntegerProperty numeroDePaginas;
    private IntegerProperty codigoDeBarras;
    private DoubleProperty preco;

    public Item(String nome, String editora, int edicao, String idioma, String dataDePublicacao, int numeroDePaginas, int codigoDeBarras, double preco) {
        this.nome = new SimpleStringProperty(nome);
        this.editora = new SimpleStringProperty(editora);
        this.edicao = new SimpleIntegerProperty(edicao);
        this.idioma = new SimpleStringProperty(idioma);
        this.dataDePublicacao = new SimpleStringProperty(dataDePublicacao);
        this.numeroDePaginas = new SimpleIntegerProperty(numeroDePaginas);
        this.codigoDeBarras = new SimpleIntegerProperty(codigoDeBarras);
        this.preco = new SimpleDoubleProperty(preco);
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
    public String getIdioma() {
        return idioma.get();
    }

    public void setIdioma(String idioma) {
        this.idioma.set(idioma);
    }

    public StringProperty idiomaProperty() {
        return idioma;
    }

    public String getDataDePublicacao() {
        return dataDePublicacao.get();
    }

    public void setDataDePublicacao(String dataDePublicacao) {
        this.dataDePublicacao.set(dataDePublicacao);
    }

    public StringProperty dataDePublicacaoProperty() {
        return dataDePublicacao;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas.get();
    }
    
    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas.set(numeroDePaginas);
    }

    public IntegerProperty numeroDePaginasProperty() {
        return numeroDePaginas;
    }

    public int getCodigoDeBarras() {
        return codigoDeBarras.get();
    }

    public void setCodigoDeBarras(int codigoDeBarras) {
        this.codigoDeBarras.set(codigoDeBarras);
    }
    
    public IntegerProperty codigoDeBarrasProperty() {
        return codigoDeBarras;
    }

    public double getPreco() {
        return preco.get();
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco.set(preco);
    }
    
    public DoubleProperty precoProperty() {
        return preco;
    }
}
