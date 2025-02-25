package com.sooft.challenge.contract.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CompanyDto {

  private String cuit;

  private String name;

  private Date registrationDate;
}
