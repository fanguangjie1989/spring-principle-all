package spring.base.principle.di.xml;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanLifeCycle implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
	private String operateDate;
	private String beanName;
	private BeanFactory beanFactory;

	public BeanLifeCycle() {
		System.out.println("BeanLifeCycle.constructor ...");
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		System.out.println("BeanLifeCycle.setOperateDate().." + operateDate);
		this.operateDate = operateDate;
	}

	@Override
	public String toString() {
		return "BeanLifeCycle [operateDate=" + operateDate + ", beanName=" + beanName + ", beanFactory=" + beanFactory
				+ "]";
	}

	// 不建议使用这样会提高业务代码和Spring的耦合度
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destroy() ...Do SomeThing before destroy");
	}

	// 推荐做法去配置文件中定义destroy-method
	public void myDestroy() throws Exception {
		System.out.println("BeanLifeCycle.myDestroy() ...Do SomeThing before destroy");
	}

	// 推荐做法去配置文件中定义init-method
	public void myInit() throws Exception {
		System.out.println("BeanLifeCycle.myInit() ...");
	}

	// 不建议使用这样会提高业务代码和Spring的耦合度
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet() ...Do SomeThing");
	}

	// 实现了 BeanNameAware 在bean 实例化后 初始化之前执行 将Bean id传进来
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("BeanNameAware.setBeanName() ...");
	}

	// 实现了 BeanNameAware 在bean 实例化后 初始化之前执行 将BeanFactory实例传进来
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("BeanFactoryAware.setBeanFactory() ...");
	}

	@PostConstruct
	public void initByPostConstruct() throws Exception {
		System.out.println("@PostConstruct bean ....");
	}
	
	@PreDestroy
	public void destroyBYPreDestroy() {
		System.out.println("@PreDestroy bean ....");
	}
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml-lifecycle.xml");
		ctx.refresh();
		BeanLifeCycle beanLifeCycle = ctx.getBean("beanLifeCycle", BeanLifeCycle.class);
		System.out.println(beanLifeCycle);
		ctx.close();

	}
}
