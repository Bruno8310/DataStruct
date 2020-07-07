package edu.csuft.Bruno.sort;

import java.util.Arrays;

/**
 * 内排序
 * 
 * @author Bruno
 *
 */
public class App {

	public static void main(String[] args) {

		int[] arr = new int[] { 9, 8, 7, 5, 4, 6, 3, 4, 5, 2 };
		quickSort(arr, 0, arr.length - 1);
		//swap(arr,1, 3);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 快速排序的实现
	 * 
	 * @param arr
	 * @param s   数组起始位置
	 * @param t   数组结束位置
	 */
	public static void quickSort(int[] arr, int start, int high) {

		if (start >= high) {
			return;
		}

		// 左端
		int l = start;
		// 右端
		int r = high - 1;
		// 中轴
		int temp = arr[high];

		while (l < r) {

			while (l < r && arr[l] < temp)
				l++;

			while (r > l && arr[r] > temp)
				r--;

			System.out.printf("l=%d, r=%d\n", l, r);
			swap(arr, l, r);
			System.out.println(Arrays.toString(arr));

		}
		
		if (l == high - 1) {
			// 基准是最大值(极端情况，三数选中值)
			quickSort(arr, start, high - 1);
		} else {
			quickSort(arr, start, l - 1);
			quickSort(arr, l + 1, high);
		}

	}

	private static void swap(int[] arr, int l, int r) {
		int temp;
		temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;

	}

	public static void swap2(int s, int t) {
		int temp;
		if (s > t) {
			temp = s;
			s = t;
			t = temp;
		}
		System.out.println(s);
		System.out.println(t);
	}
}
