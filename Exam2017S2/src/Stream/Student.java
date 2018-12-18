package Stream;

import java.util.List;

public class Student {
	
	private  String name;
	private Integer year;
	private  List<Course> followed;
	private  List<Course> validated;
	
	public Student(String name,Integer year,List<Course> followed,List<Course> validated) {
		this.name=name;
		this.year=year;
		this.followed=followed;
		this.validated=validated;
	}
	
	public Student()
	{
		
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public List<Course> getFollowed() {
		return followed;
	}

	public List<Course> getValidated() {
		return validated;
	}
 
}
