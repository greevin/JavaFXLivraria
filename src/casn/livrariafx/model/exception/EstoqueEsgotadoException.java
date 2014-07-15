/* Classe de exceção quando o estoque de um produto está esgotado */

package casn.livrariafx.model.exception;

public class EstoqueEsgotadoException extends Exception {

    @SuppressWarnings("compatibility:6324068529587200135")
    private static final long serialVersionUID = 1L;

    public EstoqueEsgotadoException(Throwable throwable) {
        super(throwable);
    }

    public EstoqueEsgotadoException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public EstoqueEsgotadoException(String string) {
        super(string);
    }

    public EstoqueEsgotadoException() {
        super();
    }
}
