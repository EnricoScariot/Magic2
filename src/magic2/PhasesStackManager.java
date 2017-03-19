/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic2;

import java.util.Stack;

/**
 *
 * @author skari
 */
public class PhasesStackManager {
    private Stack s= new Stack();
    private Stack support= new Stack();

    
    boolean isEmpty(){
        return s.empty();
    }
    
    public Phase popFromS(){
        return (Phase) s.pop();
    }
    //add the phase "el" after the Phase specified into "where"
    public void addPhase(String where, Phase el){
        if(where=="top")
            s.push(el);
        else{
            
            //cerco il posto giusto in cui mettere la fase
            Phase p=(Phase)s.peek();
            while(p.getName()!=where){
                Phase fase=(Phase)s.pop();
                support.push(fase);
                p=(Phase)s.peek();
           }
            //faccio la push nel posto giusto
            s.push(el);
            //rimetto nel mio stck le altre fasi in ordine
            while(!support.empty()){
              Phase fase=(Phase)support.pop();  
              s.push(fase);
            }
        }
    }  
    
    // delete from the stack the phase specified into "where"
    public void deletePhase(String where){
        if(where=="top")
            s.pop();
        else{
             //cerco il posto giusto in cui mettere la fase
            Phase p=(Phase)s.peek();
            while(p.getName()!=where){
                Phase fase=(Phase)s.pop();
                support.push(fase);
                p=(Phase)s.peek();
           }
            //elimino la fase
            s.pop();
            //rimetto nel mio stck le altre fasi in ordine
            while(!support.empty()){
              Phase fase=(Phase)support.pop();  
              s.push(fase);
            }
        }
    }
    
    public void stackInizialization(){
        EndPhase e=new EndPhase();
        s.push(e);
        MainPhase m=new MainPhase();
        s.push(m);
        CombatPhase c=new CombatPhase();
        s.push(c);
        UntapPhase u=new UntapPhase();
        s.push(u);
        DrawPhase d=new DrawPhase();
        s.push(d);
        System.out.println("now the stack is: " + s);
     }
    
    public void prepareNewStack(EffectManager e){
        stackInizialization();
    }
    
    
}
