import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatsMain
{
	public static void main(String[] args)
	{
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
			frame.setPreferredSize(new Dimension(1000,500));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.getContentPane().add(new StatsPanel());
			frame.pack();	
	}		
}
