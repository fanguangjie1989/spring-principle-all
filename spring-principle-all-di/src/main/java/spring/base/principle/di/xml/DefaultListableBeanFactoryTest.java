package spring.base.principle.di.xml;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class DefaultListableBeanFactoryTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
		rdr.loadBeanDefinitions(new ClassPathResource("META-INF/spring/app-context-xml.xml"));
		MessageProvider helloWorldMessageProvider =  factory.getBean("helloWorldMessageProvider",MessageProvider.class);
		System.out.println(helloWorldMessageProvider.getMessage());
		MessageRenderer standardOutMessageRenderer =  factory.getBean("standardOutMessageRenderer",MessageRenderer.class);
		standardOutMessageRenderer.render();
		CollectionInjection injectCollection = factory.getBean("injectCollection",CollectionInjection.class);
		injectCollection.displayInfo();
	}
}
