package com.sooft.challenge.application;

import com.sooft.challenge.domain.entity.Company;
import com.sooft.challenge.domain.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CompanyCommandHandler {

  private final CompanyRepository companyRepository;

  public Company registerCompany(Company company) {
    company.setId(UUID.randomUUID());
    return companyRepository.create(company);
  }
}
