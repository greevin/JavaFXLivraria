package javafxlivraria.model;

/**
 * Classe com as informações do Vendedor. Vendedor É-UM tipo de Funcionário.
 *
 * *
 */
public class Vendedor extends Funcionario {

    public Vendedor(String nome, String dataDeAdmissao, String dataDeAniversario, double salario,
            Endereco enderecoDoFuncionario) {
        super(nome, dataDeAdmissao, dataDeAniversario, salario, enderecoDoFuncionario);
    }

    @Override
    public String toString() {
        return String.format("Nome do Vendedor: %s "
                + "\nData de Admissão: %s"
                + "\nData de Aniversário: %s"
                + "\nSalário: %.2f "
                + "\nEndereço da Vendedor: %s", nome, dataDeAdmissao, dataDeAniversario, salario, enderecoDoFuncionario);
    }
}
