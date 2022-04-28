package com.ericeol.alfa11.pupilplatform.services;

import com.ericeol.alfa11.pupilplatform.models.DTO.OperationDTO;
import com.ericeol.alfa11.pupilplatform.models.Operation;
import com.ericeol.alfa11.pupilplatform.repositories.OperationRepository;
import com.ericeol.alfa11.pupilplatform.repositories.PupilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationsService {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    PupilRepository pupilRepository;

    public Page<OperationDTO> all(Pageable params) {

        Page<Operation> operations = operationRepository.findAll(params);

        return OperationDTO.transform(operations);

    }

    public ResponseEntity<OperationDTO> one(Long id) {
        Optional<Operation> operation = operationRepository.findById(id);

        if(operation.isPresent()) {
            return ResponseEntity.ok(new OperationDTO(operation.get()));
        }

        return ResponseEntity.notFound().build();
    }

}
