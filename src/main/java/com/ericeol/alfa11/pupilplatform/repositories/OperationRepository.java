package com.ericeol.alfa11.pupilplatform.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ericeol.alfa11.pupilplatform.models.Operation;
import com.ericeol.alfa11.pupilplatform.models.DTO.RankingDTO;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{

	@Query(value = "SELECT new com.ericeol.alfa11.pupilplatform.models.DTO.RankingDTO(SUM(op.points) AS total, op.pupil.name AS pupil) FROM Operation op WHERE op.stock = 'Dólar' GROUP BY op.pupil.name")
	List<RankingDTO> sumDolarPointsAndGroupByPupilName();
	
}
