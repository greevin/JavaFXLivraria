package javafxlivraria.model;

import java.util.*;

/** 
 * Classe com informações sobre o Cliente
 * **/
public class Cliente {
    
    private String nome;
    private String dataDeCadastro;
    private String dataDeAniversario;
    private Endereco enderecoDeEntrega;
    private Endereco enderecoDeFaturamento;

    public Cliente(String nome, String dataDeCadastro, String dataDeAniversario, Endereco enderecoDeEntrega,
                   Endereco enderecoDeFaturamento) {
        this.nome = nome;
        this.dataDeAniversario = dataDeAniversario;
        this.dataDeCadastro = dataDeCadastro;
        this.enderecoDeEntrega = enderecoDeEntrega;
        this.enderecoDeFaturamento = enderecoDeFaturamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDataDeAniversario(String dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    public String getDataDeAniversario() {
        return dataDeAniversario;
    }
    
    public void setDataDeCadastro(String dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }
    
    //String nome, int dataDeCadastro, int dataDeAniversario, 
    //Endereco enderecoDeEntrega, Endereco enderecoDeFaturamento
    public String toString(){
        return String.format("Nome do Cliente: %s " +
            "\nCadastrado desde: %s " +
            "\nData de Aniversário: %s " +
            "\nEndereço de Entrega: %s" +
            "\nEndereço de Faturamento: %s", nome, dataDeCadastro, dataDeAniversario, enderecoDeEntrega, enderecoDeFaturamento);
    }
}
