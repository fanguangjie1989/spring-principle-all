package spring.base.principle.di.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
	@Value("Scott Tiger")
	private String name;
	@Value("32")
	private int age;
	@Value("1.778")
	private float height;
	@Value("true")
	private boolean programmer;
	@Value("1009843200")
	private Long ageInSeconds;

	@Override
	public String toString() {
		return "name: " + name + " age: " + age + " height: " + height + " programmer: " + programmer
				+ " ageInSeconds: " + ageInSeconds;
	}
}
