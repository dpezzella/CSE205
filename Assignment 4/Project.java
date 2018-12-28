// Assignment #: 6
// Name: Derek Pezzella
// StudentID: 
// Lecture: TTh 4:30-5:45
// Description: Project class used by the Assignment 6 class. This class handles the entire project, including the 
//        	manager. It stores the project variables: the project title, project number, project location,
//        	and project manager. It also formats the project information output in the toString method.
//        	Note: This is modified from Assignment 4

class Project {
	//private variables, only to be accessed by the Project class
	private String projTitle;
	private int projNumber;
	private String projLocation;
	private Manager projManager;

	//class constructor
	public Project() {
		projTitle = "?";
		projNumber = 0;
		projLocation = "?";
		projManager = new Manager();
	}

	//returns the project title stored in the private variable String projTitle
	public String getProjTitle() {
		return projTitle;
	}

	//returns the project number stored in the private variable int projNumber
	public int getProjNumber() {
		return projNumber;
	}

	//returns the project location stored in the private variable String projLocation
	public String getProjLocation() {
		return projLocation;
	}

	//returns the project manager stored in the private variable Manager projManager
	public Manager getProjManager() {
		return projManager;
	}

	//sets the project title stored in the private variable String projTitle
	public void setProjTitle(String newTitle) {
		projTitle = newTitle;
	}

	//sets the project number stored in the private variable int projNumber
	public void setProjNumber(int newNumber) {
		projNumber = newNumber;
	}
	
	//sets the project location stored in the private variable String projLocation
	public void setProjLocation(String newLocation) {
		projLocation = newLocation;
	}

	//calls the mutator methods inside the Manager class to set a new first name, last name, and dept number
	//for the new project manager
	public void setProjManager(String newFirstName, String newLastName, int newDeptNum) {
		projManager.setFirstName(newFirstName);
		projManager.setLastName(newLastName);
		projManager.setDeptNum(newDeptNum);
	}
	
	//formats project information to be printed out by the Assignemnt4 class
	public String toString() {
		String newString = "\nProject Title:\t\t" + projTitle + "\n" 
			+ "Project Number:\t\t" + projNumber + "\n" 
			+ "Project Location:\t" + projLocation + "\n"
			+ "Project Manager:\t" + projManager.toString() + "\n\n";
		return newString;
	}	
}
