package edu.csuft.Bruno.test;

public class Test5 {

	
		public static void main (String [] args) {
			
		int[][] temp = new int[6][];
 		
		for (int[] is : temp) {
			for (int is2 : is) {
				System.out.println(is2);
			}
		}
			
		StringBuffer a = new StringBuffer ("A");
		StringBuffer b = new StringBuffer ("B");
		operate (a,b);
		System.out.println(a + "," +b);
		}

		private static void operate(StringBuffer x, StringBuffer y) {
			x.append(y);
			y = x;
		}
		
		
		
}
