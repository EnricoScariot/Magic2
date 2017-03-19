/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic2;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author skari
 */
public class PlayedCardStack {
    
    Stack<Card> playedCardStack= new Stack<Card>();
    EffectManager e;
    
    public PlayedCardStack(EffectManager e) {
        this.e=e;
        
    }
    
  
    
    
    public void add(Card c){
        playedCardStack.push(c);
        
    }
    
    public void resolve(){
        while(!this.playedCardStack.empty()){
            Card c=this.playedCardStack.pop();
           c.executeEffect();
                
            }
    
        
    }
    
    public void printPlayedCardStack(){
        System.out.println("now the PlayedCardStack is: " + playedCardStack);
    }
    
}
