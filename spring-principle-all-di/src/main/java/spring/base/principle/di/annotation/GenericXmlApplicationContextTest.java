package spring.base.principle.di.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class GenericXmlApplicationContextTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		MessageProvider configurableMessageProvider = ctx.getBean("configurableMessageProvider", MessageProvider.class);
		System.out.println(configurableMessageProvider.getMessage());
		InjectSimple simple = ctx.getBean("injectSimple", InjectSimple.class);
		System.out.println(simple);
		InjectSimpleSpel simpleSpel = ctx.getBean("injectSimpleSpel", InjectSimpleSpel.class);
		System.out.println(simpleSpel);
		ctx.close();
	}

}
