package edu.csuft.Bruno.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.csuft.Bruno.ds.list.LineList;

/**
 * 基于数组实现的栈，应用于中缀表达式转换成后缀表达式
 * 
 * @author Bruno
 *
 */
public class App1 {

	/**
	 * 键值对存储运算符和权重
	 */
	private static Map<String, Integer> operatorMap = new HashMap<>();

	/**
	 * 运算符字符串
	 */
	private static String operatorStr = "+-*/()";
	
	/**
	 * 给运算符添加权重，实现优先级
	 */
	static {
		operatorMap.put("+", 1);
		operatorMap.put("-", 1);
		operatorMap.put("*", 2);
		operatorMap.put("/", 2);
		operatorMap.put("(", 0);
	}

	/**
	 * 中缀表达式转换成后缀表达式
	 * 
	 * @param expression 表达式字符串
	 */
	public static void convertorExpre(String expression) {
		// 输入表达式空格间隔每个字符，用空格进行截取
		String[] str = expression.split(" ");

		// 用自定义线性表存储后缀表达式的每个字符串
		LineList<String> resultList = new LineList<>();

		// 用自定义栈临时存储运算符
		LinkeStack<String> stack = new LinkeStack<>();

		for (int i = 0; i < str.length; i++) {
			// 是运算符
			if (operatorStr.contains(str[i])) {
				if ("(".equals(str[i])) {
					stack.push(str[i]);
				} else if (")".equals(str[i])) {
					// 栈中元素全部出栈
					popElementsToList(stack, resultList);
				} else {
					// 比较优先级，判断是否出栈还是入栈
					popOrPushStack(stack, str[i], resultList);
				}

			} else {
				// 是操作数,加入列表
				resultList.add(str[i]);
			}
		}
		
		
		// 清空栈
		while (stack.size() > 0) {
			resultList.add(stack.pop());
		}

		System.out.println(resultList);

	}

	/**
	 * 运算符的优先级比较，是否入栈还是出栈
	 * 
	 * @param stack      栈
	 * @param str        运算符
	 * @param resultList 结果列表
	 */
	private static void popOrPushStack(LinkeStack<String> stack, String str, LineList<String> resultList) {

		// 先判断是否为空栈

		if (stack.size() != 0) {
			// 非空,获取栈顶元素
			String peek = stack.peek();
			// 判断优先级，栈顶优先级小，入栈
			if (operatorMap.get(peek) < operatorMap.get(str)) {
				stack.push(str);
			} else {
				String temp = stack.pop();
				resultList.add(temp);
				// 递归比较
				popOrPushStack(stack, str, resultList);
			}

		} else {
			// 空栈
			stack.push(str);

		}

	}

	/**
	 * 除括号外的运算符全部出栈，存入线性表
	 * 
	 * @param stack
	 * @param resultList
	 */
	private static void popElementsToList(LinkeStack<String> stack, LineList<String> resultList) {
		if (stack.size() != 0) {
			String str = stack.pop();
			if (str.equals("(")) {
				// 递归继续判断栈顶元素
				popElementsToList(stack, resultList);
			} else {
				resultList.add(str);
				popElementsToList(stack, resultList);
			}	
			
		}
		
	}

	
	public static void main(String[] args) {
		System.out.println("请输入算术表达式，用空格间隔操作数与运算符:");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		convertorExpre(str);
	}
}
