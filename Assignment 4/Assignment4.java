// Assignment #: 4
// Name: Derek Pezzella
// StudentID: 
// Lecture: TTh 4:30-5:45
// Description: Assignment 4 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.

import java.util.*;

public class Assignment4
 {
  public static void main (String[] args)
   {
       // local variables, can be accessed anywhere from the main method
       char input1 = 'Z';
       String inputInfo;
       String projTitle, projLocation, first, last, projNumStr, deptNumStr;
       int projNumber, deptNum;
       String line = new String();

       // instantiate a Project object
       Project project1 = new Project();

       printMenu();

       //Create a Scanner object to read user input
       Scanner scan = new Scanner(System.in);

       do  // will ask for user input
        {
            System.out.println("What action would you like to perform?");
            line = scan.nextLine();
            
            if (line.length() == 1)
            {
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);

                // matches one of the case statement
                switch (input1)
                {
                    case 'A':   //Add Project
                        System.out.print("Please enter the Project information:\n");
                        System.out.print("Enter its title:\n");
                        projTitle = scan.nextLine();
                        project1.setProjTitle(projTitle);

                        System.out.print("Enter its project number:\n");
                        projNumStr = scan.nextLine();
                        projNumber = Integer.parseInt(projNumStr);
                        project1.setProjNumber(projNumber);
                    
                        System.out.print("Enter its location:\n");
                        projLocation = scan.nextLine();
                        project1.setProjLocation(projLocation);
                        
                        System.out.print("Enter its manager's first name:\n");
                        first= scan.nextLine();
                        System.out.print("Enter its manager's last name:\n");
                        last = scan.nextLine();
                        System.out.print("Enter its manager's department number:\n");
                        deptNumStr = scan.nextLine();
                        deptNum = Integer.parseInt(deptNumStr);
                        project1.setProjManager(first, last, deptNum);
                        
                        break;
                    case 'D':   //Display project
                        System.out.print(project1);
                        break;
                    case 'Q':   //Quit
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

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd Project\n" +
                        "D\t\tDisplay Project\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");
  }
}
