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
public interface Phase {
    public abstract String getName();
     
     public abstract void execute(Player current, Player enemy);
}
