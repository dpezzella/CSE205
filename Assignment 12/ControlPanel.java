// Assignment #: 12
//         Name: Derek Pezzella
//    StudentID:
//      Lecture: TTh 4:30-5:45
//  Description: The ControlPanel class creates 2 panels and
//               control panels that control their movement.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ControlPanel extends JPanel
 {
  private int width, height;
  private int panelNum;

  //The constructor creates creates 2 panels and
  //control panels that control their movement, and organize them using a layout
  public ControlPanel(int width, int height)
   {
       this.width = width;
       this.height = height;
       panelNum = 2; //the number of panels is 2

       //create 2 panels to control the movements
       WaveControlPanel[] wavePanels;
       wavePanels = new WaveControlPanel[panelNum];
       wavePanels[0] = new WaveControlPanel(width/panelNum, height, Color.RED);
       wavePanels[1] = new WaveControlPanel(width/panelNum, height, Color.BLUE);

       //add two panels into this control panel using GridLayout
       setLayout(new GridLayout(panelNum, 1));
       for (int i = 0; i < panelNum; i++)
            add(wavePanels[i]);

       setPreferredSize(new Dimension(width,height));
    }
}
