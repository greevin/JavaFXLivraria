package javafxlivraria.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafxlivraria.LivrariaPrincipal;
import javafxlivraria.model.Filial;
import javafxlivraria.model.Item;
import javafxlivraria.model.ItemCarrinho;
import javafxlivraria.model.Jornal;
import javafxlivraria.model.Livro;
import javafxlivraria.model.Revista;

/**
 *
 * @author casn
 */
public class EscolheProdutosController {

    // Reference to the main application.
    private LivrariaPrincipal mainApp;
    private Object stage;

    @FXML
    private Button comprarProdutoButton;
    @FXML
    private Button limparCarrinhoButton;
    @FXML
    private Button finalizarCompraButton;

    @FXML
    private ComboBox<Filial> filialComboBox;
    @FXML
    private Label razaoSocialLabel;
    @FXML
    private Label enderecoLabel;
    @FXML
    private Label gerenteLabel;

    @FXML
    private TableView<Item> tabelaItens;
    @FXML
    private TableColumn<Item, String> tipoColunaItens;
    @FXML
    private TableColumn<Item, String> tituloColunaItens;
    @FXML
    private TableColumn<Item, String> estoqueColunaItens;

    @FXML
    private Label tituloLabel;
    @FXML
    private Label editoraLabel;
    @FXML
    private Label edicaoLabel;
    @FXML
    private Label idiomaLabel;
    @FXML
    private Label dataDePublicacaoLabel;
    @FXML
    private Label numeroDePaginasLabel;
    @FXML
    private Label codigoDeBarrasLabel;
    @FXML
    private Label formatoLabel;
    @FXML
    private Label precoLabel;
    @FXML
    private Label quantidadeLabel;

    @FXML
    private TextField quantidadeField;

