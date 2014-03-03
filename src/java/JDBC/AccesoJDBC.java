package JDBC;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alumno
 */
public class AccesoJDBC {
    
    private Connection conn;
    
    public static String capitalize(String s) {
        if (s.length() == 0) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
    
    public AccesoJDBC(){
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            this.conn = DriverManager.getConnection
            ("jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public ResultSet getResultados(String categoria, String lugar){
        ResultSet res = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "Select equipo1, equipo2, resultado from resultados_rm where categoria = ? and lugar = ?"
            );
            ps.setString(1, categoria);
            ps.setString(2, lugar);
            res = ps.executeQuery();
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
    
}