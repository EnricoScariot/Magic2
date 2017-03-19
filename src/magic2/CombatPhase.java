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
public class CombatPhase implements Phase {
      
   public String getName() {
        return "CombatPhase";
    }

    
    public void execute(Player current, Player enemy) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Combat phase........");
    }
    
}
