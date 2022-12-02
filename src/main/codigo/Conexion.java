package main.codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    String bd = "";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion(String bd, String user, String password) {
        this.bd = bd;
        this.user = user;
        this.password = password;
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+ bd, user, password);
            JOptionPane.showMessageDialog(null, "La conexión a la BD " + bd + " fue un éxito", "Conexión aceptada", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "La conexión a la BD " + bd + " ha fracasado", "Conexión denegada", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}