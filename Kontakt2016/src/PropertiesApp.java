import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesApp {
	
	private static String mode; 

	public PropertiesApp(String mode) {
		if (mode.equals("Dev")) {
			setMode(mode);
		}else if (mode.equals("Prd")) {
			setMode(mode);
		}else{
			System.exit(0);
		}
	}

	public void setKontaktProp() {

		Properties prop = new Properties();
		OutputStream output = null;

		try {
			if(getMode()=="Prd" ) output = new FileOutputStream("config.prd.properties");
			if(getMode()=="Dev" ) output = new FileOutputStream("config.dev.properties");
			//prop.setProperty("host", "sql.bk.waw.pl");
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static String getProp(String key) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {
			if(getMode()=="Dev" ) prop.load(new FileInputStream("config.dev.properties"));
			if(getMode()=="Prod" ) prop.load(new FileInputStream("config.prd.properties"));
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return prop.getProperty(key);

	}

	public static String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}