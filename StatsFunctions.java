import java.util.ArrayList;
import java.util.Scanner;

public class StatsFunctions
{
	//create instance data
		private Scanner inputScanner;
		private ArrayList<Double> dataValuesArrayList, minToQ1DataValues, medToMaxDataValues;
		private String data;
		private Double dataClones;
		private double mean, median, q1, q3, numberOfDataValues, sumOfDataValues, iqr;

		

	//******************************************
	//CONSTRUCTOR
	//******************************************
		public StatsFunctions()
		{
			inputScanner = new Scanner(System.in);
			dataValuesArrayList = new ArrayList<Double>();
			dataClones = null;
			mean = 0;
			median = 0; 
			q1= 0; 
			q3= 0; 
			sumOfDataValues = 0;

			minToQ1DataValues = new ArrayList<Double>();
			medToMaxDataValues = new ArrayList<Double>();
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
			//int i = 0;
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
			}
			
			else
			{
				median = dataValuesArrayList.get(((int) Math.ceil(numberOfDataValues / 2)) - 1);				
			}
		}

	//Calculates IQR
		public void calculateIQR()
		{
			iqr = q3- q1;
		}

	//Methods to calculate Q1 and Q3 - create a seperate array for them and then do "median" calculations again
		public void calculateQ1()
		{
			if(numberOfDataValues % 2 == 0)
			{
				for(int i=0; i<= (int)((numberOfDataValues / 2) - 1); i++)
				{
					minToQ1DataValues.add(dataValuesArrayList.get(i));
					
				}

				if(minToQ1DataValues.size() % 2 == 0)
				{
					q1 = (minToQ1DataValues.get(((minToQ1DataValues.size() / 2) - 1)) + minToQ1DataValues.get((minToQ1DataValues.size()/2))) / 2;
				}
			
				else
				{
					q1 = dataValuesArrayList.get(((minToQ1DataValues.size() / 2)));				
				}	
			}

			else
			{
				for(int i=0; i<= (int)((numberOfDataValues / 2) - 1); i++)
				{
					minToQ1DataValues.add(dataValuesArrayList.get(i));
					
				}

				if(minToQ1DataValues.size() % 2 == 0)
				{
					q1 = (minToQ1DataValues.get(((minToQ1DataValues.size() / 2) - 1)) + minToQ1DataValues.get((minToQ1DataValues.size()/2))) / 2;
				}
			
				else
				{
					q1 = minToQ1DataValues.get(((minToQ1DataValues.size() / 2)));				
				}
			}
		}

		public void calculateQ3()
		{
			if(numberOfDataValues % 2 == 0)
			{
				for(int i=(int)((numberOfDataValues / 2) - 1); i<=numberOfDataValues - 1; i++)
				{
					medToMaxDataValues.add(dataValuesArrayList.get(i));
					
				}

				if(medToMaxDataValues.size() % 2 == 0)
				{
					q1 = (medToMaxDataValues.get(((medToMaxDataValues.size() / 2) - 1)) + medToMaxDataValues.get((medToMaxDataValues.size()/2))) / 2;
				}
			
				else
				{
					q1 = medToMaxDataValues.get(((medToMaxDataValues.size() / 2)));				
				}
			}

			else
			{
				for(int i=(int)((numberOfDataValues / 2) + 1); i<=numberOfDataValues - 1 ; i++)
				{
					medToMaxDataValues.add(dataValuesArrayList.get(i));
					
				}

				if(medToMaxDataValues.size() % 2 == 0)
				{
					q3 = (medToMaxDataValues.get(((medToMaxDataValues.size() / 2) - 1)) + medToMaxDataValues.get((medToMaxDataValues.size()/2))) / 2;
				}
			
				else
				{
					q3 = medToMaxDataValues.get(((medToMaxDataValues.size() / 2)));				
				}
			}
		}
			
	
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

		public double getIQR()
		{	
			return iqr;
		}


		public String dataValuesToString()
		{
			return "[dataValuesArrayList=" + dataValuesArrayList + "]";
		}
		
		public String DataSummary()
		{
			System.out.println();
			return "Summary:\nMean = " + mean + "\nMedian = " + median + "\nQ1 = " + q1 + "\nQ3 = " + q3 + "\nIQR = " + iqr;
		}
	}
