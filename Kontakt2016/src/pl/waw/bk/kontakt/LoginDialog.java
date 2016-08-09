package pl.waw.bk.kontakt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginDialog extends JDialog {

	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private JButton btnLogin;
	private JButton btnCancel;
	private boolean succeeded;

	public LoginDialog(MainFrameApp mainframe) {
		super(mainframe, "Login", true);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (Login.authenticate(getUsername(), getPassword())) {
						succeeded = true;
						dispose();
					} else {
						JOptionPane.showMessageDialog(LoginDialog.this, "B³êdny login lub has³o", "Login",
								JOptionPane.ERROR_MESSAGE);
						tfUsername.setText("");
						pfPassword.setText("");
						succeeded = false;
					}
				}
			}
		};

		setTitle("Logowanie");

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		lbUsername = new JLabel("Username: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbUsername, cs);

		tfUsername = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		tfUsername.setText(PropertiesApp.getProp("login_default"));
		tfUsername.addKeyListener(listener);
		panel.add(tfUsername, cs);

		lbPassword = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbPassword, cs);

		pfPassword = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		pfPassword.setText(PropertiesApp.getProp("password_default"));
		pfPassword.addKeyListener(listener);

		panel.add(pfPassword, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		btnLogin = new JButton("Login");

		ActionListener listenAndCheck = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Login.authenticate(getUsername(), getPassword())) {
					succeeded = true;
					dispose();
				} else {
					JOptionPane.showMessageDialog(LoginDialog.this, "B³êdny login lub has³o", "Login",
							JOptionPane.ERROR_MESSAGE);
					tfUsername.setText("");
					pfPassword.setText("");
					succeeded = false;
				}
			}
		};
		
		btnLogin.addActionListener(listenAndCheck);
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});

		JPanel bp = new JPanel();
		bp.add(btnLogin);
		bp.add(btnCancel);

		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(bp, BorderLayout.PAGE_END);

		pack();
		setResizable(false);
		setLocationRelativeTo(mainframe);
	}

	public String getUsername() {
		return tfUsername.getText().trim();
	}

	public String getPassword() {
		return new String(pfPassword.getPassword());
	}

	public boolean isSucceeded() {
		return succeeded;
	}
	
	
	
	
	
}