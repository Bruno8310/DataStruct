package edu.csuft.Bruno.parser;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * 完成JSON解析器
 * 
 * 1.JSON字符串转换成pojo对象---反序列化操作
 * 
 * 2.pojo对象转换成JSON字符串---序列化操作 分为三种类型进行解析: Map,List,普通实体对象
 * 
 * @author Bruno
 *
 */
public class ParserDemo {

	/**
	 * 
	 * @param o 目标对象
	 * @return JSON格式字符串
	 */
	public String toJson(Object o) {
		// 为空对象，返回空
		if (o == null) {
			return null;
		} else {
			// StringBuilder在append性能上好，可变的字符串序列
			StringBuilder sb = new StringBuilder();
			// 在运行时创建对象
			Class clazz = o.getClass();
			// 获得类名
			String type = clazz.getSimpleName();
			if (type.equals("Map") || type.equals("HashMap")) {
				// Map类型
				sb.append(mapJson(o));
			} else if (type.equals("List") || type.equals("ArrayList")) {
				// List类型
				sb.append("[");
				List<Object> list = (List<Object>) o;
				for (Object object : list) {
					sb.append(objectJson(o) + ",");
				}
				// 剔除最后一个元素的逗号
				sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
				sb.append("]");
			} else {
				// pojo类型
				sb.append(objectJson(o));
			}

			return sb.toString();
		}

	}

	/**
	 * Map类型的对象序列化
	 * 
	 * @param o
	 * @return
	 */
	private Object mapJson(Object o) {
		// 定义一个可变字符序列对象
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		// 将操作对象强转为Mapx类型
		Map<String, Object> map = (Map<String, Object>) o;
		// 获取map中所有key，用Set容器保存
		Set<String> keys = map.keySet();
		// 遍历所有的value值，如果是字符串类型需要加""保存
		for (String key : keys) {
			if (map.get(key) instanceof String) {
				// key:value格式拼接并保存,需要转义字符
				sb.append(String.format("\"%s\":\"%s\",", key, map.get(key)));
			} else {
				sb.append(String.format("\"%s\":%s,", key, map.get(key)));
			}
		}
		// 剔除最后元素的逗号
		sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
		sb.append("}");
		return sb.toString();
	}

	/**
	 * pojo类型的对象序列化
	 * 
	 * @param o
	 * @return
	 */
	private String objectJson(Object o) {
		// 判断是否为空
		if (o == null) {
			return "{}";
		} else {
			// 在运行时创建对象
			Class clazz = o.getClass();
			StringBuilder sb = new StringBuilder();
			// 获得所有成员方法
			Field[] fields = clazz.getDeclaredFields();
			sb.append("{");
			for (Field field : fields) {
				String name = field.getName();
				String name1 = String.format("%s%s", name.substring(0, 1).toUpperCase(), name.substring(1));
				try {
					// 获得getter方法，执行方法，获取返回值得到value
					Method method = clazz.getDeclaredMethod("get" + name1);
					if (method.invoke(o) != null) {
						// 分方法类型
						if ("String".equals(method.getReturnType().getSimpleName())) {
							sb.append(String.format("\"%s\":\"%s\",", name, method.invoke(o)));
						} else if ("int".equals(method.getReturnType().getSimpleName())
								|| "boolean".equals(method.getReturnType().getSimpleName())) {
							sb.append(String.format("\"%s\":%s,", name, method.invoke(o)));
						} else if ("List".equals(method.getReturnType().getSimpleName())
								|| "ArrayList".equals(method.getReturnType().getSimpleName())) {
							// 返回值是List类型,需要对集合中元素进行遍历解析---递归实现
							StringBuilder strb = new StringBuilder();
							strb.append("[");
							// 方法返回值进行强制转换
							List<Object> tempList = (List<Object>) method.invoke(o);
							for (Object object : tempList) {
								strb.append(objectJson(object) + ",");
							}
							// 对List内部元素，进行解析后
							strb = new StringBuilder(strb.substring(0, strb.lastIndexOf(",")));
							strb.append("]");
							sb.append(String.format("\"%s\":%s,", name, strb));
						} else if ("Map".equals(method.getReturnType().getSimpleName())
								|| "HashMap".equals(method.getReturnType().getSimpleName())) {
							String temp = (String) mapJson(method.invoke(o));
							sb.append(String.format("\"%s\":%s,", name, temp));
						} else {
							String temp = objectJson(method.invoke(o));
							sb.append(String.format("\"%s\":%s,", name, temp));
						}
					}

				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
			sb.append("}");
			return null;
		}
	}
	
	
	/**
	 * 1.JSON字符串对象
	 * 
	 * 2.JSON数组字符串对象
	 * [{},{},{}.....]
	 * 
	 * 将JSON字符串转化为pojo对象
	 * @param json 字符串
	 * @param clazz 不是返回类型的类对象，而是List集合中泛型的对象
	 * @return
	 */
	public Object fromJson(String json, Class clazz) {
		//JSON数组对象		
		if ("[".equals(json.substring(0, 1))) {
			//JSON数据默认返回类型List,剔除[]
			String strs = json.substring(1, json.lastIndexOf("]"));
			List<Object> list = new ArrayList<>();
			//将字符串切分成字符串数组
			String[] array = strs.split(",\\{");
			for (int i = 0; i < array.length; i++) {
				//从索引为1开始添加{
				if (i > 0) {
					array[i] = "{" + array[i];
				}
				//递归---遍历数组中所有元素进行解析
				list.add(fromJson(array[i], clazz));
			}
			return list;
		} else {
		//JSON字符串对象
			Object o = null;
			try {
				o = clazz.newInstance();
				//定义一个正则表达式，匹配字符串的模式
				String reg = "(\\d|(a-z):\\{.*?\\}|:\\[\\{.*?\\}\\])+";
				//正则表达式编译表示
				Pattern p = Pattern.compile(reg);
				//对输入的字符串进行解释和匹配操作的引擎
				Matcher m = p.matcher(json);
				List<String> strs = new ArrayList<>();
				//find()对字符串进行匹配，匹配到的字符串可以在任何位置
				/*
				 * m.find()函数,如果找到匹配的子字符串,它返回true,没有找到匹配的子字符串,
				 * 它返回false.当写到while条件中时,它表示持续在原字符串中从左至右扫描,
				 * 当发现有匹配的子字符串时,由m.group()捕获并输出,
				 * 如果扫描到原字符串尾也没有发现匹配的子字符串,则返回false,跳出循环
				 * */
				while(m.find()) {
					strs.add(m.group());
					
					
				}
				
				
				
				
				
				
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		return null;
	}
	
	
	
	
	
	
	
	

}
