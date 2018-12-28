// Assignment #: 11
// Name: Derek Pezzella
// StudentID:
// Lecture: TTh 4:30-5:45pm
// Description: Uses a queue to find prime numbers less than the integer entered by the user


//We will be using LinkedList as a Queue
import java.util.LinkedList;

public class PrimeComputing
 {
  private int n, lastPrime, primeCount, current;
  private LinkedList<Integer> originalQueue;
  private LinkedList<Integer> primeQueue;
  private LinkedList<Integer> backupQueue;

  //Constructor to initialize all queues
  public PrimeComputing(int enteredNum)
   {
      //TO BE COMPLETED
      originalQueue = new LinkedList<Integer>();
      primeQueue = new LinkedList<Integer>();
      backupQueue = new LinkedList<Integer>();

      n = enteredNum;
      lastPrime = 0;
      primeCount = 0;

      for(int i = 2; i <= n; i++) {
	      originalQueue.offer(i);
      }
   }

  // computes all prime numbers up to some n
  public void computePrimesUpToN()
   {
       boolean noDivisors = false;
       int nextPrime = 2;
       lastPrime = 2;
       int current;
       
       System.out.println("\nProcessing......");
       
       //I couldn't get this to work at all. Alternatively, I could 
       //use the Sieve of Eratothenses with a queue
       
       do {
           //1. Remove the first element in the original queue of integers
           //and set the next prime "nextPrime" to be the number
	   nextPrime = originalQueue.remove();
	   
           
           //2. Enqueue the next Prime into the primeQueue.
           //TO BE COMPLETED
	   primeQueue.offer(nextPrime);
           
           //3. Go through the integers in the original queue,
           //and elimienate any number that is divisible by the next prime
           //HINT: you will need to remove each integer from the original queue
           //to examine them, and put back the integers that are NOT
           //divisible by the next prime.
           //This is where you will need a back up queue.
           //Also, you will need to keep track of the last such prime
           //that is used to divide other integers in the original queue.
	  
	   //I tried going through the entire queue to see if the number
	   //in the while loop was divisble by the numbers remaining in the
	   //queue, but couldn't get it to work. 
	   for(int i = 2; i <= n; i++) {
		   noDivisors = false;
		   current = originalQueue.remove();

		   for(int j = i; j < n; j++) {
		   	if(current%i != 0 && current != i) {
				//Not divisble by the i -- still possibly prime
				//so re-add into originalQueue
				originalQueue.offer(i);

				if(j == n - 1) {
					noDivisors = true;
				}
		   	} else {
				//If the current does not equal itself (since by definition of prime, 
				//it's only divisible by 1 and itself), then it is divisble by another number in the queue.
				if(i != current) {
					System.out.println(current + " is divisible by " + j);
					j = n + 1;
				}
			}
		   }
	   }

	   //If the number has no divisors, ie no number in the queue divides, then it is a prime.
	   if(noDivisors) {
           	System.out.println("The next prime to divide: " + nextPrime);
	   }

       } while (nextPrime <= Math.sqrt(n));
    
       
       //4. Transfer all remaining integers in the original queue
       //to the prime queue.
 
       //TO BE COMPLETED
 
   }

  //It prints out all primes up to N, by displaying 10 prime numbers
  //in each line.
  public void printResults()
     {
         System.out.println("\n-----------------------");
         System.out.println("The prime(s) up to " + n);
         System.out.println("-----------------------");
         
         int count = 0;
         primeCount = 0;
         
         while (primeQueue.isEmpty() == false)
         {
             int primeNum = primeQueue.remove();
             System.out.print(primeNum + "\t");
             
             count++;
             //displaying 10 primes in each line
             if (count%10 == 0)
                 System.out.print("\n");
         }
         System.out.println("\n-----------------------");
         primeCount = count;
     }
     
  // It returns the laegest prime that was used to divide other integers
  // in the original queue. Note that this is not the largest prime found.
  public int getMaxPrime()
     {
         return lastPrime;
     }
    
  // It return the count of prime numbers up to n
  public int getCount()
     {
         return primeCount;
     }
}

