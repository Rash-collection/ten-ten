/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.core;

/**
 * <p></p>
 * @author rash4
 */
public class Apartment extends Unit<Apartment, Floor>{
    public Apartment(Floor parent, int _2D_index){
        super(parent);
        this.COORDS = _2D_index;
    }
    
    public String fullCoords(){
        // include parent's info too
        return "[" + this.getRow() + ":" + this.getCol() + "]";
    }
    public int getCol(){
        return Coords.col(this.COORDS);
    }
    public int getRow(){
        return Coords.row(this.COORDS);
    }
    public int get2DIndex(){return this.COORDS;}
    // mainly for contracts info.
    private final int COORDS;
}