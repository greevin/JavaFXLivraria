package javafxlivraria.model;

public class Filial {

    private String razaoSocial;
    private Endereco enderecoFisico;
    private Gerente gerente;
    private Estoque estoque;

    public Filial(String razaoSocial, Endereco enderecoFisico, Gerente gerente, Estoque estoque) {
        super();
        this.razaoSocial = razaoSocial;
        this.enderecoFisico = enderecoFisico;
        this.gerente = gerente;
        this.estoque = estoque;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setEnderecoFisico(Endereco enderecoFisico) {
        this.enderecoFisico = enderecoFisico;
    }

    public Endereco getEnderecoFisico() {
        return enderecoFisico;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    //String razaoSocial, Endereco enderecoFisico, Gerente gerente
    public String toString() {
        return String.format("Razão Social: %s"
                + "\nEndereço da Livraria: %s"
                + "\nResponsável: %s" + "\nTotal de itens em estoque: ", razaoSocial, enderecoFisico, gerente.getNome(), estoque);
    }
}
