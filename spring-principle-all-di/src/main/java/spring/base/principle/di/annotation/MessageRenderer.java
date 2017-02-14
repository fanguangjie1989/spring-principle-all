package spring.base.principle.di.annotation;

public interface MessageRenderer {
	
	void render();

	void setMessageProvider(MessageProvider provider);

	MessageProvider getMessageProvider();
}
