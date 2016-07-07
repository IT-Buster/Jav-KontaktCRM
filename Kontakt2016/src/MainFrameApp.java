import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.JFrame;

public class MainFrameApp extends JFrame {

	public MainFrameApp() { 

		//final JFrame frame = new JFrame("Main Frame"); 
/*		JButton btnLogin = new JButton("Click to login");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDlg = new LoginDialog( frame );
				loginDlg.setVisible(true);
				if (loginDlg.isSucceeded()) {
					btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
				}
			}
		});
*/
		MainMenuBar mainmenu = new MainMenuBar();
		setJMenuBar(mainmenu);
		
		TextArea textarea = new TextArea();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		getContentPane().add(textarea);
		setVisible(true);  
	}
}
