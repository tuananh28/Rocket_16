package com.vti.config;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.vti.entity.Account;
import com.vti.service.IAccountService;
import com.vti.service.JWTTokenService;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
	private IAccountService accountService;
	
    public JWTAuthenticationFilter(String url, AuthenticationManager authManager, IAccountService accountService) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        this.accountService = accountService;
    }

    @Override
    public Authentication attemptAuthentication(
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws AuthenticationException, IOException, ServletException {
        
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                		request.getParameter("accountname"),
                		request.getParameter("password"),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(
    		HttpServletRequest request, 
    		HttpServletResponse response, 
    		FilterChain chain, 
    		Authentication authResult) throws IOException, ServletException {
    	// infor account
    	Account account = accountService.getAccountByUsername(authResult.getName());
    	
        JWTTokenService.addJWTTokenAndUserInfoToBody(response, account);
    }
}
