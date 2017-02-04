package com.rajasekar;

import java.io.File;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1/2);
	}
	
	public void printTesting(){
		System.out.println("Testing class");
		
		File [] hiddenFiles = new File(".").listFiles(file -> file.isHidden());
		File [] hiddenFiles1 = new File(".").listFiles((File file) -> {
			if(file.isHidden()){
				return true;
			}
			else{
				return false;
			}
		});
		File [] hiddenFiles2 = new File(".").listFiles(File::isHidden);
		File [] hiddenFiles3 = new File(".").listFiles(File::isHidden);
	}
		
		
	

}
