package casn.livrariafx.model;

/**
 *
 * @author casn
 */
public class Jornal extends Item {

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
    public Jornal(String nome, String editora, Integer edicao, String idioma, String dataDePublicacao, Integer numeroDePaginas,
            Integer codigoDeBarras, Double preco) {
        super(nome, editora, edicao, idioma, dataDePublicacao, numeroDePaginas, codigoDeBarras, preco);
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
    public Jornal(String nome, String editora, Integer edicao, String idioma, String dataDePublicacao, Integer numeroDePaginas,
            Integer codigoDeBarras, Double preco, Integer quantidade) {
        super(nome, editora, edicao, idioma, dataDePublicacao, numeroDePaginas, codigoDeBarras, preco, quantidade);
    }
}
