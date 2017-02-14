package spring.base.principle.di.xml;

public interface MessageRenderer {
	
	void render();

	void setMessageProvider(MessageProvider provider);

	MessageProvider getMessageProvider();
}
