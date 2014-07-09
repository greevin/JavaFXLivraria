package javafxlivraria.model;

import javafxlivraria.exception.EstoqueEsgotadoException;

public class Order {

    private Cliente cliente;
    private ItemPedido itemPedido;
    private double total;
    private int quantidade;
    //private Endereco endereco;


    public Order(Cliente cliente, ItemPedido itemPedido) {
        super();
        this.cliente = cliente;
        this.itemPedido = itemPedido;
        //this.endereco = endereco;
    }

    public void comprarItem(int quantidadeComprada) throws EstoqueEsgotadoException {
        //int quantidadeComprada = itemPedido.getQuantidade();
        int quantidade = itemPedido.getQuantidade();

        if ((quantidade - quantidadeComprada) >= 0) {
                    int novaQtd = quantidade - quantidadeComprada;
                    itemPedido.setQuantidade(novaQtd);
                } else {
                    throw new EstoqueEsgotadoException("Livro " + itemPedido.getItem().getTitulo()
                    + " sem estoque suficiente.");
                }
    }

    public double calculaValorTotal() {
        return total = quantidade * itemPedido.getItem().getPreco();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public String toString() {
        return String.format("Cliente: %s" + "\nDados do Pedido: %s" + "\nTotal Pedido: %.2f", cliente.getNome(), itemPedido,
                             total);
    }
}
