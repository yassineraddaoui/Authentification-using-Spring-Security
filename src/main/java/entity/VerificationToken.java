package entity;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {
	private static final int EXPIRATION_TIME= 10;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" , nullable = false) 
	private Long id;
	
	private String token;
	
	private Date expirationDate;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "used_id",
		nullable = false,
		foreignKey = @ForeignKey(name="fk_user_verif_token"))
	private User user;
	 
	
	
	
	
	public VerificationToken(String token, User user) {
		super();
		this.token = token;
		this.user = user;
		this.expirationDate = calculateExpirationDate(EXPIRATION_TIME);
	}
	
	
	public Date calculateExpirationDate(int expirationTime) {
		Calendar calendar =Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, expirationTime);
		return new Date(calendar.getTime().getTime());
	}
	
	public VerificationToken(String token) {
		super();
		this.token = token;
		this.expirationDate = calculateExpirationDate(EXPIRATION_TIME);
	}

}
