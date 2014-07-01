package javafxlivraria.model;


import java.util.Date;

/** 
 * Classe com as informações do Gerente. Gerente É-UM tipo de Funcionário.
 * 
 * **/
public class Gerente extends Funcionario{
    
    
    //String nome, int dataDeAdmissao, int dataDeAniversario, double salario, Endereco enderecoDaLivraria

    public Gerente(String nome, String dataDeAdmissao, String dataDeAniversario, double salario,
                   Endereco enderecoDoFuncionario) {
        super(nome, dataDeAdmissao, dataDeAniversario, salario, enderecoDoFuncionario);
    }

    public String toString(){
        return String.format("Nome do Gerente: %s " +
            "\nData de Admissão: %s" +
            "\nData de Aniversário: %s" +
            "\nSalário: %.2f " +
            "\nEndereço da Gerente: %s", nome, dataDeAdmissao, dataDeAniversario, salario, enderecoDoFuncionario);
    }
}
