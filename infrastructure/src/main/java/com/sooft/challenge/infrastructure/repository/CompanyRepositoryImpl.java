package com.sooft.challenge.infrastructure.repository;

import com.sooft.challenge.domain.entity.Company;
import com.sooft.challenge.domain.repository.CompanyRepository;
import com.sooft.challenge.infrastructure.document.CompanyDocument;
import com.sooft.challenge.infrastructure.document.TransferDocument;
import com.sooft.challenge.infrastructure.repository.mapper.CompanyDocumentMapper;
import com.sooft.challenge.infrastructure.repository.mongo.CompanyMongoRepository;
import com.sooft.challenge.infrastructure.repository.mongo.TransferMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {

  private final CompanyMongoRepository companyMongoRepository;

  private final TransferMongoRepository transferMongoRepository;

  private final CompanyDocumentMapper documentMapper;

  @Override
  public Company create(Company company) {
    CompanyDocument companyDocument = companyMongoRepository.save(documentMapper.toDocument(company));
    return documentMapper.toDomain(companyDocument);
  }

  @Override
  public List<Company> getCompanies() {
    return companyMongoRepository.findAll().stream().map(documentMapper::toDomain).toList();
  }

  @Override
  public List<Company> getCompaniesByRegistrationDate(Date date) {
    List<CompanyDocument> companies = companyMongoRepository.findByRegistrationDateAfter(date);
    return companies.stream().map(documentMapper::toDomain).toList();
  }

  @Override
  public List<Company> getCompaniesByTransferDate(Date date) {
    List<TransferDocument> transfers = transferMongoRepository.findByTransferDateAfterDistinctByCompanyId(date);
    List<CompanyDocument> companies = transfers.stream()
        .map(transfer -> companyMongoRepository.findById(transfer.getCompanyId()))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());
    return companies.stream().map(documentMapper::toDomain).toList();
  }
}
