package javafxlivraria.model;

import java.util.Objects;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafxlivraria.LivrariaLogger;

/**
 *
 * @author casn
 */
public class Item {

    private final StringProperty titulo;
    private final StringProperty editora;
    private final IntegerProperty edicao;
    private final StringProperty idioma;
    private final StringProperty dataDePublicacao;
    private final IntegerProperty numeroDePaginas;
    private final IntegerProperty codigoDeBarras;
    private final DoubleProperty preco;
    private final IntegerProperty quantidade;
    private static final Logger logger = LivrariaLogger.getInstance(false);

    /**
     *
     * @param nome
     * @param editora
     * @param edicao
     * @param idioma
     * @param dataDePublicacao
     * @param numeroDePaginas
     * @param codigoDeBarras
     * @param preco
     */
    public Item(String nome, String editora, Integer edicao, String idioma, String dataDePublicacao, Integer numeroDePaginas, Integer codigoDeBarras, Double preco) {
        this(nome, editora, edicao, idioma, dataDePublicacao, numeroDePaginas, codigoDeBarras, preco, 0);
    }

    /**
     *
     * @param nome
     * @param editora
     * @param edicao
     * @param idioma
     * @param dataDePublicacao
     * @param numeroDePaginas
     * @param codigoDeBarras
     * @param preco
     * @param quantidade
     */
    public Item(String nome, String editora, Integer edicao, String idioma, String dataDePublicacao, Integer numeroDePaginas, Integer codigoDeBarras, Double preco, Integer quantidade) {
        this.titulo = new SimpleStringProperty(nome);
        this.editora = new SimpleStringProperty(editora);
        this.edicao = new SimpleIntegerProperty(edicao);
        this.idioma = new SimpleStringProperty(idioma);
        this.dataDePublicacao = new SimpleStringProperty(dataDePublicacao);
        this.numeroDePaginas = new SimpleIntegerProperty(numeroDePaginas);
        this.codigoDeBarras = new SimpleIntegerProperty(codigoDeBarras);
        this.preco = new SimpleDoubleProperty(preco);
        this.quantidade = new SimpleIntegerProperty(quantidade);
    }

    /**
     * @return the nome
     */
    public String getTitulo() {
        return titulo.get();
    }

    /**
     * @param nome the nome to set
     */
    public void setTitulo(String nome) {
        this.titulo.set(nome);
    }

    /**
     *
     * @return
     */
    public StringProperty tituloProperty() {
        return titulo;
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

    /**
     *
     * @return
     */
    public StringProperty editoraProperty() {
        return editora;
    }

    /**
     * @return the edicao
     */
    public Integer getEdicao() {
        return edicao.get();
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(Integer edicao) {
        this.edicao.set(edicao);
    }

    /**
     *
     * @return
     */
    public IntegerProperty edicaoProperty() {
        return edicao;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma.get();
    }

    /**
     *
     * @param idioma
     */
    public void setIdioma(String idioma) {
        this.idioma.set(idioma);
    }

    /**
     *
     * @return
     */
    public StringProperty idiomaProperty() {
        return idioma;
    }

    /**
     *
     * @return
     */
    public String getDataDePublicacao() {
        return dataDePublicacao.get();
    }

    /**
     *
     * @param dataDePublicacao
     */
    public void setDataDePublicacao(String dataDePublicacao) {
        this.dataDePublicacao.set(dataDePublicacao);
    }

    /**
     *
     * @return
     */
    public StringProperty dataDePublicacaoProperty() {
        return dataDePublicacao;
    }

    /**
     *
     * @return
     */
    public Integer getNumeroDePaginas() {
        return numeroDePaginas.get();
    }

    /**
     *
     * @param numeroDePaginas
     */
    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas.set(numeroDePaginas);
    }

    /**
     *
     * @return
     */
    public IntegerProperty numeroDePaginasProperty() {
        return numeroDePaginas;
    }

    /**
     *
     * @return
     */
    public Integer getCodigoDeBarras() {
        return codigoDeBarras.get();
    }

    /**
     *
     * @param codigoDeBarras
     */
    public void setCodigoDeBarras(Integer codigoDeBarras) {
        this.codigoDeBarras.set(codigoDeBarras);
    }

    /**
     *
     * @return
     */
    public IntegerProperty codigoDeBarrasProperty() {
        return codigoDeBarras;
    }

    /**
     *
     * @return
     */
    public Double getPreco() {
        return preco.get();
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco.set(preco);
    }

    /**
     *
     * @return
     */
    public DoubleProperty precoProperty() {
        return preco;
    }

    /**
     *
     * @return
     */
    public Integer getQuantidade() {
        return quantidade.get();
    }

    /**
     *
     * @param quantidade
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade.set(quantidade);
    }

    /**
     *
     * @return
     */
    public IntegerProperty quantidadeProperty() {
        return quantidade;
    }

    @Override
    public int hashCode() {
        Integer hash = 3;
        hash = 31 * hash + Objects.hashCode(this.titulo);
        hash = 31 * hash + Objects.hashCode(this.editora);
        hash = 31 * hash + Objects.hashCode(this.edicao);
        hash = 31 * hash + Objects.hashCode(this.idioma);
        hash = 31 * hash + Objects.hashCode(this.dataDePublicacao);
        hash = 31 * hash + Objects.hashCode(this.numeroDePaginas);
        hash = 31 * hash + Objects.hashCode(this.codigoDeBarras);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        if (!Objects.equals(this.edicao, other.edicao)) {
            return false;
        }
        if (!Objects.equals(this.idioma, other.idioma)) {
            return false;
        }
        if (!Objects.equals(this.dataDePublicacao, other.dataDePublicacao)) {
            return false;
        }
        if (!Objects.equals(this.numeroDePaginas, other.numeroDePaginas)) {
            return false;
        }
        if (!Objects.equals(this.codigoDeBarras, other.codigoDeBarras)) {
            return false;
        }
        return true;
    }
}
