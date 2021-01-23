/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.etudiant;

import Metier.Service;
import Models.Classe;
import Models.Etudiant;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ClasseController implements Initializable {

    @FXML
    private Button handleCreerClasse;
    @FXML
    private TextField txtLibelle;
    @FXML
    private TextField txtNbre;
    @FXML
    private TableColumn<Classe, String> tblcLibelle;
    @FXML
    private TableColumn<Classe, String> tblcNbre;
    @FXML
    private TableColumn<Etudiant,String> tblcNomPrenom;
    @FXML
    private TableColumn<Classe, String> tblcId;
    @FXML
    private TableColumn<Etudiant, String> tblcEtuId;
    @FXML
    private TableColumn<Etudiant, String> tblcTuteur;
    @FXML
    private TableView<Classe> tblvClasse;
    @FXML
    private TableView<Etudiant> tblvEtudiant;
    private Service metier;
    ObservableList<Classe> obClasses;
    ObservableList<Etudiant> obEtudiants;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        metier=new Service();
        obClasses=FXCollections.observableArrayList(
        metier.listerClasse()
        );
       loadTable();
    }   
    private void loadTable(){
         tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblcNbre.setCellValueFactory(new PropertyValueFactory<>("nbre"));
        tblvClasse.setItems(obClasses);
        
    }

    @FXML
    private void handleCreerClasse(ActionEvent event) {
        String libelle=txtLibelle.getText();
        int nbre=Integer.parseInt (txtNbre.getText());
        Classe cl=new Classe(libelle,nbre);
        if (metier.creerClasse(cl)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Classe ajoutée avec succes");
            alert.setTitle("Information");
            alert.show();
            obClasses.add(cl);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur Insertion");
            alert.setTitle("Erreur");
            alert.show();
            
        }
    }

    @FXML
    private void handleShowEtudiant(MouseEvent event) throws SQLException {
        Classe classeSelected=tblvClasse
                            .getSelectionModel()
                            .getSelectedItem();
        obEtudiants=FXCollections
                .observableArrayList(
                  metier
                     .listerEtudiantParClasse(classeSelected)
        );
        tblcEtuId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNomPrenom.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblcTuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));
        tblvEtudiant.setItems(obEtudiants);
    }
    
}
