import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainApp {
	private String env;

	private static final Logger log4j = LogManager.getLogger(MainApp.class.getName());

    private static PropertiesApp kontprop;
	public MainApp() {
		
		/// ustawienie srodowiska
		setEnv("TST");
		log4j.info("Starting Apps:");
		log4j.info("Set Env:" + getEnv());
		
		// za�adowanie parametr�w z plik�w konfiguracyjnych  -- w�a�ciwe to trzeba je �adowa wg potrzeb 
		log4j.info( kontprop.getKontaktProp("dbuser_dev") );
		
		//uruchomienie g��wnego okna
		MainFrameApp mainframe = new MainFrameApp();
		mainframe.setVisible(false); //Zabezpieczenie przed logowaniem 
		LoginDialog loginDlg = new LoginDialog(mainframe);
		loginDlg.setVisible(true); 
		log4j.debug("Logowanie do Systemu");

		if (loginDlg.isSucceeded()) {
			log4j.debug("Poprawne has�o !!");
			mainframe.setVisible(true);  // jak poprawne has�o to poka� MainFrame
		} else {
			log4j.debug("B�ad Logowania !!");
		}
	}

	public static void main(String[] args) {
		new MainApp();
	}

	private String getEnv() {
		return env;
	}

	private void setEnv(String env) {
	
		PropertiesApp kontprop = new PropertiesApp(env);
		this.env = kontprop.getKontaktProp(env) ;	
	}

	public static PropertiesApp getKontprop() {
		return kontprop;
	}

	public static void setKontprop(PropertiesApp kontprop) {
		MainApp.kontprop = kontprop;
	}

}
