package com.ipartek.ipartex.controladores;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v2/token")
public class TokenController {
	@GetMapping("/csrf")
	public Map<String, String> getCsrfToken(HttpServletRequest request) {
	    CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
	    return Collections.singletonMap("csrfToken", token.getToken());
	}

}
