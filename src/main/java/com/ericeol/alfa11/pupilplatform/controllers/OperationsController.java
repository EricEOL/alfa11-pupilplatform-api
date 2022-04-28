package com.ericeol.alfa11.pupilplatform.controllers;

import java.net.URI;
import java.util.Optional;

import com.ericeol.alfa11.pupilplatform.services.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ericeol.alfa11.pupilplatform.models.Operation;
import com.ericeol.alfa11.pupilplatform.models.DTO.OperationDTO;
import com.ericeol.alfa11.pupilplatform.models.form.OperationForm;
import com.ericeol.alfa11.pupilplatform.models.update.UpdateOperation;
import com.ericeol.alfa11.pupilplatform.repositories.OperationRepository;
import com.ericeol.alfa11.pupilplatform.repositories.PupilRepository;

@RestController
@RequestMapping("/operations")
public class OperationsController {

	@Autowired
	OperationRepository repository;

	@Autowired
	OperationsService operationsService;
	
	@Autowired
	PupilRepository pupilRepository;
	
	@GetMapping
	public Page<OperationDTO> all(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable params) {
		return operationsService.all(params);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OperationDTO> one(@PathVariable Long id) {
		return operationsService.one(id);
	}
	
	@PostMapping
	public ResponseEntity<OperationDTO> add(@RequestBody OperationForm form, UriComponentsBuilder uriComponentsBuilder) {
		return operationsService.add(form, uriComponentsBuilder);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<OperationDTO> update(@PathVariable Long id, @RequestBody UpdateOperation form) {
			
		Optional<Operation> operationIsPresent = repository.findById(id);
		
		if(operationIsPresent.isPresent()) {
			Operation operation = form.update(id, repository);
			return ResponseEntity.ok(new OperationDTO(operation));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Optional<Operation> operation = repository.findById(id);
		
		if(operation.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
		
}
