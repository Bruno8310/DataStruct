package edu.csuft.Bruno.exam;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        //操作数
        int k = in.nextInt();
        
        String str = in.nextLine();
        String[] arr = str.split(" ");
        int[] arr1 = null;
        for (int i = 0; i < arr.length; i++) {
			arr1[i] = Integer.parseInt(arr[i]);
		}        
        
        int res;      
        res = smallestRange(k, arr1);
        System.out.println(String.valueOf(res));    

    }

	private static int smallestRange(int k, int[] arr1) {
		int temp;
		int res = 0;
		//将数组中元素进行从小到大排序,冒泡排序
		for (int i = 0; i < arr1.length - 1; i++) {
			for (int j = 0; j < arr1.length - 1 - i; j++) {
				if (arr1[j] > arr1[j+1]) {
					temp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = temp;
				}
			}
		}
		
				
		return res;
	}
}
