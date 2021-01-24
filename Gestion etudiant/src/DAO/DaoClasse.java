/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import Models.Classe;

/**
 *
 * @author user
 */
//DAO ORM(Object Relationnel(BD) Mapping)
  // Objet => BD
  // BD => Objet
public class DaoClasse implements IDao<Classe> {
    private final String SQL_INSERT="INSERT INTO `classe` (`libelle`, `nbre_etudiant`) VALUES (?,?);";
    private final String SQL_SELECT_ALL="select * from classe";
    
    private DaoMysql mysql;

    public DaoClasse() {
        mysql=new DaoMysql();
    }
    
    @Override
    public int insert(Classe classe){
         int nbreLigne=0;
        try {
            //1-Ouvrir Connexion
            mysql.ouvrirConnexionBD();
            //2-Preparer la requete
              //a-Passer la requete
                  mysql.preparerRequete(SQL_INSERT);
              //b(facultative)-injecter les variables de la requere
              //Objet vers BD 
              mysql.getPs().setString(1,classe.getLibelle());
                mysql.getPs().setInt(2, classe.getNbre());
             //3- Execution de la requete
             //Requte mis a jour :insert-update-delete
                nbreLigne=mysql.executeMisAJour();
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnexion();
        }
        
           return nbreLigne;
    }
    
    public List<Classe> findAll(){
        List<Classe>lClasses=new ArrayList<>();       
        
        try {
            //1-Ouvrir Connexion
            mysql.ouvrirConnexionBD();
            //2-Preparer la requete
              //a-Passer la requete
                  mysql.preparerRequete(SQL_SELECT_ALL);
           //3- Execution de la requete
           ResultSet rs=  mysql.executeSelect();
            //Parcourir le resultat de la requete
            while(rs.next()){
                Classe cl=new Classe();
                //Hydrater l'objet Cl
                //BD=> Objet
                 cl.setId(rs.getInt("id"));
                 cl.setLibelle(rs.getString("libelle"));
                 cl.setNbre(rs.getInt("nbre_etudiant"));
                lClasses.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lClasses;
    }
}
