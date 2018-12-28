import javax.swing.*;
import java.awt.*;

public class layoutTest extends JApplet {
	private JPanel panel;
	private JTextField projectTitle;
	private JTextField projectNumber;
	private JTextField projectLocation;

	public void init() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		panel = new JPanel();
		panel.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		projectTitle = new JTextField(10);
		projectNumber = new JTextField(10);
		projectLocation = new JTextField(10);	

		panel.add(projectTitle);
		panel.add(projectNumber);
		panel.add(projectLocation);

		panel.setPreferredSize(new Dimension(400,300));

		setSize(800,300);
	
	}
}
