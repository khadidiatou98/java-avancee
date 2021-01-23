/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Admin;
import Models.Classe;
import Models.Convert;
import Models.Etudiant;
import Models.Personne;
import Models.Professeur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class DaoPersonne implements IDao<Personne>{
    private final String SQL_SELECT_BY_CLASSE="select p.id,nom_complet,tuteur,classe_id,libelle,nbre from personne p where classe_id=? and cl.id=p.classe_id";
    private final String SQL_INSERT="INSERT INTO `personne` (`type`, `id`, `nom_complet`, `tuteur`, `modules`, `grade`, `classe_id`) VALUES (?,?,?,?,?, ?,?);";
    private final String SQL_SELECT_PROFESSEUR="select * from personne where matricule='?'";
    private final String SQL_SELECT_ALL_PROFESSEUR="select * from personne where type='Professeur'";
     private final String SQL_SELECT_CONNECT="select * from personne where login=? and pwd=?";
    private DaoMysql mysql;

    public DaoPersonne() {
        mysql=new DaoMysql();
    }
    
    public List<Etudiant> findByClasse(Classe classe) {
        List<Etudiant> lEtudiants=new ArrayList<>();
       
       
         try {
                mysql.ouvrirConnexionBD();
                mysql.preparerRequete(SQL_SELECT_BY_CLASSE); 
                System.out.println( classe.getId());
                mysql.getPs().setInt(1,classe.getId());
                
         ResultSet rs=mysql.executeSelect();
         while(rs.next()){
             Etudiant etu=new Etudiant();
             etu.setNomComplet(rs.getString("nom_complet"));
             etu.setId(rs.getInt("id"));
             etu.setTuteur(rs.getString("tuteur"));
             Classe cl=new Classe();
             cl.setId(rs.getInt("classe_id"));
             cl.setLibelle(rs.getString("libelle"));
             cl.setNbre(rs.getInt("nbre"));
             etu.setCl(cl);
             lEtudiants.add(etu);
             
             }
             
        } catch (SQLException ex) {
           System.err.println("Erreur D'execution de requete");
        }finally{
               mysql.closeConnexion();
      }
        //recuperation
        return lEtudiants;

   /* @Override
    public int insert(Personne objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }*/
   
        
    }
    public Professeur findProfesseurByMatricule(String matricule) throws SQLException{
        Professeur professeur=null;
        
        
          try {
               mysql.ouvrirConnexionBD();
               mysql.preparerRequete(SQL_SELECT_PROFESSEUR); 
               mysql.getPs().setString(1, matricule);
               ResultSet rs=mysql.executeSelect();
               if(rs.next()){ 
                   professeur=new Professeur();
                   professeur.setId(rs.getInt("id"));
                   professeur.setNomComplet(rs.getString("nom_complet"));
                   professeur.setMatricule(rs.getString("matricule"));
                  
                   professeur.setModules(Convert.stringToList(rs.getString("modules")));
                } 
         
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE,null,ex);
        }
              return professeur;

    

   
    }
    public List<Professeur> findProfesseur(){
       List<Professeur>lProfesseurs=new ArrayList<>();
        
        //Remplir la liste
        return lProfesseurs; 
        
        
    }
    public Personne findUserConnect(String login,String pwd) throws SQLException{
        Personne pers=null;
        mysql.OuvrirConnexionBD();
        mysql.PreparerRequete(SQL_SELECT_CONNECT);
            try{
                mysql.getPs().setString(1,login);
                mysql.getPs().setString(2,pwd);
                ResultSet rs=mysql.executeSelect();
                if(rs.next()){
                    if(rs.getString("type").trim().compareTo("Etudiant")==0){
                        pers=new Etudiant(rs.getNString("tuteur"));
                        
                    }else{
                        if(rs.getString("type").trim().compareTo("Professeur")==0){
                        pers=new Professeur();
                        ((Professeur)pers).setGrade(rs.getString("matricule"));
                        ((Professeur)pers).setModules(Convert.stringToList(rs.getString("modules")));
                        
                    }  else{
                        pers =new Admin();
                    }
            
                }
                pers.setId(rs.getInt("id"));
                pers.setNomComplet(rs.getString("nomComplet"));
                pers.setLogin(rs.getString("login"));
                pers.setPwd(rs.getString("pwd"));
                }
              
            }catch(SQLException ex) {
               Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE,null,ex);     
                    
    }

            return pers;
    }          
        
         @Override
    public int insert(Personne pers){
        int nbreLigne=0;
        //Traitement Insertion
        return nbreLigne;
    }
}