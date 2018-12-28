// Assignment #: 7
//         Name: Derek Pezzella
//    StudentID: 	
//      Lecture: TTh 4:30-5:45pm
//  Description: it needs to be filled.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // to use listener interfaces

public class WholePanel extends JPanel
{
   private Color currentColor;
   private int currentWidth, currentHeight;
   private CanvasPanel canvas;
   private JPanel menuPanel;

   private JCheckBox fillCheck;
   private boolean fillChecked = false;

   private JRadioButton whiteRadio, redRadio, blueRadio, greenRadio, orangeRadio;
   private ButtonGroup controlsGroup;

   private int x1, y1;
   private int lastY = 0;
   private int lastX = 0;

   private final int delta = 3;

   public WholePanel()
   {
     //white is the default color
     currentColor = Color.WHITE;

     //default x-y cooridnate, width, and height of a rectangle
     currentWidth = currentHeight = 100;
     x1 = 100; y1 = 100;

     fillCheck = new JCheckBox("Filled");

     whiteRadio = new JRadioButton("white", true);
     redRadio = new JRadioButton("red", true);
     blueRadio = new JRadioButton("blue", true);
     greenRadio = new JRadioButton("green", true);
     orangeRadio = new JRadioButton("orange", true);
	
     menuPanel = new JPanel();

     menuPanel.add(fillCheck);
     menuPanel.add(whiteRadio);
     menuPanel.add(redRadio);
     menuPanel.add(blueRadio);
     menuPanel.add(greenRadio);
     menuPanel.add(orangeRadio);

     //Add radio buttons to control group, so user can only select one color at a time
     controlsGroup = new ButtonGroup();

     controlsGroup.add(whiteRadio);
     controlsGroup.add(redRadio);
     controlsGroup.add(blueRadio);
     controlsGroup.add(greenRadio);
     controlsGroup.add(orangeRadio);

     canvas = new CanvasPanel();

     JSplitPane sPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuPanel, canvas);

     setLayout(new BorderLayout());
     add(sPane, BorderLayout.CENTER);
	
     //Add listener to fill checkbox and color radio buttons
     ColorListener colorLis = new ColorListener();
     FillListener fillLis = new FillListener();

     fillCheck.addActionListener(fillLis);
     
     whiteRadio.addActionListener(colorLis);
     redRadio.addActionListener(colorLis);
     blueRadio.addActionListener(colorLis);
     greenRadio.addActionListener(colorLis);
     orangeRadio.addActionListener(colorLis); 
   }

     private class ColorListener implements ActionListener {
	     public void actionPerformed(ActionEvent event) {
		     Object source = event.getSource();

		     if(source == whiteRadio) {
			     currentColor = Color.WHITE;
			     repaint();
		     } else if(source == redRadio) {
			     currentColor = Color.RED;
			     repaint();
		     } else if(source == blueRadio) {
			     currentColor = Color.BLUE;
			     repaint();
		     } else if(source == greenRadio) {
			     currentColor = Color.GREEN;
			     repaint();
		     } else if(source == orangeRadio) {
			     currentColor = Color.ORANGE;
			     repaint();
		     }
	     }
     }

     private class FillListener implements ActionListener {
	     public void actionPerformed(ActionEvent event) {
		     if(!fillChecked) {
			     fillChecked = true;
			     repaint();
		     } else {
			     fillChecked = false;
			     repaint();
		     }
	     }
     }

 //CanvasPanel is the panel where pressed keys will be drawn
 private class CanvasPanel extends JPanel
  {
     //Constructor to initialize the canvas panel
     public CanvasPanel( )
      {
        // make this canvas panel listen to mouse
        addMouseListener(new PointListener());
        addMouseMotionListener(new PointListener());

        setBackground(Color.BLACK);
      }


     //this method draws all characters pressed by a user so far
     public void paintComponent(Graphics page)
      {
       super.paintComponent(page);

       //set color, then draw a rectangle
       page.setColor(currentColor);

       if(!fillChecked) {
       	page.drawRect(x1, y1, currentWidth, currentHeight);
       } else {
	page.fillRect(x1, y1, currentWidth, currentHeight);
       }
      }

    // listener class that listens to the mouse
    public class PointListener implements MouseListener, MouseMotionListener
         {
         //in case that a user presses using a mouse,
         //record the point where it was pressed.
         public void mousePressed (MouseEvent event) {}
         public void mouseClicked (MouseEvent event) {}
         public void mouseReleased (MouseEvent event) {
		 setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	 }
         public void mouseEntered (MouseEvent event) {}
         public void mouseExited (MouseEvent event) {}
         public void mouseMoved(MouseEvent event) {}
         public void mouseDragged(MouseEvent event)
          {
		  Point clickedPoint = event.getPoint();
	
		  //If the user dragged the mouse, check to see if its within the rectangle's area
		  if((clickedPoint.x <= x1 + currentWidth && clickedPoint.x >= x1) && (clickedPoint.y <= y1 + currentHeight && clickedPoint.y >= y1)) {
			  setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			  //top
			  if((clickedPoint.x >= x1 && clickedPoint.x <= x1 + currentWidth) 
					  && (clickedPoint.y <= y1 + currentHeight * .25 && clickedPoint.y >= y1)
					  && (lastY > clickedPoint.y)) { //this line means the user's mouse is moving up in the top quadrant
				  setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
				  y1 -= delta;
				  currentHeight += delta;
				  repaint();
			  }

			  //bottom
			  if((clickedPoint.x >= x1 && clickedPoint.x <= x1 + currentWidth) 
					  && (clickedPoint.y >= y1 + currentHeight * .75 && clickedPoint.y >= y1)
					  && (lastY < clickedPoint.y)) { //this line means the user's mouse is moving down in the bottom quadrant
				  setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
				  currentHeight += delta;
				  repaint();
			  }

			  //left
			  if((clickedPoint.y >= y1 && clickedPoint.y <= y1 + currentHeight) 
					  && (clickedPoint.x <= x1 + currentWidth * .25 && clickedPoint.x >= x1)
					  && (lastX > clickedPoint.x)) { //this line means the user's mouse is moving left in the left quadrant
				  setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
				  x1 -= delta;
				  currentWidth += delta;
				  repaint();
			  }

			  //right
			  if((clickedPoint.y >= y1 && clickedPoint.y <= y1 + currentHeight) 
					  && (clickedPoint.x >= x1 + currentWidth * .75 && clickedPoint.x >= x1)
					  && (lastX < clickedPoint.x)) { //this line means the user's mouse is moving right in the right quadrant
				  setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
				  currentWidth += delta;
				  repaint();
			  }

		  } else {
			  setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }

		  lastY = clickedPoint.y;
		  lastX = clickedPoint.x;
          }

    } // end of PointListener

  } // end of Canvas Panel Class

} // end of Whole Panel Class
