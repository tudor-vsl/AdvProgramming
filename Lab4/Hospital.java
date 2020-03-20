
public class Hospital implements Comparable<Hospital> {

	String name;
	int capacity;
	
	public Hospital(String name,int capacity)
	{
		this.name = name;
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getName()
	{
		return name;
	}

	@Override
	public String toString() {
		return  name ;
	}

	@Override
	public int compareTo(Hospital o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
