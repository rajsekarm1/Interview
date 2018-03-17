package com.rajasekar.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaticCompareMethodExample {
	
	public static int compareIpaddress(String s1, String s2){
		String []s1SplitArray = s1.split("\\.");
		String []s2SplitArray = s2.split("\\.");
		
		for(int i=0;i<s1SplitArray.length;i++){
			int value = s1SplitArray[i].compareTo(s2SplitArray[i]);
			if (value == 0){
				continue;
			}else{
				return value;
			}
		}
		return 0;
	}
	
	
		public static boolean isNumeric(String str)  
		{  
		  try  
		  {  
		    double d = Double.parseDouble(str);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }  
		  return true;  
		}
	
	

	public static void main(String[] args) {
		List<String> ipList = new ArrayList<>();
		ipList.add("172.18.138.132");
		ipList.add("172.18.138.131");
		
		
		ipList.sort(StaticCompareMethodExample::compareIpaddress);
		List<String> newList = ipList.stream().filter(StaticCompareMethodExample::isNumeric).collect(Collectors.toList());
		
		System.out.println(ipList);
		
		

	}

}
