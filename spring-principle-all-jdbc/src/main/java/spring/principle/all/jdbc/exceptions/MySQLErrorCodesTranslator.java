package spring.principle.all.jdbc.exceptions;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
/**
 * 
 * @author fanguangjie
 * translate the checked SQLException into a runtime Spring JDBC exception.
 * 
 */
public class MySQLErrorCodesTranslator extends SQLErrorCodeSQLExceptionTranslator {
	@Override
	protected DataAccessException customTranslate(String task, String sql, SQLException sqlex) {
		if (sqlex.getErrorCode() == -12345) {
			return new DeadlockLoserDataAccessException(task, sqlex);
		}
		return null;
	}
}
