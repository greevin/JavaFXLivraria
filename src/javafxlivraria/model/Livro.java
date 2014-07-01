package javafxlivraria.model;

import java.util.Date;

public class Livro extends Item {
    
    private String formato;
    
    /*private String nome;
    private String editora;
    private int edicao;
    private String formato;
    private String idioma;
    private String dataDePublicacao;
    private int numeroDePaginas;
    private int codigoDeBarras;
    private double preco;

    public Livro(String nome, String editora, int edicao, String formato, String idioma, String dataDePublicacao,
                 int numeroDePaginas, int codigoDeBarras, double preco) {
        this.nome = nome;
        this.editora = editora;
        this.edicao = edicao;
        this.formato = formato;
        this.idioma = idioma;
        this.dataDePublicacao = dataDePublicacao;
        this.numeroDePaginas = numeroDePaginas;
        this.codigoDeBarras = codigoDeBarras;
        this.preco = preco;
    }


    public void setDataDePublicacao(String dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public String getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEditora() {
        return editora;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setCodigoDeBarras(int codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public int getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    //String nome, String editora, int edicao, String formato, String idioma, int dataDePublicacao,
    //int numeroDePaginas, int codigoDeBarras, double preco

    public String toString() {
        return String.format("Nome: %s " + "\nEditora: %s" + "\nEdicao: %s" + "\nFormato: %s" + "\nIdioma: %s" +
                             "\nData de Publicação: %s" + "\nNumero de Páginas: %d" + "\nCódigo de Barras: %s" +
                             "\nPreço: %.2f", nome, editora, edicao, formato, idioma, dataDePublicacao,
                             numeroDePaginas, codigoDeBarras, preco);
    }*/

    public Livro(String nome, String editora, int edicao, String idioma, String dataDePublicacao, int numeroDePaginas,
                 int codigoDeBarras, double preco, String formato, int quantidade) {
        super(nome, editora, edicao, idioma, dataDePublicacao, numeroDePaginas, codigoDeBarras, preco, quantidade);
        this.formato = formato;
    }


    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }
    
    public String toString() {
        return String.format(super.toString() + "\nFormato: %s", formato);
    }
}
