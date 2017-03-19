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
public class EffectManager {
    private ArrayList<Effect> listOfEffects=new ArrayList<>();
    
    public void executeEffects(){
        
    }
    
    public void addEffect(Effect e){
        this.listOfEffects.add(e);
    }
}
