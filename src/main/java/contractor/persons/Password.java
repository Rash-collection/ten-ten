/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.persons;

/**
 * <p>String wrapper for now({@code 02/04/2024})</p>
 * @author rash4
 */
public final class Password {
    public final static int MIN_LENGTH = 8;
    public final static int MAX_LENGTH = 16;
    // the min length for incoded String.
    public final static int MIN_LENGTHENED = 44;
    // the max length for incoded String.
    public final static int MAX_LENGTHENED = 84;
    public Password(String password){
        if(!validatePassword(password)) throw new IllegalArgumentException();
        this.PASS = password;
    }
    /**
     * <p>Password 'String' validation, checks whether it's valid value to {@link #incode(java.lang.String)}</p>
     * @param password  the original value to check
     * @return          {@code true} if trim().length is between bounds({@link #MIN_LENGTH} - {@link #MAX_LENGTH}) &&
     * not contains spaces, ofc return {@code false} if NULL, isBlank or the opposite of the mentioned above.
     */
    public static boolean validatePassword(String password){
        if(password == null || password.isBlank() || password.contains(" "))return false;
        final int len = password.trim().length();
        return len >= MIN_LENGTH && len <= MAX_LENGTH;
    }
    /**
     * <p>Passcode 'String' validation, checks whether it's a valid encoded value for the {@link #decode(java.lang.String)} method.</p>
     * @param passcode  the incoded value to check
     * @return          {@code true} if trim().length is between the bounds({@link #MIN_LENGTHENED} - {@link #MAX_LENGTHENED}) &&
     * contains hyphens {@code -} && startWith the leading({@code '1111'}), ofc return {@code false} if NULL, isBlank or has spaces or the opposite of the above.
     */
    public static boolean validatePasscode(String passcode){
        if(     passcode == null || passcode.isBlank() ||
                passcode.contains(" ") || !passcode.contains("-") ||
                // note that seg="1111" is never possible, except for the explicit lead.
                !passcode.startsWith("1111")) return false;
        final int len = passcode.trim().length();
        if(len < MIN_LENGTHENED || len > MAX_LENGTHENED)return false;
        final var parts = passcode.trim().split("-"); // split all segments
        for (int i = 1; i < parts.length; i++) {   // start at 1 to skip "1111"
            if (parts[i].length() != 4) return false;
        }return true;
    }
    static String incode(String password){
        if(!validatePassword(password))
            throw new IllegalArgumentException("password must be (8~16)x characters.");
        final var cod = new StringBuilder();
        final var chr = password.trim().toCharArray();
        cod.append("1111");
        for(char c : chr){
            cod.append((String.format("-%04d", (int)c)));
        }
        return cod.toString();
    }
    static String decode(String passcode){
        if(!validatePasscode(passcode))
            throw new IllegalArgumentException("invalid or corrupted incoded password.");
        final var dec = new StringBuilder();
        final var ints = passcode.trim().split("-");
        for(int i = 1; i < ints.length; i++){ // skip the first sequence -_-
            try{
                final char pars = (char)Integer.parseInt(ints[i]);
                dec.append(pars);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("corrupted encoded password");
            }
        }
        return dec.toString();
    }
    public String pass(){return this.PASS;}
    private final String PASS;
}