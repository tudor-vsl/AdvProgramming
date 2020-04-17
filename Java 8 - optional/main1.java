import java.util.Random;

import com.github.javafaker.Faker;

public class test2 {

	public static void main(String[] args) {
		
		//conexiunea
		Database db1 = Database.getInstance();
		db1.connection();
		
		//random pentru releaseYear
		Random r = new Random();
		int low = 1950;
		int high = 2020;
		int result = r.nextInt(high-low) + low;
		
		//creare de obiecte faker, album, char si artist + album si artist controller
		Faker faker = new Faker();
		Artist artist = new Artist(faker);
		Album album = new Album(faker, result);
		
		ArtistController ac = new ArtistController();
		AlbumController alc = new AlbumController();
		Chart chart = new Chart();
		
		artist.setArtist(faker);
		
		
		/*for(int i = 5; i < 49; i++)
		{
			result = r.nextInt(high-low) + low;
			
			//introducere de date in tabelele albums, artists si chart
			ac.create(artist.getName(), artist.getCountry());
			alc.create(album.getAlbumName(), ac.getArtistId(artist.getName()), album.getAlbumReleaseYear());
			chart.create(i, album.getAlbumName());
			
			//creare de noi date pentru inserat
			result = r.nextInt(high-low) + low;
			
			artist.setArtist(faker);
			album.setAlbum(faker, result);
			
		}*/
		//chart.printOrderedArtists();
		
		chart.switchPlaces(1, 4);
		chart.create(1, album.getAlbumName());
	}

}
