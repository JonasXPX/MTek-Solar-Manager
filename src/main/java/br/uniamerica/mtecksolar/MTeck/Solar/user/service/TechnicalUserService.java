package br.uniamerica.mtecksolar.MTeck.Solar.user.service;

import br.uniamerica.mtecksolar.MTeck.Solar.config.service.DefaultService;
import br.uniamerica.mtecksolar.MTeck.Solar.user.TechnicalUser;
import br.uniamerica.mtecksolar.MTeck.Solar.user.domain.repository.TechnialUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TechnicalUserService extends DefaultService<TechnicalUser> {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final TechnialUserRepository technialUserRepository;

  public TechnicalUser signUp(TechnicalUser technicalUser) {
    technicalUser.setPassword(bCryptPasswordEncoder.encode(technicalUser.getPassword()));
    return technialUserRepository.save(technicalUser);
  }
}
