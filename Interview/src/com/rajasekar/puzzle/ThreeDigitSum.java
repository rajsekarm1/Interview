package com.rajasekar.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeDigitSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int digitValue[] = {-1,-1,2,-2,3,4,5};
		Arrays.sort(digitValue);
		List<int[]> zeroSumDigit = new ArrayList<int[]>();
		
		for(int i=0;i<digitValue.length;i++){
			int currentValue = digitValue[i];
			
			if(i!=0 && currentValue==digitValue[i-1]){
				continue;
			}
			
			int startIndex = i+1;
			int endIndex = digitValue.length-1;
			while(startIndex<endIndex){
				if(currentValue+digitValue[startIndex]+digitValue[endIndex]==0){
					int zeroSubArray[] = new int[3];
					zeroSubArray[0] = currentValue;
					zeroSubArray[1] = digitValue[startIndex];
					zeroSubArray[2] = digitValue[endIndex];
					zeroSumDigit.add(zeroSubArray);
					break;
				}
				if(currentValue+digitValue[startIndex] > digitValue[endIndex]){
					startIndex++;
				}else {
					endIndex--;
				}
				
			}
		}
		
		zeroSumDigit.stream().forEach(data -> {
			for(int z: data){
				System.out.print(z+" ");
			}
			System.out.println(" ");
		});
		
		
	}
	
	
	

}
