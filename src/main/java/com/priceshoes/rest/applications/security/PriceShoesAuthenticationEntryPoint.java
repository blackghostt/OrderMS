package com.priceshoes.rest.applications.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class PriceShoesAuthenticationEntryPoint implements AuthenticationEntryPoint 
{
	public void commence(HttpServletRequest pRequest, HttpServletResponse pResponse,
			AuthenticationException authException) throws IOException, ServletException 
	{
		pResponse.sendError(401, "Unauthorized"); 
	}
}
