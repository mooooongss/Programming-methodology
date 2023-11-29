package prac;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import prac.ClickAndDoubleClickEx.MyMouseListener;

public class MouseWheelFrame extends JFrame {
	public MouseWheelFrame() {
		super("마우스 휠을 굴려 폰트 크기 조절");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Love Java");
		c.add(label);
		
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		
		label.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int n = e.getWheelRotation();
				if(n < 0) {
					JLabel la = (JLabel)e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					if(size <= 5) {
						return;
					}
					la.setFont(new Font("Arial", Font.PLAIN, size-5));
				} else {
					JLabel la = (JLabel)e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					la.setFont(new Font("TimesRoman", Font.PLAIN, size+5));
				}
			}
		});
		
		setSize(1500, 500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MouseWheelFrame();
	}
}
