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
public abstract class Name<T extends Name<T>> 
        extends Entity<Name<T>> 
        implements Comparable<T>{
    @SuppressWarnings("unused")
    private Name(){
        throw new UnsupportedOperationException();
    }
    protected Name(String name){
        if(name == null || name.isBlank()) throw new IllegalArgumentException(
                "Must provide valid 'name' aka not (NULL, empty or blank).");
        this.name = name;
    }
    /**Kinda copy-constructor, might throw NPE.*/
    protected Name(T name){
        this(name.name());
    }
    @Override public int compareTo(T o){
        return this.name.compareTo(o.name());
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