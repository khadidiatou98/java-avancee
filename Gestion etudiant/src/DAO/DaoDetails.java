/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Details;
import java.util.List;

/**
 *
 * @author hp
 */
public class DaoDetails implements IDao<Details> {

    private final String SQL_INSERT="INSERT INTO `details` (`classe_id`, `professeur_id`, `modules`, `annee`) VALUES ('?', '?', '?', '?');"
private final String SQL_SELECT_MODULES="select * from details where professeur_id=? and classe_id=?"
            public int insert(Details details){
                
                int nbreLigne=0;
                //traitement isertio
                return nbreLigne;
            }
            public List<String> findModules(Details details){

                
}