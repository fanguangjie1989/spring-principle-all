package spring.principle.all.jdbc.dao;

import java.util.List;

import spring.principle.all.jdbc.po.Contact;

public interface ContactDao {
	List<Contact> findAll();
	List<Contact> findByFirstName(String firstName);
	String findLastNameById(Long id);
	String findFirstNameById(Long id);
	void insert(Contact contact);
	void update(Contact contact);
	void delete(Long contactId);
	List<Contact> findAllWithDetail();
}
