package edu.csuft.Bruno.exam;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String res;

		String _input;
		try {
			System.out.println("请输入一个包含数字的字符串：");
			_input = in.nextLine();
		} catch (Exception e) {
			_input = null;
		}

		res = find_longest_num_str(_input);
		System.out.println(String.format("%d/%s", res.length(), res));
	}

	private static String find_longest_num_str(String _input) {
		int countNum = 0;
		int index;
		String resultStr = "";
		char[] arr = _input.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if ('0' <= arr[i] && arr[i] <= '9') {
				countNum = 1;
				index = i;
				for (int j = i + 1; j < arr.length; j++) {
					if ('0' <= arr[j] && arr[j] <= '9') {
						countNum++;
						index = j;
					} else {
						break;
					}
				}
				
				if (countNum > resultStr.length()) {
					resultStr = _input.substring(i, index + 1);
				}
				
			} else {
				continue;
			}
		}

		return resultStr;
	}
}
