/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cours.list;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class Exo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    //1-creer une liste String
        List<String> lString=new ArrayList();
        //2-ajouter des elements
        lString.add("Fatou Sall");
        lString.add("Aida Seck");
        lString.add("Aliou Gueye");
        lString.add("Mr LO");
        lString.add("Mr Diop");
        lString.add("Mr Mallé");
        //3-affichage de la liste
        //Methode1
        for(String elt:lString){
            System.out.println(elt);
        }
        lString.add(0, "Debut");
          lString.forEach((elt) -> {
            System.out.println(elt);
         });
          //4-supprimmer des elts
          lString.remove("Debut");
          lString.remove(2);
          System.out.println("Affichage apres Supression");
          lString.forEach((elt) -> {
           System.out.println(elt);
              } );
          //modifier un element de la liste
           lString.set(0,"Bonsoir");
          System.out.println("Affichage apres Supression");
          lString.forEach((elt) -> {
           System.out.println(elt);
              } );
          //recherche un element de la liste
          if(lString.contains("Bonjour")==true){
              System.out.println("Element existe");
          }else{
              System.out.println("Element Pas existe");
          }
}
