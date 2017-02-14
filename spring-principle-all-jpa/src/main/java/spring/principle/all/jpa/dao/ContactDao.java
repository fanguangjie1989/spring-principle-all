package spring.principle.all.jpa.dao;

import java.util.List;

import spring.principle.all.jpa.entity.Contact;

public interface ContactDao {
	
	List<Contact> findAll();

	List<Contact> findAllWithDetail();

	Contact findById(Long id);

	Contact save(Contact contact);

	void delete(Contact contact);
}
