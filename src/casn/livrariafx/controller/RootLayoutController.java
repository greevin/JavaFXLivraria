/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casn.livrariafx.controller;

import java.io.File;
import javafx.stage.FileChooser;
import casn.livrariafx.LivrariaPrincipal;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author CASN
 */
public class RootLayoutController {

    //Referência para a aplicação principal.
    private LivrariaPrincipal mainApp;

    /**
     * É chamado pelo aplicativo principal para dar uma referência de volta para si mesmo.
     *
     * @param mainApp
     */
    public void setMainApp(LivrariaPrincipal mainApp) {
        this.mainApp = mainApp;
    }

    public void handleSair() {
        System.exit(0);
    }
    
    // Menu Exportar/Exportar Clientes
    public void handleExportarClientesDados() {
        FileChooser fileChooser = new FileChooser();

        // Define a extensão
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Mostra a caixa de diálogo para salvar arquivo
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Certifica que tem a extensão correta
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveClienteDataToFile(file);
        }
    }
    // Menu Ajuda/Sobre
    public void handleSobre() {
        Dialogs.create()
                .title("LivrariaPOO")
                .masthead("Sobre")
                .message("Autor: Cícero Alexandrino")
                .showInformation();

    }
}
