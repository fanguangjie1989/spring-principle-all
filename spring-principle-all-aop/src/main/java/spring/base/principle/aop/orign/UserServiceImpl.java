package spring.base.principle.aop.orign;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import spring.base.principle.aop.entity.User;

public class UserServiceImpl implements UserService {
	private ConcurrentMap<Long, User> users = new ConcurrentHashMap<Long, User>();
	@Override
	public void addUser(User user) {
		users.put(user.getId(), user);
	}

	@Override
	public User getUser(Long id) {
		return users.get(id);
	}

}
