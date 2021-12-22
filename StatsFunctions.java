import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * @author srihariraman
 *
 */
public class StatsFunctions
{
	//create instance data
		private Scanner inputScanner;
		private ArrayList<Double> dataValuesArrayList, minToQ1DataValues, medToMaxDataValues, outlierList, zScoreList;
		private String data;
		private Double dataClones;
		private double mean, median, q1, q3, numberOfDataValues, sumOfDataValues, iqr, standardDeviation, lowFence, highFence, zScore;

		

	//******************************************
	//CONSTRUCTORS
	//******************************************
		StatsFunctions()
		{
			inputScanner = new Scanner(System.in);
			dataValuesArrayList = outlierList = new ArrayList<Double>();
			dataClones = null;
			mean = zScore = 0;
			median = 0; 
			q1= 0; 
			q3= 0; 
			sumOfDataValues = 0;
			standardDeviation = 0;
			lowFence = highFence = 0;
			minToQ1DataValues = new ArrayList<Double>();
			medToMaxDataValues = new ArrayList<Double>();
			
		}
		
		StatsFunctions(ArrayList<Double> dataValuesArrayList)
		{
			inputScanner = new Scanner(System.in);
			this.dataValuesArrayList = dataValuesArrayList;
			//DEBUG: System.out.println(this.dataValuesArrayList);
			outlierList = new ArrayList<Double>();
			dataClones = null;
			mean = zScore = 0;
			median = 0; 
			q1= 0; 
			q3= 0; 
			sumOfDataValues = 0;
			standardDeviation = 0;
			lowFence = highFence = 0;
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
					
					sortData(dataValuesArrayList);
					
				return dataValuesArrayList;
					
			
		}
		
		//Use for GUI
		public ArrayList<Double> collectData(String result)
		{
			Scanner lineScan = new Scanner(result);
			
			lineScan.useDelimiter(",");
			while(lineScan.hasNext())
			{
				dataValuesArrayList.add(Double.parseDouble(lineScan.next()));
			}
			
			sortData(dataValuesArrayList);
			
			return dataValuesArrayList;
		}
		
	//**********************************************************************
	//METHODS TO CALCULATE THE 5 NUMBER SUMMARY (MEAN, MEDIAN, Q1, Q3, IQR)
	//**********************************************************************
		public void calculateMean()
		{
			//int i = 0;
			//loop to add all the values

				for(int i = 0; i <= this.dataValuesArrayList.size() - 1; i++)
				{
					sumOfDataValues+=dataValuesArrayList.get(i);
				}
				
				numberOfDataValues = dataValuesArrayList.size();
			//calculate the mean below and add to ArrayList
				mean = sumOfDataValues / numberOfDataValues;
						
		}
		
		
		public void calculateMedian()
		{
			//System.out.println(dataValuesArrayList.toString());
			numberOfDataValues = dataValuesArrayList.size();
			
			//System.out.println(numberOfDataValues);
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
			iqr = getQ3()- getQ1();
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
				
				sortData(minToQ1DataValues);

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

		//Find Q3	
		public void calculateQ3()
		{
			if(numberOfDataValues % 2 == 0)
			{
				for(int i=(int)((numberOfDataValues / 2) - 1); i<=numberOfDataValues - 1; i++)
				{
					medToMaxDataValues.add(dataValuesArrayList.get(i));
					
				}
				
				sortData(medToMaxDataValues);

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
		
		//Sorts the data
			private void sortData(ArrayList<Double> a)
			{
				Collections.sort(a);
			}
		
	//**********************************************************************************
	//OTHER STATISTIC FUNCTIONS
	//**********************************************************************************
			public void calculateSD()
			{
				calculateMean();
				for (int i = 0; i < numberOfDataValues; i++) 
				{
		            standardDeviation += Math.pow((dataValuesArrayList.get(i) - mean), 2);     
		        }
				
				standardDeviation /= numberOfDataValues;
	            standardDeviation = Math.sqrt(standardDeviation);
			}
			
			public void findOutliers()
			{
				calculateIQR();
				calculateQ1();
				calculateQ3();
				
				lowFence = q1 - (1.5 * iqr);
				highFence = q3 + (1.5 * iqr);
				
				for(int i = 0; i < numberOfDataValues; i++)
				{
					if(dataValuesArrayList.get(i) < lowFence || dataValuesArrayList.get(i) > highFence)
					{
						outlierList.get(i);
					}
				}
			}
			
			public void calculateZScores()
			{
				calculateMean();
				calculateSD();
				
				for(int i = 0; i < numberOfDataValues; i++)
				{
					zScore = (dataValuesArrayList.get(i) - mean) / standardDeviation;
					zScoreList.add(zScore);
				}
			}
			
			
			
	//*************************************************************************
	//GET/SET METHODS
	//*************************************************************************
		public double getMean()
		{
			return mean;
		}
		
		public double getStandardDeviation()
		{
			return standardDeviation;
		}


		public void setStandardDeviation(double standardDeviation)
		{
			this.standardDeviation = standardDeviation;
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

		
		public ArrayList<Double> getDataValuesArrayList()
		{
			return dataValuesArrayList;
		}


		public void setDataValuesArrayList(ArrayList<Double> dataValuesArrayList)
		{
			this.dataValuesArrayList = dataValuesArrayList;
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


		public ArrayList<Double> getOutlierList()
		{
			return outlierList;
		}


		public void setOutlierList(ArrayList<Double> outlierList)
		{
			this.outlierList = outlierList;
		}


		public double getLowFence()
		{
			return lowFence;
		}


		public void setLowFence(double lowFence)
		{
			this.lowFence = lowFence;
		}


		public double getHighFence()
		{
			return highFence;
		}


		public void setHighFence(double highFence)
		{
			this.highFence = highFence;
		}


		public ArrayList<Double> getzScoreList()
		{
			return zScoreList;
		}


		public void setzScoreList(ArrayList<Double> zScoreList)
		{
			this.zScoreList = zScoreList;
		}
		
		
	}
