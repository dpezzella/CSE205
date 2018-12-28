public class downcastTest {
	public static void main(String[] args) {
		String ds3 = "ds3";
		Object testObj = ds3; 
		Object downcastObj = new Object();
		boolean downcastIsString = false;
		boolean downcast2IsString = false;

		testObj = (String)testObj;
		//downcastObj = (String)downcastObj;

		//System.out.println(testObj.substring(0));
		System.out.println(testObj);

		if(testObj instanceof String) {
			downcastIsString = true;
		} 

		if(downcastObj instanceof String) {
			downcast2IsString = true;
		}

		System.out.println(downcastIsString + " " + downcast2IsString);

		String testStr = ((String)testObj).substring(0);
		System.out.println(testStr);

		Character charTest = new Character('A');

		char testD = 'D';
		char testS = 'S';

		if(Character.digit(testD,2570) < Character.digit(testS, 2570)) {
			System.out.println("yes!");
		} else {
			System.out.println("no.... " + "D value: " + Character.digit(testD,10) + " S value: " + Character.digit(testS,10));
		}

		int testint = (int)testD;
		int testint2 = (int)testS;

		System.out.println(testint);
		System.out.println(testint2);

		if(testint < testint2) {
			System.out.println("cheese");
		}
	}
}
