package br.uniamerica.mtecksolar.MTeck.Solar.config.controller;

import br.uniamerica.mtecksolar.MTeck.Solar.config.Model;
import br.uniamerica.mtecksolar.MTeck.Solar.config.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultController<T extends Model, S extends DefaultService<T>> {

  @Autowired
  protected S service;
}
