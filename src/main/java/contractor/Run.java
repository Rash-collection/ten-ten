/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package contractor;

import contractor.entities.names.Full;
import static contractor.entities.names.Full.make;
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
    }
}