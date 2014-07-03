package javafxlivraria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafxlivraria.LivrariaPrincipal;
import javafxlivraria.model.ItemFX;
import javafxlivraria.model.LivroFX;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author casn
 */
public class LivrariaController {
    @FXML
    private TableView<LivroFX> itemTable;
    @FXML
    private TableColumn<ItemFX, String> nomeColumn;
    @FXML
    private TableColumn<ItemFX, String> editoraColumn;

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

    // Reference to the main application.
    private LivrariaPrincipal mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
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
    nomeColumn.setCellValueFactory(
            cellData -> cellData.getValue().nomeProperty());
    editoraColumn.setCellValueFactory(
            cellData -> cellData.getValue().editoraProperty());

    // Clear person details.
    showPersonDetails(null);

    // Listen for selection changes and show the person details when changed.
    itemTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    private void showPersonDetails(ItemFX person) {
    if (person != null) {
        // Fill the labels with info from the person object.
        nomeLabel.setText(person.getNome());
        editoraLabel.setText(person.getEditora());
        edicaoLabel.setText(Integer.toString(person.getEdicao()));
        //postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
        //cityLabel.setText(person.getCity());

        // TODO: We need a way to convert the birthday into a String! 
        // birthdayLabel.setText(...);
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
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(LivrariaPrincipal mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        itemTable.setItems(mainApp.getItemData());
    }
}
