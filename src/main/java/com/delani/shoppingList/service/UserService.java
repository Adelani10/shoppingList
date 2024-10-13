package com.delani.shoppingList.service;

import com.delani.shoppingList.model.User;
import com.delani.shoppingList.model.UserPrincipal;
import com.delani.shoppingList.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JWTService jwtService;


  public String register(User user) {
    try {
      if (!user.getUsername().isBlank()
          && !user.getPassword().isBlank()) {
        String plainPassword = user.getPassword();
        user.setPassword(encoder.encode(plainPassword));
        userRepository.save(user);
        user.setPassword(plainPassword);
        return verify(user);
      } else {
        throw new IllegalArgumentException("Username, email or password must not be blank");
      }
    } catch (IllegalArgumentException ex) {
      throw new RuntimeException("Insert a  valid username, email or password", ex);
    }
  }

  public String verify(User user) {
    try {
      Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
      if (authentication.isAuthenticated()) {
        return jwtService.generateToken(user.getUsername());
      } else {
        throw new BadCredentialsException("Invalid credentials");
      }
    } catch (BadCredentialsException ex) {
      throw new RuntimeException("Invalid username or password");
    } catch (AuthenticationException ex) {
      throw new RuntimeException("Authentication failed: " + ex.getMessage());
    }
  }

  public User getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.isAuthenticated()) {
      Object principal = authentication.getPrincipal();
      if (principal instanceof UserPrincipal) {
        return ((UserPrincipal) principal).getUser();
      } else {
        throw new RuntimeException("Principal isn't an instance of CreatorPrincipal");
      }
    }
    return null;
  }
}
