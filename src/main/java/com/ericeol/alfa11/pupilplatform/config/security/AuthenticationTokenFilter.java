package com.ericeol.alfa11.pupilplatform.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ericeol.alfa11.pupilplatform.models.Pupil;
import com.ericeol.alfa11.pupilplatform.repositories.PupilRepository;

public class AuthenticationTokenFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;
	private PupilRepository pupilRepository;
	
	public AuthenticationTokenFilter(TokenService tokenService, PupilRepository pupilRepository) {
		this.tokenService = tokenService;
		this.pupilRepository = pupilRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = getToken(request);
		
		boolean validToken = tokenService.isValid(token);

		if(validToken) {
			authenticateUser(token);
		}
		
		filterChain.doFilter(request, response);
	}

	private void authenticateUser(String token) {
		
		Long userId = tokenService.getUserId(token);
		
		Pupil user = pupilRepository.findById(userId).get();
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String getToken(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}
}
