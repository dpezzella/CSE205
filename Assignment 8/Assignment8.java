// Assignment #: 8
//         Name: Derek Pezzella
//    StudentID:
//      Lecture: TTh 4:30-5:45pm
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. 

import java.io.*;
import java.util.Scanner;

public class Assignment8 implements Serializable
 {
  public static void main (String[] args) 
   {
       char input1;
       String projTitle, projNumStr, projLocation, firstName, lastName, deptNumStr;
       int projNumber, deptNumber;
     
       boolean operation = false;
       int operation2 = 0;
       String line;
       String filename;

       // create a ProjectManagement object. This is used throughout this class.
       ProjectManagement manage1 = null;

       //For custom code in input and output files
       String inputLine; //outputting line
       String firstLine; //reading file
       Scanner in; //reading file scanner

       try
       {
           // print out the menu
           printMenu();

           // create a BufferedReader object to read input from a keyboard
           InputStreamReader isr = new InputStreamReader (System.in);
           BufferedReader stdin = new BufferedReader (isr);
           
           System.out.print("Please enter a maximum number of projects\n");
           String maxStr = stdin.readLine().trim(); //read in the max number as a string
           int max = Integer.parseInt(maxStr);
           manage1 = new ProjectManagement(max);

           do
           {
               System.out.print("What action would you like to perform?\n");
               line = stdin.readLine().trim();  //read a line
               input1 = line.charAt(0);
               input1 = Character.toUpperCase(input1);

               if (line.length() == 1)          //check if a user entered only one character
               {
                   switch (input1)
                   {
                       case 'A':   //Add Project
                           System.out.print("Please enter a project to add:\n");
                           System.out.print("Please enter its title to add:\n");
                           projTitle = stdin.readLine().trim();
                           System.out.print("Please enter its project number to add:\n");
                           projNumStr = stdin.readLine().trim();
                           projNumber = Integer.parseInt(projNumStr);
                           System.out.print("Please enter its project location to add:\n");
                           projLocation = stdin.readLine().trim();
                           
                           System.out.print("Please enter its manager's first name to add:\n");
                           firstName = stdin.readLine().trim();
                           System.out.print("Please enter its manager's last name to add:\n");
                           lastName = stdin.readLine().trim();
                           System.out.print("Please enter its manager's department number to add:\n");
                           deptNumStr = stdin.readLine().trim();
                           deptNumber = Integer.parseInt(deptNumStr);

                           operation = manage1.addProject(projTitle, projNumber, projLocation,
                                                          firstName, lastName, deptNumber);
                           if (operation == true)
                               System.out.print("project added\n");
                           else
                               System.out.print("project not added\n");
                           break;
                       case 'C':  //Create a new project management
                           System.out.print("Please enter a new maximum number of projects:\n");
                           maxStr = stdin.readLine().trim(); //read in the max number as a string
                           max = Integer.parseInt(maxStr);
                           manage1 = new ProjectManagement(max);
                           break;
                       case 'D':  //Search by project number
                           System.out.print("Please enter project number to search:\n");
                           projNumStr = stdin.readLine().trim();
                           projNumber = Integer.parseInt(projNumStr);
                           operation2=manage1.projectNumberExists(projNumber);

                           if (operation2 > -1)
                               System.out.print("project number " + projNumber + " found\n");
                           else
                               System.out.print("project number " + projNumber + " not found\n");
                           break;
                       case 'E':  //Search by manager
                           System.out.print("Please enter the first name of a manager to search:\n");
                           firstName = stdin.readLine().trim();
                           System.out.print("Please enter the last name of a manager to search:\n");
                           lastName = stdin.readLine().trim();
                           System.out.print("Please enter the department number of a manager to search:\n");
                           deptNumStr = stdin.readLine().trim();
                           deptNumber = Integer.parseInt(deptNumStr);
                           
                           operation2=manage1.managerExists(firstName, lastName, deptNumber);
                    
                           if (operation2 > -1)
                           {
                               System.out.print("project manager "  + lastName + "," + firstName
                                            + " of the department " + deptNumber + " found\n");
                           }
                           else
                           {
                               System.out.print("project manager "  + lastName + "," + firstName
                                                + " of the department " + deptNumber + " not found\n");
                           }
                           break;
                       case 'L':   //List projects
			   //hack to match test cases
			   if(manage1.listProjects() != "no project\n\n") {
			   	System.out.print("\n");
			   	System.out.print("\n");
                           	System.out.print(manage1.listProjects());
			   } else {
				System.out.print("\n");
                           	System.out.print(manage1.listProjects());
			   }
                           break;
                       case 'O':  // Sort by project numbers
                           manage1.sortByProjectNumber();
                           System.out.print("sorted by project numbers\n");
                           break;
                       case 'P':  // Sort by manager information
                           manage1.sortByManager();
                           System.out.print("sorted by managers\n");
                           break;
                       case 'Q':   //Quit
                           break;
                       case 'R':  //Remove by project number
                           System.out.print("Please enter project number to remove:\n");
                           projNumStr = stdin.readLine().trim();
                           projNumber = Integer.parseInt(projNumStr);
                           operation=manage1.removeProjectNumber(projNumber);
                           if (operation == true)
                               System.out.print("project number " + projNumber + " removed\n");
                           else
                               System.out.print("project number " + projNumber + " not found\n");

                           break;
                       case 'T':  //Close ProjectManagement
                           manage1.closeProjectManagement();
                           System.out.print("project management system closed\n");
                           break;
                       case 'U':  //Write Text to a File
                           System.out.print("Please enter a file name to write:\n");
                           filename = stdin.readLine().trim();

			   PrintWriter out = new PrintWriter(filename);
			   
			   try {
				   System.out.print("Please enter a string to write in the file:\n");
				   inputLine = stdin.readLine().trim();
				   out.print(inputLine + "\n");
				   System.out.print(filename + " was written\n");
			   } catch (IOException ex) {
				   System.out.print("Could not write to file\n");
			   } finally {
				   out.close();
			   }

                           break;
                       case 'V':  //Read Text from a File
                           System.out.print("Please enter a file name to read:\n");
                           filename = stdin.readLine().trim();

			   try {
			   	   File inputFile = new File(filename);
			           in = new Scanner(inputFile);
			   
				   firstLine = in.nextLine();
				   System.out.print(filename + " was read\n");
				   System.out.print("The first line of the file is:\n");
				   System.out.print(firstLine + "\n");
			   } catch (FileNotFoundException ex) {
				   System.out.print(filename + " was not found\n");
			   } catch (IOException ex) {
				   System.out.print(filename + " could not be read.\n");
			   } 
                         
                           break;
                   case 'W':  //Serialize ProjectManagement to a File
                           System.out.print("Please enter a file name to write:\n");
                           filename = stdin.readLine().trim();

			   //from here on, look at 2-20 notes.java
                           FileOutputStream fileOutput = null;
			   ObjectOutputStream outStream = null;

			   try {
				   fileOutput = new FileOutputStream(filename);
				   outStream = new ObjectOutputStream(fileOutput);

			           outStream.writeObject(manage1);

				   System.out.print(filename + " was written\n");
			   } catch (IOException ex) {
				   System.out.print("Could not write to file\n");
			   } finally {
				   if(outStream != null) {
				   	outStream.close();
					fileOutput.close();
				   }
			   }

                           break;
                       case 'X':  //Deserialize ProjectManagement from a File
                           System.out.print("Please enter a file name to read:\n");
                           filename = stdin.readLine().trim();

			   FileInputStream fileInput = null;
			   ObjectInputStream inStream = null;
			   
			   try {
			   	fileInput = new FileInputStream(filename);
			   	inStream = new ObjectInputStream(fileInput);
			    
			   	Object obj1 = inStream.readObject();

				manage1 = (ProjectManagement)obj1;

				System.out.print(filename + " was read\n");
			   } catch (ClassNotFoundException ex) {
				   System.out.print(filename + " was not found\n");
			   } catch (FileNotFoundException ex) {
				   System.out.print(filename + " was not found\n");
			   } catch (IOException ex) {
				   System.out.print(filename + " was not found\n");
			   } finally {
				   if(inStream != null) {
				   	fileInput.close();
				   	inStream.close();
				   }
			   }
                          
                           break;
                       case '?':   //Display Menu
                           printMenu();
                           break;
                       default:
                           System.out.print("Unknown action\n");
                           break;
                   }
               }
               else
               {
                   System.out.print("Unknown action\n");
               }
           } while (input1 != 'Q' || line.length() != 1);
       }
    catch (IOException exception)
       {
           System.out.print("IO Exception\n");
       }
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Project\n" +
                      "C\t\tCreate ProjectManagement\n" +
                      "D\t\tSearch by Project Number\n" +
                      "E\t\tSearch by Manager\n" +
                      "L\t\tList Projects\n" +
                      "O\t\tSort by Project Number\n" +
                      "P\t\tSort by Manager\n" +
                      "Q\t\tQuit\n" +
                      "R\t\tRemove by Project Number\n" +
                      "T\t\tClose ProjectManagement\n" +
                      "U\t\tWrite Text to File\n" +
                      "V\t\tRead Text from File\n" +
                      "W\t\tSerialize ProjectManagement to File\n" +
                      "X\t\tDeserialize ProjectManagement from File\n" +
                      "?\t\tDisplay Help\n\n");
  }
}


