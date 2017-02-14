package spring.base.principle.aop.orign;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import spring.base.principle.aop.entity.User;
import sun.misc.ProxyGenerator;

/**
 * 
 * @author fanguangjie 
 * <br/>
 * CGLIB动态代理--类继承
 * <br/>
 *         <p>
 *         1.asm-version.jar 作用：修改字节码信息，可以动态在内存中创建class类和修改class类信息<br/>
 *         2.cglib-version.jar 作用：对asm的操作进行了包装<br/>
 *         3.性能问题 CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少，
 *         但是CGLib在创建代理对象时所花费的时间却比JDK多得多，所以对于单例的对象，
 *         因为无需频繁创建对象，用CGLib合适，反之，使用JDK方式要更为合适一些。
 *         同时，由于CGLib由于是采用动态创建子类的方法，对于final方法，无法进行代理。
 *         4.被代理的类可以是接口也可以是实体类
 *         </p>
 * <code>
	public final class UserServiceImpl$$EnhancerByCGLIB$$f9c806c9 extends Proxy implements Factory{
	  private static Method m5;
	  public UserServiceImpl$$EnhancerByCGLIB$$f9c806c9(InvocationHandler paramInvocationHandler)
	  {
	    super(paramInvocationHandler);
	  }
	}
 * <code>
 */
@SuppressWarnings("restriction")
public class CglibProxyFactory implements MethodInterceptor {
	//cglib的加强类用来创建动态代理
	private Enhancer enhancer = new Enhancer();
	
	/**
	 * 动态代理的类
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object getProxy(Class clazz) {
		// 设置要创建动态代理的类（父类）
		enhancer.setSuperclass(clazz);
		//设置回调，代理类上所有的方法调用都会调用Callback,而Callback需要执行intercept()方法拦截
		enhancer.setCallback(this);
		// 通过字节码技术动态创建子类实例
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("*** TODO before *** " + method.getName());
		// 调用父类的方法
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("*** TODO after *** " + method.getName());
		return result;
	}

	public static void main(String[] args) throws Exception {
		CglibProxyFactory cglibProxyFactory =  new CglibProxyFactory();
		UserService userService = (UserService)cglibProxyFactory.getProxy(UserServiceImpl.class);
		System.out.println(userService.getClass());
		User user = new User();
		user.setId(2L);
		user.setUserName("fangj");
		userService.addUser(user);
		System.out.println(userService.getUser(2L));
		//保存生成的字节码
		byte[] proxyClass = ProxyGenerator.generateProxyClass(userService.getClass().getSimpleName(), userService.getClass().getInterfaces());
		FileOutputStream outputStream = new FileOutputStream(new File("H:\\"+userService.getClass().getSimpleName()+".class"));
		outputStream.write(proxyClass);
		outputStream.flush();
		outputStream.close();
	}

}
