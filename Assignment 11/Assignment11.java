// Assignment #: 11
// Name: Derek Pezzella
// StudentID:
// Lecture: TTh 4:30-5:45pm
// Description: Assignment 11 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//      enter the next choice until the choice of 'Q' (Quit) is entered.

import java.io.*;

public class Assignment11
 {
  public static void main (String[] args) throws IOException
   {
       char input1;
       String line = new String();

       printMenu();

       InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader stdin = new BufferedReader(isr);
       PrimeComputing primeComputing = null;

       do  // will ask for user input
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)
          {
           // matches one of the case statements
           switch (input1)
            {
             case 'E':   //Enter Problem parameters
                 System.out.print("Please a positive integer n, to find primes up to n:\n");
                 int n = Integer.parseInt(stdin.readLine().trim());
                    
                    if (n < 2)
                        System.out.print("Please enter an integer greater than 1.\n");
                    else
                    {
                    
                    primeComputing = new PrimeComputing(n);
                    primeComputing.computePrimesUpToN();

                    primeComputing.printResults();
                    
                    System.out.print("The largest prime number used to divide: " + primeComputing.getMaxPrime()
                                     + "\n\n");
                    System.out.print("The count of prime numbers found: " + primeComputing.getCount()
                                     + "\n\n");
                    }
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


  /** The method printMenu displays the menu to a user**/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "E\t\tEnter A Positive Integer To Find Primes\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
  }
}
