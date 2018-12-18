package Stream;

import java.util.List;

public class Arena {
	
	public final String name;
	public	 final List<Boxer> fighters;
	public final City location;
	
	public Arena(String name,List<Boxer> fighters,City location) {
		this.name=name;
		this.fighters=fighters;
		this.location=location;
	}

}
