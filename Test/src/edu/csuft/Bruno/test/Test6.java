package edu.csuft.Bruno.test;

public class Test6 {

	public static void main(String[] args) {
		int num = isException(0);
		System.out.println(num);
	}
	
	private static int isException(int n) {
		
		try {
			int temp = 1/n;
			return temp;
		} catch (Exception e) {
			return 0;
		} finally {
			return 1;
		}
		
		
	}
	
}
