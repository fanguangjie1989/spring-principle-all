package spring.base.principle.di.xml;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class DefaultListableBeanFactoryCnamespaceTest {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
		rdr.loadBeanDefinitions(new ClassPathResource("META-INF/spring/app-context-xml-cnamespace.xml"));
		MessageProvider configurableMessageProvider =  factory.getBean("configurableMessageProvider",MessageProvider.class);
		System.out.println(configurableMessageProvider.getMessage());
		MessageProvider configurableMessageProviderCnamespace =  factory.getBean("configurableMessageProviderCnamespace",MessageProvider.class);
		System.out.println(configurableMessageProviderCnamespace.getMessage());
	}
}
