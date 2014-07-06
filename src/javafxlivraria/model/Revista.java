package javafxlivraria.model;

public class Revista extends Item {


    public Revista(String nome, String editora, int edicao, String idioma, String dataDePublicacao,
                   int numeroDePaginas, int codigoDeBarras, double preco) {
        super(nome, editora, edicao, idioma, dataDePublicacao, numeroDePaginas, codigoDeBarras, preco);
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
