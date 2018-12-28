// Assignment #: 8
//         Name: Derek Pezzella
//    StudentID:	
//      Lecture: TTh 4:30-5:45pm
//  Description: The project management class contains the projects and its associated methods

import java.io.*;
import java.util.*;

public class ProjectManagement implements Serializable {
	private Project[] projectList;
	private int currentProjectCount;
	private int maxSize;
	private boolean removedTrigger = false;

	//Class constructor 
	public ProjectManagement(int maximumsize) {
		maxSize = maximumsize;
		projectList = new Project[maxSize];
		
		//Initialize array with null objects to be filled by user
		for(int i = 0; i < maxSize; i++) {
			projectList[i] = null;
		}

		currentProjectCount = 0;

	}

	//Using linear search, find out if a project exists by searching with the project number
	public int projectNumberExists(int projectNumber) {
		int result = -1;

		//linear search
		for(int i = 0; i < currentProjectCount; i++) {
			if(projectList[i].getProjNumber() == projectNumber) {
				result = i;
			}
		}

		return result;
	}

	//Using linear search, find out of a manager exists by searching through all of the projects' managers
	public int managerExists(String firstName, String lastName, int deptNum) {
		int result = -1;
		Manager manager;

		for(int i = 0; i < currentProjectCount; i++) {
			manager = projectList[i].getProjManager();

			if(manager.getFirstName().equals(firstName) && manager.getLastName().equals(lastName) && manager.getDeptNum() == deptNum) {
				result = i;
			}
		}

		return result;
	}

	//Add a project to the current project management
	public boolean addProject(String projTitle, int projNumber, String projLocation, String firstName, String lastName, int deptNum) {
		boolean result = false;
		boolean projectExists = false;

		//Before creating the project, make sure that another project with the same number doesn't exist
		for(int i = 0; i < currentProjectCount; i++) {
			if(projectList[i].getProjNumber() == projNumber) {
				projectExists = true;
			}

		}

		//Create the project
		if(currentProjectCount < maxSize && !projectExists) {
			projectList[currentProjectCount] = new Project();
			projectList[currentProjectCount].setProjTitle(projTitle);
			projectList[currentProjectCount].setProjLocation(projLocation);
			projectList[currentProjectCount].setProjNumber(projNumber);
			projectList[currentProjectCount].setProjManager(firstName, lastName, deptNum);

			currentProjectCount++;

			result = true;
		}

		return result;
	}

	//Remove a project based upon the project number, using a linear search
	public boolean removeProjectNumber(int projectNumber) {
		boolean result = false;
		int switchPlace = 0;
		int lastNonNull = 0;

		for(int i = 0; i < currentProjectCount; i++) {
			if(projectList[i].getProjNumber() == projectNumber) {
				switchPlace = i;
				result = true;
			}
		}

		//collapse array on the now null project
		if(result) {
			for(int j = switchPlace; j < currentProjectCount - 1; j++) {
				projectList[j].copy(projectList[j + 1]);

				lastNonNull = j;
			}

			removedTrigger = true;
		}

		return result;
	}

	
	//Using selection sort in the sort class, sort the projects by their project numbers
	public void sortByProjectNumber() {
		ProjectNumberComparator c = new ProjectNumberComparator();
		int lengthLessNulls = 0;
		Project[] sorted = new Project[projectList.length];

		removedTrigger = false;

		for(int j = 0; j < projectList.length; j++) {
			if(projectList[j] != null) {
				lengthLessNulls += 1;
			}
		}

		try {
			sorted = Sorts.sort(projectList, lengthLessNulls, c);
		} catch(Throwable t) {
			t.printStackTrace();
		}	
	}

	
	//Using selection sort in the sort class, sort the projects by their manager information (first name, last name, department number)
	public void sortByManager() {
		ManagerComparator c = new ManagerComparator();
		int lengthLessNulls = 0;
		Project[] sorted = new Project[projectList.length];

		for(int j = 0; j < projectList.length; j++) {
			if(projectList[j] != null) {
				lengthLessNulls += 1;
			} 
		}

		try {
			sorted = Sorts.sort(projectList, lengthLessNulls, c);

		} catch(Throwable t) {
			t.printStackTrace();
		}	
	}

	//Run through the print out the project details inside each project using their toString method
	public String listProjects() {
		String result = "";
		final String noProj = "no project\n\n"; //is this worth doing?

		if(currentProjectCount > 0 && !removedTrigger) {
			for(int i = 0; i < currentProjectCount; i++) {
				if(projectList[i] != null) {
					result += projectList[i].toString();
				}
			}
		//hack to correct end-of-array
		} else if(currentProjectCount > 0 && removedTrigger) { 

			for(int i = 0; i < currentProjectCount - 1; i++) {
				if(projectList[i] != null) {
					result += projectList[i].toString();
				}
			}
		} else {
			result = noProj;
		}

	
		return result;

	}

	//Close the current project management by setting all the projects in the array to null
	public void closeProjectManagement() {
		if(currentProjectCount > 0) {
			for(int i = 0; i < currentProjectCount; i++) {
				projectList[i] = null;
			}

			currentProjectCount = 0;
		} 

	}
}
