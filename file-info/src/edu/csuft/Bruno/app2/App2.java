package edu.csuft.Bruno.app2;
/**
 * 统计文件中相关信息
 * @author Bruno
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class App2 {
	/**
	 * 总行
	 */
	int line;
	/**
	 * 代码行
	 */
	int code;
	/**
	 * 注释行
	 */
	int comment;
	/**
	 * 空行
	 */
	int blank;
	/**
	 * 字符
	 */
	int ch;
	/**
	 * 字符次数
	 */
	HashMap<Character, Integer> map = new HashMap<>(); 
	
	
	public  void count(String filename) {
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
				FileWriter fileWriter = new FileWriter("test2.txt")) {
			
			String text;
			
			while ((text=bufferedReader.readLine()) != null) {
				//读取一行
				line++;
				
				//截断空白
				text = text.trim();
				
				//ch += text.length();
				
				countCharactor(text);
				
				
			}
			
			System.out.println(ch);
			for (Character character : map.keySet()) {
				//System.out.printf("%c:%d\n",character,map.get(character));
				String charText = String.format("%c : %5.4f%%\n", character, map.get(character)/Double.valueOf(ch)*100);
				System.out.println(charText);
				fileWriter.write(charText);
			}
			fileWriter.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	private void countCharactor(String text) {
		char[] chs = text.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			char c = chs[i];					
		
			if (c >= 'a' && c <= 'z') {
				c -= 32;
				if (map.containsKey(c)) {
					int n = map.get(c);
					map.put(c, n+1);
				} else {
					map.put(c, 1);
				}
				ch++;
		
			}
			if (c >= 'A' && c <= 'Z') {
				if (map.containsKey(c)) {
					int n = map.get(c);
					map.put(c, n+1);
				} else {
					map.put(c, 1);
				}
				ch++;
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		
		App2 app2 = new App2();
		app2.count("test.txt");
	}
	
	
	
}
