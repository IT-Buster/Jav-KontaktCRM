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
		///ustawienie srodowiska
		setEnv("TST");
		log4j.info("Starting Apps:");
		log4j.info("Set Env:"+getEnv());
		//za³adowanie parametrów z plików konfiguracyjnych 
		//kontprop = new PropertiesApp("Test");
		//System.out.println( kontprop.getKontaktProp("dbuser") );
		// MainFrameKontakt mainframe = new MainFrameKontakt();
		// Okienko logowania - jeœli ok to uruchom menu
		// uruchomienie glównej ramki aplikacji
		MainFrameApp mainframe = new MainFrameApp();
		
	}
	
	public static void main(String[] args) {	
		new MainApp();
	}

	private String getEnv() {
		return env;
	}

	private void setEnv(String env) {
		this.env = env;
	}

}
