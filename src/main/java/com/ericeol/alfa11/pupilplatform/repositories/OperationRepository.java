package com.ericeol.alfa11.pupilplatform.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ericeol.alfa11.pupilplatform.models.Operation;
import com.ericeol.alfa11.pupilplatform.models.DTO.RankingDTO;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{

	@Query(value = "SELECT new com.ericeol.alfa11.pupilplatform.models.DTO.RankingDTO(SUM(op.points) AS total, op.pupil.name AS pupil) FROM Operation op WHERE op.stock = 'USD' GROUP BY op.pupil.name")
	Page<RankingDTO> sumDolarPointsAndGroupByPupilName(Pageable parameters);
	
	@Query(value = "SELECT new com.ericeol.alfa11.pupilplatform.models.DTO.RankingDTO(SUM(op.points) AS total, op.pupil.name AS pupil) FROM Operation op WHERE op.stock = 'B3' GROUP BY op.pupil.name")
	Page<RankingDTO> sumB3PointsAndGroupByPupilName(Pageable parameters);
	
	Iterable<Operation> findAllByPupilId(Long id);
	
	void deleteAllByPupilId(Long id);
}
