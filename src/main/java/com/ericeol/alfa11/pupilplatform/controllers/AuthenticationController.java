package com.ericeol.alfa11.pupilplatform.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericeol.alfa11.pupilplatform.config.security.TokenService;
import com.ericeol.alfa11.pupilplatform.models.DTO.TokenDTO;
import com.ericeol.alfa11.pupilplatform.models.form.LoginForm;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDTO> auth(@RequestBody @Valid LoginForm form) {
		
		UsernamePasswordAuthenticationToken loginData = form.transform();
		
		try {
			
			Authentication authentication = authenticationManager.authenticate(loginData);
			
			String token = tokenService.generateToken(authentication);
			
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}

	}
	
}
