/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic2;

/**
 *
 * @author skari
 */
public class EndPhase implements Phase {
      
    public String getName() {
        return "EndPhase";
    }

   
    public void execute(Player current, Player enemy) {
       // System.out.println("The field of the player : "+p.getId()+" is :"+p.getField().toString());
      //  System.out.println("The deck of the player : "+p.getId()+" is :"+p.getDeck().toString());
    }
}
