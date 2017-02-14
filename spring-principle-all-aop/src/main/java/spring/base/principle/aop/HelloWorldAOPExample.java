package spring.base.principle.aop;

import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAOPExample {
	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MessageDecorator());
		pf.setTarget(target);
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		target.writeMessage();
		System.out.println("");
		proxy.writeMessage();
	}
}
