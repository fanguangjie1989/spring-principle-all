package spring.principle.all.jpa.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.principle.all.jpa.dao.ContactDao;
import spring.principle.all.jpa.entity.Contact;

/**
 * 
 * @author fanguangjie
 *
 */
@Transactional
@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
	private static final Log log = LogFactory.getLog(ContactDaoImpl.class);
	final static String ALL_CONTACT_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from contact";
	/*
	 * @PersistenceContext annotation, which is the standard JPA annotation for
	 * entity manager injection.
	 */
	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAll() {
		List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
		return contacts;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAllWithDetail() {
		List<Contact> contacts = em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
		return contacts;
	}

	@Transactional(readOnly = true)
	@Override
	public Contact findById(Long id) {
		TypedQuery<Contact> query = em.createNamedQuery("Contact.findById", Contact.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Contact save(Contact contact) {
		if (contact.getId() == null) {
			em.persist(contact);
			log.info("Inserting new contact");
		} else {
			em.merge(contact);
			log.info("Updating existing contact");
		}
		log.info("Contact saved with id: " + contact.getId());
		return contact;
	}

	@Override
	public void delete(Contact contact) {
		Contact mergedContact = em.merge(contact);
		em.remove(mergedContact);
		log.info("Contact with id: " + contact.getId() + " deleted successfully");
	}

	@Transactional(readOnly = true)
	public List<Contact> findAllByNativeQuery() {
		//return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, Contact.class).getResultList();
		return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, "contactResult").getResultList();
	}

}
