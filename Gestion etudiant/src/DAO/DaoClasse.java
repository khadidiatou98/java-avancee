/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Classe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class DaoClasse implements IDao<Classe> {
    private final String SQL_INSERT="INSERT INTO 'classe'('id' 'libelle' 'nbre' )VALUES (?,?);";
    private final String SQL_SELECT_ALL="select * from classe"
    
    public int insert(Classe classe){
        int nbreLigne=0;
        //Insertion
        //charger driver
        Class.forName("com.mysql.jdbc.Driver"); {
     } catch 
            
        return nbreLigne;
    }
    
    public List<Classe> findAll(){
   List<Classe>lClasse=new ArrayList<>
            
}
}