package spring.base.principle.di.javaconfig;

public class StandardOutMessageRenderer implements MessageRenderer {
	private MessageProvider messageProvider;
	@Override
	public void render() {
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider=provider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

}
