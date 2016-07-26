import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;

import javax.swing.*;

public class MainApp {
	
	private static final int PORT = 9999;
	private static ServerSocket socket;   

	private String env;

	private static final Logger log4j = LogManager.getLogger(MainApp.class.getName());

	public static PropertiesApp kontprop;

	private MainApp() { 

		checkIfRunning();	

		log4j.info("Starting Apps:");
		kontprop = new PropertiesApp("Dev");
		log4j.info("Mode: " + PropertiesApp.getMode());
		
		//log4j.info( kontprop.getProp("dbuser") );
		//log4j.info( kontprop.getProp("default_login") );
		//log4j.info( kontprop.getProp("default_password") );

		// uruchomienie g³ównego okna
		MainFrameApp mainframe = new MainFrameApp();
		mainframe.setVisible(false); // Zabezpieczenie przed logowaniem
		LoginDialog loginDlg = new LoginDialog(mainframe);
		loginDlg.setVisible(true);
		log4j.debug("Logowanie do Systemu");

		if (loginDlg.isSucceeded()) {
			log4j.debug("Poprawne has³o !!");
			mainframe.setVisible(true); // jak poprawne has³o to poka¿ MainFrame
		} else {
			log4j.debug("B³ad Logowania !!");
		}
	}

	public static void main(String[] args) {
		new MainApp();
		//System.exit(0);
	}

	private String getEnv() {
		return env;
	}

	private void setEnv(String env) {

		PropertiesApp kontprop = new PropertiesApp(env);
		this.env = kontprop.getProp(env);
		this.env = env;
	}

	public static PropertiesApp getKontprop() {
		return kontprop;
	}

	public static void setKontprop(PropertiesApp kontprop) {
		MainApp.kontprop = kontprop;
	}
	
	private static void checkIfRunning() {
		  try {
		    //Bind to localhost adapter with a zero connection queue 
		    socket = new ServerSocket(PORT,0,InetAddress.getByAddress(new byte[] {127,0,0,1}));
		  }
		  catch (BindException e) {
		    System.err.println("Already running.");
		    System.exit(1);
		  }
		  catch (IOException e) {
		    System.err.println("Unexpected error.");
		    e.printStackTrace();
		    System.exit(2);
		  }
		}
	
}
