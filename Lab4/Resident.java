
public class Resident {
	String name;
	int priority;
	public Resident(String name, int priority)
	{
		this.name=name;
		this.priority = priority;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getName()
	{
		return name;
	}
	
}
