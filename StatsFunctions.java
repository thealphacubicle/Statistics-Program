package stats.project;

import java.util.ArrayList;
import java.util.Scanner;

public class StatsFunctions
{
	//create instance data
		private Scanner inputScanner;
		private ArrayList<Double> dataValuesArrayList, q1OfDataSet;
		private String data;
		private Double dataClones;
		private double mean, median, q1, q3, numberOfDataValues, sumOfDataValues;

	//******************************************
	//CONSTRUCTOR
	//******************************************
		public StatsFunctions()
		{
			inputScanner = new Scanner(System.in);
			dataValuesArrayList = new ArrayList<Double>();
			q1OfDataSet = new ArrayList<Double>();
			dataClones = null;
			mean = 0;
			median = 0; 
			q1= 0; 
			q3= 0; 
			sumOfDataValues = 0;
		}
	
	
	//*************************************************************************
	//METHOD TO COLLECT THE DATA
	//*************************************************************************
		@SuppressWarnings({ "static-access" })
		public ArrayList<Double> collectData()
		{			
			System.out.println("Enter the data values. Enter the code DONE when done");
			
					do
					{
						data = inputScanner.nextLine();
						
						if(!data.equalsIgnoreCase("DONE"))
						{
							dataClones = dataClones.parseDouble(data);
							dataValuesArrayList.add(dataClones);
						}
						
					}
					while(!data.equalsIgnoreCase("DONE"));
					
					numberOfDataValues = dataValuesArrayList.size();
								
				return dataValuesArrayList;
		}
	
		
		
	//**********************************************************************
	//METHODS TO CALCULATE THE 5 NUMBER SUMMARY (MEAN, MEDIAN, Q1, Q3, IQR)
	//**********************************************************************
		public void calculateMean(ArrayList<Double> dataValuesArrayList)
		{
			//sumOfDataValues
			//loop to add all the values
				for(int i = 0; i <= dataValuesArrayList.size() - 1; i++)
				{
					sumOfDataValues+=dataValuesArrayList.get(i);
				}
			
			//calculate the mean below and add to ArrayList
				mean = sumOfDataValues / numberOfDataValues;
						
		}
		
		public void calculateMedian()
		{
			if(numberOfDataValues % 2 == 0)
			{
				median = (dataValuesArrayList.get((int)((numberOfDataValues / 2) - 1)) + dataValuesArrayList.get((int)(numberOfDataValues/2))) / 2;

				//DEBUG (this function works): System.out.println(median);
			}
			
			else
			{
				median = dataValuesArrayList.get(((int) Math.ceil(numberOfDataValues / 2)) - 1);				
				//DEBUG: System.out.println(Math.ceil(numberOfDataValues / 2));
				//DEBUG (This function works): System.out.println(median);
			}
		}
		
		
		public void calculateQ1()
		{
			//create a copy up to median to calculate Q1
			if(numberOfDataValues % 2 == 0)
			{
				for(int i = 0; i <= Math.ceil(numberOfDataValues / 2); i++)
				{
					q1OfDataSet.add(dataValuesArrayList.get(i));
					
				}
				
				//DEBUG: System.out.println(q1OfDataSet.toString());
				q1 = (q1OfDataSet.get((int)Math.ceil(numberOfDataValues / 2) - 1) + dataValuesArrayList.get((int)Math.floor(numberOfDataValues/2) / 2));
				System.out.println(q1);
			}
				
			/*
			else
			{
				ArrayList<Double> q1OfDataSet = new ArrayList<Double>();
				
				for(int i = 0; i < Math.ceil(numberOfDataValues / 2) - 1; i++)
				{
					q1OfDataSet.add(dataValuesArrayList.get(i));
				}
				
				System.out.println(q1OfDataSet.toString());

				q1 = q1OfDataSet.get((int)Math.ceil(numberOfDataValues / 2) - 1);
				//System.out.println(q1);
			
			
			 */
	
			}
		
		
		/*
		
		protected ArrayList<Double> calculateFiveNumberSummary(ArrayList<Double> dataValuesArrayList)
		{		
			
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

						q1 = q1OfDataSet.get((int)Math.ceil(numberOfDataValues / 2) - 1);
						//System.out.println(q1);


						
			
					}
					
				return returning5NumberSummary;
	
		}
*/
	
	//*************************************************************************
	//GET/SET METHODS
	//*************************************************************************
		public double getMean()
		{
			return mean;
		}

		public double getMedian()
		{
			return median;
		}

		public double getQ1()
		{
			return q1;
		}

		public double getQ3()
		{
			return q3;
		}


		public double getSumOfDataValues()
		{
			return sumOfDataValues;
		}
		
		public double getNumberOfDataValues()
		{	
			return numberOfDataValues;
		}


		public String dataValuesToString()
		{
			return "[dataValuesArrayList=" + dataValuesArrayList + "]";
		}
		
		
		
		

		
	


	}
