package spring.base.principle.aop.orign;

import spring.base.principle.aop.entity.User;
/**
 * 
 * @author fanguangjie
 * 静态代理模式和被代理对象实现相同的接口
 */
public class UserServiceProxy implements UserService {
	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void addUser(User user) {
		System.out.println("TODO Something before add user");
		userService.addUser(user);
		System.out.println("TODO Something after add user");
	}

	@Override
	public User getUser(Long id) {
		System.out.println("TODO Something before get user");
		User u = userService.getUser(id);
		System.out.println("TODO Something after get user");
		return u;
	}

}
