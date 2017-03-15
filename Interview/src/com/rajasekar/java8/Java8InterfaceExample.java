package com.rajasekar.java8;

interface SuperInterface {
	static void methodOfSuperInterface(){
		System.out.println("static SuperInterface::methodOfSuperInterface");
	}
	
	default public void defaultMethod(){
		System.out.println("default SuperInterface::defaultMethod");
	}
}

interface I2SuperInterface{
	default public void defaultMethod(){
		System.out.println("default I2SuperInterface::defaultMethod");
	}
}

interface SubSuperInterface extends SuperInterface{
	
	@Override
	default public void defaultMethod() {
		System.out.println("default SubSuperInterface::defaultMethod");
	}
	
}

abstract class  SuperClass {
	public void defaultMethod(){
		System.out.println("class SuperClass:: defaultMethod");
	}
}

class ClassOfSubSuperInterface implements SubSuperInterface,I2SuperInterface{
	public void defaultMethod(){
		I2SuperInterface.super.defaultMethod();
	}
}


public class Java8InterfaceExample {

	public static void main(String[] args) {
		SuperInterface.methodOfSuperInterface();
		ClassOfSubSuperInterface supInt = new ClassOfSubSuperInterface();
		supInt.defaultMethod();
		

	}

}
