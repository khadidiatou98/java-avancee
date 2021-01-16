/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Classe;
import Models.Personne;
import Models.Professeur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class DaoPersonne implements IDao<Personne> {
    private final String SQL_SELECT_BY_CLASSE="select * from personne where type='Etudiant' and classe_id=?";

    private final String SQL_INSERT="INSERT INTO `personne` (`classe.id`, `type`, `id`, `nom_complet`, `tuteur`, `modules`, `grade`) VALUES ('?', '?', '?', '?', '?', ?, ?);"
    private final String SQL_SELECT_PROFESSEUR="select* from personne where matricule=?";
      private final String SELECT_ALL_PROFESSEUR="select * from personne where type='Professeur'";
       private final String SELECT_CONNECT="select* from personne where login=? and pwd=?"
    public List<Personne> findByClasse(Classe classe){
        List<Personne> lEtudiants=new ArrayList<>();
        //recuperation
        return lEtudiants
    }
public int insert (Personne pers){
        int nbreLigne=0;
        //traitement insertion
        return nbreLigne;
        }
    public Professeur findProfesseurByMatricule(String matricule){
        Professeur professeur=null;
        
        }
    public List<Professeur> findProfesseur(){

        List<Professeur> lProfesseurs=new ArrayList ();
        
        return lProfesseurs;
}
    public Personne findUserConnect(String login ,String pwd){
     Personne pers=null;
     return pers;
}