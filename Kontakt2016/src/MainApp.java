import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainApp {
	private String env;

	private static final Logger log4j = LogManager.getLogger(MainApp.class.getName());

	// private static PropertiesApp kontprop;

	public static void main(String[] args) {

		// logowanie
		log4j.info("Starting Apps:");

		// ustawiam œrodowisko TST DEV PRD
		// setEnv("TST");
		// kontprop = new PropertiesApp("Test");
		// System.out.println( kontprop.getKontaktProp("dbuser") );
		// MainFrameKontakt mainframe = new MainFrameKontakt();
		// Okienko logowania - jeœli ok to uruchom menu

		final JFrame frame = new JFrame("Main Frame");
		final JButton btnLogin = new JButton("Click to login");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDlg = new LoginDialog(frame);
				loginDlg.setVisible(true);
				// if logon successfully
				if (loginDlg.isSucceeded()) {
					btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
				}
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(btnLogin);
		frame.setVisible(true);

	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

}
