package com.ericeol.alfa11.pupilplatform.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericeol.alfa11.pupilplatform.models.Operation;
import com.ericeol.alfa11.pupilplatform.models.DTO.RankingDTO;
import com.ericeol.alfa11.pupilplatform.repositories.OperationRepository;

@RestController
@RequestMapping("/ranking")
public class RankingController {
	
	@Autowired
	OperationRepository operationRepository;

	@GetMapping
	public List<?> generateFullRanking() {
		
		List<RankingDTO> operations = operationRepository.sumDolarPointsAndGroupByPupil();
		
		
		return operations;
		
	}
	
}
