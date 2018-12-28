import java.*;

public class removeNullTest {
	public static void main(String[] args) {
		String[] test = {"a", "b", null, "c", "d", null, "e"};
		String[] new_test = new String[100];
		int newCounter = 0;

		for(int i = 0; i < test.length; i++) {
			if(test[i] != null) {
				//new_test[newCounter] = new String();
				new_test[newCounter] = test[i];
				newCounter++;
			}
		}

		for(int j = 0; j < new_test.length; j++) {
			if(new_test[j] != null) {
				System.out.println(new_test[j]);
			}
		}
				
	}
}
