import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrameApp extends JFrame {

	public static class OpenMyContactFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new MyContactFrame();
		}

	}

	static class exitApp implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public MainFrameApp() {

		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);

		JMenu kontakty = new JMenu("Kontakty");
		menubar.add(kontakty);

		JMenuItem mojekontakty = new JMenuItem("Moje Kontakty");
		kontakty.add(mojekontakty);
		mojekontakty.addActionListener(new OpenMyContactFrame());

		JMenuItem mailing = new JMenuItem("Mailing");
		kontakty.add(mailing);

		JMenuItem mojegrupy = new JMenuItem("Grupy");
		kontakty.add(mojegrupy);

		menubar.add(Box.createHorizontalGlue());

		JMenuItem exit = new JMenuItem("Exit");
		menubar.add(exit);
		exit.addActionListener(new exitApp());

		setJMenuBar(menubar);

		setJMenuBar(menubar);
		setVisible(false);

	}

	public static void main(String[] args) {
		new MainFrameApp();
	}
}
