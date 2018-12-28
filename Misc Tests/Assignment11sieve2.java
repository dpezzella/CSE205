import java.util.LinkedList;

public class sieve2 {
	private static LinkedList<Integer> list1;
	private static LinkedList<Integer> list2;
	private static int n;

	public static void main(String[] args) {
		list1 = new LinkedList<Integer>();
		list2 = new LinkedList<Integer>();
		n = 20;

		sieve(n);
	}

	public static void sieve(int n) {
		//load integers 1 to 20 into list1
		for(int i = 1; i <= n; i++) {
			list1.offer(i);
		}

		//remove items at multiples of 2
		for(int j = 2; j <= n; j++) {
			if(j%2 == 0) {
				list1.remove();
				list2.offer(0);
				//System.out.print(0 + " ");
			} else {
				list2.offer(list1.remove());
				//System.out.print(list2.remove() + " ");
				list2.offer(list1.remove());
				//System.out.print(list2.remove() + " ");
			}
		}

	}

	public static void printList() {
		for(int k = 1; k <= n; k++) {
			System.out.print(list2.remove());
		}
	}
}
