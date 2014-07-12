package casn.livrariafx.model;

import java.util.logging.Logger;
import casn.livrariafx.util.LivrariaLogger;

/**
 *
 * @author glauber
 */
public class Endereco {

    private String tipoDeLogradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private static final Logger logger = LivrariaLogger.getInstance(false);

    /**
     *
     * @param tipoDeLogradouro
     * @param logradouro
     * @param numero
     * @param complemento
     * @param cidade
     * @param uf
     */
    public Endereco(String tipoDeLogradouro, String logradouro, String numero, String complemento, String cidade,
            String uf) {
        this.tipoDeLogradouro = tipoDeLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    /**
     *
     * @param tipoDeLogradouro
     */
    public void setTipoDeLogradouro(String tipoDeLogradouro) {
        this.tipoDeLogradouro = tipoDeLogradouro;
    }

    /**
     *
     * @return
     */
    public String getTipoDeLogradouro() {
        return tipoDeLogradouro;
    }

    /**
     *
     * @param logradouro
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     *
     * @return
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     *
     * @param complemento
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     *
     * @return
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     *
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     *
     * @return
     */
    public String getCidade() {
        return cidade;
    }

    /**
     *
     * @param uf
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     *
     * @return
     */
    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s %s. \n%s - %s", tipoDeLogradouro, logradouro, numero, complemento, cidade, uf);
    }
}
