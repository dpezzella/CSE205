import java.util.LinkedList;

public class Sieve {
	private LinkedList<Integer> originalQueue;
  	private LinkedList<Integer> primeQueue;
  	private LinkedList<Integer> backupQueue;
	boolean current;

	public static void main(String[] args) {
		originalQueue = new LinkedList<integer>;
	}

	public void SieveOfEratosthenes(int n) {
		int counter = 2;

		//fill the linked list with booleans set to true
		for(int i = 0; i <= n; i++) {
			originalQueue.offer(true);
		}

		//remove every multiple of the x
		do {
			current = originalQueue.remove();


			counter++;
		} while (counter <= Math.sqrt(n))
		
	}
}
