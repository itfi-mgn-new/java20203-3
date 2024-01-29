package lesson15;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StandardDialogsTEst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane		pane;
		JFileChooser	chooser;
		JColorChooser	color;
		
		JPanel			p = new JPanel(new BorderLayout());
		p.add(new JLabel("lskjdfkljdfskl"), BorderLayout.NORTH);
		
		JTextField		f = new JTextField();
		p.add(f);
		
		JOptionPane.showMessageDialog(null, p);
		JOptionPane.showConfirmDialog(p, f);
		JOptionPane.showInputDialog("slkdfjjklsdjfflkjsdlkf");
		
		chooser = new JFileChooser(new File("c:/"));
		
		chooser.showOpenDialog(null);
		
		color = new JColorChooser(new Color(10,10,200));
		color.showDialog(null, "s;ldfjsdl;fkl;sfdk", Color.BLACK);
	}

}
