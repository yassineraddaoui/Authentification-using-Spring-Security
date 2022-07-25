package controller;

import java.util.concurrent.Flow.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entity.User;
import event.RegistrationEvent;
import model.UserModel;
import service.UserService;

@RestController
public class RegController {
	@Autowired
	private UserService userService;
	@Autowired
	private ApplicationEventPublisher publisher;
	@PostMapping("/register")
	public String registerUser(@RequestBody UserModel userModel) {
		User user =userService.registerUser(userModel);
		publisher.publishEvent(new RegistrationEvent(
				user,
				"url"
				));
		return "OKK!!";
	}
	
}
