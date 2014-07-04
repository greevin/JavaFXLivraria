/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxlivraria;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafxlivraria.model.Endereco;
import javafxlivraria.model.FilialFX;
import javafxlivraria.model.Gerente;
import javafxlivraria.model.ItemFX;
import javafxlivraria.model.LivroFX;


/**
 *
 * @author casn
 */
public class LivrariaPrincipal extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    //private ObservableList<ItemFX> itemData = FXCollections.observableArrayList();
    private ObservableList<LivroFX> itemData = FXCollections.observableArrayList();
    //private ObservableList<FilialFX> filialData = FXCollections.observableArrayList();
    
    public LivrariaPrincipal(){
        itemData.add(new LivroFX("Livro", "Livraria da Rua", "Capa Dura"));
        itemData.add(new LivroFX("teste2", "teste2", "Capa Comum"));
        itemData.add(new LivroFX("teste3", "teste3", "Capa Comum"));
        itemData.add(new LivroFX("teste4", "teste4", "Capa Comum"));
        itemData.add(new LivroFX("teste5", "teste5", "Capa Comum"));
        
        /*Endereco[] enderecosFilial = new Endereco[4];

        enderecosFilial[0] = new Endereco("Rua", "dos Jornalistas", "2050", "Nenhum", "Belo Horizonte", "MG");
        enderecosFilial[1] = new Endereco("Avenida", "João Braga Costa Nunes", "1000", "Loja 3", "Poços de Caldas", "MG");
        enderecosFilial[2] = new Endereco("Rua", "Primeiro de Janeiro", "250", "Nenhum", "São Bernardo do Campo", "SP");
        enderecosFilial[3] = new Endereco("Avenida", "Ipanema", "3242", "Casa", "Rio de Janeiro", "RJ");

        Gerente gerente1 = new Gerente("Carlos Eduardo", "13/01/1986", "06/05/2003", 450, enderecosFilial[0]);
        
        filialData.add(new FilialFX("teste", enderecosFilial[0], gerente1));*/
    }
    
    public ObservableList<LivroFX> getItemData() {
        return itemData;
    }
    
    /*public ObservableList<FilialFX> getFilialData() {
        return filialData;
    }*/

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Livraria");

        initRootLayout();

        showLivraria();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LivrariaPrincipal.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     
    public void showLivraria() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LivrariaPrincipal.class.getResource("Livraria.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    
    public void showLivraria() {
    try {
        // Load person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LivrariaPrincipal.class.getResource("Livraria.fxml"));
        AnchorPane personOverview = (AnchorPane) loader.load();

        // Set person overview into the center of root layout.
        rootLayout.setCenter(personOverview);

        // Give the controller access to the main app.
        LivrariaController controller = loader.getController();
        controller.setMainApp(this);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}
