/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.persons;

import contractor.names.First;
import contractor.names.Last;
import contractor.names.Nick;

/**
 * <p>For creating new users.</p>
 * <p>
 * This works as a 'person' TEMPLATE for the table insert,
 * hence when the check is done and everything is fine construct a new instance of {@link User}
 * </p>
 * <p>new person's <b>registry</b> needs ({@link contractor.names.Full}({@link contractor.names.Firs}, {@link contractor.names.Last}), PASSWORD, {@link contractor.names.Nick})</p>
 * @author rash4
 */
public class NewPerson<T extends NewPerson<T>> extends Person<T>{
    public NewPerson(First name, Last family, Nick nick, Password pass) {
        super(name, family, nick, pass); // just to call the constructor
        this.PASSWORD = pass;
        this.NICK = nick;
    }
    @Override public String toString(){
        return ("%s (%s%s) : \"%s\"").formatted(this.NICK.name(),
                this.NAME.first().name(), this.NAME.last().name(), this.PASSWORD);
    }
    final Nick NICK;
    final Password PASSWORD;
}