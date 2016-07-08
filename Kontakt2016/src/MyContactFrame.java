import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class MyContactFrame extends JFrame {

	public MyContactFrame() {
	
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Moje Kontakty");

		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);

		menubar.add(Box.createHorizontalGlue());

		setJMenuBar(menubar);
		setVisible(true);
	
	
	
	}

}
