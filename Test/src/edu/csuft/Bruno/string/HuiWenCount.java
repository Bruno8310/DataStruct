package edu.csuft.Bruno.string;
/**
 * 计算一个字符串中每个字符的次数，任意组合出最大长度的回文字符串
 * @author Bruno
 *
 */
public class HuiWenCount {
	
	public static void main(String[] args) {
		String string = "asdfghjkl;mnbvcxzasdfghjkl;mnbvcxzvvvvm";
		System.out.println(string.length());
		System.out.println(count(string));
	}
	
	/**
	 * 统计每个字符出现的次数，为偶数个时，都可以算入，为 奇数个时，减一算入，回文最中间的那个字符可以为奇数
	 * @param str
	 * @return
	 */
	public static int count(String str) {
		//前128个为基础ASCII码，后128个为扩展ASCII码
		int[] arrChar = new int[256];
		//统计回文字符串最大长度
		int lengthStr = 0;
		for (char i : str.toCharArray()) {
			arrChar[i]++;
		}
		
		for (int i = 0; i < arrChar.length; i++) {
			lengthStr += (arrChar[i]/2)*2;			
		}
		
		if (lengthStr < str.length()) {
			lengthStr++;
		}
		return lengthStr;
	}
}
