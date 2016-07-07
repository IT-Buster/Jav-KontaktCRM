import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainMenuBar extends JMenuBar {
	private static final Logger log4j = LogManager.getLogger(MainApp.class.getName());

	public MainMenuBar() {

		JMenu file = new JMenu("Plik");
		JMenu edit = new JMenu("Edycja");
		JMenu tools = new JMenu("Narzêdzia");
		JMenu exit = new JMenu("Exit");
		// JMenu help = new JMenu("Help");
		// JMenuItem about = new JMenuItem("About");

		add(file);
		add(edit);
		add(tools);
		add(Box.createHorizontalGlue());
		add(exit);
		// exit.addActionListener(new exitApp());
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				log4j.info("TEST");

			}
		});

		file.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("TEST");

			}
		});
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

		file.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("TESTY");

			}
		});

		frame.setJMenuBar(menubar);
		frame.setVisible(true);
	}

	// Exit app
	static class exitApp implements ActionListener {
		private static final Logger log4j = LogManager.getLogger(MainApp.class.getName());

		public void actionPerformed(ActionEvent e) {
			log4j.info("Application Exited");
			System.exit(0);
		}
	}

}
