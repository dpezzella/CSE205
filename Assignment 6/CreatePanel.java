// Assignment #: 6
//         Name: Derek Pezzella
//    StudentID:
//      Lecture: TTh 4:30-5:45pm
//  Description: Sets up the "Create Project" pane, where the user can create projects with a name, project number, and location. These projects are then displayed on the right side of the tab.
//   		 The projects the user created then shows up in the "Select Panel" pane. 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.EmptyBorder;

public class CreatePanel extends JPanel
 {
   private Vector projectList;
   private SelectPanel sPanel;

   private JLabel projectTitle;
   private JLabel projectNumber;
   private JLabel projectLocation;
   private JLabel projectStatusLabel;

   private JTextField textProjectTitle;
   private JTextField textProjectNumber;
   private JTextField textProjectLocation;
   private JButton buttonCreateProject;

   private JTextArea projectListTextArea; 
   private JScrollPane projectListScrollPane;

   boolean firstProjectAdded = false;
   
 //Constructor initializes components and organize them using certain layouts
 public CreatePanel(Vector projectList, SelectPanel sPanel)
  {
    final int FIELD_WIDTH = 25;
    final int AREA_ROWS = 17;
    final int AREA_COLUMNS = 35;

    projectList = new Vector(25);

    this.projectList = projectList;
    this.sPanel = sPanel;

    //Add in a space between the top and bottom entry pane to center text entry fields
    EmptyBorder entryBorder = new EmptyBorder(90,0,100,0); //top,left,bottom,right

    //Add in labels for left-side entry pane
    projectStatusLabel = new JLabel("");
    projectStatusLabel.setForeground(Color.RED);
    projectTitle = new JLabel("Project Title");
    projectNumber = new JLabel("Project Number");
    projectLocation = new JLabel("Project Location");

    //Text entry fields for left-side entry pane
    textProjectTitle = new JTextField(FIELD_WIDTH);
    textProjectNumber = new JTextField(FIELD_WIDTH);
    textProjectLocation = new JTextField(FIELD_WIDTH);

    buttonCreateProject = new JButton("Create a project");

    projectListTextArea = new JTextArea("No Project", AREA_ROWS, AREA_COLUMNS);
    projectListScrollPane = new JScrollPane(projectListTextArea);

    projectListTextArea.setEditable(false);
      
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); //Main CreatePanel layout - BoxLayout
    
    JPanel statusLabel = new JPanel(); //Project added label - GridLayout
    JPanel entry = new JPanel(); //Left-sided panel - BoxLayout
    JPanel entry_2 = new JPanel(); //Main container - GridLayout
    JPanel entrySubmitButton = new JPanel(); //Submit button container - BoxLayout
    JPanel list = new JPanel(); //Right-sided panel for project names - FlowLayout

    //Set up the status label panel
    statusLabel.setLayout(new GridLayout(1,1)); 
    statusLabel.add(projectStatusLabel);

    //Set up container panel for spacing
    entry.setPreferredSize(new Dimension(400,250));
    entry.setLayout(new BoxLayout(entry, BoxLayout.Y_AXIS)); 
    entry.setBorder(entryBorder);

    //Add text fields and corresponding labels
    entry_2.setLayout(new GridLayout(4,2));
    entry_2.add(projectTitle);
    entry_2.add(textProjectTitle);
    entry_2.add(projectNumber);
    entry_2.add(textProjectNumber);
    entry_2.add(projectLocation);
    entry_2.add(textProjectLocation);

    entrySubmitButton.setLayout(new BoxLayout(entrySubmitButton, BoxLayout.Y_AXIS));
    entrySubmitButton.add(buttonCreateProject);

    list.add(projectListScrollPane);

    entry.add(statusLabel);
    entry.add(entry_2);
    entry.add(entrySubmitButton);

    add(entry);
    add(list);

    //Listener for the submit button
    ButtonListener lis = new ButtonListener();
    buttonCreateProject.addActionListener(lis);
  }


  //ButtonListener is a listener class that listens to
  //see if the buttont "Create a project" is pushed.
  //When the event occurs, it add the project information
  //in the text fields to the text area
  //and the list of project information,
  //and it also does error checking.
  private class ButtonListener implements ActionListener
   {
    public void actionPerformed(ActionEvent event)
     {
	String projectTitleInput = textProjectTitle.getText();
	String projectNumberInput = textProjectNumber.getText();
	String projectLocationInput = textProjectLocation.getText();

	int projectNumberInt = 0; //used to convert the string input from the user to integer

	projectStatusLabel.setText(""); //clear old error/message once a new project has been attempted to be added
	
	if(!projectTitleInput.equals("") & !projectNumberInput.equals("") & !projectLocationInput.equals("")) {
		try {
			projectNumberInt = Integer.parseInt(projectNumberInput);

			Project newProject = new Project();

			newProject.setProjTitle(projectTitleInput);
			newProject.setProjNumber(projectNumberInt);
			newProject.setProjLocation(projectLocationInput);

			projectList.add(newProject.toString());

			//Clear the "No project" text in the project list text area once the first project has been addded
			if(!firstProjectAdded) {
				projectListTextArea.setText("");
				firstProjectAdded = true;
			}

			projectListTextArea.append(newProject.toString());

			projectStatusLabel.setText("Project added");

			//pass on the new projectList vector so it can be updated in the select panel
			sPanel.updateVector(projectList);

			//I don't need to call this since I don't actually use it
			//sPanel.updateprojectListTextArea();
		} catch(NumberFormatException e) {
			projectStatusLabel.setText("Please enter an integer for the project number");
		}
	} else {
		projectStatusLabel.setText("Please enter all fields");
	}

     }
  }

}
