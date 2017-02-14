package spring.base.principle.di.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	
	
	public MyBeanPostProcessor() {
		super();
		System.out.println("MyBeanPostProcessor.constructor ....");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization() Before "+beanName+" Initialization Do something");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization() After "+beanName+" Initialization Do something");
		return bean;
	}

}
