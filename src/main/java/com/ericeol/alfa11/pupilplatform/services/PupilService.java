package com.ericeol.alfa11.pupilplatform.services;

import com.ericeol.alfa11.pupilplatform.models.DTO.PupilDTO;
import com.ericeol.alfa11.pupilplatform.models.Pupil;
import com.ericeol.alfa11.pupilplatform.models.form.PupilForm;
import com.ericeol.alfa11.pupilplatform.repositories.OperationRepository;
import com.ericeol.alfa11.pupilplatform.repositories.PupilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PupilService {

    @Autowired
    PupilRepository pupilRepository;

    @Autowired
    OperationRepository operationRepository;

    public Page<PupilDTO> all(Pageable params) {
        Page<Pupil> pupils = pupilRepository.findAll(params);

        return PupilDTO.transform(pupils);
    }

    public void add(PupilForm form) {
        Pupil pupil = form.transform();
        pupilRepository.save(pupil);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<Pupil> checkPupilExists = pupilRepository.findById(id);

        if(checkPupilExists.isPresent()) {

            operationRepository.deleteAllByPupilId(id);

            pupilRepository.deleteById(id);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
