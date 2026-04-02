/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.persons;

import contractor.core.ConnectDB;
import contractor.names.Full;
import contractor.names.Nick;
import java.sql.SQLException;
import java.time.Instant;
import java.util.UUID;

/**
 * <p>Manages all database related updates.</p>
 * @author rash4
 */
public final class UsersManager {
    public static void regex(NewPerson person){
        registerPerson(person.NAME.first().name(), person.NAME.last().name(), person.NICK.name(), person.pass().pass());
    }
    public static void registerPerson(String firstName, String lastName, String nickName, String password){
        ConnectDB.executeQuery(((
                """
                INSERT INTO ten_ten.users (first_n, last_n, nick_n, legendary)
                VALUES ('%s', '%s', '%s', '%s')
                RETURNING *;
                """).formatted(firstName, lastName, nickName, Password.incode(password))), rs->{
            try {
                rs.next();
                final int id = rs.getInt("id");
                final Full fullName = Full.make(rs.getString("first_n"), rs.getString("last_n"));
                final UUID token = rs.getObject("access_token", UUID.class);
                final Instant created = rs.getTimestamp("created_at").toInstant();
                final Password pass = new Password(Password.decode(rs.getString("legendary")));
                final Nick nick = new Nick(rs.getString("nick_n"));
                System.out.println(">> " + id + "||" + fullName + "||" + nick +
                        "||" + token + "||" + created + "||" + pass.pass());
                // create the user instance -_-
            } catch (SQLException e) {
                System.out.println("SQL ERROR:");
                System.out.println("Message: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Error Code: " + e.getErrorCode());
                return false;
            }return true;
        });
    }
}