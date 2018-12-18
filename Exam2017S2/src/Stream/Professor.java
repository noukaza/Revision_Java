package Stream;

import java.util.List;

public class Professor {
	
	private  String name;
	private  List<Course> taught;
	
	public Professor(String name,List<Course> taught) 
	{
		this.name=name;
		this.taught=taught;
		
		
	}
	
	public Professor()
	{
		
	}

	public String getName() {
		return name;
	}

	public List<Course> getTaught() {
		return taught;
	}
}
