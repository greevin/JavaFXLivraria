package casn.livrariafx.model;

import java.util.logging.Logger;
import casn.livrariafx.model.exception.EstoqueEsgotadoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import casn.livrariafx.util.LivrariaLogger;
import casn.livrariafx.model.exception.ItemNaoCadastradoException;

/**
 *
 * @author casn
 */
public class Estoque {

    private final ObservableList<Item> estoqueDeItens = FXCollections.observableArrayList();
    private static final Logger logger = LivrariaLogger.getInstance(false);

    /**
     *
     * @param item
     * @param quantidade
     */
    public void cadastraItem(Item item, Integer quantidade) {
        item.setQuantidade(quantidade);
        if (!estoqueDeItens.contains(item)) {
            estoqueDeItens.add(item);
        } else {
            int index = estoqueDeItens.indexOf(item);
            Item old = estoqueDeItens.remove(index);
            item.setQuantidade(quantidade + old.getQuantidade());
            estoqueDeItens.add(item);
        }
    }

    /**
     *
     * @param item
     * @param quantidade
     * @throws ItemNaoCadastradoException
     */
    public void incrementaItem(Item item, Integer quantidade) throws ItemNaoCadastradoException {
        if (estoqueDeItens.contains(item)) {
            int index = estoqueDeItens.indexOf(item);
            Item old = estoqueDeItens.remove(index);
            item.setQuantidade(quantidade + old.getQuantidade());
            estoqueDeItens.add(item);
        } else {
            throw new ItemNaoCadastradoException();
        }
        logger.info("Quantidade Total do " + item.getTitulo() + " em estoque: " + item.getQuantidade());
    }

    /**
     *
     * @param item
     * @param quantidade
     * @throws EstoqueEsgotadoException
     * @throws ItemNaoCadastradoException
     */
    public void decrementaItem(Item item, Integer quantidade) throws EstoqueEsgotadoException, ItemNaoCadastradoException {
        if (estoqueDeItens.contains(item)) {
            int index = estoqueDeItens.indexOf(item);
            Item old = estoqueDeItens.remove(index);

            if (old.getQuantidade() - quantidade >= 0) {
                item.setQuantidade(old.getQuantidade() - quantidade);
                estoqueDeItens.add(item);
            } else {
                throw new EstoqueEsgotadoException();
            }
        } else {
            throw new ItemNaoCadastradoException();
        }

        logger.info("Quantidade Total do " + item.getTitulo() + " em estoque após remover: " + item.getQuantidade());
    }

    /**
     *
     * @return
     */
    public Integer quantidadeTotal() {
        Integer total = 0;
        for (Item item : estoqueDeItens) {
            total = total + item.getQuantidade();
        }
        return total;
    }

    /**
     *
     * @param item
     * @return
     */
    public Integer getQuantidade(Item item) {
        int index = estoqueDeItens.indexOf(item);
        return estoqueDeItens.get(index).getQuantidade();
    }

    /**
     *
     * @return
     */
    public ObservableList<Item> getOversableListEstoqueDeItens() {
        return estoqueDeItens;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estoque (Total de Itens: ").append(estoqueDeItens.size()).append(") \n");

        for (Item item : estoqueDeItens) {
            sb.append(item);
            sb.append("\n");
        }
        return sb.toString();
    }
}
