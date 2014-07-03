package javafxlivraria.model;

public class Livro extends Item {

    private String formato;

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
