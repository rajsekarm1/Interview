package com.rajasekar.collections;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Integer> treeSet = new TreeSet<>();
		
		treeSet.add(new Integer(1));
		treeSet.add(new Integer(2));
		treeSet.add(new Integer(3));
		treeSet.add(new Integer(4));
		treeSet.add(new Integer(5));
		treeSet.add(new Integer(6));
		treeSet.add(new Integer(7));
		treeSet.add(new Integer(9));
		treeSet.add(new Integer(8));
		
		NavigableSet<Integer> naviSet = (NavigableSet<Integer>)treeSet;
		naviSet = naviSet.descendingSet();
		
		/*while(iterator.hasNext()){
			System.out.println("Iterator value:"+iterator.next());
			
		}*/
		System.out.println(naviSet);

	}

}
