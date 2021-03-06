package com.ericeol.alfa11.pupilplatform.models.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
	private String password;
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UsernamePasswordAuthenticationToken transform() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
	
}
