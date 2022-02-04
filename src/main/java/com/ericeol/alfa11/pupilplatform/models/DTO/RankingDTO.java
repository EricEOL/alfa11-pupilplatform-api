package com.ericeol.alfa11.pupilplatform.models.DTO;

public class RankingDTO {
	
	private Double total;
	private String pupil;
	
	public RankingDTO() {
	}

	public RankingDTO(Double total, String pupil) {
		this.total = total;
		this.pupil = pupil;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getPupil() {
		return pupil;
	}

	public void setPupil(String pupil) {
		this.pupil = pupil;
	}
		
}
