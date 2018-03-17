package com.rajasekar.collections;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashSet;
import java.util.Set;

class Person{
	int id;
	public int getId() {
		return id;
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;
	
	public int hashCode() {
		return id;
		
	};
	
	@Override
	public boolean equals(Object person){
		if(!Person.class.isInstance(person)){
			return false;
		}
		
		if(person==null){
			return false;
		}
		Person per = (Person)person;
		if(per.getId() == id){
			return true;
		}else{
			return false;
		}
		
	}
}
public class HashSetExample {

	public static void main(String[] args) {
		Person p1 = new Person(1,"Raja");
		Person p2 = new Person(2,"Sekar");
		Person p3 = new Person(2,"Sekar");
		Set<Person> personSet = new HashSet<Person>();
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		
		
		System.out.println(personSet.size());

	}

}
