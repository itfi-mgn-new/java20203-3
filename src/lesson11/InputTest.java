package lesson11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;

public class InputTest extends JFrame implements ActionListener {
	private static final long 	serialVersionUID = -3026916452903563350L;

	private final JTextArea		content = new JTextArea();
	private final JButton		button = new JButton("Press me");
	private final JPopupMenu	popup = new JPopupMenu();
	
	public InputTest() {
		getContentPane().add(new JScrollPane(content), BorderLayout.CENTER);
		getContentPane().add(button, BorderLayout.SOUTH);
		
		button.addActionListener((e)->System.err.println("Button pressed!"));
		
		
		final JMenuItem	item1 = new JMenuItem("Item 1");
		final JMenuItem	item2 = new JMenuItem("Item 2");
		
		item1.addActionListener(this);
		item1.setActionCommand("COMMAND 1");
		item2.addActionListener(this);
		item2.setActionCommand("COMMAND 2");
		
		popup.add(item1);
		popup.add(item2);
		
		content.addKeyListener(new KeyListener() {
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTEXT_MENU) {
					final Rectangle	rect = content.getVisibleRect();
					
					popup.show(content, (int)rect.getCenterX(), (int)rect.getCenterY());
				}
			}
		});

		content.addMouseListener(new MouseListener() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override public void mouseClicked(MouseEvent e) {}
			
			@Override 
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(content, e.getX(), e.getY());
				}
			}
		});

		content.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK), "uppercaseZ");
		content.getActionMap().put("uppercaseZ", new AbstractAction() {
			{putValue(ACTION_COMMAND_KEY, "uppercaseZ");}
			@Override
			public void actionPerformed(ActionEvent e) {
				InputTest.this.actionPerformed(e);
			}
		});
		content.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK), "lowercaseZ");
		content.getActionMap().put("lowercaseZ", new AbstractAction() {
			{putValue(ACTION_COMMAND_KEY, "lowercaseZ");}
			@Override
			public void actionPerformed(ActionEvent e) {
				InputTest.this.actionPerformed(e);
			}
		});
		
		content.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				if (input instanceof JTextComponent) {
					final boolean	check = !((JTextComponent)input).getText().trim().isEmpty(); 
					
					if (!check) {
						System.err.println("Content can't be empty");
						input.setBackground(Color.red);
					}
					else {
						input.setBackground(Color.white);
					}
					return check;
				}
				else {
					return true;
				}
			}
		});
		
		new DropTarget(content, new DropTargetListener(){
			@Override public void dragEnter(DropTargetDragEvent dtde) {}
			@Override public void dragOver(DropTargetDragEvent dtde) {}
			@Override public void dropActionChanged(DropTargetDragEvent dtde) {}
			@Override public void dragExit(DropTargetEvent dte) {}

			@Override
			public void drop(DropTargetDropEvent dtde) {
              try {
            	  if (dtde.getTransferable().isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
            		  dtde.acceptDrop(DnDConstants.ACTION_COPY);
            		  
            		  final List<File>	files = (List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
            		  
            		  for (File item : files) {
            			  try(final Reader	rdr = new FileReader(item)) {
            				  content.read(rdr, item);
            			  }
            		  }
            		  dtde.dropComplete(true);
            	  }
            	  else {
            		  dtde.rejectDrop();
            	  }
              } catch(IOException | UnsupportedFlavorException exc){
            	  exc.printStackTrace();
              }
			}
		});
		
		setSize(200,200);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		switch (e.getActionCommand()) {
			case "COMMAND 1" :
				System.err.println("Select command 1");
				break;
			case "COMMAND 2" :
				System.err.println("Select command 2");
				break;
			case "uppercaseZ" :
				content.setText(content.getText().toUpperCase());
				break;
			case "lowercaseZ" :
				content.setText(content.getText().toLowerCase());
				break;
			default :
				break;
		}
	}
	
	public static void main(String[] args) {
		new InputTest().setVisible(true);
	}
}
