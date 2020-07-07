package edu.csuft.Bruno.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class App {

	public static void main(String[] args) {
		
		
		
		int[] temp = {};
		File file = new File("E:\\jdk_code");
		ArrayList<File> list = getFiles(file);
		for (File file2 : list) {
			
			//文件后缀名为.java的文件
			if (file2.getName().matches(".*\\.java$")) {
				temp = count(file2);
			}
		}	
			
	}
	
	
	/**
	 * 统计单个文件中各种行数
	 * @param file
	 * @return
	 */
	public static int[] count(File file) {
		int[] arr = new int[4];
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String str = null;
		boolean flag = false;
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while ((str = bufferedReader.readLine()) != null) {
				arr[0]++;
				
				if (str.trim().equals("")) {
					arr[1]++;
				} else if (str.trim().startsWith("//")) {
					arr[2]++;
				} else if (str.trim().startsWith("/*") && !str.trim().endsWith("*/")) {
					arr[2]++;
					flag = true;
				} else if (str.trim().startsWith("/*") && str.trim().startsWith("*/")) {
					arr[2]++;
				} else if (flag == true) {
					arr[2]++;
					if (str.trim().endsWith("*/")) {
						flag = false;
					}
				} else {
					arr[3]++;
				}
								
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
		
		return arr;
	}
	
	
	
	
	public static int foldCount = 0;
	
	
	
	public static int getFoldCount() {
		return foldCount;
	}
	
	/**
	 * 递归查找所有文件，统计文件夹个数
	 * @param file
	 * @return
	 */
	public static ArrayList<File> getFiles(File file) {
		ArrayList<File> list = new ArrayList<>();
		File[] files = file.listFiles();
		for (File file2 : files) {
			if (file2.isDirectory()) {
				foldCount++;
				getFiles(file2);
			} else {
				list.add(file2);
			}
		}
		return list;		
		
	}
	
	
	
}
