package com.sooft.challenge.contract.mapper;

import com.sooft.challenge.contract.dto.CompanyDto;
import com.sooft.challenge.domain.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyDtoMapper {

  Company toEntity(CompanyDto companyDto);

  CompanyDto toDto(Company company);
}
