package spring.base.principle.aop.orign;

import spring.base.principle.aop.entity.User;

public interface UserService {
	void addUser(User user);
	User getUser(Long id);
}
