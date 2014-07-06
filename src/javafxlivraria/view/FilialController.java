/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxlivraria.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafxlivraria.LivrariaPrincipal;
import javafxlivraria.model.Filial;

/**
 *
 * @author casn
 */
public class FilialController {
    @FXML
    private TableView<Filial> itemTable;
    /*@FXML
    private TableColumn<FilialFX, String> nomeColumn;
    @FXML
    private TableColumn<FilialFX, String> editoraColumn;*/

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
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public FilialController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    //nomeColumn.setCellValueFactory(
            //cellData -> cellData.getValue().razaoSocialProperty());
    //editoraColumn.setCellValueFactory(
      //      cellData -> cellData.getValue().);

    // Clear person details.
    showFilialDetails(null);

    // Listen for selection changes and show the person details when changed.
    itemTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showFilialDetails(newValue));
    }

    private void showFilialDetails(Filial person) {
    if (person != null) {
        // Fill the labels with info from the person object.
        razaoSocialLabel.setText(person.getRazaoSocial());
        enderecoLabel.setText(person.getEnderecoFisico().getCidade());
        gerenteLabel.setText(person.getGerente().getNome());
        //postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
        //cityLabel.setText(person.getCity());

        // TODO: We need a way to convert the birthday into a String! 
        // birthdayLabel.setText(...);
    } else {
        // Person is null, remove all the text.
        razaoSocialLabel.setText("");
        enderecoLabel.setText("");
        gerenteLabel.setText("");
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
        //itemTable.setItems(mainApp.getFilialData());
    }
    
}
