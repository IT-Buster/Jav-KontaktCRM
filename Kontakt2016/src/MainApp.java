import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class MainApp {

	private static final Logger log4j = LogManager.getLogger(MainApp.class
	        .getName());
	
	//private static PropertiesApp kontprop;

	public static void main(String[] args) {
		
		//logowanie 
		System.out.println("Starting Apps:");
			
		
		log4j.trace("This is a trace message." + log4j.getName());
		log4j.debug("This is  a debug message.");
		log4j.info("This is an info message.");
		log4j.error("This is an error message");
		
		
		//czy œrodowisko  
		//kontprop = new PropertiesApp("Test");
		
		//System.out.println( kontprop.getKontaktProp("dbuser") );
		
		//MainFrameKontakt mainframe = new MainFrameKontakt();
		
	}

}
