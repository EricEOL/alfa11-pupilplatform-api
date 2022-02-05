package com.ericeol.alfa11.pupilplatform.models.form;

import com.ericeol.alfa11.pupilplatform.models.Pupil;

public class PupilForm {

	private String name;
	private String email;
	private String password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Pupil transform() {
		return new Pupil(name, email, password);
	}
}
