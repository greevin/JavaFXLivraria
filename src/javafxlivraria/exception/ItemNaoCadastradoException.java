/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxlivraria.exception;

/**
 *
 * @author casn
 */
public class ItemNaoCadastradoException extends Exception {

    /**
     * Creates a new instance of <code>ItemNaoCadastradoException</code> without
     * detail message.
     */
    public ItemNaoCadastradoException() {
    }

    /**
     * Constructs an instance of <code>ItemNaoCadastradoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ItemNaoCadastradoException(String msg) {
        super(msg);
    }
}
