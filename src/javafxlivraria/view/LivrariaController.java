package javafxlivraria.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.util.StringConverter;
import javafxlivraria.LivrariaPrincipal;
import javafxlivraria.model.Filial;
import javafxlivraria.model.Item;
import javafxlivraria.model.Jornal;
import javafxlivraria.model.Livro;
import javafxlivraria.model.Revista;

/**
 *
 * @author casn
 */
public class LivrariaController {

    @FXML
    private TableView<Item> itemTableItens;
    @FXML
    private TableColumn<Item, String> tituloItemColuna;
    @FXML
    private TableColumn<Item, String> tipoItemColuna;

    @FXML
    private ComboBox<Filial> filialComboBox;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Label nomeLabel;
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
    private Label precoLabel;
    @FXML
    private Label quantidadeLabel;
    @FXML
    private Label formatoLabel;

    @FXML
    private Label razaoSocialLabel;
    @FXML
    private Label enderecoLabel;
    @FXML
    private Label gerenteLabel;

    // Reference to the main application.
    private LivrariaPrincipal mainApp;

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public LivrariaController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        
        showFilialDetails(null);
        showItemDetails(null);
       
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
        
    }

    private void preencheTabelaItens(Filial filial){
        
        // Add observable list data to the table
        itemTableItens.setItems(filial.getEstoque().getOversableListItens());
        
         // Initialize the table with the two columns.
        tipoItemColuna.setCellValueFactory(
                cellData -> {
                    SimpleStringProperty rotulo = new SimpleStringProperty();
                    if(cellData.getValue() instanceof Jornal)
                        rotulo.set("Jornal");
                    else if(cellData.getValue() instanceof Revista)
                        rotulo.set("Revista");
                    else if(cellData.getValue() instanceof Livro)
                        rotulo.set("Livro");
                    return rotulo;
                }
                
                );
        tituloItemColuna.setCellValueFactory(
                cellData -> cellData.getValue().nomeProperty());
        
        // Listen for selection changes and show the person details when changed.
        itemTableItens.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showItemDetails(newValue));
 
    }
    
    private void showItemDetails(Item item) {
        if (item != null) {
            // Fill the labels with info from the person object.
            nomeLabel.setText(item.getNome());
            editoraLabel.setText(item.getEditora());
            edicaoLabel.setText(Integer.toString(item.getEdicao()));
            idiomaLabel.setText(item.getIdioma());
            dataDePublicacaoLabel.setText(item.getDataDePublicacao());
            numeroDePaginasLabel.setText(Integer.toString(item.getNumeroDePaginas()));
            codigoDeBarrasLabel.setText(Integer.toString(item.getCodigoDeBarras()));
            precoLabel.setText(Double.toString(item.getPreco()));
        } else {
            // Person is null, remove all the text.
            nomeLabel.setText("");
            editoraLabel.setText("");
            edicaoLabel.setText("");
            idiomaLabel.setText("");
            dataDePublicacaoLabel.setText("");
            numeroDePaginasLabel.setText("");
            codigoDeBarrasLabel.setText("");
            precoLabel.setText("");
            formatoLabel.setText("");
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

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(LivrariaPrincipal mainApp) {
        this.mainApp = mainApp;
        
        filialComboBox.setItems(mainApp.getComboBoxData());
    }
}
