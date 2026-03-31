/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.core;

/**
 * <p>Local utility class for {@link Unit} coordinates in parent's grid.</p>
 * @author rash4
 */
public final class Coords {
    // Encode (row, col) → single int
    public static int encode(int row, int col) {
        return (row << 16) | (col & 0xFFFF);
    }
    // Extract row from encoded int
    public static int row(int coord) {
        return coord >>> 16;
    }
    // Extract column from encoded int
    public static int col(int coord) {
        return coord & 0xFFFF;
    }
}