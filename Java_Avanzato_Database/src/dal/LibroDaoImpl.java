package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LibroEntity;

/**
 * DAO: esegue CRUD sulla tabella Autore
 * IMPL: implementation - dovrebbe implementare un'interfaccia che imponga alla classe 
 * 	i metodi necessari al dao (crud)
 */
public class LibroDaoImpl implements LibroDao
{

	@Override
	public List<LibroEntity> getAll() {
		ConnessioneDatabase db = new ConnessioneDatabase();
		Connection conn = db.getConnection();
		
		List<LibroEntity> libri = new ArrayList<LibroEntity>();
		
		try {
			//preparo la query da eseguire
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
			
			//eseguire la query
//			ps.execute();//non usare
			//ResultSet è un 
			ResultSet rs = ps.executeQuery(); // per le SELECT
			//ps.executeUpdate(); // per Insert, Update, Delete 
			
			//next mi dice se c'è una riga (true) e si sposta alla riga successiva
			//se false non ci sono più righe
			while (rs.next()) {
				LibroEntity libro = new LibroEntity();
				settaValoriLibro(libro, rs);
				
				//aggiungo alla lista
				libri.add(libro);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return libri;
	}

	@Override
	public LibroEntity getLibroById(int id) {
		ConnessioneDatabase db = new ConnessioneDatabase();
		Connection conn = db.getConnection();
		
		LibroEntity libro = new LibroEntity();
		try {
			//? è un placeholder che dobbiamo valorizzare 
			//posso averne tanti
			PreparedStatement ps = conn.prepareStatement("select * from libro where id = ?");
			//PreparedStatement ps = conn.prepareStatement("select * from libro where id = ? and titolo = ? and pagine = ?");
			
			//ATTENZIONE!!
			//questo è l'unico caso al mondo dove la posizione del "?" non è Zero Based
			//ma parte da 1 - mannaggia!!!
			ps.setInt(1, id);
			//ps.setString(2, "titolo");
			
			ResultSet rs =ps.executeQuery();
			
			while (rs.next()) {
				settaValoriLibro(libro, rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return libro;
	}

	//abbiamo bisogno di restituire il libro?
	//no, xè lo passiamo per riferimento
	private void settaValoriLibro(LibroEntity libro, ResultSet rs) throws SQLException {
		libro.setId( rs.getInt("id") );
		libro.setTitolo( rs.getString("titolo"));
		libro.setPrezzo(rs.getBigDecimal("prezzo"));
		libro.setPagine( rs.getShort("pagine"));
		libro.setId_editore(rs.getInt("id_editore"));
	}

	@Override
	public int updateLibro(LibroEntity libro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLibroById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
	//metodo esempio
	public void readLibro() {
		ConnessioneDatabase db =  new ConnessioneDatabase();
		Connection conn = db.getConnection();
		
		String query = "Select * from libro";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			//esegue la query e restituisce un risultato iterabile
			ResultSet rs = ps.executeQuery(); 
			
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
