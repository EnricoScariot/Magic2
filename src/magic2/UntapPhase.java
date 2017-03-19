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
public class UntapPhase implements Phase {
    
    
    public String getName() {
       return "UntapPhase";
    }

   
    public void execute(Player current, Player enemy) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Untap phase........");
       for(int i=0;i<current.getField().size();i++)
           current.untap(i);
       
    }
  
}
