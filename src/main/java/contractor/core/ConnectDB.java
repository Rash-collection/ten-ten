/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>
 * Basic connecting to database and two query methods,
 * one expect returning results, the other just for updates.
 * </p>
 * @author rash4
 */
public final class ConnectDB {
    private ConnectDB(){}
    private static Connection conn;
    public synchronized static Connection connector(){
        if(conn == null) conn = connect();
        return conn;
    }
    private static Connection connect(){
        Connection cunt;
        try{
            cunt = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres?currentSchema=ten_ten",
                "contractor",
                "cunt-reactor"
            );
            System.out.println("Connected to DB successfully!");
            return cunt;
        }catch(SQLException e){
            throw new RuntimeException("Cannot connect to database", e);
        }
    }
    @Deprecated(forRemoval=true)
    public static PreparedStatement statement(String statement){
        if(statement == null || statement.isBlank())
            throw new IllegalArgumentException("statement is NULL or BLANK.");
        try {
            return connector().prepareStatement(statement);
        } catch (SQLException e) {
            throw new RuntimeException("couldn't prepare the statement..", e);
        }
    }
    @Deprecated(forRemoval=true)
    public static ResultSet executeQuery(String statement){
        try {
            return statement(statement).executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException("faild to execute query...", e);
        }
    }
    // for results
    public static void executeQuery(String sql, Reporter rp){
        if(sql == null || sql.isBlank() || rp == null)
            throw new IllegalArgumentException();
        try (PreparedStatement ps = connector().prepareStatement(sql);
            ResultSet rs = ps.executeQuery())
        {
            if(!rp.route(rs)){
                System.out.println("no results found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("failed to execute query...", e);
        }
    }
    // for updates
    public static int executeUpdate(String statement){
        if(statement == null || statement.isBlank())
            throw new IllegalArgumentException();
        try (PreparedStatement ps = connector().prepareStatement(statement)){
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("failed to execute update...", e);
        }
    }
}