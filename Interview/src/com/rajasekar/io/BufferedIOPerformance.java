package com.rajasekar.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class BufferedIOPerformance {

	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("key1","value1");
		// TODO Auto-generated method stub
		Path path = FileSystems.getDefault().getPath("/Users/rajsekarm/git/Interview/Interview/src", "Request.xml");
		StringBuffer buffer = new StringBuffer();
		Instant startTime = Instant.now();
		try(InputStream fin = Files.newInputStream(path)) {
			BufferedInputStream bis = new BufferedInputStream(fin);
			DataInputStream dis = new DataInputStream(bis);
            String temp = null;
            while((temp = dis.readLine()) != null){
            	buffer.append(temp);
            }
			/*while(bis.available()>0) {
		         
	            // read the byte and convert the integer to character
	            buffer.append((char)bis.read());

	            // print the characters
	            System.out.println("Char: "+c);;
	         }*/
			
			//This block is to test reading from file input stream. 
		/*	StringBuffer buffer = new StringBuffer();
			int i = 0;
			while((i = fin.read())!=-1){
				char ch = (char)i;
				buffer.append(ch);
			}*/
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(buffer.toString());
		Instant endTime = Instant.now();
		System.out.println(Duration.between(startTime, endTime).toMillis());
	}

}
