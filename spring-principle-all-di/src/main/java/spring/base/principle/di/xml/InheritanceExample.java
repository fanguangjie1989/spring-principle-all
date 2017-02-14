package spring.base.principle.di.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
/**
 * 
 * @author fanguangjie
 * 
 * spring中使用parent属性来减少配置
 * 例如多个数据源配置
 *
 */
public class InheritanceExample {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "InheritanceExample [name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml-inheritance.xml");
		ctx.refresh();
		InheritanceExample childexample1 =  ctx.getBean("childexample1",InheritanceExample.class);
		InheritanceExample childexample2 =  ctx.getBean("childexample2",InheritanceExample.class);
		System.out.println(childexample1);
		System.out.println(childexample2);
		ctx.close();
	}
}
