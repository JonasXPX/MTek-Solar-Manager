package br.uniamerica.mtecksolar.MTeck.Solar.config.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TechnicalUsernameNotFoundException extends Exception{
  public TechnicalUsernameNotFoundException(String username) {
    super(username);
  }
}
