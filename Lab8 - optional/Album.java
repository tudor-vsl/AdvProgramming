import java.util.Random;

import com.github.javafaker.Faker;

public class Album {
	
	private Faker faker = new Faker();
	
	
	private String name;
	private int releaseYear;
	
	public Album(Faker faker, int result) {
		
		this.name = faker.gameOfThrones().house();
		this.releaseYear = result;
	}
	
	public String getAlbumName() {
		
		return name;
	}
	
	public int getAlbumReleaseYear() {
		
		return releaseYear;
	}
	public void setAlbum(Faker faker, int result) {
			
			this.name = faker.gameOfThrones().house();
			this.releaseYear = result;
		}
		
	}
	

