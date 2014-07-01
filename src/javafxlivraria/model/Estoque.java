package javafxlivraria.model;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

import java.util.*;

public class Estoque {
    
    private ArrayList<Item> itens = new ArrayList<Item>();
    
    public void cadastraItem(Item item){
        this.itens.add(item);
        System.out.println("Quantidade Total do "+ item.getNome() + " em estoque: "+ item.getQuantidade());
    }
    
    public void removeItem(Item item, int quantidade){
        int i = item.getQuantidade() - quantidade;
        //i--;
        System.out.println("Quantidade Total do "+ item.getNome() + " em estoque após remover: "+ i);
    }
    
    public void quantidadeTotal(Item item){
        int total = item.getQuantidade();
        System.out.println(total);
    }
    
    //chama o metódo toString da classe Livros
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Estoque (Total de Itens: "+ itens.size() + ") \n");
        
        for(Item item:itens){
            sb.append(item);
            sb.append("\n");
        }
        return sb.toString();
    }
}