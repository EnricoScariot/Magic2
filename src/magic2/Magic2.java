/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic2;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author skari
 */
public class Magic2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PhasesStackManager m = new PhasesStackManager();
        EffectManager e = new EffectManager();
        PlayedCardStack p = new PlayedCardStack(e);
        int idPlayer1 = 0;
        int idPlayer2 = 1;

        Player currentPlayer;
        Player enemy;
        int current = -1;

        Player p1 = new Player(idPlayer1, "Enrico", 10, e, m, p);
        Player p2 = new Player(idPlayer2, "Sergio", 10, e, m, p);

        p1.setEnemy(p2);
        p2.setEnemy(p1);
        //create the 2 decks
        p1.deckCreate();
        p2.deckCreate();

        p1.shuffleDeck();
        p2.shuffleDeck();

        //put 5 cards into the hand of the players
        p1.inizializeHand();
        p2.inizializeHand();
        m.stackInizialization();

        // decidi chi inizia, in questo caso inizia il giocatore 1
        Scanner scanin = new Scanner(System.in);
        while (current != 0 && current != 1) {
            System.out.println("Which player have to begin? (0/1)");
            current = scanin.nextInt();
        }

        while (p1.getLife() > 0 && p2.getLife() > 0) {
            if ((current % 2) == p1.getId()) {
                currentPlayer = p1;
                enemy = p2;
            } else {
                currentPlayer = p2;
                enemy = p1;
            }
            //      System.out.println("Now is the turn of the player : "+current);
            //      System.out.println("You have the following cards "+currentPlayer.getHand().toString());
            //while che cicla finchè non viene inserita un numero di carta valida
            //      System.out.println("which one do you want to play?");
            while (!m.isEmpty()) {
                System.out.println("The field of " + p1.getName() + " is " + p1.getField());
                System.out.println("The Hand of " + p1.getName() + " is " + p1.getHand());
                System.out.println("The Deck of " + p1.getName() + " is " + p1.getDeck());

                System.out.println("The field of " + p2.getName() + " is " + p2.getField());
                System.out.println("The Hand of " + p2.getName() + " is " + p2.getHand());
                System.out.println("The Deck of " + p2.getName() + " is " + p2.getDeck());
                Phase fase = m.popFromS();
                fase.execute(currentPlayer, enemy);
                p.printPlayedCardStack();
                        
                p.resolve();
                e.executeEffects();
                
            }

            System.out.println("The field of " + p1.getName() + " is " + p1.getField());
            System.out.println("The Hand of " + p1.getName() + " is " + p1.getHand());
            System.out.println("The Deck of " + p1.getName() + " is " + p1.getDeck());

            System.out.println("The field of " + p2.getName() + " is " + p2.getField());
            System.out.println("The Hand of " + p2.getName() + " is " + p2.getHand());
            System.out.println("The Deck of " + p2.getName() + " is " + p2.getDeck());

            current++;

            //aggiungo o tolgo fasi a seconda della carta che ho giocato
            m.prepareNewStack(e);
            //
        }

    }

}
