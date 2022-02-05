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

import com.ericeol.alfa11.pupilplatform.models.Pupil;
import com.ericeol.alfa11.pupilplatform.models.DTO.PupilDTO;
import com.ericeol.alfa11.pupilplatform.models.form.PupilForm;
import com.ericeol.alfa11.pupilplatform.repositories.PupilRepository;

@RestController
@RequestMapping("/pupil")
public class PupilController {

	@Autowired
	PupilRepository repository;
	
	@GetMapping
	public Page<PupilDTO> list(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable parameters) {
		
		Page<Pupil> pupils = repository.findAll(parameters);
		
		return PupilDTO.transform(pupils);
	}
	
	@PostMapping
	@Transactional
	public void add(@RequestBody PupilForm form) {
		
		Pupil pupil = form.transform();
		
		repository.save(pupil);
	}
	
}