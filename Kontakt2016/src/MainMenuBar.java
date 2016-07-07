import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenuBar extends JMenuBar {

	public MainMenuBar() {

		JMenu file = new JMenu("Plik");
		JMenu edit = new JMenu("Edycja");
		JMenu tools = new JMenu("Narzêdzia");
		JMenu exit = new JMenu("Exit");
		//JMenu help = new JMenu("Help");
		//JMenuItem about = new JMenuItem("About");
		
		add(file);
		add(edit);
		add(tools);
		add(Box.createHorizontalGlue());
		exit.addActionListener(new exitApp());
		add(exit);
	}

	public static void main(String[] args) {
		// Frame
		JFrame frame = new JFrame("Menu");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JMenuBar menubar = new JMenuBar();

		JMenu file = new JMenu("File");
		menubar.add(file);

		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		exit.addActionListener(new exitApp());
		
		JMenu help = new JMenu("Help");
		menubar.add(help);

		JMenuItem about = new JMenuItem("About");
		help.add(about);

		frame.setJMenuBar(menubar);
		frame.setVisible(true);
	}

	// Exit app
	static class exitApp implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

}
