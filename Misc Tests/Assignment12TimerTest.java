import java.util.*;
import javax.swing.*;
import java.awt.*;

public class TimerTest {
	private Timer test;
	private int delay;

	private class testListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.print(delay);
		}
	}

	public static void main(String[] args) {
		test = new Timer(delay, testListener);
	}
}
