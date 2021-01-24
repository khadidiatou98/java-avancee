/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Admin;
import Models.Classe;
import Models.Convert;
import Models.Etudiant;
import Models.Personne;
import Models.Professeur;

/**
 *
 * @author user
 */
public class DaoPersonne implements IDao<Personne> {
    private final String 
            SQL_SELECT_BY_CLASSE="select "
            + " p.id,nom_complet,tuteur,"
            + " classe_id,libelle,nbre_etudiant  "
            + " from personne p,classe cl "
            + " where classe_id=?"
            + " and cl.id=p.classe_id";
    
    private final String SQL_INSERT="INSERT INTO `personne` (`nom_complet`, `type`, `tuteur`, `modules`, `grade`, `classe_id`)"
            + " VALUES (?,?,?,?,?,?)";
    private final String 
            SQL_SELECT_PROFESSEUR="select * from personne"
                                  + " where matricule=?";
    private final String SQL_SELECT_ALL_PROFESSEUR="select * from personne where type='Professeur'";
    private final String SQL_SELECT_CONNECT="select * from personne where login=? and pwd=?";
    private DaoMysql mysql;
    public DaoPersonne() {
        mysql=new DaoMysql();
    }
    
    public List<Etudiant> findByClasse(Classe classe){
          List<Etudiant> lEtudiants=new ArrayList<>();
         
        try {
            //1 Ouvrir la Connexion
           mysql.ouvrirConnexionBD();
         //2- Preparer la requete
           mysql.preparerRequete(SQL_SELECT_BY_CLASSE);
            mysql.getPs().setInt(1, classe.getId());
          //Exection de la requete
           ResultSet rs=mysql.executeSelect();
           //Recuperation des informations de la requete
           while(rs.next()){
               //Donnée Etudiant
               Etudiant etu=new Etudiant();
               etu.setNomComplet(rs.getString("nom_complet"));
               etu.setId(rs.getInt("id"));
               etu.setTuteur(rs.getString("tuteur"));
               //Recuperation des donnees de la classe
               Classe cl=new Classe();
               cl.setId(rs.getInt("classe_id"));
               cl.setLibelle(rs.getString("libelle"));
               cl.setNbre(rs.getInt("nbre_etudiant"));
              //Faire la relation
                etu.setCl(cl);
              //Ajouter l'etudiant dans la Liste  
                lEtudiants.add(etu);
           }
        } catch (SQLException ex) {
            System.err.println("Erreur D'execution de requete");
        }finally{
            mysql.closeConnexion();
        }
        return lEtudiants;
    }
    public Professeur findProfesseurByMatricule(String matricule){
          Professeur professeur=null;
          
        try {
            //1 Ouvrir la Connexion
             mysql.ouvrirConnexionBD();
            //2- Preparer la requete
             mysql.preparerRequete(SQL_SELECT_PROFESSEUR);
             mysql.getPs().setString(1, matricule);
             ResultSet rs=mysql.executeSelect();
             if(rs.next()){
                 professeur=new Professeur();
                 professeur.setId(rs.getInt("id"));
                 professeur.setNomComplet(rs.getString("nom_complet"));
                 professeur.setGrade(rs.getString("grade"));
                 professeur.setMatricule(rs.getString("matricule"));
                 professeur.setModules(
                         Convert.stringToList
                          (rs.getString("modules"))
                 );
             }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       return professeur;
   }
 
 public List<Professeur> findProfesseur(){
     List<Professeur> lProfesseurs=new ArrayList();
     //Recuperation des Professeur
     return lProfesseurs;
 }
   
public Personne findUserConnect(String login,String pwd) {
    Personne pers=null;
    mysql.ouvrirConnexionBD();
    mysql.preparerRequete(SQL_SELECT_CONNECT);
        try {
            mysql.getPs().setString(1, login);
            mysql.getPs().setString(2, pwd);
            ResultSet rs=mysql.executeSelect();
            if(rs.next()){
                if(rs.getString("type").trim().compareTo("Etudiant")==0){
                   pers=new Etudiant(rs.getString("tuteur"));
                }else{
                    if(rs.getString("type").trim().compareTo("Professeur")==0){
                    pers=new Professeur();
                    //DownCasting
                     ((Professeur)pers).setGrade(rs.getString("grade"));
                        ((Professeur)pers).setMatricule(rs.getString("matricule"));
                        ((Professeur)pers).setModules(
                         Convert.stringToList
                          (rs.getString("modules"))
                        );
                    }else{
                        pers=new Admin();
                    }
                }
                //Commun
                 pers.setId(rs.getInt("id"));
                 pers.setNomComplet(rs.getString("nom_complet"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    return pers;
    
}
    
    
    
    public int insert(Personne pers){
        int nbreLigne=0;
        //Traitement Insertion
        return nbreLigne;
    }
 
    
}
