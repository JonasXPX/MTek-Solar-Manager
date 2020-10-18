package br.uniamerica.mtecksolar.MTeck.Solar.config.security;

import br.uniamerica.mtecksolar.MTeck.Solar.user.TechnicalUser;
import br.uniamerica.mtecksolar.MTeck.Solar.user.domain.repository.TechnialUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final TechnialUserRepository technialUserRepository;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
    TechnicalUser technicalUser = technialUserRepository.findOneByUsername(username);
    if(technicalUser == null) {
      throw new UsernameNotFoundException(username);
    }
    return new User(technicalUser.getUsername(), technicalUser.getPassword(), Collections.emptyList());
  }
}
