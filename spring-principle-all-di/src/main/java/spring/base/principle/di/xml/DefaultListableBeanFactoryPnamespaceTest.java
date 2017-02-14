package spring.base.principle.di.xml;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class DefaultListableBeanFactoryPnamespaceTest {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
		rdr.loadBeanDefinitions(new ClassPathResource("META-INF/spring/app-context-xml-pnamespace.xml"));
		MessageRenderer standardOutMessageRenderer =  factory.getBean("standardOutMessageRenderer",MessageRenderer.class);
		standardOutMessageRenderer.render();
		MessageRenderer standardOutMessageRendererPnamespace =  factory.getBean("standardOutMessageRendererPnamespace",MessageRenderer.class);
		standardOutMessageRendererPnamespace.render();
		InjectSimple simple = factory.getBean("injectSimple", InjectSimple.class);
		System.out.println(simple);
		InjectSimpleSpel simpleSpel = factory.getBean("injectSimpleSpel", InjectSimpleSpel.class);
		System.out.println(simpleSpel);
	}
}
