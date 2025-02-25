package com.sooft.challenge.infrastructure.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Document(collection = "companies")
public class CompanyDocument {

  @Id
  private UUID id;

  private String cuit;

  private String name;

  private Date registrationDate;
}
