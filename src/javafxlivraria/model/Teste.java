package javafxlivraria.model;

import java.util.*;

public class Teste {
    public static void main(String[] args) throws EstoqueEsgotadoException {

        Endereco[] enderecosClientes = new Endereco[4];

        enderecosClientes[0] = new Endereco("Avenida", "dos Aeronautas", "444", "Nenhum", "Belo Horizonte", "MG");
        enderecosClientes[1] = new Endereco("Rua", "da Bahia", "550C", "Fundos", "Belo Horizonte", "MG");
        enderecosClientes[2] = new Endereco("Rua", "dos Abacateiros", "3000", "Sem complemento", "São Paulo", "SP");
        enderecosClientes[3] = new Endereco("Avenida", "dos Jacarandás", "3242", "Casa", "Bento Gonçalves", "RS");
        
        Endereco[] enderecosFilial = new Endereco[4];

        enderecosFilial[0] = new Endereco("Rua", "dos Jornalistas", "2050", "Nenhum", "Belo Horizonte", "MG");
        enderecosFilial[1] = new Endereco("Avenida", "João Braga Costa Nunes", "1000", "Loja 3", "Poços de Caldas", "MG");
        enderecosFilial[2] = new Endereco("Rua", "Primeiro de Janeiro", "250", "Nenhum", "São Bernardo do Campo", "SP");
        enderecosFilial[3] = new Endereco("Avenida", "Ipanema", "3242", "Casa", "Rio de Janeiro", "RJ");
        
        Endereco[] enderecosFuncionario = new Endereco[4];

        enderecosFuncionario[0] = new Endereco("Alameda", "Pedro Barroso", "15", "Fundos", "Vespasiano", "MG");
        enderecosFuncionario[1] = new Endereco("Rua", "Inconfidentes", "100", "Apto 500", "Nova Lima", "MG");
        enderecosFuncionario[2] = new Endereco("Rua", "Cataventos", "9250", "Nenhum", "São Paulo", "SP");
        enderecosFuncionario[3] = new Endereco("Rua", "Novos Caminhos", "150", "Casa", "Rio de Janeiro", "RJ");

        Cliente cliente1 = new Cliente("José do Nascimento", "12/12/1986", "13/05/2013", enderecosClientes[1], enderecosClientes[2]);
        Cliente cliente2 = new Cliente("Maria Eduarda", "13/06/2014", "19/05/1996", enderecosClientes[3], enderecosClientes[3]);
        
        //endereco3 onde o Gerente mora.
        Gerente gerente1 = new Gerente("Carlos Eduardo", "13/01/1986", "06/05/2003", 450, enderecosFuncionario[0]);
        Gerente gerente2 = new Gerente("Maria dos Santos", "15/04/2004", "10/09/1980", 650, enderecosFuncionario[1]);
        //Vendedor vendedor1 = new Vendedor("Juliano Pereira", "10/10/1980", "11/11/2011", 120, endereco4);

        Livro livro1 =
            new Livro("Livro das Abelhas", "Editora Europa", 1, "Portugues", "05/05/2014", 230, 111111, 50, "Capa Dura",
                      3);
        Livro livro2 =
            new Livro("O Senhor dos Anéis - Volume Único", "Editora Atlas", 10, "Portugues", "09/04/2013", 690, 222222,
                      150, "Capa Comum", 5);

        Jornal jornal1 =
            new Jornal("O Estado de Minas", "O Estado de Minas", 545454, "Português", "05/10/2013", 50, 22222222, 2,
                       3);
        
        Revista revista1 = new Revista("Claudia", "Abril", 4343, "Português", "Abril 2014", 3434, 24242, 15, 5);
        
        Estoque estoque = new Estoque();
        estoque.cadastraItem(livro1);
        estoque.cadastraItem(livro2);
        estoque.cadastraItem(jornal1);
        estoque.cadastraItem(revista1);
        System.out.println(estoque);
        
        estoque.removeItem(livro1, 2);
        estoque.removeItem(livro2, 3);
        System.out.println();
        
        Filial filial1 = new Filial("Livraria da Rua de Cima", enderecosFilial[0], gerente1, estoque);
        System.out.println(filial1);
        System.out.println();
        
        Filial filial2 = new Filial("Livraria da Vila", enderecosFilial[1], gerente2, estoque);
        System.out.println(filial2);
        
        ItemPedido item1 = new ItemPedido(livro1, 3);
        
        System.out.println();
        Order order = new Order(cliente1, item1);
        System.out.println("Seus pedidos:");
        //order.comprarItem(2);
        //order.calculaValorTotal();
        System.out.println(order);

        /*ItemPedido item = new ItemPedido(livro2, 6);
        System.out.println("Pedido do cliente: " + cliente1.getNome());
        System.out.println(item.toString());
        estoque.removeItem(item.getItem(), item.getQuantidade());
        System.out.println();
        
        ItemPedido item2 = new ItemPedido(livro2, 4);
        System.out.println("Pedido do cliente: " + cliente2.getNome());
        System.out.println(item2.toString());
        estoque.removeItem(item2.getItem(), item2.getQuantidade());*/

    }
}
