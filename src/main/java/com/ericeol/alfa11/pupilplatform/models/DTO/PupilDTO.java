package com.ericeol.alfa11.pupilplatform.models.DTO;

import org.springframework.data.domain.Page;

import com.ericeol.alfa11.pupilplatform.models.Pupil;

public class PupilDTO {

	private Long id;
	private String name;
	private String email;
	
	public PupilDTO(Pupil pupil) {
		this.id = pupil.getId();
		this.name = pupil.getName();
		this.email = pupil.getEmail();
	}
	
	public static Page<PupilDTO> transform(Page<Pupil> pupils) {
		
		return pupils.map(PupilDTO::new);
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
