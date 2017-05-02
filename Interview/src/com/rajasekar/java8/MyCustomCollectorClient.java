package com.rajasekar.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.*;

class MyCustomCollector<T> implements Collector<T, List<T>, List<T>>{

	@Override
	public Supplier<List<T>> supplier() {
		return () -> new ArrayList<T>();
	}

	@Override
	public BiConsumer<List<T>, T> accumulator() {
		return (list, entity)->{
			list.add(entity);
		};
	}

	@Override
	public BinaryOperator<List<T>> combiner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<List<T>, List<T>> finisher() {
		return Function.identity();
	}

	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		// TODO Auto-generated method stub
		return Collections.singleton(Characteristics.IDENTITY_FINISH);
	}
	
	
}



public class MyCustomCollectorClient {

	public static void main(String[] args) {
		Stream<String> strStream = Stream.of("raja","sekar","naveen","praveen");
		List<String> strList = strStream.filter(str -> 1==1)
		.collect(new MyCustomCollector<String>());
		strList.forEach(System.out::println);
	}

}
