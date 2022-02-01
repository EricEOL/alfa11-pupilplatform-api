package com.ericeol.alfa11.pupilplatform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericeol.alfa11.pupilplatform.models.Operation;
import com.ericeol.alfa11.pupilplatform.models.DTO.OperationDTO;
import com.ericeol.alfa11.pupilplatform.models.form.OperationForm;
import com.ericeol.alfa11.pupilplatform.repositories.OperationRepository;
import com.ericeol.alfa11.pupilplatform.repositories.PupilRepository;

@RestController
@RequestMapping("/operations")
public class OperationsController {

	@Autowired
	OperationRepository repository;
	
	@Autowired
	PupilRepository pupilRepository;
	
	@GetMapping
	public Page<OperationDTO> list(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable parameters) {
		
		Page<Operation> operations = repository.findAll(parameters);
		
		return OperationDTO.transform(operations);
	}
	
	@PostMapping
	@Transactional
	public void add(@RequestBody OperationForm form) {
		Operation operation = form.transform(pupilRepository);
		repository.save(operation);
	}
	
}
