import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
	
	Connection con = Database.getCon();
	public void create(String name, int artistId, int releaseYear)
	{
		try {
		
			Statement myState = con.createStatement();
		
			String sqlInsert = "insert into albums"
					+ " (name, artist_id, release_year)"
					+ " values ('" + name + "', " + artistId + ", " + releaseYear + ")";
		
			myState.executeUpdate(sqlInsert);
		
			ResultSet myRs = myState.executeQuery("select * from albums");
			
			while (myRs.next()) {
				System.out.println(myRs.getString("id") + "." + myRs.getString("name") + " -> "+ myRs.getString("artist_id") +" - "+ myRs.getString("release_year"));	
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void findByArtist(int artistId)
	{
		try {
		
			Statement myState = con.createStatement();
		
			ResultSet myRs = myState.executeQuery("select * from albums where artist_id=" + artistId);
			
			while (myRs.next()) {
				System.out.println(myRs.getString("id") + "." + myRs.getString("name") + " -> "+ myRs.getString("artist_id") +" - "+ myRs.getString("release_year"));		
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
