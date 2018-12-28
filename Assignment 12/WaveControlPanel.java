// Assignment #: 12
//         Name: Derek Pezzella
//    StudentID: 12901902394
//      Lecture: TTh 4:30-5:45pm
//  Description: The WaveControlPanel class creates 3 buttons and 2 sliders to
//               to control the movement of waves, and also contains a panel
//               displaying waves.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class WaveControlPanel extends JPanel
 {
      //components of the panel
      private WavePanel wPanel;
      private JButton start, clear, colorButton;
      private JSlider waveWidth, delay;
      private JLabel label1, label2;
      private JColorChooser chooser;
      private JPanel buttons1;

      private int width, height;
      private Color color;

      //Constructor to create all components, add their listener to them,
      //and arrange them using a layout.
      public WaveControlPanel(int width, int height, Color initialColor)
       {
           //create a color chooser with the specified initial color
           chooser = new JColorChooser(initialColor);
           color = initialColor;
           this.width = width;
           this.height = height;

           //create a panel displaying waves, with the specified color
           wPanel = new WavePanel(initialColor);

           //create 3 buttons, start, clear, and color chooser for waves.
           start = new JButton("Start");
           clear = new JButton("Clear");
           colorButton = new JButton("Color");


           //add a listener to each button
           start.addActionListener(new ButtonListener());
           clear.addActionListener(new ButtonListener());
           colorButton.addActionListener(new ButtonListener());

           buttons1 = new JPanel();
           buttons1.setLayout(new GridLayout(3,1));

           buttons1.add(start);
           buttons1.add(clear);
           buttons1.add(colorButton);


           //create a slider for the delay with major tick spacing 10,
           //minor tick spacing 5. The minimum value is 0, the maximum
           //is 40, and the initial set value is 20.
           delay = new JSlider(JSlider.HORIZONTAL, 0, 40, 20);
           delay.setMajorTickSpacing(10);
           delay.setMinorTickSpacing(5);
           delay.setPaintTicks(true);
           
	   delay.setPaintLabels(true);
           delay.setAlignmentX(Component.LEFT_ALIGNMENT);
           delay.addChangeListener(new DelayListener());

           //create a label for the delay
           label1 = new JLabel("Initial Wave Delay");

           JPanel panel3 = new JPanel();
           panel3.setLayout(new BorderLayout());
           panel3.add(label1, BorderLayout.NORTH);
           panel3.add(delay, BorderLayout.CENTER);


           //create a slider for the wave width with major tick spacing 10,
           //minor tick spacing 5. The minimum value is 5, the maximum
           //is 100, and the initial set value is 50.
           waveWidth = new JSlider(JSlider.HORIZONTAL, 5, 100, 50);
           waveWidth.setMajorTickSpacing(10);
           waveWidth.setMinorTickSpacing(5);
           waveWidth.setPaintTicks(true);
           waveWidth.setPaintLabels(true);
           waveWidth.setAlignmentX(Component.LEFT_ALIGNMENT);
           waveWidth.addChangeListener(new WaveWidthListener());

           //create a label for the wave width
           label2 = new JLabel("Initial Wave Width");

           JPanel panel4 = new JPanel();
           panel4.setLayout(new BorderLayout());
           panel4.add(label2, BorderLayout.NORTH);
           panel4.add(waveWidth, BorderLayout.CENTER);


           JPanel panel6 = new JPanel();
           panel6.setLayout(new GridLayout(2,1));
           panel6.add(panel3);
           panel6.add(panel4);

           JPanel panel5 = new JPanel();
           panel5.setLayout(new BorderLayout());
           panel5.add(buttons1, BorderLayout.CENTER);
           panel5.add(panel6, BorderLayout.EAST);


           setLayout(new BorderLayout());
           wPanel.setPreferredSize(new Dimension((width*2)/3, height));
           add(wPanel, BorderLayout.CENTER);
           add(panel5, BorderLayout.WEST);

}

  //ButtonListener defines actions to be performed when each button
  //is pushed.
  private class ButtonListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
        {
            Object action = event.getSource();

	    if (action == start) {
		    wPanel.resume();
	    }

	    if (action == clear) {
		    wPanel.clearPanel();
	    }
	    
	    //the user clicked the color button to change the color of the waves
            if (action == colorButton)
             {
                 color = chooser.showDialog(null, "Change Wave color", color);
                 wPanel.changeColor(color);
             }
         }
     } //end of ButtonListener

   //DelayListener adjusts the delay of the timer based on
   //the chosen integer in the corresponding slider.
   private class DelayListener implements ChangeListener
    {
        public void stateChanged(ChangeEvent event)
         {
             wPanel.setDelay((int)delay.getValue());
         }

     }


     //WaveWidthListener adjusts the value of waveWidth based on
     //the chosen integer in the corresponding slider.
     private class WaveWidthListener implements ChangeListener
      {
          public void stateChanged(ChangeEvent event)
           {
	       wPanel.setWaveWidth((int)waveWidth.getValue());
           }
     }

 }
