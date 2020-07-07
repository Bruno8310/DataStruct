package edu.csuft.Bruno.string;
/**
 * TODO:将字符串翻转
 * @author Bruno
 *
 */
public class FanZhuan {

	public static void main(String[] args) {
		String str = "I am a student";
		String str2 = reverseStr(str);
		System.out.println(str2);
		
		String str3 = reverseStrAll(str2);
		System.out.println(str3);
		
	}
	
	/**
	 * 翻转每个单词
	 * @param str
	 * @return
	 */
	public static String reverseStr(String str) {
		String[] strArr = str.split(" ");
		String str2 = "";
		for (int i = 0; i < strArr.length; i++) {
			if (i < strArr.length - 1) {
				strArr[i] = reverseStrAll(strArr[i]);
				str2 += strArr[i] + " ";
			} else {
				strArr[i] = reverseStrAll(strArr[i]);
				str2 += strArr[i];
			}
		}
		
		return str2;
	}
		
	/**
	 * 翻转整个字符串
	 * @param str
	 * @return
	 */
	public static String reverseStrAll(String str) {
		char[] temp = str.toCharArray();
		char temp1;
		for (int i = 0; i < temp.length/2; i++) {
			temp1 = temp[i];
			temp[i] = temp[temp.length-1-i];
			temp[temp.length-1-i] = temp1; 
		}
 		String str1 = new String(temp);	
 		return str1;
		
	}
	
}
