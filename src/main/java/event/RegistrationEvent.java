package event;

import org.springframework.context.ApplicationEvent;

import entity.User;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegistrationEvent extends ApplicationEvent{
	private User user;
	private String appURL;
	public RegistrationEvent( User user, String appURL) {
		super(user);
		this.user = user;
		this.appURL = appURL;
	}

}
