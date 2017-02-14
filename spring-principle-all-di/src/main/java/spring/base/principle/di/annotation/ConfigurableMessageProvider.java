package spring.base.principle.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("configurableMessageProvider")
public class ConfigurableMessageProvider implements MessageProvider {

	private String message;
	
	//@Value, to define the value to be injected into the constructor.
	@Autowired
	public ConfigurableMessageProvider(@Value("configurableMessageProvider ... value ") String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
