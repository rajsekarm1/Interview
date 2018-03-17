package com.rajasekar.performance;

import java.time.Duration;
import java.time.Instant;

enum Day {
	NoMoonDay,
	Monday,
	Tuesday,
	Wednesday,
	Thursday,
	Friday,
	Saturday,
	Sunday;
}

public class IfElseVsSwitch {

	public static void main(String[] args) {
		
		for(int a =0;a<100;a++){
		int limit=10000000;
		Day dayArray[] = Day.values();
		Instant startTime = Instant.now();
		for(int i=0;i<limit;i++){
			int y= i%dayArray.length;
			//System.out.print(ifElseTime(dayArray[y]));
			ifElseTime(dayArray[y]);
		}
		Instant endTime = Instant.now();
		System.out.println("\nIf else Time taken:"+Duration.between(startTime, endTime).toMillis());
		
		Instant startTime1 = Instant.now();
		for(int i=0;i<limit;i++){
			int y= i%dayArray.length;
			//System.out.print(switchTime(dayArray[y]));
			switchTime(dayArray[y]);
		}
		Instant endTime1 = Instant.now();
		System.out.println("Switch time taken:"+Duration.between(startTime1, endTime1).toMillis());
		}
	}
	
	public static Day ifElseTime(Day day){
		if(day == Day.Monday) return Day.Monday;
		else if(day == Day.Tuesday) return Day.Tuesday;
		else if(day == Day.Wednesday) return Day.Wednesday;
		else if(day == Day.Thursday) return Day.Thursday;
		else if(day == Day.Friday) return Day.Friday;
		else if(day == Day.Saturday) return Day.Saturday;
		else if(day == Day.Sunday) return Day.Sunday;
		else if(day == Day.NoMoonDay) return Day.NoMoonDay;
		else return null;
		
	}
	
	public static Day switchTime(Day day){
		
		switch(day){
			case Monday: return Day.Monday;
			case Tuesday: return Day.Tuesday;
			case Wednesday: return Day.Wednesday;
			case Thursday: return Day.Thursday;
			case Friday: return Day.Friday;
			case Saturday: return Day.Saturday;
			case Sunday: return Day.Sunday;		
			case NoMoonDay: return Day.NoMoonDay;
			default:
				return null;
			
		}
		
		
	}

}
