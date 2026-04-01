/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.core;

/**
 * <p></p>
 * @author rash4
 */
public class Rise extends Unit<Rise, Unit.Root>{
    protected final static int MIN = 1;
    protected Rise(int floors, String name){
        this(new Floor[floors], name);
    }
    Rise(Floor[] floors, String name){
        super(Unit.ROOT);
        if(floors == null || floors.length < MIN || name == null || name.isBlank())
            throw new IllegalArgumentException();
        this.NAME = name;
        this.FLOORS = floors; // maybe copy array elements!!
        this.TYPE = RiseType.classify(this.floorsCount());
    }
    public boolean hasNullUnit(){
        for(var unit : this.FLOORS){
            if(unit == null || unit.hasNullUnit())return true;
        }return false;
    }
    public final int floorsCount(){return this.FLOORS.length;}
    public String name(){return this.NAME;}
    public RiseType type(){return this.TYPE;}
    
    private final Floor[] FLOORS;
    private final RiseType TYPE;
    private final String NAME;
}