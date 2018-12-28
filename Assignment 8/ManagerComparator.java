// Assignment #: 8
//         Name: Derek Pezzella
//    StudentID: 1201902394	
//      Lecture: TTh 4:30-5:45pm
//  Description: Uses comparator to compare department numbers. If the two objects have the same department number, sort by their first name.

import java.util.Comparator;

public class ManagerComparator extends Project implements Comparator {
	public int compare(Object a, Object b) {
		int result = 0;

		if(a != null && b != null) {
			Project p1 = (Project)a;
			Project p2 = (Project)b;

			//SOrting hierarchy (from what I can tell):
			//1. Dept Num
			//2. First Name
			//3. Location
	
			if(p1.getProjManager().getDeptNum() < p2.getProjManager().getDeptNum()) {
				result = -1;
			} else if(p1.getProjManager().getDeptNum() > p2.getProjManager().getDeptNum()) {
				result = 1;
			} else if(p1.getProjManager().getDeptNum() == p2.getProjManager().getDeptNum()){
				//sort by first name
				if(p1.getProjManager().getFirstName().compareTo(p2.getProjManager().getLastName()) < 0) {
					result = -1;
				} else if(p1.getProjManager().getFirstName().compareTo(p2.getProjManager().getFirstName()) > 0) {
					result = 1;
				} else if(p1.getProjManager().getFirstName().compareTo(p2.getProjManager().getFirstName()) == 0) {
					//sort by location next
				}
			}
		}

		return result;
	}
}
