package javafxlivraria.model;

import javafxlivraria.exception.EstoqueEsgotadoException;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafxlivraria.exception.ItemNaoCadastradoException;

public class Estoque {

    private Map<Item, Integer> estoqueDeItens = new HashMap<>();

    public void cadastraItem(Item item) {
        if (!estoqueDeItens.containsKey(item)) {
            estoqueDeItens.put(item, 0);
        }
    }

    public void adicionaItem(Item item, Integer quantidade) throws ItemNaoCadastradoException {
        if (estoqueDeItens.containsKey(item)) {
            estoqueDeItens.replace(item, estoqueDeItens.get(item) + quantidade);
        } else {
            throw new ItemNaoCadastradoException();
        }
        System.out.println("Quantidade Total do " + item.getNome() + " em estoque: " + estoqueDeItens.get(item));
    }

    public void removeItem(Item item) throws EstoqueEsgotadoException, ItemNaoCadastradoException {
        if (estoqueDeItens.containsKey(item)) {
            Integer quantidade = estoqueDeItens.get(item);
            if (quantidade > 0) {
                estoqueDeItens.replace(item, estoqueDeItens.get(item) - 1);
            } else {
                throw new EstoqueEsgotadoException();
            }
        } else {
            throw new ItemNaoCadastradoException();
        }
        System.out.println("Quantidade Total do " + item.getNome() + " em estoque após remover: " + estoqueDeItens.get(item));
    }

    public Integer quantidadeTotal() {
        Integer total = 0;
        for (Integer quantidade : estoqueDeItens.values()) {
            total = total + quantidade;
        }
        return total;
    }

    public Integer getQuantidade(Item item) {
        return estoqueDeItens.get(item);
    }

    public ObservableList<Item> getOversableListItens(){
        ObservableList<Item> dados = FXCollections.observableArrayList();
        dados.addAll(estoqueDeItens.keySet());
        return dados;
    }
    //chama o metódo toString da classe Livros
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Estoque (Total de Itens: " + estoqueDeItens.size() + ") \n");

        for (Item item : estoqueDeItens.keySet()) {
            sb.append(item);
            sb.append("\n");
        }
        return sb.toString();
    }
}
