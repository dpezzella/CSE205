// Assignment #: 8
//         Name: Derek Pezzella
//    StudentID:	
//      Lecture: TTh 4:30-5:45pm
//  Description: Uses comparator to compare project numbers.
//

import java.util.*;

public class ProjectNumberComparator extends Project implements Comparator {
	public int compare(Object a, Object b) {
		int result = 0;

		if(a != null && b != null) {
			Project p1 = (Project) a;
			Project p2 = (Project) b;

			if(p1.getProjNumber() < p2.getProjNumber()) {
				result = -1;
			} else if(p1.getProjNumber() > p2.getProjNumber()) {
				result = 1;
			} else if(p1.getProjNumber() == p2.getProjNumber()){
				result = 0;
			}
		}

		return result;
	}
}
