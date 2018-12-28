// Assignment #: 8
//         Name: Derek Pezzella
//    StudentID: 	
//      Lecture: TTh 4:30-5:45pm
//  Description: The Manager class describes a manager.
//               It also provides their accessor, mutator methods,
//               and toString method.

import java.io.*;

public class Manager implements Serializable
{

 private String firstName;
 private String lastName;
 private int deptNum;

 /************************************************************************
 Constructor method to initialize intance variables.
 ************************************************************************/
 public Manager()
  {
      firstName = new String("?");
      lastName= new String("?");
      deptNum = 0;
  }

 //Copy method that copies the variables from the other class
 public void copy(Manager other) {
	 if(other != null) {
	 	this.firstName = other.firstName;
	 	this.lastName = other.lastName;
	 	this.deptNum = other.deptNum;
	 }
 }

 /************************************************************************
 Accessor methods
 ************************************************************************/
 public String getFirstName()
  {
   return firstName;
  }

 public String getLastName()
  {
   return lastName;
  }

 public int getDeptNum()
  {
   return deptNum;
  }

 /************************************************************************
  Modifier methods
 ************************************************************************/
 public void setFirstName(String someFirstName)
  {
   firstName = someFirstName;
  }

 public void setLastName(String someLastName)
  {
   lastName = someLastName;
  }

 public void setDeptNum(int someDeptNum)
  {
   deptNum = someDeptNum;
  }

 /*****************************************************************************
 This method return a string containing the attribute information of a manager
 *****************************************************************************/
 public String toString()
  {
   String result;

      result = firstName + " " + lastName + ", Dept Num:" + deptNum;

   return result;
  }
} 


