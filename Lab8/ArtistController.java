import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
	
	Connection con = Database.getCon();
	public void create(String name, String country)
	{
		try {
		
			Statement myState = con.createStatement();
		
			String sqlInsert = "insert into artists"
					+ " (name, country)"
					+ " values ('" + name + "', '" + country + "')";
		
			//myState.executeUpdate(sqlInsert);
		
			ResultSet myRs = myState.executeQuery("select * from artists");
			
			while (myRs.next()) {
				System.out.println(myRs.getString("id") + "." + myRs.getString("name") + " - "+ myRs.getString("country"));	
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
}
