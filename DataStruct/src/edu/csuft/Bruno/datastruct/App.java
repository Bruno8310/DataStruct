package edu.csuft.Bruno.datastruct;

/**
 * TODO:求两个数的最大公约数 TODO:连续子元素(子序列)的最大和
 * 
 * @author Bruno
 *
 */
public class App {

	public static void main(String[] args) {
		/*
		 * System.out.println(gcd(4, 8)); 
		 * System.out.println(gcd(2, 8));
		 */
		int[] arr = new int[] { 7, -2, -4, -1, 12, 2, 4, 6 };
		System.out.println(maxSub(arr));

	}

	/**
	 * 最大公约数简称---gcd
	 * 
	 * @param p 被除数
	 * @param q 除数
	 * @return 最大公约数
	 */
	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q);
	}

	/**
	 * 穷举法--时间复杂度 --O(n^2)
	 * @param arr 数组
	 * @return 子序列的和最大值
	 */
	private static int maxSub(int[] arr) {
		int start = 0;
		int end = 0;
		int sum = 0;
		//外层循环控制执行次数
		for (int i = 0; i < arr.length; i++) {
			//枚举各种情况的子序列的和
			int thisSum = 0;
			for (int j = 0; j < arr.length; j++) {
				thisSum += arr[j];
				if (thisSum > sum) {
					sum = thisSum;
					start = i;
					end = j;
				}
			}
		}
		System.out.printf("%d~%d\n", start, end);
		return sum;
	}
	
	/***
	 * 动态规划--时间复杂--O(n)
	 * @param arr
	 * @return
	 */
	private static int maxSub2(int[] arr) {
		//总和
		int sum = 0;
		//临时总和
		int thisSum = 0;
		for(int i = 0; i < arr.length; i++) {
			thisSum += arr[i];
			
			if (thisSum > sum) {
				sum = thisSum;
			}
			//累加过程中子序列和小于0，重置临时和
			if (thisSum < 0) {
				thisSum = 0;
			}
		}		
		return sum;
	}
}
