/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlivraria.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author casn
 */
public class Livro extends Item {

    private final StringProperty formato;

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
     * @param formato
     */
    public Livro(String nome, String editora, Integer edicao, String idioma, String dataDePublicacao,
            Integer numeroDePaginas, Integer codigoDeBarras, Double preco, String formato) {
        super(nome, editora, edicao, idioma, dataDePublicacao, numeroDePaginas, codigoDeBarras, preco);
        this.formato = new SimpleStringProperty(formato);
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
     * @param formato
     * @param quantidade
     */
    public Livro(String nome, String editora, Integer edicao, String idioma, String dataDePublicacao,
            Integer numeroDePaginas, Integer codigoDeBarras, Double preco, String formato, Integer quantidade) {
        super(nome, editora, edicao, idioma, dataDePublicacao, numeroDePaginas, codigoDeBarras, preco, quantidade);
        this.formato = new SimpleStringProperty(formato);
    }

    /**
     * @return the formato
     */
    public StringProperty formatoProperty() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(String formato) {
        this.formato.set(formato);
    }

    /**
     *
     * @return
     */
    public String getFormato() {
        return formato.get();
    }

}
