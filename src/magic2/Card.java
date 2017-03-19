/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic2;

import java.util.ArrayList;

/**
 *
 * @author skari
 */
public abstract class Card {
    String name;
    private ArrayList<Effect> effectList;
    boolean isTapped=false;
    
    

   public void executeEffect(){
       
   }
    
}
