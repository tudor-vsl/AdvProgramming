import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Chart {
	
	Connection con = Database.getCon();
	public void create(int rank, String albumName)
	{
		try {
		
			Statement myState = con.createStatement();
		
			String sqlInsert = "insert into chart"
					+ " (place, name)"
					+ " values ('" + rank + "', '" + albumName + "')";
		
			myState.executeUpdate(sqlInsert);
		
			ResultSet myRs = myState.executeQuery("select * from chart");
			
			while (myRs.next()) {
				System.out.println(myRs.getString("place") + "." + myRs.getString("name") );	
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void printOrderedArtists()
	{
		try {
			Statement myState = con.createStatement();
		
			ResultSet myRs = myState.executeQuery("select ar.name from chart c join albums a on c.name = a.name join artists ar on ar.id = a.artist_id");
			
			int i=1;
			while (myRs.next()) {
				System.out.print(i + ". ");
				System.out.println(myRs.getString("ar.name") );	
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void switchPlaces(int rank1, int rank2)
	{
		try {
			String art1Name = null;
			String art2Name = null;
			
			Statement myState = con.createStatement();
		
			ResultSet myRs = myState.executeQuery("select name from chart where place=" + rank1);
			while (myRs.next()) {
				art1Name = myRs.getString("name");
				//System.out.println(art1Name);
			}
			
			myRs = myState.executeQuery("select name from chart where place=" + rank2);
			while (myRs.next()) {
				art2Name = myRs.getString("name");
				//System.out.println(art2Name);
			}
			
			String sqlUpdate = "update chart set"
					+ " name="
					+ "'" + art2Name + "' where place=" + rank1;
			
			myState.executeUpdate(sqlUpdate);
			
			sqlUpdate = "update chart set"
					+ " name=" 
					+ "'" + art1Name + "' where place=" + rank2;
			
			myState.executeUpdate(sqlUpdate);
			
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
