

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//jdbc:mysql://localhost/bd","root
/**
 *
 * @author Work
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Work
 */
public class Tback {

    /**
     * @param args the command line arguments
     */
   
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//jdbc:mysql://localhost/bd","root
/**
 *
 * @author Work
 */

    private String servidor; 
    private String banco; 
    private String usuario; 
    private String senha;  
    private Connection conexao; 
    public Tback(){
        this.servidor = "localhost";
        this.banco ="tb_costumer_account";
        this.usuario ="root";
        this.senha="";
}

public boolean conectar (){
 
    try
    {
    this.conexao = DriverManager.getConnection("jdbc:mysql://"+this.servidor+"/"+this.banco,this.usuario,this.senha);
    
 return true;
} 
     catch (SQLException ex) {
   throw new RuntimeException(ex);  
    }
 }
public Connection getConnection (){


return conexao;

}
 public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//public List<tela1> read() throws SQLException{

  
//this.conexao = DriverManager.getConnection("jdbc:mysql://"+this.servidor+"/"+this.banco,this.usuario,this.senha);
// try  { String servidor = ("Select * from tb_costumer_accoount");

    private static class ConnectionFactory {

        public ConnectionFactory() {
        }
    }
 
 }





    
    
    