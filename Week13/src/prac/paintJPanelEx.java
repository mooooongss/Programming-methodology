package prac;

import javax.swing.*;
import java.awt.*;

public class paintJPanelEx extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public paintJPanelEx() {
		setTitle("JPanel paintComponent() Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(panel);
		
		setSize(700, 700);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(new Color(37, 48, 25));
			g.fillOval(20, 20, 80, 80);
			
			g.setColor(Color.ORANGE);
			g.drawRect(150, 150, 30, 30);
		}
	}

	public static void main(String[] args) {
		new paintJPanelEx();
	}

}
