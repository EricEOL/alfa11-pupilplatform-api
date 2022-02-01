package com.ericeol.alfa11.pupilplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericeol.alfa11.pupilplatform.models.Pupil;

public interface PupilRepository extends JpaRepository<Pupil, Long>{
	
}
