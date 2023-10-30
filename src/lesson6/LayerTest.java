package lesson6;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LayerTest extends JFrame {
	private final JTextField family = new JTextField(); 
	private final JTextField name = new JTextField(); 
	private final JTextField patroname = new JTextField(); 
	private final JTextField birthDate = new JTextField(); 
	private final JTextField sex = new JTextField(); 
	
	public LayerTest() {
		final JLabel familyLabel = new JLabel("Фамилия");
		final JLabel nameLabel = new JLabel("Имя");
		final JLabel patronameLabel = new JLabel("Отчество");
		final JLabel birthDateLabel = new JLabel("Дата рождения");
		final JLabel sexLabel = new JLabel("Пол");
		final SpringLayout sl = new SpringLayout();
		final JPanel panel = new JPanel(sl);
		
		panel.add(familyLabel);
		panel.add(family);
		panel.add(nameLabel);
		panel.add(name);
		panel.add(patronameLabel);
		panel.add(patroname);
		panel.add(birthDateLabel);
		panel.add(birthDate);
		panel.add(sexLabel);
		
		sl.putConstraint(SpringLayout.WEST, familyLabel, 0, SpringLayout.WEST, panel);
		sl.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, panel);
		sl.putConstraint(SpringLayout.WEST, birthDateLabel, 0, SpringLayout.WEST, panel);
		
		sl.putConstraint(SpringLayout.EAST, family, 0, SpringLayout.EAST, panel);
		sl.putConstraint(SpringLayout.EAST, patroname, 0, SpringLayout.EAST, panel);
		sl.putConstraint(SpringLayout.EAST, sex, 0, SpringLayout.EAST, panel);

		sl.putConstraint(SpringLayout.NORTH, familyLabel, 0, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.NORTH, family, 0, SpringLayout.NORTH, panel);
		
		sl.putConstraint(SpringLayout.NORTH, nameLabel, 0, SpringLayout.SOUTH, family);
		sl.putConstraint(SpringLayout.NORTH, name, 0, SpringLayout.SOUTH, family);
		sl.putConstraint(SpringLayout.NORTH, patronameLabel, 0, SpringLayout.SOUTH, family);
		sl.putConstraint(SpringLayout.NORTH, patroname, 0, SpringLayout.SOUTH, family);
		
		sl.putConstraint(SpringLayout.NORTH, birthDateLabel, 0, SpringLayout.SOUTH, name);
		sl.putConstraint(SpringLayout.NORTH, birthDate, 0, SpringLayout.SOUTH, name);
		sl.putConstraint(SpringLayout.NORTH, sexLabel, 0, SpringLayout.SOUTH, name);
		sl.putConstraint(SpringLayout.NORTH, sex, 0, SpringLayout.SOUTH, name);

		sl.putConstraint(SpringLayout.WEST, family, 0, SpringLayout.EAST, familyLabel);
		sl.putConstraint(SpringLayout.WEST, name, 0, SpringLayout.EAST, nameLabel);
		sl.putConstraint(SpringLayout.WEST, patroname, 0, SpringLayout.EAST, patronameLabel);
		sl.putConstraint(SpringLayout.WEST, birthDate, 0, SpringLayout.EAST, birthDateLabel);
		sl.putConstraint(SpringLayout.WEST, sex, 0, SpringLayout.EAST, sexLabel);

		sl.putConstraint(SpringLayout.WEST, patronameLabel, 0, SpringLayout.EAST, name);
		sl.putConstraint(SpringLayout.WEST, sexLabel, 0, SpringLayout.EAST, birthDate);

		sl.putConstraint(SpringLayout.EAST, familyLabel, 0, SpringLayout.EAST, birthDateLabel);
		sl.putConstraint(SpringLayout.EAST, nameLabel, 0, SpringLayout.EAST, birthDateLabel);
		
		
		panel.add(sex);
		
		getContentPane().add(panel);
		
		setSize(640,480);
		setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LayerTest().setVisible(true);
	}

}
