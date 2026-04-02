/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package contractor;

import contractor.names.First;
import contractor.names.Full;
import static contractor.names.Full.make;
import contractor.names.Last;
import contractor.names.Nick;
import contractor.persons.NewPerson;
import contractor.persons.Password;
import contractor.persons.UsersManager;
import java.util.Arrays;
import static debug.Virtual.vc;

/**
 * 
 * @author rash4
 */
public class Run {
    public static void main(String[] args) {
        vc().initialize();
        final var n1 = make("Rashid", "Hindi");
        System.out.println("Hello " + n1.fullName());
        final var n2 = make("hindi", "Rashid");
        System.out.println(n1);
        System.out.println(n2);
        System.out.println("" + n1.first().equals(n2.last())); // compiler complain about type on the equals method XD
        System.out.println("" + n1.last().equals(n2.first())); // compiler complain about type on the equals methodXD
        
        final Full fu[] = new Full[]{n1, n2, make("hallo", "me")};
        java.util.Arrays.sort(fu);
        System.out.println(Arrays.toString(fu));
        
        final var rash = new NewPerson<>(n1.first(), n1.last(), new Nick("Larckh"), new Password("lemme@M123korewa"));
        System.out.println(rash);
        
//        NewPerson guest = new NewPerson(new First("NULL"), new Last("NULL"), new Nick("GUEST"), new Password("01234567890"));
//        UsersManager.regex(guest);
        //
    }
}