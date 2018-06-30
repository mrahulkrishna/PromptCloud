import java.io.File;
import java.io.PrintWriter;

import java.util.Scanner;


public class match_binary_operator_supporter
{
public static void main(String[] args) throws Exception
{
		  
		  int n=0;
		  boolean arrayinput= true;
		  String arr[] = new String[n];
		  PrintWriter writer = new PrintWriter("output.txt");
		  Scanner sc=  new Scanner(new File("input.txt"));  
			 while(sc.hasNext())
			 {
			  String input = sc.nextLine();
			  
	           if(arrayinput)
	         {  
	        	input  = input.replace("[","");
	        	input = input.replace("]", "");
	        	input= input.replace(" ","");
	        	arr = input.split(",");
	        	n = arr.length;
	        	arrayinput=false;
	         }
	           else
	           {  
	        	   
	        	   if(input.length()==0)
	        	   {
	        		 writer.println("No Input Provided!"); 
	        	   }
	        	   else  
	        		   if(input.charAt(0)=='"')
	        	   { 
	       
	        		   writer.println("Exception :"+input+" is a string!");
	        	   }
	        	   else 
	        	   {
	        		 int x =0;
	        		 int count=0;
	        		 for(int j=0;j<arr.length;j++)
	        		 {
	        			if(input.equals(arr[j]))
	        			{
	        				count++;
	        			}
	        		 }
	        		 if(count==0)
	        		 {
	        			writer.println("Exception :"+input+" is not in list!"); 
	        		 }
	        		 else if (count >1)
	        		 {
	        			 writer.println("Exception : "+input+" is a duplicate entry!");
	        		 }
	        		 else {
	        		 int no = Integer.parseInt(input);
	        		 int n1 = no;
	        		 while(no>0)
	        		 {
	        			 no = no/2;
	        			 x++;
	        		 }
	        		 boolean check = false;
	        		 String suppoter = String.valueOf((n1+x));
	        		 for(int j=0;j<arr.length;j++)
	        		 {
	        			if(suppoter.equals(arr[j]))
	        			{
	        				check=true;
	        			}
	        		 }
	        		 if(check)
	        		 {
	        			 writer.println(n1+" is SUPPORTED BY THE NUMBER "+suppoter);
	        		 }
	        		 else
	        		 {
	        			 writer.println(n1+" is NOT SUPPORTED ");
	        		 }
	        		 
	        	     } 
	        	 }	        	   
	           }
			 }	
	writer.close();
	sc.close();
  }
}
