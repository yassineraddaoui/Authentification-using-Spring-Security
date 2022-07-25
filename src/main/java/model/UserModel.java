package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	private String firstName;
	private String lastName;
	private String mail;
	private String password;
	private String matchingPassword;

}
