package spring.base.principle.di.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class GenericXmlApplicationContextTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		MessageProvider configurableMessageProvider = ctx.getBean("configurableMessageProvider", MessageProvider.class);
		System.out.println(configurableMessageProvider.getMessage());
		ctx.close();
	}
}
