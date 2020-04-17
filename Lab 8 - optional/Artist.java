import com.github.javafaker.Faker;

public class Artist {

	//private Faker faker = new Faker();
	
	private String name;
	private String country;
	
	public Artist(Faker faker)
	{
		this.name = faker.artist().name();
		this.country = faker.country().name();
	}
	
	public void setArtist(Faker faker)
	{
		this.name = faker.artist().name();
		this.country = faker.country().name();
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCountry()
	{
		return country;
	}
	
}
