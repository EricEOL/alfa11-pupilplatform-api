package com.ericeol.alfa11.pupilplatform.models.update;

import com.ericeol.alfa11.pupilplatform.models.Operation;
import com.ericeol.alfa11.pupilplatform.repositories.OperationRepository;

public class UpdateOperation {

	private String stock;
	private Double points;
	
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
	
	public Operation update(Long id, OperationRepository repository) {
		
		Operation operation = repository.getById(id);
		
		operation.setStock(this.stock);
		operation.setPoints(this.points);
		
		return operation;
	}
}
