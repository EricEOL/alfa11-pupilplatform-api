package com.ericeol.alfa11.pupilplatform.controllers;

import com.ericeol.alfa11.pupilplatform.services.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ericeol.alfa11.pupilplatform.models.DTO.OperationDTO;
import com.ericeol.alfa11.pupilplatform.models.form.OperationForm;
import com.ericeol.alfa11.pupilplatform.models.update.UpdateOperation;

@RestController
@RequestMapping("/operations")
public class OperationsController {

	@Autowired
	OperationsService operationsService;
	
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
	public ResponseEntity<OperationDTO> update(@PathVariable Long id, @RequestBody UpdateOperation form) {
		return operationsService.update(id, form);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return operationsService.delete(id);
	}
		
}
