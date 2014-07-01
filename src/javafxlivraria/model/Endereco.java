package javafxlivraria.model;

import java.util.ArrayList;

public class Endereco {
    
    private String tipoDeLogradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(String tipoDeLogradouro, String logradouro, String numero, String complemento, String cidade,
                    String uf) {
        this.tipoDeLogradouro = tipoDeLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }


    public void setTipoDeLogradouro(String tipoDeLogradouro) {
        this.tipoDeLogradouro = tipoDeLogradouro;
    }

    public String getTipoDeLogradouro() {
        return tipoDeLogradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUf() {
        return uf;
    }
    
    //String tipoDeLogradouro, String logradouro, String numero, String complemento, String cidade,
    //String uf
    //Avenida dos Aeronautas, 344 - Superior. Belo Horizonte - MG
    public String toString(){
        return String.format("%s %s, %s %s. \n%s - %s", tipoDeLogradouro, logradouro, numero, complemento, cidade, uf);
    }
}
