package edu.csuft.Bruno.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

public class Test {

	public static void main(String[] args) {

		ArrayStack<String> aStack = new ArrayStack<>();
		System.out.println(aStack.isEmpty());
		System.out.println(aStack.size());
		aStack.push("AA");
		aStack.push("BB");
		aStack.push("CC");
		aStack.push("DD");
		System.out.println(Arrays.toString(aStack.data));
		System.out.println(aStack.size());
		aStack.pop();
		aStack.pop();
		aStack.pop();
		System.out.println(Arrays.toString(aStack.data));
		System.out.println(aStack.size());
		
		
	}
}