package spring.base.principle.di.event;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7569110563683735302L;
	private String msg;

	public MessageEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMessage() {
		return this.getTimestamp()+" "+msg;
	}

}
