package lesson6;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;

public class ControlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JButton	button = new JButton();
		
		button.getName();
		Dimension x = button.getSize();
		Point p = button.getLocation();
		Rectangle r = button.getBounds();
		button.setVisible(false);
		button.setEnabled(false);
		
		button.setMinimumSize(x);
		button.setPreferredSize(x);
		button.setMaximumSize(x);
	}
}
