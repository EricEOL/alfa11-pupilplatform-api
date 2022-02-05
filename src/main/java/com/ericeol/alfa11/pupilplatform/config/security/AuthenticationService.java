package com.ericeol.alfa11.pupilplatform.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ericeol.alfa11.pupilplatform.models.Pupil;
import com.ericeol.alfa11.pupilplatform.repositories.PupilRepository;

@Service
public class AuthenticationService implements UserDetailsService{
	@Autowired
	private PupilRepository pupilRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Pupil> pupil = pupilRepository.findByEmail(username);
		
		if(pupil.isPresent()) {
			return pupil.get();
		}
		
		throw new UsernameNotFoundException("Usuário ou senha incorretos");
	}
}
