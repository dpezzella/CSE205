// Assignment #: 8
//         Name: Derek Pezzella
//    StudentID: 	
//      Lecture: TTh 4:30-5:45pm
//  Description: Implements selection sort to sort elements
import java.util.*;

public class Sorts {
	//https://algs4.cs.princeton.edu/23quicksort/
	
	public static Project[] sorted;
	private static int projSize;

	//it's supposed to be void...
	public static Project[] sort(Project[] a, int size, Comparator<Project> c) {
		boolean containsNull = false;

		for(int j = 0; j < size; j++) {
			if(a[j] == null) {
				containsNull = true;
			}
		}

		if(!containsNull) {
			Project temp = new Project();
			sorted = new Project[size];
			int minIndex = 0;
			projSize = size;

			for(int index = 0; index <= size - 1; index++) {
				//swap
				minIndex = index;

				for(int scan = index + 1; scan < size; scan++) {
					if(c.compare(a[scan], a[minIndex]) < 0) {
						minIndex = scan;
					}
				}
			
				temp.copy(a[minIndex]);
				a[minIndex].copy(a[index]);
				a[index].copy(temp);
			}
		

			//copy the sorted array into a returnable object for getSorted()
			for(int i = 0; i < size; i++) {
				sorted[i] = new Project();
				sorted[i].copy(a[i]);
			}
		}

		return sorted;
	}
}
