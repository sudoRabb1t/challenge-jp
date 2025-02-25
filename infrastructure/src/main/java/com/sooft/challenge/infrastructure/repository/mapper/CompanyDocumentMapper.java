package com.sooft.challenge.infrastructure.repository.mapper;

import com.sooft.challenge.domain.entity.Company;
import com.sooft.challenge.infrastructure.document.CompanyDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyDocumentMapper {

  Company toDomain(CompanyDocument companyDocument);

  CompanyDocument toDocument(Company company);
}
