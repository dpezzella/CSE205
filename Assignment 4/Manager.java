// Assignment #: 4
// Name: 
// StudentID: 1201902394
// Lecture: TTh 4:30-5:45
// Description: Manager class used by the Project class and, in turn, the Assignment4 class. This
// 		stores manager information: the first name, last name, and department number of the project manager.
// 		It also formats the manager information to be printed out by the Assignment4 class.

class Manager {
	//private variables to be only accessed by the Manager class
	private String firstName;
	private String lastName;
	private int deptNum;

	public Manager() {
		firstName = "?";
		lastName = "?";
		deptNum = 0;
	}

	//returns the manager first name stored in the private variable String firstName
	public String getFirstName() {
		return firstName;
	}

	//returns the manager last name stored in the private variable String lastName
	public String getLastName() {
		return lastName;
	}

	//returns the manager department number stored in the private variable int deptNum
	public int getDeptNum() {
		return deptNum;
	}

	//sets the project manager's first name stored in the private variable String firstName
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	//sets the project manager's last name stored in the private variable String lastName
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}

	//sets the project manager's department number stored in the private variable int deptNum
	public void setDeptNum(int newDeptNum) {
		deptNum = newDeptNum;
	}

	//formats the project manager's information to be printed by the Assignment4 class
	public String toString() {
		String returnString = firstName + " " + lastName + ", Dept Num:" + deptNum;
		return returnString;
	}
}
