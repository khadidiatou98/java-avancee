/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import DAO.DaoClasse;
import DAO.DaoPersonne;
import Models.Classe;
import Models.Details;
import Models.Etudiant;
import Models.Personne;
import java.util.List;

/**
 *
 * @author hp
 */
public class Service {
    private DaoClasse daoClasse;
    private DaoPersonne daoPersonne;
    private DaoDetails daoDetails;

    public Service() {
       daoClasse=new DaoClasse(); 
       daoPersonne=new DaoPersonne();
       daoDetails=new DaoDetails();
    }
    
        public List<Personne>listerEtudiantParClasse(Classe classe){
       return daoPersonne.findByClasse(classe);    
     }       
     
    public boolean creerClasse(Classe classe){
        int nbreLigne=daoClasse.insert(classe);
        return nbreLigne != 0;
        
    }
    public List<Classe> listerClasse(){
  return daoClasse.findAll();
    
}
    /*
    public boolean creerEtudiant(Etudiant etu){
        return daoPersonne.insert(etu)!=0;
    }
     public boolean creerProfesseur(Professseur prof){
        return daoPersonne.insert(prof)!=0;
    }
*/
      public boolean creerPersonne(Personne pers){
        return daoPersonne.insert(pers)!=0;
    }
    public professeur chercherProfesseur(String matricule){
        return daoPersonne.findProfesseurByMatricule(matricule),
    }
    public boolean attribuerClasse(Classe classe,Professeur prof,List<String>modules,String annee)  {
               if(prof.get.Id==0){
                  int id=daoPersonne.insert(prof) ;
                  prof.setId(id);
               }
        Details details=new Details(annee,modules,classe,prof);
        return daoDetails.insert(detail)!=0;
               
    }
    public List<String> listerModulesProfesseurParClasse(Classe classe,Professeur professeur) {
          Details details=new Details(classe,professeur);
          return daoDetails.findModules(details);

    }
public Personne seConnecter(String login, String pwd){
        return daoPersonne.findUserConnect(login, pwd);
        
        }
        }