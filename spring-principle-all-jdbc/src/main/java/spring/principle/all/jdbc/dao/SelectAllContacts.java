package spring.principle.all.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import spring.principle.all.jdbc.po.Contact;
/**
 * 
 * @author fanguangjie
 * 1.可重用的查询
 * 2.实现mapRow(ResultSet rs, int rowNum)方法将JDBC查询的结果集转换成想要的对象集合
 */
public class SelectAllContacts extends MappingSqlQuery<Contact> {
	private static final String SQL_SELECT_ALL_CONTACT = "select id, first_name, last_name, birth_date from contact";

	public SelectAllContacts(DataSource dataSource) {
		super(dataSource, SQL_SELECT_ALL_CONTACT);
	}

	@Override
	protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setId(rs.getLong("id"));
		contact.setFirstName(rs.getString("first_name"));
		contact.setLastName(rs.getString("last_name"));
		contact.setBirthDate(rs.getDate("birth_date"));
		return contact;
	}

}
