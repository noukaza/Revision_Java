package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
	
	
	
	
	public List<City> VillesMoinsHab(Stream<City> citys)
	{
		return citys.filter(c->c.getInhabitants().size()<10000).collect(Collectors.toList());
	}
	
	public Optional<Monument> MonumentVieux(Stream<Monument> mon)
	{
		return mon.max((x,y)->x.setAge()-y.getAge());
		//return mon.reduce((m1,m2)->m1.getAge()<m2.getAge()?m1:m2);
	}
	
	public Set<Monument> MonumentVisite(Stream<Person> per)
	{
		return per.flatMap(p->p.getVisited().stream()).collect(Collectors.toSet());
	}
	
	public static Set<Person> visiteHabite(Stream<Person> per )
	{
		return per.filter(p->p.getVisited()
				.stream()
				.filter(m->m.getLocation().getInhabitants().contains(p))
				.count()>0)
				.collect(Collectors.toSet());
	}
	
	public Map<Integer,List<Person>> PersonePerMonument(Stream<Person> per)
	{
		return per.collect(Collectors.groupingBy(p->p.getVisited().size()));
	}
	

	

}
