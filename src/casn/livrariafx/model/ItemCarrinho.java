package casn.livrariafx.model;

import java.util.Objects;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author casn
 */
public class ItemCarrinho {

    private final StringProperty titulo;
    private final DoubleProperty preco;
    private final IntegerProperty unidades;
    private final DoubleProperty total;

    /**
     *
     * @param titulo
     * @param preco
     * @param unidades
     */
    public ItemCarrinho(String titulo, Double preco, Integer unidades) {
        this.titulo = new SimpleStringProperty(titulo);
        this.preco = new SimpleDoubleProperty(preco);
        this.unidades = new SimpleIntegerProperty(unidades);
        this.total = new SimpleDoubleProperty(preco * unidades);
    }

    /**
     *
     * @param item
     * @param unidades
     */
    public ItemCarrinho(Item item, Integer unidades) {
        this(item.getTitulo(), item.getPreco(), unidades);
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo.get();
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }

    /**
     *
     * @return
     */
    public StringProperty tituloProperty() {
        return titulo;
    }

    /**
     *
     * @return
     */
    public Double getPreco() {
        return preco.get();
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco.set(preco);
    }

    /**
     *
     * @return
     */
    public DoubleProperty precoProperty() {
        return preco;
    }

    /**
     *
     * @return
     */
    public Integer getUnidades() {
        return unidades.get();
    }

    /**
     *
     * @param unidades
     */
    public void setUnidades(Integer unidades) {
        this.unidades.set(unidades);
    }

    /**
     *
     * @return
     */
    public IntegerProperty unidadesProperty() {
        return unidades;
    }

    /**
     *
     * @return
     */
    public Double getTotal() {
        return total.get();
    }

    /**
     *
     * @param total
     */
    public void setTotal(Double total) {
        this.total.set(total);
    }

    /**
     *
     * @return
     */
    public DoubleProperty totalProperty() {
        return total;
    }

    /**
     *
     * @param unidades
     */
    public void aumentaUnidades(Integer unidades) {
        this.unidades.setValue(this.getUnidades() + unidades);
        recalculaTotal();
    }

    /**
     *
     * @param unidades
     */
    public void diminuiUnidades(Integer unidades) {
        this.unidades.setValue(this.getUnidades() - unidades);
        recalculaTotal();
    }

    private void recalculaTotal() {
        this.total.setValue(this.getUnidades() * this.getPreco());
    }

    @Override
    public int hashCode() {
        Integer hash = 3;
        hash = 31 * hash + Objects.hashCode(this.titulo);
        hash = 31 * hash + Objects.hashCode(this.preco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemCarrinho other = (ItemCarrinho) obj;
        if (!this.getTitulo().equals(other.getTitulo())) {
            return false;
        }
        if (!this.getPreco().equals(other.getPreco())) {
            return false;
        }
        return true;
    }
}
