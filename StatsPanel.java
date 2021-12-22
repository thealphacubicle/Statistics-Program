import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatsPanel extends JPanel
{
	private JLabel userLabel, checkOptionsLabel, solutionLabel;
	private JTextField userText;
	private JCheckBox mean, median, mode, sd, iqr, q1, q3;
	private ArrayList<Double> dataValuesArrayList;
	JButton solutions;
	String result;
	
	public StatsPanel()
	{		
		this.setLayout(null);
		
		//User enters stuff
			 userLabel = new JLabel("Enter Data Values: ");
				userLabel.setBounds(10,20,130,25);
				this.add(userLabel);
			
			userText = new JTextField();
				userText.setBounds(170,20,165,25);
				userText.addActionListener(new TextBoxListener());
				this. add(userText);
		
		//Options to select which data values to return
			 checkOptionsLabel = new JLabel("Select values to return: ");
				checkOptionsLabel.setBounds(10,50, 200, 85);
				this.add(checkOptionsLabel);
				
			mean = new JCheckBox("Get Mean");
				mean.setBackground(Color.green);
				mean.setBounds(10, 120, 150, 20);
				mean.addItemListener(new CheckBoxListener());
				this.add(mean);
				
			 median = new JCheckBox("Get Median");
				median.setBackground(Color.green);
				median.setBounds(10, 140, 150, 20);
				median.addItemListener(new CheckBoxListener());
				this.add(median);
				
			 iqr = new JCheckBox("Get IQR");
				iqr.setBackground(Color.green);
				iqr.setBounds(10, 160, 150, 20);
				iqr.addItemListener(new CheckBoxListener());
				this.add(iqr);
				
			 q1 = new JCheckBox("Get Q1");
				q1.setBackground(Color.green);
				q1.setBounds(10, 180, 150, 20);
				q1.addItemListener(new CheckBoxListener());
				this.add(q1);
				
			 q3 = new JCheckBox("Get Q3");
				q3.setBackground(Color.green);
				q3.setBounds(10, 200, 150, 20);
				q3.addItemListener(new CheckBoxListener());
				this.add(q3);
				
			sd = new JCheckBox("Get Standard Deviation");
				sd.setBackground(Color.green);
				sd.setBounds(10, 220, 200, 20);
				sd.addItemListener(new CheckBoxListener());
				this.add(sd);
			
			solutionLabel = new JLabel("N/A");
				solutionLabel.setBounds(10,350,200,20);
				this.add(solutionLabel);
				
			
	}
	
	private class CheckBoxListener implements ItemListener
	{
		StatsFunctions s1;
		
		@Override
		public void itemStateChanged(ItemEvent e)
		{
			
			if(mean.isSelected())
			{
				s1 = new StatsFunctions(dataValuesArrayList);
				s1.calculateMean();
				solutionLabel.setText("Mean: " + s1.getMean());
				//System.out.println("Mean: " + s1.getMean());
			}
			
			if(median.isSelected())
			{
				s1 = new StatsFunctions(dataValuesArrayList);
				s1.calculateMedian();
				solutionLabel.setText("Median: " + s1.getMedian());
				//System.out.println("Median: " + s1.getMedian());
			}
			
			if(iqr.isSelected())
			{
				s1 = new StatsFunctions(dataValuesArrayList);
				s1.calculateIQR();
				solutionLabel.setText("IQR: " + s1.getIQR());
				//System.out.println("IQR: " + s1.getIQR());
			}
			
			if(q1.isSelected())
			{
				s1 = new StatsFunctions(dataValuesArrayList);
				s1.calculateQ1();
				solutionLabel.setText("Q1: " + s1.getQ1());
				//System.out.println("Q1: " + s1.getQ1());
			}
			
			if(q3.isSelected())
			{
				s1 = new StatsFunctions(dataValuesArrayList);
				s1.calculateQ3();
				solutionLabel.setText("Q3: " + s1.getQ3());
				//System.out.println("Q3: " + s1.getQ3());
			}
			
			if(sd.isSelected())
			{
				s1 = new StatsFunctions(dataValuesArrayList);
				s1.calculateSD();
				solutionLabel.setText("Standard Deviation: " + s1.getStandardDeviation());
				//System.out.println("Standard Deviation: " + s1.getStandardDeviation());
			}			
		}
	}
	
	public class TextBoxListener implements ActionListener
	{
		StatsFunctions s;

		@Override
		public void actionPerformed(ActionEvent e)
		{
			String data = userText.getText();
			
			s = new StatsFunctions();
			
			dataValuesArrayList = s.collectData(data);		
		}

	}
}
