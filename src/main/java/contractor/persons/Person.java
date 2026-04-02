/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.persons;

import contractor.Entity;
import contractor.names.First;
import contractor.names.Full;
import contractor.names.Last;
import contractor.names.Nick;

/**
 * <p></p>
 * @author rash4
 */
public abstract class Person<T extends Person<T>> extends Entity<T>{
    protected Person(Full name){
        if(name == null) throw new IllegalArgumentException(
                "NAME instance is 'final' must never be BULL.");
        this.NAME = name;
    }
    protected Person(String name){
        this.NAME = Full.make(name, name);
    }
    protected Person(User user){ // it's gonna throw anyway XD
        this(user.name());
    }
    protected Person(First first, Last last, Nick nick, Password pass){
        if(first == null || last == null || nick == null || pass == null)
            throw new IllegalArgumentException("Person's constructor doesn't telorate any null value.");
        this.NAME = new Full(first, last);
    }
    public Full name(){return this.NAME;}
    final Full NAME;
}