package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO: esegue CRUD sulla tabella Autore
 * IMPL: implementation - dovrebbe implementare un'interfaccia che imponga alla classe 
 * 	i metodi necessari al dao (crud)
 */
public class LibroDaoImpl {

	public void readLibro() {
		ConnessioneDatabase db =  new ConnessioneDatabase();
		Connection conn = db.getConnection();
		
		String query = "Select * from libro";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery(); //esegue la query e restituisce un risultato iterabile
			
			while (rs.next()) {
				String titolo = rs.getString("titolo");
				System.out.println(titolo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
