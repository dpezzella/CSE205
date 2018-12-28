// Assignment #: 12
//         Name: Derek Pezzella
//    StudentID:
//    Lecture: TTh 4:30-5:45pm
//    Description: The Assignment 12 class creates a controlpanel and
//               adds it as its Applet content and also sets its size.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class WavePanel extends JPanel {
	private boolean dev = true;

	private Color color;
	private Timer timer;
	private int time;
	private int step;
	private int delay;
	private int waveHeight;
	private int waveWidth;
	private int lastX;
	private int lastY;
	private ArrayList ptList;

	public WavePanel(Color newColor) {
		setBackground(Color.WHITE);
		
		color = newColor;
		ptList = new ArrayList();

		//initialize default wave and timer values
		time = 0;
		step = 1;
		delay = 20;
		waveHeight = 72;
		waveWidth = 50;

		//used to test whether the wave is going to go off the panel
		lastX = 0;
		lastY = 0;

		timer = new Timer(delay, new WaveListener());
		timer.start();
	}

	//I kept getting a nullpointerexception for my timers
	//This method was to check where I was getting it from
	public void nullCheck() {
		if(color == null) { System.out.println("color is null"); }
		if(ptList == null) { System.out.println("ptList is null"); }
		if(timer == null) {System.out.println("timer is null"); }
	}

	//start the timer and, in turn, draw the new wave
	public void resume () {
		nullCheck();

		lastX = 0;
		lastY = 0;
		time = 0;

		timer.start();
		repaint();
	}

	//clear the panel of the wave in preparation for a new one
	public void clearPanel() {
		nullCheck();

		timer.stop();

		ptList.clear();

		time = 0;
		repaint();
	}

	//change the color the wave
	public void changeColor(Color anotherColor) {
		color = anotherColor;
	}

	//change the delay between dot drawing, ie change how quickly the wave is drawn
	public void setDelay(int delayNum) {
		nullCheck();

		delay = delayNum;
		timer.setDelay(delay);
		
		repaint();
	}

	//change wave period
	public void setWaveWidth(int newWidth) {
		waveWidth = newWidth;
		repaint();
	}

	//draw the wave
	public void paintComponent(Graphics gfx) {
		super.paintComponent(gfx);

		//draw all of the points in ptList, which holds the dots for the wave	
		for(int i = 0; i < ptList.size(); i++) {
			Object newDot = ptList.get(i);
			newDot = (Dot)newDot;

			((Dot)newDot).draw(gfx);

			lastX = ((Dot)newDot).getX();
			lastY = ((Dot)newDot).getY();
		}

		//if the wave goes off the panel in the x direction, stop drawing
		if(lastX > getWidth()) {
			timer.stop();
		}

		
		//if the wave goes off the panel in the y direction, stop drawing
		if(Math.abs(lastY) > getHeight()) {
			timer.stop();
		}
	}

	//calculate a dot in the wave, and draw it using the Dot class's draw method
	private class WaveListener implements ActionListener {
	       public void actionPerformed(ActionEvent event) {
		       time += step;

		       int x = (waveWidth * time)/50;
		       int y = (int)(waveHeight * Math.sin((0.0174533)*time)+85);
		       
		       Dot newDot = new Dot(x, y, color);
		       ptList.add(newDot);

		       repaint();
	       }
	}	
}
