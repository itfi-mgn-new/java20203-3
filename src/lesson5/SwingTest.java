package lesson5;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class SwingTest extends JFrame {
	private static final long serialVersionUID = -1893280556387861254L;

	private final JButton click = new JButton("click me");
	
	public SwingTest() {
		setTitle("swing hello world");
		setLocationRelativeTo(null);
		setSize(640, 480);
		addWindowListener(new WindowListener() {
			@Override public void windowOpened(WindowEvent e) {}
			@Override public void windowIconified(WindowEvent e) {}
			@Override public void windowDeiconified(WindowEvent e) {}
			@Override public void windowDeactivated(WindowEvent e) {}
			@Override public void windowClosed(WindowEvent e) {}
			@Override public void windowActivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.err.println("Closed");
				dispose();
			}
		});
		
		final JMenuItem item1 = new JMenuItem("item 1");
		final JMenuItem item2 = new JMenuItem("item 2");
		final JMenuItem item3 = new JMenuItem("item 3");
		final JMenu submenu1 = new JMenu("Submenu 1");		
		final JMenuBar bar = new JMenuBar();
		
		item1.addActionListener((e)->System.err.println("Item1"));
		
		submenu1.add(item1);
		submenu1.add(item2);
		
		bar.add(submenu1);
		bar.add(item3);
		
		getContentPane().add(bar, BorderLayout.NORTH);
		
		click.addActionListener((e)->{System.err.println("sdhdjkhddjkfdkfjhdjkfhkjdfhfjkdhfkjfh");});
	
		final JTextArea ta = new JTextArea();
		final JScrollPane jsp = new JScrollPane(ta);
		
		final JTabbedPane jtp = new JTabbedPane();
		final JLabel l = new JLabel("<html><body><b>jh</b>sgdh<font color=red>gshd</font>g</body></html>");
		
		jtp.addTab("tab1", click);
		jtp.addTab("tab2", l);
		
		final JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp, jtp);
	
		getContentPane().add(pane, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SwingTest st = new SwingTest();
		
		st.setVisible(true);
		System.err.println("sjdhkjsdjk");
		
	}
}
