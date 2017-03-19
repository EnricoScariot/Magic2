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
        
        int current1,i; 
        do{
               current1=-1;
         while(current1 != 0 && current1!= 1){
                    System.out.println(enemy.getName()+ " did you want to play an instant? (0/1)");
                    current1 = sc.nextInt();
                    }  
                 if(current1==1){
                      
                         System.out.println("Which card do you want to play?(0/"+(enemy.getHand().size()-1)+")");

                      i = sc.nextInt();
                      enemy.responde(i);
                      
                     
                    }  
         current1=-1;               
         while(current1 != 0 && current1!= 1){
                    System.out.println(current.getName()+ " did you want to play an instant? (0/1)");
                    current1 = sc.nextInt();
                    }  
                 if(current1==1){
                      
                         System.out.println("Which card do you want to play?(0/"+(current.getHand().size()-1)+")");

                      i = sc.nextInt();
                      current.responde(i);
                     
                 }
        }while(current1!=0 && current.getHand().size()>0&&enemy.getHand().size()>0);
    }
    
    
}
