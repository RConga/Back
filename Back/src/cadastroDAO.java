

import java.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.beans.Cadastro;
 

public class cadastroDAO {

    Connection con;
    
    public cadastroDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Cadastro c) {

        PreparedStatement stmt = null;

      try {
            stmt = con.prepareStatement("INSERT INTO tb_costumer_account (id_customer,cpf_cnpj,nm_custumer,is_active,vl_total) VALUES(?,?,?,?,?)");
            stmt.setInt(1, c.getId());
            stmt.setInt(2, c.getCpf());
            stmt.setString(3, c.getNome());
            stmt.setDouble(4, c.getSaldo()); 
            stmt.setString(5, c.getativo());
            stmt.executeUpdate();

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Cadastro> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cadastro> cadastro = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_costumer_account");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cadastro cadastros = new cadastros();
                
                cadastros.setativo(rs.getInt("is_active"));
                cadastros.setsaldo(rs.getString("vl_total"));
                
                cadastros.add(cadastros);
            }
               
                   
                   
                   
        } catch (SQLException ex) {
            Logger.getLogger(cadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cadastro;

    }
    public List<Cadastro> readForDesc(String desc) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cadastro> cadastro = new ArrayList<>();

        try {
            stmt = con.prepareStatement(" Select Max(vl_total) from tb_costumer_account ");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();
               
            while (rs.next()) {
            
                cadastro cadastros = new cadastro();
                cadastros.setnome(rs.getString("nm_custumer"));
                cadastros.setativo(rs.getInt("is_active"));
                cadastros.setsaldo(rs.getString("vl_total"));
            }
                           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(cadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cadastro;

    }

    public Iterable<cadastro> readJTable() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void create(cadastro c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class cadastros extends Cadastro {

        public cadastros() {
        }
    }

    
}
    