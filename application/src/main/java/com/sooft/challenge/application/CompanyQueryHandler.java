package com.sooft.challenge.application;

import com.sooft.challenge.domain.entity.Company;
import com.sooft.challenge.domain.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyQueryHandler {

  private final CompanyRepository repository;

  public List<Company> getAllCompanies() {
    return repository.getCompanies();
  }

  public List<Company> getCompaniesByTransfersDate(Date date) {
    return repository.getCompaniesByTransferDate(date);
  }

  public List<Company> getCompaniesByRegistrationDate(Date date) {
    return repository.getCompaniesByRegistrationDate(date);
  }
}
