package Stream;

import java.util.List;

public class Course {
	
	private  String name;
	private  List<Student> whoFollowed;
	private  List<Course> associated;
	
	public Course(String name,List<Student> whoFollowed, List<Course> associated)
	{
		this.name=name;
		this.whoFollowed=whoFollowed;
		this.associated=associated;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public List<Student> getWhoFollowed() {
		return whoFollowed;
	}

	public List<Course> getAssociated() {
		return associated;
	}

}
