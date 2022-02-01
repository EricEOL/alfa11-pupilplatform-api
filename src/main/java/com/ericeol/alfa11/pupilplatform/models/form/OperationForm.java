package com.ericeol.alfa11.pupilplatform.models.form;

import java.util.Optional;

import com.ericeol.alfa11.pupilplatform.models.Operation;
import com.ericeol.alfa11.pupilplatform.models.Pupil;
import com.ericeol.alfa11.pupilplatform.repositories.PupilRepository;

public class OperationForm {

	private Long pupilId;
	private String stock;
	private Double points;
	
	public Long getPupilId() {
		return pupilId;
	}
	public void setPupilId(Long pupilId) {
		this.pupilId = pupilId;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Double getPoints() {
		return points;
	}
	public void setPoints(Double points) {
		this.points = points;
	}
	
	public Operation transform(PupilRepository pupilRepository) {
		
		Optional<Pupil> pupil = pupilRepository.findById(pupilId);
		
		return new Operation(stock, points, pupil.get());
	}
}
