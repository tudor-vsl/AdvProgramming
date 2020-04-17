import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
	
	//crearea unei variabile de tip connection si atribuind valoarea myCon 
	Connection con = Database.getCon();
	
	//functie ce insereaza date in tabel
	public void create(String name, String country)
	{
		try {
		
			Statement myState = con.createStatement();
		
			String sqlInsert = "insert into artists"
					+ " (name, country)"
					+ " values ('" + name + "', '" + country + "')";
		
			myState.executeUpdate(sqlInsert);
		
			ResultSet myRs = myState.executeQuery("select * from artists");
			
			while (myRs.next()) {
				System.out.println(myRs.getString("id") + "." + myRs.getString("name") + " - "+ myRs.getString("country"));	
			}
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	//functia ce gaseste elemente din tabel dupa nume
	public void findByName(String name)
	{
		try {
		
			Statement myState = con.createStatement();
		
			ResultSet myRs = myState.executeQuery("select * from artists where name like '" + name + "'");
			
			while (myRs.next()) {
				System.out.println(myRs.getString("id") + "." + myRs.getString("name") + " - "+ myRs.getString("country"));	
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getArtistId(String name)
	{
		try {
		
			Statement myState = con.createStatement();
		
			ResultSet myRs = myState.executeQuery("select id from artists where name like '" + name + "'");
			while (myRs.next())
				return myRs.getInt("id");	
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return -1;
	}
}
