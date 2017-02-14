package spring.base.principle.di.javaconfig;

public class ConfigurableMessageProvider implements MessageProvider {

	private String message = "Default message";

	public ConfigurableMessageProvider() {
		
	}

	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
