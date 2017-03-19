/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic2;

import java.util.Scanner;

/**
 *
 * @author skari
 */
public class DrawPhase implements Phase{
    
   public String getName() {
       return "DrawPhase";
    }

  
    
    public void execute(Player current, Player enemy) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Now is the player "+current.getId() +" draw phase......");
        current.draw();  
     
         // l'avversario risponde
        
      
    }
    
    
}
