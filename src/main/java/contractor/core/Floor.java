/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.core;

/**
 * <p></p>
 * @author rash4
 */
public class Floor extends Unit<Floor, Rise>{
    protected final static int MIN = 2;
    protected Floor(int units, Rise parent, int index){
        this(new Apartment[units], parent, index);
    }
    protected Floor(Apartment[] units, Rise parent, int index){
        super(parent);
        if(units == null || units.length < MIN)
            throw new IllegalArgumentException();
        this.UNITS = units;
        this.INDEX = index;
    }
    // if not has NULL unit then it's a success
    static boolean fillApartments(Floor floor){
        final var len = floor.unitsCount();
        for(int i = 0; i < len; i++){
            floor.UNITS[i] = new Apartment(floor, Coords.encode(floor.INDEX, i));
        }
        return !floor.hasNullUnit();
    }
    public boolean hasNullUnit(){
        for(var unit : this.UNITS){
            if(unit == null)return true;
        }return false;
    }
    public int unitsCount(){return this.UNITS.length;}
    private final Apartment[] UNITS;
    private final int INDEX;
}