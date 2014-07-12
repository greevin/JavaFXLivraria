package javafxlivraria.model;

/**
 *
 * @author glauber
 */
public class ItemPedido {

    private Item item;
    private int quantidade;

    /**
     *
     * @param item
     * @param quantidade
     */
    public ItemPedido(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    /**
     *
     * @param item
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     *
     * @return
     */
    public Item getItem() {
        return item;
    }

    /**
     *
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {

        this.quantidade = quantidade;
    }

    /**
     *
     * @return
     */
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return String.format("\nSeu item: %s" + "\nPreço Unitário: %.2f" + "\nQuantidade: %d",
                item.getTitulo(), item.getPreco(), quantidade);
    }
}
