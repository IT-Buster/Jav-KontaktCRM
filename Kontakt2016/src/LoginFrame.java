import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

// this guy extends *nothing*
public class LoginFrame {
	private static final int COLS = 10;
	private JPanel mainPanel = new JPanel(); // this is what I'll add to
												// contentPane
	private JTextField field1 = new JTextField(COLS);
	private JTextField field2 = new JTextField(COLS);
	private JPasswordField passwordField = new JPasswordField(COLS);
	private JComponent[] allComponents = { new JLabel("Login:"), field1, new JLabel("Field 2:"), field2,
			new JLabel("Password:"), passwordField };

	public LoginFrame() {
		field2.setEditable(false);
		field2.setFocusable(false);
		field1.setText("Field 1");
		field2.setText("Uneditable");

		mainPanel.setLayout(new GridLayout(4, 2, 20,20));
		for (JComponent comp : allComponents) {
			mainPanel.add(comp);
		}
	}

	public JComponent getMainComponent() {
		return mainPanel;
	}

	private static void createAndShowGui() {
		LoginFrame loginFrame = new LoginFrame();

		JFrame frame = new JFrame("Login System");
		
		JPanel contentPanel = new JPanel();
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		contentPanel.setBorder(padding);
		frame.setContentPane(contentPanel);
		
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(1, 6));
		frame.getInsets().set(100, 100, 100, 100);
		frame.getContentPane().add(loginFrame.getMainComponent()) ;
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}