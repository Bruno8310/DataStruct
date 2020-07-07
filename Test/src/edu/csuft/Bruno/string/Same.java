package edu.csuft.Bruno.string;
/**
 * 判断两个字符串中字符是否完全相同
 * @author Bruno
 *
 */
public class Same {

	public static void main(String[] args) {
		String s = "abccba";
		String t = "asdfghjkl";
		boolean flag = isSame(s, t);
		System.out.println(flag);
	}
	
	/**
	 * 将第一个字符串中每个字符的个数存入数组，然后将第二个字符串的字符个数从当前数组取出，当数组为0，两个字符串包含同样的字符(字符和个数完全相同)
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isSame(String s, String t) {
		//存放每个字符的个数
		int[] strArr = new int[26];
		
		for (char c : s.toCharArray()) {
			strArr[c - 'a']++;
		}
		
		for(char c : t.toCharArray()) {
			strArr[c - 'a']--;
		}
		
		for(int temp : strArr) {
			if (temp != 0) {
				return false;
			}
		}
		return true;
	}
}
