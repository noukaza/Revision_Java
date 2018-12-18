package Streams;

import java.util.List;

public class City {
	
	private String name;
	private List<Person> inhabitants;
	private List<Monument> monuments;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Person> getInhabitants() {
		return inhabitants;
	}
	public void setInhabitants(List<Person> inhabitants) {
		this.inhabitants = inhabitants;
	}
	public List<Monument> getMonuments() {
		return monuments;
	}
	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}
	
	

}
