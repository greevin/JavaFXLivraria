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
    
    private StringProperty formato;

    public Livro(String nome, String editora, int edicao, String idioma, String dataDePublicacao,
                   int numeroDePaginas, int codigoDeBarras, double preco, String formato) {
        super(nome, editora, edicao, idioma, dataDePublicacao, numeroDePaginas, codigoDeBarras, preco);
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
    
    public String getFormato(){
        return formato.get();
    }
    
}
