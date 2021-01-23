/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Details;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class DaoDetails implements IDao<Details> {
    
    private final String SQL_INSERT="INSERT INTO `details` (`modules`, `annee`, `classe_id`, `professeur_id`) VALUES ('?', '?',?,?);";
    private final String SQL_SELECT_MODULES="select * from details where classe_id=? and professeur_id=?";
    private DaoMysql mysql;
    @Override
    //override:methode redéfinie
    public int insert(Details details){
        int nbreLigne=0;
        //1-chargement du driver etouvrir connexion
        mysql.ouvrirConnexionBD();
        //preparer la requete
        mysql.preparerRequete(SQL_INSERT);
        //Remplacer les var
        mysql.getPs().setString(2,details.getAnnee());
        mysql.getPs().setClasse(3, details.getClasse());
        mysql.getPs().setProfesseur(4,details.getProfesseur());
        //Executer la requete
        nbreLigne=mysql.executeMisAJour();
        mysql.closeConnection();
        return nbreLigne;
 
    }
    
    public List<String>findModules(Details details){
        List<String> lModules=new ArrayList<>();
        return lModules;
    }
}
    
    