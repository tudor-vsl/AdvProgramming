
public class Main {

	public static void main(String[] args) {
		
		Database db1 = Database.getInstance();
		db1.connection();
		ArtistController ac = new ArtistController();
		//ac.create("Eminem", "America");
		//ac.create("Smiley", "Romania");
		//ac.create("Mercury", "UK");
		//ac.create("Stromae", "France");
		//ac.findByName("Eminem");
		
		AlbumController AC = new AlbumController();
		//AC.create("Kamikaze", 5, 2018);
		//AC.create("Acasa", 6, 2013);
		//AC.create("Queen", 7, 1973);
		//AC.create("Cheese", 8, 2010);
		
		AC.findByArtist(8);
	}

}
