package Stream;

import java.util.List;

public class City {
	
	public final String name;
	public final List<City> twins;
	
	public City(String name, List<City> twins)
	{
		this.name=name;
		this.twins=twins;
	}

}
