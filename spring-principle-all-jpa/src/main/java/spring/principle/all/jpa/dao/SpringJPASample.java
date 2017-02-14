package spring.principle.all.jpa.dao;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.principle.all.jpa.entity.Contact;

public class SpringJPASample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		ContactDao contactService = ctx.getBean("contactDao", ContactDao.class);
		listContacts(contactService.findAll());
		ctx.close();
	}

	private static void listContacts(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println();
		}
	}
}
