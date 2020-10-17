package br.uniamerica.mtecksolar.MTeck.Solar.services;

import br.uniamerica.mtecksolar.MTeck.Solar.user.TechnicalUser;
import br.uniamerica.mtecksolar.MTeck.Solar.user.service.TechnicalUserService;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DatabaseTearDown(value = "classpath:database/tearDown.xml")
class TechnicalUserServiceTest extends DefaultSprintBootTest {

  @Autowired
  TechnicalUserService service;

  @Test
  void shouldSaveUser() {
    TechnicalUser user = TechnicalUser.builder()
            .username("teste@teste.com")
            .active(true)
            .password("test")
            .build();

    Assertions.assertDoesNotThrow(() -> service.signUp(user));
  }
}
