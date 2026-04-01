/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package contractor.core;

/**
 * <p>Floor type is based on it's level to the ground.</p>
 * <p>under-G, ground-G and above-G(normal, top)</p>
 * @author rash4
 */
public enum FloorType {
    Top,
    Normal,
    Ground,
    UnderGround,
    ;
    public String formattedName(){
        return this.name() + " floor";
    }
    public boolean validLevel(int level){
        return switch(this){
            case Top -> false;
            case Normal -> true;
            case Ground -> level == 0;
            case UnderGround -> level < 0;
        };
    }
}