package javafxlivraria.model;

public class Jornal extends Item {


    public Jornal(String nome, String editora, int edicao, String idioma, String dataDePublicacao, int numeroDePaginas,
                  int codigoDeBarras, double preco) {
        super(nome, editora, edicao, idioma, dataDePublicacao, numeroDePaginas, codigoDeBarras, preco);
    }

    public String toString() {
        return super.toString();
    }
}
