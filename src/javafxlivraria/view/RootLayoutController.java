/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlivraria.view;

import java.io.File;
import javafx.stage.FileChooser;
import javafxlivraria.LivrariaPrincipal;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author glauber
 */
public class RootLayoutController {

    // Reference to the main application.
    private LivrariaPrincipal mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(LivrariaPrincipal mainApp) {
        this.mainApp = mainApp;
    }

    public void handleSair() {
        System.exit(0);
    }

    public void handleImportarDados() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        System.out.println("Arquivo carregado");
    }

    public void handleExportarDados() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveEstoqueDataToFile(file);
        }
    }

    public void handleSobre() {
        Dialogs.create()
                .title("LivrariaPOO")
                .masthead("Sobre")
                .message("Autor: Cícero Alexandrino")
                .showInformation();

    }
}
