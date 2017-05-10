package com.rajasekar.desingpattern.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class SingleTonPatternExampleTestCase{

	@Test
	public void testSingleTonInstance(){
		
		final ExecutorService executor = Executors.newFixedThreadPool(5);
		List<Future<SingleTonPatternExample>> futureList = IntStream.rangeClosed(1,10).mapToObj(data -> {
				Future<SingleTonPatternExample> future = executor.submit(() -> SingleTonPatternExample.getInstance());
				return future;
		}).collect(Collectors.toList());
		Optional<Future<SingleTonPatternExample>> futureOptinal = futureList.stream().findAny();
		SingleTonPatternExample referenceInstance = null;
		try {
			referenceInstance = futureOptinal.isPresent()?futureOptinal.get().get():null;
			assertNotNull(referenceInstance);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			final SingleTonPatternExample tmpVaraible = referenceInstance;
			futureList.stream().forEach(future -> {
				try{
					System.out.println("Assert is true");
					assertTrue(future.get() == tmpVaraible);
				}catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		
	}
}
