package com.rajasekar.collections;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		Person p1 = new Person(1,"Sekar1");
		Person p4 = new Person(4,"Sekar4");
		Person p2 = new Person(2,"Sekar2");
		Person p3 = new Person(3,"Sekar3");
		
		Comparator<Person> personCompare = (Person pa1, Person pa2) -> { 
				if(pa1.getId() == pa2.getId())
					return 0;
				if(pa1.getId() > pa2.getId())
					return 1;
				else 
					return -1;
			};
		
		TreeSet set = new TreeSet(personCompare);
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		
		System.out.println("The set value:"+set);
		
		TreeSet set1 = new TreeSet();
		set1.add(p1);
		set1.add(p2);
		set1.add(p3);
		set1.add(p4);
		
		//set1.
		System.out.println("The set value   :"+set1);

	}

}
