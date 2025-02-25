package com.sooft.challenge.domain.repository;

import com.sooft.challenge.domain.entity.Company;

import java.util.Date;
import java.util.List;

public interface CompanyRepository {

  Company create(Company company);

  List<Company> getCompanies();

  List<Company> getCompaniesByRegistrationDate(Date registrationDate);

  List<Company> getCompaniesByTransferDate(Date transferDate);
}
