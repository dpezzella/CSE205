public class qsorttest {
	static int[] toSort = {5, 10, 7, 3, 5, 0, 0, 1, 4, 2};

	public static void main(String[] args) { 

		quickSort(toSort, 0, toSort.length-1);

		for(int i=0; i < toSort.length; i++) {
			System.out.print(toSort[i]);
		}
	}

			
	public static int partition(int[] elements, int from, int to) {
		int pivot = elements[from];
		int i = from - 1;
		int j = to + 1;

		while(i < j) { //until i and j cross     O(n)	
			i++; //O(1)

			while(elements[i] < pivot) { //O(n)
				i++;
			}

			j--;

			while(elements[j] > pivot) { //O(n)
				j--;
			}

			if(i < j) { //i and j haven't crossed yet
				//swap
				int temp = elements[i];
				elements[i] = elements[j];
				elements[j] = temp;
			}
		}

		return j; //index of the last element of the first subarray (where the array is divided)
	}
		
	public static void quickSort(int[] elements, int from, int to) {
		if(from < to) {
			int splitIndex = partition(elements, from, to);

			quickSort(elements, from, splitIndex);
			quickSort(elements, splitIndex + 1, to);
		}


	}

}
