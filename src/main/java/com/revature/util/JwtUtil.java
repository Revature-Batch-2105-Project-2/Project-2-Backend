package com.revature.util;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

/*
 * This is part of the implementation for jwt with Spring Security.
 * It is not fully secure.
 * SECRET_KEY should not be defined in here, but should be obtained from a file elsewhere (
 */
@Component
public class JwtUtil {
	private String SECRET_KEY = "Do you feel lucky, punk?";
	public Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
	
	public String generateToken(UserDetails details) {
		try {
			// should expire 24 hours after being issued
			return JWT.create().withIssuer(details.getUsername()).withIssuedAt(new Date(System.currentTimeMillis())).withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)).sign(algorithm);
		} catch (JWTCreationException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean verifyToken(String token, UserDetails details) {
		try {
			JWTVerifier verifier = JWT.require(algorithm).withIssuer(details.getUsername()).build();
			DecodedJWT jwt = verifier.verify(token);
			return details.getUsername().equals(jwt.getIssuer());
		} catch (JWTVerificationException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public DecodedJWT decodeToken(String token) {
		try {
			return JWT.decode(token);
		} catch (JWTDecodeException e) {
			e.printStackTrace();
			return null;
		}
	}
}
