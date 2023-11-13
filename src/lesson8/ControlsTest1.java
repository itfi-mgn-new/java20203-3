package lesson8;

import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;

public class ControlsTest1 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private final JButton			button = new JButton("Press me"); 
	private final JToggleButton		toggle = new JToggleButton("Toggle me");
	private final JCheckBox			check = new JCheckBox("Check me");
	private final JComboBox<String>	comboBox = new JComboBox<String>(Arrays.asList("value1", "value2", "value3").toArray(new String[0]));
	private final JList<String>		list = new JList<String>(Arrays.asList("List value1", "List value2", "List value3").toArray(new String[0]));
	private final JProgressBar		progress = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	private final JScrollBar		scroll = new JScrollBar(JScrollBar.HORIZONTAL, 50, 10, 0, 100);
	private final JSlider			slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
	private final JSpinner			spinner = new JSpinner();
	
	
	public ControlsTest1() {
		getContentPane().setLayout(new GridLayout(3,3));
		getContentPane().add(button);
		getContentPane().add(toggle);
		getContentPane().add(check);
		getContentPane().add(comboBox);
		getContentPane().add(list);
		getContentPane().add(progress);
		getContentPane().add(scroll);
		getContentPane().add(slider);
		getContentPane().add(spinner);
		
		progress.setValue(50);
		progress.setStringPainted(true);
		progress.setString("assa");
	}

	public static void main(String[] args) {
		final ControlsTest1	ct = new ControlsTest1();
		
		ct.setSize(640, 480);
		ct.setLocationRelativeTo(null);
		ct.setVisible(true);
	}

}
