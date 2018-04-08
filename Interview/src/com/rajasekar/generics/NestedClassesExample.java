package com.rajasekar.generics;

import com.rajasekar.collections.OuterClass;

public class NestedClassesExample {

	public static void main(String[] args) {
		OuterClass.StaticClass staticClass = new OuterClass.StaticClass(10,12); 
		//OuterClass out
		OuterClass.NormalClass normalClass = OuterClass.new NormalClass();
	}
	
	

}
