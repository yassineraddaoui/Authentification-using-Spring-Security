package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import entity.User;
import entity.VerificationToken;
import model.UserModel;
import repo.UserRepo;
import repo.VerificationTokenRepo;

@Service
public class UserServiceImpli  implements UserService{
	@Autowired
	private UserRepo userRepo;
	@Autowired 
	private PasswordEncoder passwordEncoder;
	@Autowired
	private VerificationTokenRepo verifTokenRepo;
	
	@Override
	public User registerUser(UserModel userModel) {
		User user=new User();
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setMail(userModel.getMail());
		user.setRole("USER");
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		userRepo.save(user);
		return user;
	}


	@Override
	public void saveVerificationTokenForUser(String token, User user) {
		VerificationToken verificationToken =
				new VerificationToken(token, user);
		verifTokenRepo.save(verificationToken);
	}
	
}
