package com.rajasekar.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Person{
	int age;
	String name;
	String gender;
	
	public Person(int age, String name, String gender) {
		super();
		this.age = age;
		this.name = name;
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}

public class Sorting {

	public static void main(String[] args) {
		Person p = new Person(15,"raj","M");
		Person p1 = new Person(15,"raj","M");
		Person p2 = new Person(15,"raj","M");
		List<Person> personList = Arrays.asList(p,p1,p2);
		
		
		Comparator<Integer> comp = Integer::compareTo;
	}

}
