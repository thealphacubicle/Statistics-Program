package stats.project;

import java.util.ArrayList;
import java.util.Scanner;

public class StatsMain
{

	public static void main(String[] args)
	{
		
		//objects
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> enteredDataValuesByUser = new ArrayList<Double>();
		ArrayList<Double> calculatedValues = new ArrayList<Double>();

		
		System.out.println("Welcome, select an option from the menu");
		System.out.println("1. Enter data for calculations");
		//TEMPORARY: System.out.println("2. Find the 5-number summary for already entered data");
			int userMenuChoice = sc.nextInt();
	
			
			if(userMenuChoice == 1)
			{
				StatsFunctionality collectData = new StatsFunctionality();
				enteredDataValuesByUser = collectData.collectData();
				
				StatsFunctionality calculation = new StatsFunctionality();
				calculatedValues = calculation.calculateFiveNumberSummary(enteredDataValuesByUser);	
				
				System.out.println("Your data set: " + enteredDataValuesByUser.toString());
				
				//Print the calculated summaries:
					System.out.println("Mean: " + calculatedValues.get(0));
					System.out.println("Median: " + calculatedValues.get(1));

			}
			/*
			if(userMenuChoice == 2)
			{
				//StatsFunctionality calculation = new StatsFunctionality();
				//calculation.calculateFiveNumberSummary();	
			}
			
			*/
			
			
			
			
	}

}
