package spring.base.principle.di.message;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageSourceDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml-message.xml");
		ctx.refresh();
		Locale locale_zh_CN = new Locale("zh", "CN");
		System.out.println(ctx.getMessage("hello", null, locale_zh_CN));
		System.out.println(ctx.getMessage("greeting", new Object[]{"fangj"}, locale_zh_CN));
		ctx.close();
	}
}
