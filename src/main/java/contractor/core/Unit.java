/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.core;

import contractor.entities.Entity;
import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 * @author rash4
 */
public abstract class Unit
        <SELF extends Unit<SELF, PARENT>, 
        PARENT extends Unit<?,?>> extends Entity<SELF>{
    /**The final container of all {@link Rise} objects.*/
    final static Root ROOT = new Root();
    private Unit(){
        this.PARENT = null;
    }
    public Unit(PARENT parent){
        if(parent == null) throw new IllegalArgumentException();
        this.PARENT = parent;
    }
    /**Special Unit without {@link #PARENT} AKA NULL, this object works as 'ultimat' container.*/
    static final class Root extends Unit<Root, Root>{
        final Map<String, Rise> COLLECTION = new HashMap<>();
    }
    public PARENT getParent(){return this.PARENT;}
    private final PARENT PARENT;
}