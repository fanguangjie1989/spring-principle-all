package spring.base.principle.di.event;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageEventDemo {
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml-event.xml");
		ctx.refresh();
		MessageEventPublisher messageEventPublisher =  ctx.getBean("messageEventPublisher", MessageEventPublisher.class);
		messageEventPublisher.publishMessageEvent("bean messageEventPublisher loaded");
		ctx.close();
	
	}
}
