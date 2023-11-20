package lesson9;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableTest extends JFrame {
	
	private final JTable	table = new JTable();
	
	
	public TableTest() {
		table.setModel(new PersonModel(new Person("Ivanov","Ivan","Ivanovich",21)));
		getContentPane().add(new JScrollPane(table));
		setSize(640,480);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new TableTest().setVisible(true);
	}
	
	private static class Person {
		String	firstName;
		String	middleName;
		String	lastName;
		int		age;
		
		public Person(String firstName, String middleName, String lastName, int age) {
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", age=" + age + "]";
		}
	}
	
	private static class PersonModel extends DefaultTableModel {
		private final Person[]	persons;
		
		public PersonModel(final Person... persons) {
			this.persons = persons;
		}

		@Override
		public int getRowCount() {
			return persons == null ? 0 : persons.length;
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public String getColumnName(final int columnIndex) {
			switch (columnIndex) {
				case 0 	: return "first name";
				case 1 	: return "middle name";
				case 2 	: return "last name";
				case 3 	: return "age";
				default : return "";
			}
		}

		@Override
		public Class<?> getColumnClass(final int columnIndex) {
			switch (columnIndex) {
				case 0 	: case 1 : case 2 : 
					return String.class;
				case 3 	: 
					return Integer.class;
				default : 
					return Object.class;
			}
		}

		@Override
		public boolean isCellEditable(final int rowIndex, final int columnIndex) {
			return false;
		}

		@Override
		public Object getValueAt(final int rowIndex, final int columnIndex) {
			switch (columnIndex) {
				case 0 	: return persons[rowIndex].firstName;
				case 1 	: return persons[rowIndex].middleName;
				case 2 	: return persons[rowIndex].lastName;
				case 3 	: return persons[rowIndex].age;
				default : return null;
			}
		}

		@Override
		public void setValueAt(final Object aValue, final int rowIndex, final int columnIndex) {
		}
	}
}
