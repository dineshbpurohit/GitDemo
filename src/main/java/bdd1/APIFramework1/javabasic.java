package bdd1.APIFramework1;

import java.util.ArrayList;

public class javabasic {

	public static void main(String[] args) {
		// Reverse String
		/*String str="dinesh";
		String t="";
		for(int i=str.length()-1;i>=0;i--)
		{
			char c =str.charAt(i);
			t = t+c;
		}
        System.out.println(t); */
		
		
		//Print the unique number from the list
		
		int a[]= {2,3,4,5,6,4,7,8,9,0,2,1,4,5,6};
		ArrayList<Integer> ab = new ArrayList<Integer>();
		
		int k=0;
		for(int i=0;i<a.length;i++)
		{
		  if(!ab.contains(a[i]))
		  {
			  ab.add(a[i]);
		  }
		}
	}

}
