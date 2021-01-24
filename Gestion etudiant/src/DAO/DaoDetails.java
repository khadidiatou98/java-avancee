/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import Models.Details;

/**
 *
 * @author user
 */
public class DaoDetails implements IDao<Details> {
    private final String SQL_INSERT="INSERT INTO `details` "
            + "(`classe_id`, `professeur_id`, `annee`, `modules`) "
            + "VALUES (?, ?, ?, ?);";
     private final String SQL_SELECT_MODULES="select * from details where professeur_id=? and classe_id=?";
    @Override
    public int insert(Details detail){
        int nbreLigne=0;
        //Traitement insertion
        return nbreLigne;
    }
    public List<String> findModules(Details details){
        List<String> lModules=new ArrayList();
        
        
        return lModules;
    }
}
