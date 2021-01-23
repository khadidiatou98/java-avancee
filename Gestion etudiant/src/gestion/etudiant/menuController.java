/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.etudiant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class menuController implements Initializable {

    @FXML
    private AnchorPane AnchorContent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadView("vclasse");
        } catch (IOException ex) {
            Logger.getLogger(menuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    @FXML
    private void handleLoadViewClasse(ActionEvent event) throws IOException {
       loadView("vclasse");
    }
     public void loadView (String view) throws IOException{
         AnchorPane viewLoading= FXMLLoader
                 .load(getClass()
                 .getResource(view+".fxml"));
         AnchorContent.getChildren().add(viewLoading);
         
     }

    @FXML
    private void handleDeconnexion(ActionEvent event) throws IOException {
        AnchorContent.getScene().getWindow().hide();
          AnchorPane view= FXMLLoader
                  .load(getClass()
                  .getResource("vconnexion.fxml"));
          Scene scene=new Scene(view);
          Stage stage=new Stage();
          stage.setScene(scene);
          stage.showAndWait();
    }
             
    }    

    


