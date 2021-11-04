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

		
		StatsFunctions objStatsFunctions = new StatsFunctions();
		
		enteredDataValuesByUser = objStatsFunctions.collectData();
			//DEBUG:System.out.println(objStatsFunctions.dataValuesToString());
			//DEBUG: System.out.println();
			
		objStatsFunctions.calculateMean(enteredDataValuesByUser);
			//DEBUG:System.out.println("Number of data values: " +objStatsFunctions.getNumberOfDataValues());
			//DEBUG: System.out.println("Mean: " + objStatsFunctions.getMean());
		
			//DEBUG:objStatsFunctions.calculateMedian();
			//DEBUG:System.out.println(objStatsFunctions.getMedian());

		
			
			
			
			

}

	
}