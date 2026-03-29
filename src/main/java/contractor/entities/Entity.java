/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.entities;

/**
 * <p></p>
 * @author rash4
 */
public abstract class Entity<T extends Entity<T>> {
    /**Self cast method.*/
    public T self(){return (T)this;}
}