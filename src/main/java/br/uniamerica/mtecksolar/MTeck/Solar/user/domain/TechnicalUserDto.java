package br.uniamerica.mtecksolar.MTeck.Solar.user.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TechnicalUserDto {

  private String email;
  private String password;
}
