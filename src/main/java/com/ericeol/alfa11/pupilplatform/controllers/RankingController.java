package com.ericeol.alfa11.pupilplatform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericeol.alfa11.pupilplatform.models.DTO.RankingDTO;
import com.ericeol.alfa11.pupilplatform.repositories.OperationRepository;

@RestController
@RequestMapping("/ranking")
public class RankingController {
	
	@Autowired
	OperationRepository operationRepository;

	@GetMapping("/dolar")
	public Page<RankingDTO> generateFullDolarRanking(@PageableDefault(sort = "total", direction = Direction.DESC, page = 0, size = 5) Pageable parameters) {
		Page<RankingDTO> operations = operationRepository.sumDolarPointsAndGroupByPupilName(parameters);
		
		return operations;
	}
	
	@GetMapping("/b3")
	public Page<RankingDTO> generateFullB3Ranking(@PageableDefault(sort = "total", direction = Direction.DESC, page = 0, size = 5) Pageable parameters) {
		Page<RankingDTO> operations = operationRepository.sumB3PointsAndGroupByPupilName(parameters);
		
		return operations;
	}
	
}
