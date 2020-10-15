package br.uniamerica.mtecksolar.MTeck.Solar.user;

import br.uniamerica.mtecksolar.MTeck.Solar.config.Model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicalUser implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String email;

  private Boolean active;

}
