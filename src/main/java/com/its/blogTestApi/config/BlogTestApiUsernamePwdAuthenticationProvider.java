package com.its.blogTestApi.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.its.blogTestApi.entity.UserEntity;
import com.its.blogTestApi.repository.UserRepository;

@Component
public class BlogTestApiUsernamePwdAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    String username = authentication.getName();
    String pwd = authentication.getCredentials().toString();
    Optional<UserEntity> user = userRepository.findByUserEmail(username);
    if (user.isPresent()) {
      if (passwordEncoder.matches(pwd, user.get().getPwd())) {
        return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(user.get().getUserRole()));
      } else {
        throw new BadCredentialsException("Invalid password!");
      }
    } else {
      throw new BadCredentialsException("No user registered with this details!");
    }

  }

  private List<GrantedAuthority> getGrantedAuthorities(String role) {
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(new SimpleGrantedAuthority(role));
    return grantedAuthorities;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
  }

}
