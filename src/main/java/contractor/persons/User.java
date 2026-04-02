/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.persons;

import contractor.names.First;
import contractor.names.Full;
import contractor.names.Last;
import contractor.names.Nick;
import java.util.UUID;

/**
 * <p></p>
 * @author rash4
 */
public class User extends NewPerson<User>{
    User(First name, Last family, Nick nick, Password pass) {
        super(name, family, nick, pass);
    }
    
}