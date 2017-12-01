package com.rajasekar.util;

class Car {

    int maxspeed;

    Car() {
        maxspeed = 70;
    }

    protected void finalize() {

    // Originally finalize method does nothing, but here we override finalize() saying it to print some stmt
    // Calling of finalize is uncertain. Difficult to observe so we force JVM to call it by System.gc(); GarbageCollection

        System.out.println("Called finalize method in class Car...");
    }
}

class Bike {

    int maxspeed;

    Bike() {
        maxspeed = 50;
    }

    protected void finalize() {
        System.out.println("Called finalize method in class Bike...");
    }
}

class FinalKeywordDifference {

    public static void main(String args[]) {
        Car c = new Car();
        c = null;    // if c weren`t null JVM wouldn't be certain it's cleared or not, null means has no future use or no longer in use hence clears it
        Bike b = new Bike();
        System.gc();    // should clear c, but not b
        for (b.maxspeed = 1; b.maxspeed <= 70; b.maxspeed++) {
            System.out.print("\t" + b.maxspeed);
            if (b.maxspeed > 50) {
                System.out.println("Over Speed. Pls slow down.");
            }
        }
    }
}


/*public class FinalKeywordDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalKeywordDifference _instance = new FinalKeywordDifference();
		_instance = null;
		System.out.println("main method exit");
	}
	
	protected void finalize() throws Throwable{
		System.out.println("finalize called");
	}

}*/
