package edu.csuft.Bruno.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 * 统计文件中相关信息操作
 * 
 * @author Bruno
 *
 */
public class App {

	public static void main(String[] args) {
		File file = new File("out.txt");
		FileOutputStream fOutputStream = null;
		BufferedWriter bw = null;
		int[] temp = countLine();
		
		System.out.println("行数为"+temp[0]);
		System.out.println("空行数为:"+temp[1]);
		System.out.println("注释行为"+temp[2]);
		System.out.println("代码行"+temp[3]);
		int charCount1= charactCount();
		System.out.println("字符总个数为:"+charCount1);
		
		
		
	}

	
	/**
	 * 通过缓冲流读取
	 * 统计文件中行数等数据信息
	 * 
	 * @return
	 */
	public static int[] countLine() {
		
		int[] arr = new int[4];
		// 读文件
		File file = new File("data.txt");
		BufferedReader input = null;
		String line = null;
		try {
			input = new BufferedReader(new FileReader(file));
			while ((line = input.readLine()) != null) {
				line = line.trim();
				// 行数
				arr[0]++;
				// 统计空行
				if (line.equals("")) {
					arr[1]++;
				}
				//统计注释行
				if (line.startsWith("//")) {
					arr[2]++;
				} else if (line.trim().startsWith("/*")) {
					arr[2]++;
					while (!line.endsWith("*/")) {
						line = input.readLine().trim();
						arr[2]++;
					}
				} else if (line.contains("/*")) {
					line = input.readLine().trim();
					if (line.endsWith("*/")) {
						arr[2]++;
					}
				}

			}
			//代码行
			arr[3] = arr[0] - arr[1] - arr[2];

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return arr;
	}
	
	/**
	 * 通过缓冲流读
	 * @return
	 */
	private static int charactCount() {
		int charCount = 0;
		File file = new File("data.txt");
		InputStreamReader isr = null;				
		BufferedReader input = null;
		//用于存储26字符个数
		HashMap<Character1, Integer> map = new HashMap<>();
		String line	= null;
		char ch;
		try {
			isr = new InputStreamReader(new FileInputStream(file));
			input = new BufferedReader(isr);
			while(input.read() != -1) {
//				c = (char) input.read();
//				if (map.containsKey(c)) {
//					map.put(c, map.get(c)+1);
//				}					
				
				line = input.readLine();
				//如果不为空行，统计这行的字符个数
				if (!line.trim().equals("")) {
					charCount += line.length();
				}
				
			}
		} catch (Exception e) {
			
			
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}			
		
		return charCount;
	}

	
}
