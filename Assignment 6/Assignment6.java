// Assignment #: 6
//         Name: Derek Pezzella
//    StudentID:
//      Lecture: TTh 4:30-5:45pm
//  Description: Applet in which a user creates projects in the "Create Panel" tab and then organizes them in the "Select Panel" tab. 
//  		This particular Java file just created the window and tabbed panes, where the "Create Panel" and "Select Panel" panes are added.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Assignment6 extends JApplet {
	private CreatePanel createPanel;
	private SelectPanel selectPanel;
	private JTabbedPane tPane;
	private Vector projectList;

	public void init() {
		//Vector that holds the project information, which is then passed to the create and select panels
		projectList = new Vector(25);

		tPane = new JTabbedPane();

		selectPanel = new SelectPanel(projectList);
		createPanel = new CreatePanel(projectList, selectPanel);

		tPane.addTab("Project creation", createPanel);
		tPane.addTab("Project selection", selectPanel);

		add(tPane);

		setSize(800,300);
	}
}
