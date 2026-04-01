/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.core;

import static contractor.core.Unit.ROOT;

/**
 * <p>Manages all locally saved Rises.</p>
 * @see     Unit#ROOT
 * @author rash4
 */
public final class RiseManager {
    private final static RiseManager RISES_MANAGER = new RiseManager();
    public static RiseManager manager(){return RISES_MANAGER;}
    private RiseManager(){}
    
    public RiseManager add(Rise rise){
        if(rise == null || rise.name() == null || rise.hasNullUnit())
            return this;
        ROOT.COLLECTION.put(rise.name(), rise);
        return this;
    }
    
    public RiseManager defaultRise(String name, int levels, int unitPerFloor){
        final Floor floors[] = new Floor[levels];
        final Rise def = new Rise(floors, name);
        for(int i = 0; i < levels; i++){
            if(!Floor.fillApartments(floors[i] = new Floor(unitPerFloor, def, i)))
                return this; // upon failure for some reason
        }
        return this.add(def);
    }
}