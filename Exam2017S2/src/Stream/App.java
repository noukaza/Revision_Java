package Stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.stream.Stream;

public class App {
	
	public static List<Student> Question1(Stream<Student> std)
	{
		return std.filter(s->s.getValidated().size()!=0).collect(toList());
	}
	
	public static Set<Course> Question2(Stream<Student> s)
	{
		return s.flatMap(std->std.getFollowed().stream()).collect(toSet());
	}

	public static Set<Student> Question3(Stream<Course> crs)
	{
		return crs.flatMap(c->c.getAssociated().stream()).flatMap(e->e.getWhoFollowed().stream()).collect(toSet());
	}
	
	public static Set<Student> Question4(Stream<Professor> prof )
	{
		return prof.flatMap(p->p.getTaught().stream()).flatMap(c->c.getWhoFollowed().stream()).collect(toSet());
	}
	
	public static Map<Integer, List<Professor>> Question5(Stream<Professor> prof)
	{
		return prof.collect(groupingBy(p->p.getTaught().size()));
	}
	

}
