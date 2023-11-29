package prac;

import javax.swing.*;
import java.awt.*;

public class NullContainerEx extends JFrame {
	final static int NUM_BUTTONS = 10;
	
	public NullContainerEx() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50);
		la.setSize(200, 20);
		c.add(la);
		
		for(int i = 0; i <= NUM_BUTTONS; i++) {
			JButton b = new JButton(Integer.toString(i));
			// b.setLocation(i * 15, i * 15);
			b.setLocation(i * 20, i * 20);
			b.setSize(50, 20);
			c.add(b);
		}
		
		// setSize(400, 250);
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new NullContainerEx();
	}
}
