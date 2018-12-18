package Stream;

import java.util.List;

public class Boxer {
	
	public Integer weight;
	public final String name;
	public Integer age;
	public final List<Boxer> adversaries;
	public final List<Arena> fought;
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public List<Boxer> getAdversaries() {
		return adversaries;
	}

	public List<Arena> getFought() {
		return fought;
	}

	public City getBirthplace() {
		return birthplace;
	}

	public final City birthplace;
	
	public Boxer(Integer weight, String name, Integer age, List<Boxer> adversaries, List<Arena> fought, City birthplace) {
		
		this.weight=weight;
		this.name= name;
		this.age=age;
		this.adversaries=adversaries;
		this.fought=fought;
		this.birthplace=birthplace;
	}

}
