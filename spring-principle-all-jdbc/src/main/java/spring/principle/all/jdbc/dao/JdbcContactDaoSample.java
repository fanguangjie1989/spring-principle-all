package spring.principle.all.jdbc.dao;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.principle.all.jdbc.po.Contact;

public class JdbcContactDaoSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		ContactDao jdbcTemplateContactDao = ctx.getBean("jdbcTemplateContactDao", ContactDao.class);
		System.out.println("First name for contact id 1 is: " + jdbcTemplateContactDao.findFirstNameById(1l));
		ContactDao namedParameterJdbcTemplateContactDao = ctx.getBean("namedParameterJdbcTemplateContactDao", ContactDao.class);
		System.out.println("Last name for contact id 1 is: " + namedParameterJdbcTemplateContactDao.findLastNameById(1l));
		List<Contact> contacts = namedParameterJdbcTemplateContactDao.findAll();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		contacts = namedParameterJdbcTemplateContactDao.findAllWithDetail();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		
		ContactDao annotationsJdbcContactDao = ctx.getBean("annotationsJdbcContactDao", ContactDao.class);
		Contact  jieContact = new Contact();
		jieContact.setId(1L);
		jieContact.setBirthDate(new Date());
		jieContact.setFirstName("fan");
		jieContact.setLastName("jie");
		annotationsJdbcContactDao.update(jieContact);
		
		Contact  rainContact = new Contact();
		jieContact.setId(1L);
		rainContact.setBirthDate(new Date());
		rainContact.setFirstName("rain");
		rainContact.setLastName("jie");
		//annotationsJdbcContactDao.insert(rainContact);
		contacts = annotationsJdbcContactDao.findAll();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		System.out.println(annotationsJdbcContactDao.findFirstNameById(1L));
		ctx.close();
	}
}
