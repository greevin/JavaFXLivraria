package javafxlivraria.model;

/** 
 * Classe com as informações do Funcionário
 * 
 * **/
public class Funcionario {
    
    protected String nome;
    protected String dataDeAdmissao;
    protected String dataDeAniversario;
    protected double salario;
    protected Endereco enderecoDoFuncionario;

    public Funcionario(String nome, String dataDeAdmissao, String dataDeAniversario, double salario,
                       Endereco enderecoDoFuncionario) {
        super();
        this.nome = nome;
        this.dataDeAdmissao = dataDeAdmissao;
        this.dataDeAniversario = dataDeAniversario;
        this.salario = salario;
        this.enderecoDoFuncionario = enderecoDoFuncionario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDataDeAdmissao(String dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public String getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAniversario(String dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    public String getDataDeAniversario() {
        return dataDeAniversario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setEnderecoDoFuncionario(Endereco enderecoDoFuncionario) {
        this.enderecoDoFuncionario = enderecoDoFuncionario;
    }

    public Endereco getEnderecoDoFuncionario() {
        return enderecoDoFuncionario;
    }
}
