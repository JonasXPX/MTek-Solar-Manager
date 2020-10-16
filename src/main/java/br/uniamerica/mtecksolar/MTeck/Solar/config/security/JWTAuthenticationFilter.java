package br.uniamerica.mtecksolar.MTeck.Solar.config.security;

import br.uniamerica.mtecksolar.MTeck.Solar.user.TechnicalUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static br.uniamerica.mtecksolar.MTeck.Solar.config.security.SecurityConstraints.*;

@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;

  @SneakyThrows
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    TechnicalUser credentials = new ObjectMapper()
            .readValue(request.getInputStream(), TechnicalUser.class);
    return authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    credentials.getUsername(),
                    credentials.getPassword(),
                    new ArrayList<>()
            )
    );
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
    String token = JWT.create()
            .withSubject(((User)authResult.getPrincipal()).getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .sign(Algorithm.HMAC512(SECRET.getBytes()));
    response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
  }
}
