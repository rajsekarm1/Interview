package com.rajasekar.puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestingBrackets {
	
	static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
        printParenthesis("",8,true);
        printParenthesis("",8,false);
        System.out.println(list);
        System.out.println(list.size());
        
        for(int i=0;i<list.size();i++){
        	System.out.println("Combinations:"+list.get(i)+"::::::::::::::::::::"+isValidBrackets(list.get(i)));        	
        }
       // System.out.println(isValidBrackets("(()())"));
   }
	
	private static boolean isValidBrackets(String bracketCombination){
		Stack stack = new Stack();
		for(int i=0;i<bracketCombination.length();i++){
			
			if(bracketCombination.charAt(i)=='('){
				stack.push('(');
			}else{
				if(!stack.isEmpty() && stack.peek().equals('(')){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
   

   static void printParenthesis(String str,int k,boolean isOpen){
	   if(k==0){
		   list.add(str);
		   return;
	   }
	   		
	   if(k>0){
		  
		   if(isOpen){
			   str = str+getOpenPranethesis();			   
		   }else{
			   str = str+getClaosePranethesis();
		   }
		   printParenthesis(str, k-1, true);
		   if(k-1!=0)
		   printParenthesis(str, k-1, false);
		   
	   }
       
   }
   static String getOpenPranethesis(){
	   return "(";
   }
   static String getClaosePranethesis(){
	   return ")";
   }
}
