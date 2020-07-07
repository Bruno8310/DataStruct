package edu.csuft.Bruno.exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入字符串:");
		String str = scanner.nextLine();
		
		String result = "";
		//定义截取字符串的正则表达式
		String regex1 = "Q\\d*";
		//用字符串数组存储
		
		String[] arr = str.split(regex1);
		
		Pattern r = Pattern.compile(regex1);
		Matcher m = r.matcher(str);
		int j = 0;
		
		while(m.find()) {
			String s = m.group();
			j++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			result += arr[i] + "Text" + (i+1);
		}
		
		if (j == arr.length) {
			System.out.println(result);
		} else {
			
			result = result.substring(0, result.lastIndexOf('T'));
			System.out.println(result);
		}
 		
	}
}
