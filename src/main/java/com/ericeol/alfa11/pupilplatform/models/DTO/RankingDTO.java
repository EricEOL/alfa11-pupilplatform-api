package com.ericeol.alfa11.pupilplatform.models.DTO;

public class RankingDTO {
	
	private Double total;
	private Long pupil;
	
	public RankingDTO() {
	}
	
	public RankingDTO(Double total, Long pupil) {
		this.total = total;
		this.pupil = pupil;
	}

	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Long getPupil() {
		return pupil;
	}
	public void setPupil(Long pupil) {
		this.pupil = pupil;
	}
	
	
}
