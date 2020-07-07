package edu.csuft.Bruno.execption;

public class MyTest {

	public static void main(String[] args) {
		MyTest myTest = new MyTest();
		System.out.println(myTest.test());
	}
	
	public String test() {
		try {
			System.out.println("start try");
			String[] aStrings = {"cvte"};
			for (int i = 0; i < 2; i++) {
				System.out.println(aStrings[i]);
			}
			System.out.println("try end");
			return "return of try not finally";
			
		} catch (Exception e) {
			System.out.println("exception");
			// System.exit(0);
			return "return in catch exception";
		} finally {
			System.out.println("finally end");
			String[] bStrings = {"cvte"};
			for (int i = 0; i < 2; i++) {
				System.out.println(bStrings[i]);
			}
			System.out.println("finally end");
			return "return of finally";
		}
	}
}
