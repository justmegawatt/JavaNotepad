package notepad;

import javax.swing.*; // for the main JFrame design
import java.awt.*; // for the GUI
import java.awt.event.*; // for event handling
import java.util.Scanner; // for reading from a file
import java.io.*; // for writing to a file

public class Notepad extends JFrame implements ActionListener {
	private TextArea textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
	private MenuBar menuBar = new MenuBar();
	private Menu file = new Menu();
	private MenuItem openFile = new MenuItem();
	private MenuItem saveFile = new MenuItem();
	private MenuItem close = new MenuItem();
	
	public Notepad() {
		this.setSize(500, 300); // set initial size of the window
		this.setTitle("Java Notepad"); // set the title of the window
		setDefaultCloseOperation(EXIT_ON_CLOSE); // set the default close operation (exit when it gets closed)
		this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 12)); // sets a default font for the text area

		// Add textArea to the content pane
		this.getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill automatically
		this.getContentPane().add(textArea);
		
		// Add our menu bar to the GUI
		this.setMenuBar(this.menuBar);
		this.menuBar.add(this.file); // adds the menu option to the menu
		this.file.setLabel("File"); // Sets the label of the file menu option to "File"
		// Adds the Open button to the file menu
		this.openFile.setLabel("Open");
		this.openFile.addActionListener(this); // add an action listener so we know when it's been clicked
		this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false)); //set a keyboard shortcut as C-o
		this.file.add(this.openFile); // adds the file option to the menu
		// Adds the save button to the file menu
		this.saveFile.setLabel("Save"); // Gives the save button a label
		this.saveFile.addActionListener(this); // Gives it an action listener
		this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false)); // Keyboard shortcut of C-s
		this.file.add(saveFile); //Adds the save button to the menu
		// Adds the close option to the menu
		this.close.setLabel("Close");
		this.close.addActionListener(this);
		this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4)); // Ctrl F4 closes menu
		this.file.add(this.close);
	}
	
}
