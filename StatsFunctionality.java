package stats.project;

import java.util.ArrayList;
import java.util.Scanner;

public class StatsFunctionality
{
	//*************************************************************************
	//METHOD TO COLLECT THE DATA
	//*************************************************************************
		@SuppressWarnings({ "static-access" })
		protected ArrayList<Double> collectData()
		{
			Scanner sc = new Scanner(System.in);
			ArrayList<Double> dataValuesArrayList = new ArrayList<Double>();
			
			System.out.println("Enter the data values. Enter the code DONE when done");
			
				String data;
				Double dataClones = null;
					do
					{
						data = sc.nextLine();
						
						if(!data.equalsIgnoreCase("DONE"))
						{
							dataClones = dataClones.parseDouble(data);
							dataValuesArrayList.add(dataClones);
						}
						
					}
					while(!data.equalsIgnoreCase("DONE"));
				
				//Debug: System.out.println(dataValuesArrayList.toString());
				
				return dataValuesArrayList;
		}
	
		
		
	//************************************************************
	//METHOD TO CALCULATE THE 5 NUMBER SUMMARY
	//************************************************************
		protected ArrayList<Double> calculateFiveNumberSummary(ArrayList<Double> dataValuesArrayList)
		{
			//Arraylist to return multiple data points back to the main method
				ArrayList<Double> returning5NumberSummary = new ArrayList<Double>();
			
			//Variables
			double mean, median, q1, q3, numberOfDataValues, sumOfDataValues = 0;
			
			numberOfDataValues = dataValuesArrayList.size();
			
			//loop to add all the values
				for(int i = 0; i <= dataValuesArrayList.size() - 1; i++)
				{
					sumOfDataValues+=dataValuesArrayList.get(i);
				}
			
			//calculate the mean below and add to ArrayList
				mean = sumOfDataValues / numberOfDataValues;
				returning5NumberSummary.add(mean);
			
				
	
			//calculate the median 
				if(numberOfDataValues % 2 == 0)
				{
					median = (dataValuesArrayList.get((int)((numberOfDataValues / 2) - 1)) + dataValuesArrayList.get((int)(numberOfDataValues/2))) / 2;
					returning5NumberSummary.add(median);

					//DEBUG (this function works): System.out.println(median);
				}
				
				else
				{
					median = dataValuesArrayList.get(((int) Math.ceil(numberOfDataValues / 2)) - 1);
					returning5NumberSummary.add(median);
					
					//DEBUG: System.out.println(Math.ceil(numberOfDataValues / 2));
					//DEBUG (This function works): System.out.println(median);
				}
				
			
				/*	
				//calculate Q1 
					
					//create a copy up to median to calculate Q1
					if(numberOfDataValues % 2 == 0)
					{
						ArrayList<Double> q1OfDataSet = new ArrayList<Double>();

						for(int i = 0; i <= Math.ceil(numberOfDataValues / 2); i++)
						{
							q1OfDataSet.add(dataValuesArrayList.get(i));
							
						}
						
						//DEBUG: System.out.println(q1OfDataSet.toString());
						q1 = (q1OfDataSet.get((int)Math.ceil(numberOfDataValues / 2) - 1) + dataValuesArrayList.get((int)Math.floor(numberOfDataValues/2) / 2));
						System.out.println(q1);
					}
						
					else
					{
						ArrayList<Double> q1OfDataSet = new ArrayList<Double>();

						for(int i = 0; i < Math.ceil(numberOfDataValues / 2) - 1; i++)
						{
							q1OfDataSet.add(dataValuesArrayList.get(i));
						}
						
						System.out.println(q1OfDataSet.toString());

						q1 = q1OfDataSet.get(Math.ceil(numberOfDataValues / 2) - 1);
						//System.out.println(q1);


						
			
					}
					
					*/
				return returning5NumberSummary;

			
				
			
			
			
			
		}
	
   
}
