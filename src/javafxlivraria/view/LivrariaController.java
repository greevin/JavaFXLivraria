package javafxlivraria.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.util.StringConverter;
import javafxlivraria.LivrariaPrincipal;
import javafxlivraria.model.FilialFX;
import javafxlivraria.model.ItemFX;
import javafxlivraria.model.LivroFX;

/**
 *
 * @author casn
 */
public class LivrariaController {

    @FXML
    private TableView<LivroFX> itemTableLivro;
    @FXML
    private TableColumn<ItemFX, String> nomeItemColuna;
    @FXML
    private TableColumn<ItemFX, String> editoraItemColuna;

    @FXML
    private ComboBox<FilialFX> filialComboBox;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Label nomeLabel;
    @FXML
    private Label editoraLabel;
    @FXML
    private Label edicaoLabel;
    @FXML
    private Label idiomaCodeLabel;
    @FXML
    private Label dataDePublicacaoLabel;
    @FXML
    private Label numeroDePaginasLabel;
    @FXML
    private Label razaoSocialLabel;
    @FXML
    private Label enderecoLabel;
    @FXML
    private Label gerenteLabel;
    /*@FXML
     private Label idiomaCodeLabel;
     @FXML
     private Label dataDePublicacaoLabel;
     @FXML
     private Label numeroDePaginasLabel;*/

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
        // Initialize the person table with the two columns.
        nomeItemColuna.setCellValueFactory(
                cellData -> cellData.getValue().nomeProperty());
        editoraItemColuna.setCellValueFactory(
                cellData -> cellData.getValue().editoraProperty());

        // Clear person details.
        showItemDetails(null);
        showFilialDetails(null);

        // Listen for selection changes and show the person details when changed.
        itemTableLivro.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showItemDetails(newValue));

        // Define rendering of the list of values in ComboBox drop down. 
        filialComboBox.setCellFactory((comboBox) -> {
            return new ListCell<FilialFX>() {
                @Override
                protected void updateItem(FilialFX filial, boolean empty) {
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
        filialComboBox.setConverter(new StringConverter<FilialFX>() {
            @Override
            public String toString(FilialFX filial) {
                if (filial == null) {
                    return null;
                } else {
                    return filial.getRazaoSocial();
                }
            }

            @Override
            public FilialFX fromString(String filialString) {
                return null; // No conversion fromString needed.
            }
        });

        // Handle ComboBox event.
        filialComboBox.setOnAction((event) -> {
            FilialFX selectedFilial = filialComboBox.getSelectionModel().getSelectedItem();
            showFilialDetails(selectedFilial);
        });
    }

    private void showItemDetails(ItemFX item) {
        if (item != null) {
            // Fill the labels with info from the person object.
            nomeLabel.setText(item.getNome());
            editoraLabel.setText(item.getEditora());
            edicaoLabel.setText(Integer.toString(item.getEdicao()));
            //postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            //cityLabel.setText(person.getCity());

        } else {
            // Person is null, remove all the text.
            nomeLabel.setText("");
            editoraLabel.setText("");
            edicaoLabel.setText("");

            //postalCodeLabel.setText("");
            //cityLabel.setText("");
            //birthdayLabel.setText("");
        }
    }

    private void showFilialDetails(FilialFX filial) {
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

        // Add observable list data to the table
        itemTableLivro.setItems(mainApp.getItemData());
        filialComboBox.setItems(mainApp.getComboBoxData());

    }
}
