package br.uniamerica.mtecksolar.MTeck.Solar.user.domain.repository;

import br.uniamerica.mtecksolar.MTeck.Solar.user.TechnicalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnialUserRepository extends JpaRepository<TechnicalUser, Long> {

  TechnicalUser findOneByUsername(String username);
}
