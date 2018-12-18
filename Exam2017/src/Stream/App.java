package Stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class App {


	public List<Boxer> moins80(Stream<Boxer> boxers)
	{
		return boxers.filter(b->b.weight<80).collect(Collectors.toList());
	}

	public Optional<Integer> maxBoxer(Stream<Boxer> boxers)
	{
		return boxers.map(b->b.age).reduce(Integer::max);
	}

	public Set<City> BoxerCitys(Stream<Boxer> boxers)
	{
		// si on utilise map a la place de flat map il retourne Stream<List<City>> mais flatmap nous donne Stream<City>
		return boxers.flatMap(b->b.fought.stream()).map(a->a.location).flatMap(f->f.twins.stream()).collect(Collectors.toSet());
	}

	/*public Set<Boxer> BoxerCitysbrth(Stream<City> citys,List<Boxer> boxers)
	{
	
		return citys.map(c-> {for(Boxer b:boxers)
		{
			if(b.birthplace==c)
				return b;
			else 
				return null;
		}			
		return null;}).collect(Collectors.toSet());
	}*/


	public Map<City,List<Boxer>> question4(Stream<Boxer> boxers)
	{
		return boxers.collect(Collectors.groupingBy(B->b.getFought().stream().flatMap(m->m.location).stream()));
	}
}
