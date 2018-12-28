public class recursionTest {
	//int result = 5000;

	public static void main(String[] args) {
		int[] array = {20, 6, 5, 6, 0, 10, 12, 24, 36, 1};
		int endIndex = array.length - 1;
		int startIndex = array.length - 2;
		int lowestNum = 5000;

		lowestNum = findMax(array, startIndex, endIndex, 0);

		System.out.println(lowestNum);
	}

	public static int findMax(int[] elements, int startIndex, int endIndex, int result) {
		if(startIndex == -1 || elements[startIndex] == 0) {
			return result;
		} else {
			if(elements[startIndex] < elements[endIndex]) {
				result = elements[startIndex];
			}

			return findMax(elements, endIndex - 2, endIndex - 1, result);
		}
	}
}
