/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.names;

import contractor.Entity;

/**
 * <p>Base class for names.</p>
 * <p>
 * <b>DEFAULT</b> equals, compare and hashCode are <b>CASE</b> insensitive as default behavior.
 * <br><b>PS :</b> override them when it matters.
 * </p>
 * @author rash4
 */
public abstract class Name<T extends Name<T>> 
        extends Entity<T> 
        implements Comparable<T>{
    @SuppressWarnings("unused")
    private Name(){
        throw new UnsupportedOperationException();
    }
    protected Name(String name){
        if(name == null || name.isBlank()) throw new IllegalArgumentException(
                "Must provide valid 'name' aka not (NULL, empty or blank).");
        this.name = name.trim();
    }
    /**Kinda copy-constructor, might throw NPE.*/
    protected Name(T name){
        this(name.name());
    }
    @Override public boolean equals(Object o) {
        if(this == o)return true;
        // ignores the class difference (of subclasses) -_-
        if(!(o instanceof Name n))return false;
        return this.name.equalsIgnoreCase(n.name());
    }
    @Override public int hashCode() {
        return this.name.toLowerCase().hashCode();
    }
    @Override public int compareTo(T o){
        return this.name.compareToIgnoreCase(o.name());
    }
    @Override public String toString(){
        return this.self().getClass().getSimpleName() + "Name=\"" + this.name + "\"";
    }
    @Deprecated(forRemoval=true)
    public final boolean isNull(){return this.name == null;}
    @Deprecated(forRemoval=true)
    public final boolean isEmpty(){return this.name.isEmpty();}
    @Deprecated(forRemoval=true)
    public final boolean isBlank(){return this.name.isBlank();}
    
    public String name(){return this.name;}
    private final String name;
}