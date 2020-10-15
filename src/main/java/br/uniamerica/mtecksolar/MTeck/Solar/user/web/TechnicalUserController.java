package br.uniamerica.mtecksolar.MTeck.Solar.user.web;

import br.uniamerica.mtecksolar.MTeck.Solar.config.controller.DefaultController;
import br.uniamerica.mtecksolar.MTeck.Solar.user.TechnicalUser;
import br.uniamerica.mtecksolar.MTeck.Solar.user.domain.TechnicalUserDto;
import br.uniamerica.mtecksolar.MTeck.Solar.user.service.TechnicalUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class TechnicalUserController extends DefaultController<TechnicalUser, TechnicalUserService> {

  @PostMapping
  public ResponseEntity<TechnicalUserDto> save(@RequestBody TechnicalUserDto user) {
    return ResponseEntity.ok(user);
  }
}
