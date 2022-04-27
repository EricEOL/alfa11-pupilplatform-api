package com.ericeol.alfa11.pupilplatform.services;

import com.ericeol.alfa11.pupilplatform.models.DTO.PupilDTO;
import com.ericeol.alfa11.pupilplatform.models.Pupil;
import com.ericeol.alfa11.pupilplatform.repositories.PupilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PupilService {

    @Autowired
    PupilRepository pupilRepository;

    public Page<PupilDTO> all(Pageable params) {
        Page<Pupil> pupils = pupilRepository.findAll(params);

        return PupilDTO.transform(pupils);
    }

}
