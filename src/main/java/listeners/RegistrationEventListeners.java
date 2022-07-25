package listeners;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import entity.User;
import event.RegistrationEvent;
import service.UserService;

public class RegistrationEventListeners implements
ApplicationListener<RegistrationEvent> {
	@Autowired
	private UserService userService;
	@Override
	public void onApplicationEvent(RegistrationEvent event) {
		//token verif
		User user=event.getUser();
		String token= UUID.randomUUID().toString();
		userService.saveVerificationTokenForUser(token,user);
		
		//send mail
	}

}
