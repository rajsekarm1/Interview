package com.rajasekar.collections;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashSet;
import java.util.Set;

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
