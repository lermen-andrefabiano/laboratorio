package h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.h2.tools.Server;

public class Conexao {

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.h2.Driver"); // driver para h2 db
			//return DriverManager.getConnection("jdbc:h2:file:/C:/h2/dbh2teset", "sa", ""); 
	        return DriverManager.getConnection("jdbc:h2:~/test3");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			throw new SQLException();
		}
	}

	public static void main(String[] args) {
		// inicia o servidor e testa a conexao tcp com h2 db
		try {
			Server s = Server.createTcpServer(new String[] { "-tcp", "-tcpAllowOthers", "-tcpPort", "8007", "-trace" }); 
			s.start(); // inicia o servidor
			Connection con = Conexao.getConnection();
//			PreparedStatement stm = con.prepareStatement("SELECT * FROM usuarios");
//			ResultSet rs = stm.executeQuery();
//			while (rs.next()) {
//				System.out.println(rs.getString("loginUsuario"));
//			}
		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}