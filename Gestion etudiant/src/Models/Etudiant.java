/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author hp
 */
public class Etudiant extends Personne {
    private String tuteur;
     //ManyToonen
    private Classe cl;

    public Etudiant(String tuteur) {
        this.tuteur = tuteur;
        type="Etudiant";
    }
   
    public Etudiant() {
        super();
    }

    public Classe getCl() {
        return cl;
    }

    public void setCl(Classe cl) {
        this.cl = cl;
    }

    public Etudiant(String tuteur, int id, String nomComplet) {
        super(id, nomComplet);
        this.tuteur = tuteur;
    }

    public Etudiant(String tuteur, String nomComplet) {
        super(nomComplet);
        this.tuteur = tuteur;
    }

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }

    @Override
    public String toString() {
        return super.toString()+"Tuteur:"+tuteur +"Classe:"+cl.getLibelle(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
