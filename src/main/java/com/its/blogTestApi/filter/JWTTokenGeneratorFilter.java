package com.its.blogTestApi.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.its.blogTestApi.constants.SecurityConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (null != authentication) {
      String JWT_KEY = SecurityConstants.JWT_KEY;
      String JWT_HEADER = SecurityConstants.JWT_HEADER;
      SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
      String jwt = Jwts.builder().issuer("Blog Test App").subject("JWT Token")
          .claim("username", authentication.getName())
          .claim("authorities", populateAuthorities(authentication.getAuthorities()))
          .issuedAt(new Date())
          .expiration(new Date((new Date()).getTime() + 30000000))
          .signWith(key).compact();
      response.setHeader(JWT_HEADER, jwt);
    }

    filterChain.doFilter(request, response);
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) {
    return !request.getServletPath().equals("/user/login");
  }

  private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
    Set<String> authoritiesSet = new HashSet<>();
    for (GrantedAuthority authority : collection) {
      authoritiesSet.add(authority.getAuthority());
    }
    return String.join(",", authoritiesSet);
  }

}
