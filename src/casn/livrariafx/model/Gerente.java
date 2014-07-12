package casn.livrariafx.model;

import java.util.logging.Logger;
import casn.livrariafx.util.LivrariaLogger;

/**
 * Classe com as informações do Gerente. Gerente É-UM tipo de Funcionário.
 *
 * *
 */
public class Gerente extends Funcionario {

    private static final Logger logger = LivrariaLogger.getInstance(false);

    /**
     *
     * @param nome
     * @param dataDeAdmissao
     * @param dataDeAniversario
     * @param salario
     * @param enderecoDoFuncionario
     */
    public Gerente(String nome, String dataDeAdmissao, String dataDeAniversario, double salario,
            Endereco enderecoDoFuncionario) {
        super(nome, dataDeAdmissao, dataDeAniversario, salario, enderecoDoFuncionario);
    }

    @Override
    public String toString() {
        return String.format("Nome do Gerente: %s "
                + "\nData de Admissão: %s"
                + "\nData de Aniversário: %s"
                + "\nSalário: %.2f "
                + "\nEndereço da Gerente: %s", nome, dataDeAdmissao, dataDeAniversario, salario, enderecoDoFuncionario);
    }
}
