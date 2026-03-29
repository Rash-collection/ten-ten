/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.entities.names;

/**
 * <p></p>
 * @author rash4
 */
public class Full implements Comparable<Full>{
    protected Full(String first, String last){
        if(first == null || first.isBlank() || last == null || last.isBlank())
            throw new IllegalArgumentException("firstName or lastName invalid");
        this.first = new First(first);
        this.last = new Last(last);
    }
    public Full(First fname, Last lname){
        this(fname.name(), lname.name());
    }
    /**copy constructor*/
    public Full(Full neo){
        this(neo.first, neo.last);
    }
    public static Full make(String p, String f){
        return new Full(p, f);
    }
    @Override public int compareTo(Full o){
        return this.toString().compareTo(o.toString());
    }
    @Override public String toString(){
        return this.first.name() + " " + this.last.name();
    }
    public First first(){return this.first;}
    public Last last(){return this.last;}
    private final First first;
    private final Last last;
}