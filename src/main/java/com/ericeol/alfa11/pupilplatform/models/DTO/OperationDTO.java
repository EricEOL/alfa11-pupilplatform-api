package com.ericeol.alfa11.pupilplatform.models.DTO;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.ericeol.alfa11.pupilplatform.models.Operation;

public class OperationDTO {
	
	private Long id;
	private String stock;
	private Double points;
	private LocalDateTime createdAt;
	private String pupilName;
	
	public OperationDTO(Operation operation) {
		super();
		this.id = operation.getId();
		this.stock = operation.getStock();
		this.points = operation.getPoints();
		this.createdAt = operation.getCreatedAt();
		this.pupilName = operation.getPupil().getName();
	}
	
	public static Page<OperationDTO> transform(Page<Operation> operations) {
		return operations.map(OperationDTO::new);
	}

	public Long getId() {
		return id;
	}

	public String getStock() {
		return stock;
	}

	public Double getPoints() {
		return points;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getPupilName() {
		return pupilName;
	}
	
	
}
