import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainApp {
	private String env;

	private static final Logger log4j = LogManager.getLogger(MainApp.class.getName());

	// private static PropertiesApp kontprop;
	public MainApp() {
		/// ustawienie srodowiska
		setEnv("TST");
		log4j.info("Starting Apps:");
		log4j.info("Set Env:" + getEnv());
		// za³adowanie parametrów z plików konfiguracyjnych
		// kontprop = new PropertiesApp("Test");
		// System.out.println( kontprop.getKontaktProp("dbuser") );
		// MainFrameKontakt mainframe = new MainFrameKontakt();
		// Okienko logowania - jeœli ok to uruchom menu
		// uruchomienie glównej ramki aplikacji
		MainFrameApp mainframe = new MainFrameApp();
		mainframe.setVisible(false); //Zabezpieczenie przed logowaniem 
		LoginDialog loginDlg = new LoginDialog(mainframe);
		loginDlg.setVisible(true);
		log4j.debug("Logowanie do Systemu");

		if (loginDlg.isSucceeded()) {
			log4j.debug("Poprawne has³o !!");
			mainframe.setVisible(true);
		} else {
			log4j.debug("B³ad Logowania !!");
		}

		// mainframe.setVisible(true);
	}

	public static void main(String[] args) {

		// MainApp mainapp =
		new MainApp();

	}

	private String getEnv() {
		return env;
	}

	private void setEnv(String env) {
		this.env = env;
	}

}
