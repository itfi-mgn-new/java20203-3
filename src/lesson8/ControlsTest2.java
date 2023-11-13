package lesson8;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ControlsTest2 extends JFrame {
	private static final long serialVersionUID = 1L;

	private final JRadioButton		radio1 = new JRadioButton("select 1");
	private final JRadioButton		radio2 = new JRadioButton("select 2");
	private final JRadioButton		radio3 = new JRadioButton("select 3");
	private final ButtonGroup		radioGroup = new ButtonGroup();
	private final JTextField		tf = new JTextField("Content");
	private final JPasswordField	pf = new JPasswordField();
	private final JTextArea			ta = new JTextArea("Area content");
	private final JEditorPane		ep = new JEditorPane("text/html","<html><body><h1>ASSA</h1></body></html>");
	
	public ControlsTest2() {
		getContentPane().setLayout(new GridLayout(3,2));
		
		final JPanel radioPanel = new JPanel(new GridLayout(1,3));

		radioPanel.add(radio1);
		radioPanel.add(radio2);
		radioPanel.add(radio3);
		
//		radioGroup.add(radio1);
//		radioGroup.add(radio2);
//		radioGroup.add(radio3);
		radioPanel.setBorder(new TitledBorder("Radios"));
		
		getContentPane().add(radioPanel);
		getContentPane().add(tf);
		getContentPane().add(pf);
		getContentPane().add(ta);
		getContentPane().add(ep);
		
		ep.setEditable(false);
		
	}

	
	public static void main(String[] args) {
		final ControlsTest2	ct = new ControlsTest2();
		
		ct.setSize(640, 480);
		ct.setLocationRelativeTo(null);
		ct.setVisible(true);
	}
	
}
