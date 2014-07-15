/* Classe de exceção quando o estoque de um produto está esgotado */

package casn.livrariafx.model.exception;

/**
 *
 * @author casn
 */
public class ItemNaoCadastradoException extends Exception {

    /**
     * Cria uma nova instancia de ItemNaoCadastradoException sem uma mensagem detalhada.
     */
    public ItemNaoCadastradoException() {
    }

    /**
     * Constrói uma instancia de ItemNaoCadastradoException com uma especifica mensagem detalhada.
     * 
     * @param msg a mensagem detalhada
     */
    public ItemNaoCadastradoException(String msg) {
        super(msg);
    }
}
