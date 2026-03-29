/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.entities.names;

import contractor.entities.Entity;

/**
 * <p></p>
 * @author rash4
 */
public class Full extends Entity<Full> implements Comparable<Full>{
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

    @Override public int hashCode() {
        int hash = 17;
        hash = 31 * hash + first.hashCode();
        hash = 31 * hash + last.hashCode();
        return hash;
    }
    @Override public boolean equals(Object o){
        if(o == null)return false;
        if(this == o)return true;
        if(o instanceof Full f){
            return this.first.equals(f.first()) && this.last.equals(f.last());
        }return false;
    }
    @Override public int compareTo(Full o){
        final int fst = this.first.compareTo(o.first());
        // AKA if not equals return the value and skip the rest.
        if (fst != 0) return fst;
        // AKA if the first names are the same then compare the last name.
        return this.last.compareTo(o.last());
    }
    @Override public String toString(){
        return this.first.toString()+ "||" + this.last.toString();
    }
    public String fullName(){return this.first.name() + " " + this.last.name();}
    public First first(){return this.first;}
    public Last last(){return this.last;}
    private final First first;
    private final Last last;
}