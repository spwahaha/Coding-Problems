package fb;

import java.util.Set;

public class Person {
	int id;
	Set<Person> frineds;
	public Person(int id, Set<Person> friends){
		this.id = id;
		this.frineds = friends;
	}
}
