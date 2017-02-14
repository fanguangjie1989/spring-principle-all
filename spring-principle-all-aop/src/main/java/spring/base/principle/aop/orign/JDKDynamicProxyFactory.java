package spring.base.principle.aop.orign;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import spring.base.principle.aop.entity.User;
import sun.misc.ProxyGenerator;
/**
 * 
 * @author fanguangjie
 * <br/>
 * JDK 动态生成代理--接口
 * 1.生成的代理对象继承了Proxy实现了UserService接口
 * 2.代理对象在创建的时候会生成对应的方法对象
 * 3.执行代理对象的getUser方法会将被执行的方法对象交给Proxy的InvocationHandler处理
 * <br/>
 * <code>
 * public final class $Proxy0 extends Proxy implements UserService{
	  private static Method m4;
	  
	  public $Proxy0(InvocationHandler paramInvocationHandler)
	  {
	    super(paramInvocationHandler);
	  }
	  
	  public final User getUser(Long paramLong)
	  {
	      return (User)this.h.invoke(this, m4, new Object[] { paramLong });
	  }
	  
	  //为每个方法创建一个方法对象，代理执行方法的时候，都交给InvocationHandler h来处理相当于植入了要执行的代码
	  static{
	  	m4 = Class.forName("spring.base.principle.aop.orign.UserService").getMethod("getUser", new Class[] { Class.forName("java.lang.Long") });
	  }
   }
  </code>
 */
@SuppressWarnings("restriction")
public class JDKDynamicProxyFactory implements InvocationHandler {
	
	private Object targetObj;
	
	public JDKDynamicProxyFactory(Object targetObj) {
		this.targetObj = targetObj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("**********before**********");
		Object result = method.invoke(targetObj, args);
		System.out.println("**********end**********");
		return result;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				targetObj.getClass().getInterfaces(), this);
	}
	
	public void saveProxyClassFile(){
		
	}
	
	public static void main(String[] args) throws Exception {
		JDKDynamicProxyFactory UserServiceImplProxyFactory = new JDKDynamicProxyFactory(new UserServiceImpl());
		UserService userService = (UserService)UserServiceImplProxyFactory.getProxy();
		User user =  new User();
		user.setId(1L);
		user.setUserName("fangj");
		userService.addUser(user);
		User u = userService.getUser(1L);
		System.out.println(u);
		System.out.println(userService.getClass());
		byte[] proxyClass = ProxyGenerator.generateProxyClass(userService.getClass().getSimpleName(), userService.getClass().getInterfaces());
		FileOutputStream outputStream = new FileOutputStream(new File("H:\\"+userService.getClass().getSimpleName()+".class"));
		outputStream.write(proxyClass);
		outputStream.flush();
		outputStream.close();
	}
}
