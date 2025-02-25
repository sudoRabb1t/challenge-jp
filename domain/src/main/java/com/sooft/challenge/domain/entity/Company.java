package com.sooft.challenge.domain.entity;

import java.util.Date;
import java.util.UUID;

public class Company {

  private UUID id;

  private String cuit;

  private String name;

  private Date registrationDate;

  public void setId(UUID id) {
    this.id = id;
  }
}
