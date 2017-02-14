package spring.principle.all.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import spring.principle.all.jdbc.exceptions.MySQLErrorCodesTranslator;
import spring.principle.all.jdbc.po.Contact;

public class JdbcTemplateContactDao implements ContactDao, InitializingBean {
	/**
	 * 通过spring直接注入
	 */
	private DataSource dataSource;
	/**
	 * jdbcTemplate是线程安全的
	 * 可以通过xml config 配置一个单例的实例
	 */
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 在setDataSource方法中初始化jdbcTemplate保证数据源dataSource被注入的时候jdbcTemplate也就被初始化了
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		MySQLErrorCodesTranslator errorTranslator = new MySQLErrorCodesTranslator();
		errorTranslator.setDataSource(dataSource);
		jdbcTemplate.setExceptionTranslator(errorTranslator);
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (dataSource == null) {
			throw new BeanCreationException("Must set dataSource on ContactDao");
		}
		if (jdbcTemplate == null) {
			throw new BeanCreationException("Null JdbcTemplate on ContactDao");
		}
	}

	@Override
	public List<Contact> findAll() {
		return null;
	}

	@Override
	public List<Contact> findByFirstName(String firstName) {
		return null;
	}

	@Override
	public String findLastNameById(Long id) {
		return jdbcTemplate.queryForObject("select last_name from contact where id = ?", new Object[]{id},String.class);
	}
	/**
	 * 1.使用问号占位符
	 * 2.通过对象数组传递参数
	 * 3.对象数组传递参数参数的顺序很重要不能错
	 */
	@Override
	public String findFirstNameById(Long id) {
		return jdbcTemplate.queryForObject("select first_name from contact where id = ?", new Object[]{id},String.class);
	}

	@Override
	public void insert(Contact contact) {

	}

	@Override
	public void update(Contact contact) {

	}

	@Override
	public void delete(Long contactId) {

	}

	@Override
	public List<Contact> findAllWithDetail() {
		return null;
	}

}
