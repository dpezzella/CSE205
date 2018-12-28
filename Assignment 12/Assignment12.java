// Assignment #: 12
//         Name: Derek Pezzella
//    StudentID:
//      Lecture: TTh 4:30-5:45pm
//  Description: The Assignment 12 class creates a controlpanel and
//               adds it as its Applet content and also sets its size.

import javax.swing.*;
import java.awt.*;

public class Assignment12 extends JApplet
 {
  private final int WIDTH = 800;
  private final int HEIGHT = 340;
  private final boolean dev = true;

  public void init()
   {
       //I have problems compiling on GUI assignments if I don't create an instance of 
       //some class, for some weird reason
       if(dev) { 
	       Color color_fix = Color.WHITE;
	       WavePanel panel_fix = new WavePanel(color_fix);
	       WaveControlPanel panel2_fix = new WaveControlPanel(0,0, color_fix);
       }
       
       ControlPanel panel = new ControlPanel(WIDTH,HEIGHT);
       getContentPane().add(panel);
       setSize(WIDTH,HEIGHT);
   }
 }
