package com.sooft.challenge.infrastructure.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Document(collection = "transfers")
public class TransferDocument {

  @Id
  private UUID id;

  private Date transferDate;

  private double amount;

  private UUID companyId;

  private String debitAccount;

  private String creditAccount;
}
