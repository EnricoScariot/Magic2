/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author skari
 */
public class Player {

    private int id;
    private String Name;
    private int life;
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> field = new ArrayList<>();
    private ArrayList<Card> deck = new ArrayList<>();
    final private Random rnd = new Random();
    private EffectManager effectManager;
    private PhasesStackManager phasesStackMan;
    private PlayedCardStack playedCardStack;
    private Player enemy;

    // Costruttore
    public Player(int id, String Name, int life, EffectManager e, PhasesStackManager s, PlayedCardStack p) {
        this.id = id;
        this.Name = Name;
        this.life = life;
        this.effectManager = e;
        this.phasesStackMan = s;
        this.playedCardStack = p;
    }

    //Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getLife() {
        return life;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> getField() {
        return field;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public EffectManager getEffectManager() {
        return effectManager;
    }

    public PhasesStackManager getPhasesStackMan() {
        return phasesStackMan;
    }

    public PlayedCardStack getPlayedCardStack() {
        return playedCardStack;
    }

    public void setEnemy(Player p) {
        this.enemy = p;
    }

    public void draw() {
        hand.add(deck.remove(deck.size() - 1));
        if (hand.size() > 7) {
            System.out.println("Now you have more than 7 cards, choose which one you want to discard (0/" + (getHand().size() - 1) + ")");
            System.out.println(getHand().toString());
            Scanner sc = new Scanner(System.in);
            int cs = sc.nextInt();
            discardHand(cs);
        }
    }
    //create my Deck

    public void deckCreate() {
        Card mycard;
        for (int i = 0; i <= 10; i++) {
            mycard = new Omeopaty();
            deck.add(mycard);
        }
    }

    // Shuffle my Deck
    public void shuffleDeck() {
        final int end = deck.size();
        for (int i = 0; i != end - 1; ++i) {
            int idx = i + rnd.nextInt(end - i);
            Card tmp = deck.get(idx);
            deck.set(idx, deck.get(i));
            deck.set(i, tmp);
        }
    }

    //untap the target card
    public void untap(int index) {
        if (field.get(index).isTapped) {
            field.get(index).isTapped = false;
        }
    }

    //tap the target card
    public void tap(int index) {
        field.get(index).isTapped = true;
    }

    // remove the target card from the battlefield
    public void removeCard(int index) {
        field.remove(index);
    }

    public void discardHand(int index) {
        hand.remove(index);
    }

    public void discardDeck() {
        deck.remove(deck.size() - 1);
    }

   
    public void playCard(int index) {
        //controlla se posso giocare le carte
        if (!hand.isEmpty()&&index<hand.size()) {

            Card c = hand.remove(index);


            playedCardStack.add(c);

            if (c instanceof Creature || c instanceof Enchantment) {
                field.add(c);
            }
        }
        else
            System.out.print("overflow");
            
    }

    public void inizializeHand() {
        if (deck.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                draw();
            }
        }
    }

    public void responde(int index) {
        if (!hand.isEmpty()&&index<hand.size()) {
            if (hand.get(index) instanceof Instant) // bisogna ancora settare il target su tutti i giocatori
            {
                playedCardStack.add(hand.remove(index));
            }
        } else {
            System.out.print("This is not an Instant or overflow");
        }
    }

}