    @FXML
    private TableView<ItemCarrinho> tabelaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> tituloColunaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> precoColunaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> unidadesColunaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> totalColunaCarrinho;

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public EscolheProdutosController() {
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(LivrariaPrincipal mainApp) {
        this.mainApp = mainApp;
    }

    /**
     *
     * @param filiais
     */
    public void setFiliais(ObservableList<Filial> filiais) {
        filialComboBox.setItems(filiais);
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        showFilialDetails(null);
        mostrarDetalhesItem(null);

        // Define rendering of the list of values in ComboBox drop down. 
        filialComboBox.setCellFactory((comboBox) -> {
            return new ListCell<Filial>() {
                @Override
                protected void updateItem(Filial filial, boolean empty) {
                    super.updateItem(filial, empty);

                    if (filial == null || empty) {
                        setText(null);
                    } else {
                        setText(filial.getRazaoSocial());
                    }
                }
            };
        });

        // Define rendering of selected value shown in ComboBox.
        filialComboBox.setConverter(new StringConverter<Filial>() {
            @Override
            public String toString(Filial filial) {
                if (filial == null) {
                    return null;
                } else {
                    return filial.getRazaoSocial();
                }
            }

            @Override
            public Filial fromString(String filialString) {
                return null; // No conversion fromString needed.
            }
        });

        // Handle ComboBox event.
        filialComboBox.setOnAction((event) -> {
            Filial selectedFilial = filialComboBox.getSelectionModel().getSelectedItem();
            showFilialDetails(selectedFilial);
            preencheTabelaItens(selectedFilial);

        });

        // Initialize the table with the two columns.
        tipoColunaItens.setCellValueFactory(
                cellData -> {
                    SimpleStringProperty rotulo = new SimpleStringProperty();
                    if (cellData.getValue() instanceof Jornal) {
                        rotulo.set("Jornal");
                    } else if (cellData.getValue() instanceof Revista) {
                        rotulo.set("Revista");
                    } else if (cellData.getValue() instanceof Livro) {
                        rotulo.set("Livro");
                    }
                    return rotulo;
                }
        );
        
        tituloColunaItens.setCellValueFactory(
                cellData -> cellData.getValue().tituloProperty());

        estoqueColunaItens.setCellValueFactory(
                cellData -> cellData.getValue().quantidadeProperty().asString());

        // Listen for selection changes and show the person details when changed.
        tabelaItens.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetalhesItem(newValue));

        tituloColunaCarrinho.setCellValueFactory(
                cellData -> cellData.getValue().tituloProperty());
        precoColunaCarrinho.setCellValueFactory(
                cellData -> cellData.getValue().precoProperty().asString());
        unidadesColunaCarrinho.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getUnidades().toString()));
        totalColunaCarrinho.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getTotal().toString()));

        quantidadeField.setText("1");

        //desabilita os botões "Comprar Produto", "Limpar Carrinho" e "Finalizar Comprar"
        //quando não está mostrando nada na TableView. 
        //O botão só é habilitado quando é selecionado um item.
        comprarProdutoButton.setDisable(true);
        limparCarrinhoButton.setDisable(true);
        finalizarCompraButton.setDisable(true);
        tabelaItens.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (tabelaItens.isFocused()) {
                comprarProdutoButton.setDisable(false);
                limparCarrinhoButton.setDisable(false);
                finalizarCompraButton.setDisable(false);

            }
        });
    }

    private void preencheTabelaItens(Filial filial) {
        // Add observable list data to the table
        ObservableList<Item> lista = FXCollections.observableArrayList();
        lista.addAll(filial.getEstoque().getOversableListEstoqueDeItens());
        tabelaItens.setItems(lista);
    }

    private void mostrarDetalhesItem(Item item) {
        if (item != null) {
            // Fill the labels with info from the item object.
            tituloLabel.setText(item.getTitulo());
            editoraLabel.setText(item.getEditora());
            edicaoLabel.setText(Integer.toString(item.getEdicao()));
            idiomaLabel.setText(item.getIdioma());
            dataDePublicacaoLabel.setText(item.getDataDePublicacao());
            numeroDePaginasLabel.setText(Integer.toString(item.getNumeroDePaginas()));
            codigoDeBarrasLabel.setText(Integer.toString(item.getCodigoDeBarras()));
            if (item instanceof Livro) {
                formatoLabel.setText(((Livro) item).getFormato());
            } else {
                formatoLabel.setText("Não aplicável");
            }
            precoLabel.setText(java.text.NumberFormat.getCurrencyInstance().format(item.getPreco()));
            quantidadeLabel.setText(item.getQuantidade().toString());
        } else {
            // item is null, remove all the text.
            tituloLabel.setText("");
            editoraLabel.setText("");
            edicaoLabel.setText("");
            idiomaLabel.setText("");
            dataDePublicacaoLabel.setText("");
            numeroDePaginasLabel.setText("");
            codigoDeBarrasLabel.setText("");
            formatoLabel.setText("");
            precoLabel.setText("");
            quantidadeLabel.setText("");
        }
    }

    private void showFilialDetails(Filial filial) {
        if (filial != null) {
            // Fill the labels with info from the person object.
            razaoSocialLabel.setText(filial.getRazaoSocial());
            enderecoLabel.setText(filial.getEnderecoFisico().getCidade());
            gerenteLabel.setText(filial.getGerente().getNome());
        } else {
            // Person is null, remove all the text.
            razaoSocialLabel.setText("");
            enderecoLabel.setText("");
            gerenteLabel.setText("");
        }
    }

    @FXML
    private void handleComprarProduto() {
        Integer quantidadeSelecionada = Integer.parseInt(quantidadeField.getText());
        ItemCarrinho novo = new ItemCarrinho(tabelaItens.getSelectionModel().getSelectedItem(), quantidadeSelecionada);
        ObservableList<ItemCarrinho> lista = tabelaCarrinho.getItems();
        if (lista.contains(novo)) {
            ItemCarrinho old = lista.get(lista.indexOf(novo));
            novo.aumentaUnidades(old.getUnidades());
            lista.remove(old);
            lista.add(novo);
        } else {
            lista.add(novo);
        }
        tituloColunaCarrinho.setSortType(TableColumn.SortType.ASCENDING);
        // BUG do JavaFX
        tabelaCarrinho.getColumns().get(0).setVisible(false);
        tabelaCarrinho.getColumns().get(0).setVisible(true);
        System.out.println("Você apertou o Comprar Produto");
    }

    @FXML
    private void handleFecharCompra() {
        if (tabelaCarrinho.getItems() == null) {
            System.out.println("Não tem nada aqui. :/");
        } else {
            mainApp.mostrarFinarlizaCompra(tabelaItens.getItems(), tabelaCarrinho.getItems());
            System.out.println("Você apertou o Fechar Compra");
        }

    }

    @FXML
    private void handleLimparCarrinho() {
        tabelaCarrinho.getItems().clear();
        System.out.println("Você apertou o Limpar Carrinho");
    }
    
    public void atualizaEstoque(ObservableList<ItemCarrinho> carrinho){
        for(ItemCarrinho itemCarrinho:carrinho){
            for(Item item: tabelaItens.getItems()){
                if(item.getTitulo().equalsIgnoreCase(itemCarrinho.getTitulo())){
                    item.setQuantidade(item.getQuantidade()-itemCarrinho.getUnidades());
                }
            }
        }
        mostrarDetalhesItem(tabelaItens.getSelectionModel().getSelectedItem());
    }
}
