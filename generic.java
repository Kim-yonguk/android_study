package mobileQuick;

import java.util.*;
public class generic {
	
	static ArrayList<Integer> a;
	static ArrayList<String> b;
	
	public void main(String []args)
	{
		a=new ArrayList<Integer>();
		b=new ArrayList<String>();
		for(int i=0; i<5; i++)
		{
			System.out.println("입력하시오:");
			Scanner sc=new Scanner(System.in);
			String st=sc.nextLine();
		
			if(isStringDouble(st))
			{
				a.add(Integer.parseInt(st));
			}
			else
			{
				b.add(st);
			}
		}
		
		for(int i=0;i<a.size(); i++)
		{
			System.out.print(a.get(i));
		}
		for(int j=0; j<b.size(); j++)
		{
			System.out.print
			(b.get(j));
		}
	}
	public static boolean isStringDouble(String st)
	{
		try{
			Double.parseDouble(st);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	

}
