// Assignment #: 12
//         Name: Derek Pezzella
//    StudentID:
//    Lecture: TTh 4:30-5:45
//    Description: The Assignment 12 class creates a controlpanel and
//               adds it as its Applet content and also sets its size.

import java.awt.*;
import javax.swing.*;

public class Dot {
	private int x;
	private int y;
	private Color color;
	private final int RADIUS = 3;

	//dot constructor
	public Dot(int x1, int y1, Color color1) {
		x = x1;
		y = y1;
		color = color1;
	}

	//draw a dot (oval) at the specified (x,y)
	public void draw(Graphics page) {
		page.setColor(color);
		page.fillOval(x,y,RADIUS,RADIUS);
	}

	//used for testing purposes. used to get the x coordinate
	public int getX() {
		return x;
	}
	
	//used for testing purposes. used to get the y coordinate
	public int getY() {
		return y;
	}
}
