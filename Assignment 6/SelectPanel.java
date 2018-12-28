// Assignment #: 6
//         Name: Derek Pezzella
//    StudentID:
//      Lecture: TTh 4:30-5:45pm
//  Description: Sets up the "Select Project" pane, where the user can add or remove the projects they created in the "Create Project" pane.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class SelectPanel extends JPanel
 {
   private Vector projectList, selectedList;

   private JPanel availableProjectsPanel;
   private JPanel selectedProjectsPanel;
   private JPanel buttonsPanel;

   private JButton add;
   private JButton remove;

   private JList availableProjectsList;
   private JList selectedProjectsList;
   private JScrollPane availableProjectsScrollPane;
   private JScrollPane selectedProjectsScrollPane;

   private JLabel numSelectedProjects;
   private JLabel availableProjectsLabel;
   private JLabel selectedProjectsLabel;

   private DefaultListModel createModel;
   private DefaultListModel selectModel;

   //Constructor initialize each component and arrange them using
   //certain layouts
   public SelectPanel(Vector projectList)
     {
      this.projectList = projectList;

      //List models for the available projects and select project lists
      createModel = new DefaultListModel();
      selectModel = new DefaultListModel();

      setLayout(new GridLayout(3, 1));

      availableProjectsPanel = new JPanel(); //holds available projects text area and available projects label - GridLayout
      availableProjectsPanel.setLayout(new GridLayout(2,1));

      buttonsPanel = new JPanel(); //holds the Add and Remove command buttons and selected projects label - GridLayout
      buttonsPanel.setLayout(new GridLayout(1,2));

      selectedProjectsPanel = new JPanel(); //holds selected projects text area and number of selected projects label - GridLayout
      selectedProjectsPanel.setLayout(new GridLayout(3,1));
	
      add = new JButton("Add");
      remove = new JButton("Remove");

      //Add the two lists and haven them display the model
      availableProjectsList = new JList(createModel);
      availableProjectsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      selectedProjectsList = new JList(selectModel);
      selectedProjectsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      availableProjectsScrollPane = new JScrollPane(availableProjectsList);
      selectedProjectsScrollPane = new JScrollPane(selectedProjectsList);

      //Add the labels, lists, and buttons
      numSelectedProjects = new JLabel("The total number of selected projects: 0");
      availableProjectsLabel = new JLabel("Available project(s)");
      selectedProjectsLabel = new JLabel("Selected project(s)");

      availableProjectsPanel.add(availableProjectsLabel);
      availableProjectsPanel.add(availableProjectsScrollPane);

      buttonsPanel.add(add);
      buttonsPanel.add(remove);

      selectedProjectsPanel.add(selectedProjectsLabel);
      selectedProjectsPanel.add(selectedProjectsScrollPane);
      selectedProjectsPanel.add(numSelectedProjects);

      //Add all of the panes to the select panel tab
      add(availableProjectsPanel);
      add(buttonsPanel);
      add(selectedProjectsPanel);

      ButtonListener lis = new ButtonListener();
      add.addActionListener(lis);
      remove.addActionListener(lis);
  }

  /*
 //This method updates refresh the JList of projects with
 //updated vector information
 public void updateProjectList()
  {
	//for some reason, this doesn't work
	availableProjectsList.updateUI();
  }*/

  //I couldn't get the list to update to with the updateUI command; it simply wouldn't refresh when new elements were added
  //However, using a model automatically updates the list when a new element is added to it.
  public void updateVector(Vector updatedProjectList) {
	 projectList = updatedProjectList;

	 createModel.clear();

	 for(int i = 0; i < projectList.size(); i++) {
		 createModel.addElement(projectList.get(i));
	 }
 }

 //ButtonListener class listens to see if any of
 //buttons is pushed, and perform their corresponding action.
 private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
        {
	  Object selectedItem;
	  int selectedIndex;

          if(event.getSource() == add) {
		  if(!availableProjectsList.isSelectionEmpty()) {
			  selectedItem = availableProjectsList.getSelectedValue();
			  selectModel.addElement(selectedItem);
				
			  numSelectedProjects.setText("The total number of selected objects: " + selectModel.getSize());
		  }
	  } else if (event.getSource() == remove) {
		  if(!selectedProjectsList.isSelectionEmpty()) {
			  selectedIndex = selectedProjectsList.getSelectedIndex();
			  selectModel.remove(selectedIndex);

			  numSelectedProjects.setText("The total number of selected objects: " + selectModel.getSize());
		  }
	  }
        }
  }

}
