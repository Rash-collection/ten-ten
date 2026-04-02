/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.names;

/**
 * <p>Nick name for user's displayed name (kinda global)</p>
 * @author rash4
 */
public class Nick extends Name<Nick>{
    public Nick(String name) {
        super(name);
    }
    public Nick(Nick name){
        this(name.name());
    }
    @Override public boolean equals(Object o){
        if(this == o)return true;
        // ignores the class difference (of subclasses) -_-
        if(!(o instanceof Name n))return false;
        return this.name().equals(n.name());
    }
    @Override public int compareTo(Nick o){
        return this.name().compareTo(o.name());
    }

    @Override public int hashCode() {
        return this.name().hashCode();
    }
}