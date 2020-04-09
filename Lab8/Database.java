import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	static Connection myCon;
	//crearea obiectului Database 
	static Database db = new Database();
	
	//constructor privat
	private Database() {}
	
	//functie ce retureaza obiecul;
	public static Database getInstance()
	{
		return db;
	}
	public static void connection()
	{
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pa-lab8","student","student");
			System.out.println("Conexiune efectuata.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getCon()
	{
		return myCon;
	}

}
