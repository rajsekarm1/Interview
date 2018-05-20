package com.rajasekar.collections;

import java.util.HashSet;
import java.util.Set;

class Person{
	int id;
	String name;
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode(){
		return id%8;
	}
	
	@Override
	public boolean equals(Object obj){
		Person person=(Person)obj;
		if(person.id==this.id){
			System.out.println("coming here");
			return true;
		}
		else{
			System.out.println("coming here1");
			return false;
		}
	}
	
}

public class HashSetExample {

	public static void main(String[] args) {
		Person p1 = new Person(8,"Raja");
		Person p2 = new Person(16,"Sekar");
		Person p3 = new Person(16,"Sekar");
		Set<Person> personSet = new HashSet<Person>();
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		
		
		System.out.println(personSet);

	}

}
