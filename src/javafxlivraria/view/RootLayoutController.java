/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxlivraria.view;

import javafx.application.Platform;
import javafxlivraria.LivrariaPrincipal;

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
    public void handleSair(){
        Platform.exit();
    }
    
    public void handleImportarDados(){
        
    }
    
    public void handleExportarDados(){
        
    }
    
    public void handleSobre(){
        
    }
}
