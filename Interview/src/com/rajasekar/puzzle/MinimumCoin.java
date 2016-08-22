package com.rajasekar.puzzle;

public class MinimumCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int coins[] = {1,2,5,10,50};
		
		int number = 25;
		
		int requiredCoin=0;
		
		/*while(number>0){
			for(int i = coins.length-1 ;i>=0;i--){
				if(number-coins[i]>=0){
					
					number = number-coins[i];
					System.out.println(number);
					requiredCoin++;
					break;
				}
			}
		}*/
		System.out.println(recursive(number,coins));
	}
	
	public static int recursive(int number, int coins[]){
		if(number<=0)
			return 0;
		
		for(int i = coins.length-1 ;i>=0;i--){
			if(number-coins[i]>=0){
				
				number = number-coins[i];
				
				return 1 + recursive(number, coins); 
			}
		}
		
		return 0;
			
	}

}
