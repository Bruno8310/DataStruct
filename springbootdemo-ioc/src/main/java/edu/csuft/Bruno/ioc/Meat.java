package edu.csuft.Bruno.ioc;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author Bruno
 *
 */
// 当属性值有多个选择时，方式如下:
// 第一种方式: 使用Primary注解----表示默认缺省，优先加载
// 第二种方式: 在宿主类中的成员属性添加Qualifier注解传入组件的名字
// @Primary
@Component("meat")
@Lazy
public class Meat implements Food {

	public Meat() {
		System.out.println("Meat()构造方法");
	}
}
