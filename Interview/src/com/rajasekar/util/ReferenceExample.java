package com.rajasekar.util;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strPhantomRef = new String("String Phantom Reference");
		ReferenceQueue refQueue1 = new ReferenceQueue();
		PhantomReference<String> phRef = new PhantomReference<String>(strPhantomRef,refQueue1);
		System.out.println("Phantom reference:"+phRef.get());
		//System.out.println("strPhantomRef"+strPhantomRef);
		strPhantomRef=null;
		
		String strongRef = new String("String Strong Reference");
		ReferenceQueue refQueue = new ReferenceQueue();
		WeakReference<String> weakRef = new WeakReference<String>(strongRef,refQueue);
		
		strongRef = null;
		for(int i= 0; i<100 ; i++)
			System.gc();
		System.out.println("WeakReference Data:"+weakRef.get());
		System.out.println(refQueue1.poll());
		
		String strongRef2 = new String("String2 Strong Reference");
		SoftReference<String> softRef = new SoftReference<String>(strongRef2);
		System.out.println("SoftReference Data:"+softRef.get());
		
		
		
		
	}
	/*
	 //reference will be stored in this queue for cleanup DigitalCounter digit = new DigitalCounter(); 
	PhantomReference<DigitalCounter> phantom = new PhantomReference<DigitalCounter>(digit, refQueue);

	Read more: http://javarevisited.blogspot.com/2014/03/difference-between-weakreference-vs-softreference-phantom-strong-reference-java.html#ixzz4y2d3eWx3

*/}
