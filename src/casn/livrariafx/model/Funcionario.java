package casn.livrariafx.model;

import java.util.logging.Logger;
import casn.livrariafx.util.LivrariaLogger;

/**
 * Classe com as informações do Funcionário
 *
 */
public class Funcionario {

    protected String nome;
    protected String dataDeAdmissao;
    protected String dataDeAniversario;
    protected double salario;
    protected Endereco enderecoDoFuncionario;
    private static final Logger logger = LivrariaLogger.getInstance(false);

    /**
     *
     * @param nome
     * @param dataDeAdmissao
     * @param dataDeAniversario
     * @param salario
     * @param enderecoDoFuncionario
     */
    public Funcionario(String nome, String dataDeAdmissao, String dataDeAniversario, double salario,
            Endereco enderecoDoFuncionario) {
        super();
        this.nome = nome;
        this.dataDeAdmissao = dataDeAdmissao;
        this.dataDeAniversario = dataDeAniversario;
        this.salario = salario;
        this.enderecoDoFuncionario = enderecoDoFuncionario;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param dataDeAdmissao
     */
    public void setDataDeAdmissao(String dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    /**
     *
     * @return
     */
    public String getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    /**
     *
     * @param dataDeAniversario
     */
    public void setDataDeAniversario(String dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    /**
     *
     * @return
     */
    public String getDataDeAniversario() {
        return dataDeAniversario;
    }

    /**
     *
     * @param salario
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     *
     * @return
     */
    public double getSalario() {
        return salario;
    }

    /**
     *
     * @param enderecoDoFuncionario
     */
    public void setEnderecoDoFuncionario(Endereco enderecoDoFuncionario) {
        this.enderecoDoFuncionario = enderecoDoFuncionario;
    }

    /**
     *
     * @return
     */
    public Endereco getEnderecoDoFuncionario() {
        return enderecoDoFuncionario;
    }
}
