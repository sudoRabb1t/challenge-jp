package com.sooft.challenge.contract;

import com.sooft.challenge.application.CompanyCommandHandler;
import com.sooft.challenge.application.CompanyQueryHandler;
import com.sooft.challenge.contract.dto.CompanyDto;
import com.sooft.challenge.contract.mapper.CompanyDtoMapper;
import com.sooft.challenge.domain.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyController {

  private final CompanyCommandHandler companyCommandHandler;

  private final CompanyQueryHandler companyQueryHandler;

  private final CompanyDtoMapper mapper;

  @PostMapping(value = "/companies")
  public ResponseEntity<CompanyDto> registerCompany(@RequestBody CompanyDto companyDto) {
    Company company = mapper.toEntity(companyDto);
    Company registered = companyCommandHandler.registerCompany(company);
    return ResponseEntity.ok(mapper.toDto(registered));
  }

  @GetMapping(value = "/companies")
  public ResponseEntity<List<CompanyDto>> getCompanies(
      @RequestParam(required = false) String transfersDate,
      @RequestParam(required = false) String registrationDate
  ) {
    if (transfersDate == null && registrationDate == null) {
      List<Company> companies = companyQueryHandler.getAllCompanies();
      return ResponseEntity.ok(companies.stream().map(mapper::toDto).toList());
    }

    if (transfersDate != null) {
      Date date = getParsedDate(transfersDate);
      List<Company> companies = companyQueryHandler.getCompaniesByTransfersDate(date);
      return ResponseEntity.ok(companies.stream().map(mapper::toDto).toList());
    } else {
      Date date = getParsedDate(registrationDate);
      List<Company> companies = companyQueryHandler.getCompaniesByRegistrationDate(date);
      return ResponseEntity.ok(companies.stream().map(mapper::toDto).toList());
    }
  }

  private Date getParsedDate(String date) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    Date formattedDate;
    try {
      formattedDate = format.parse(date);
    } catch (ParseException e) {
      throw new RuntimeException("Format date error", e);
    }
    return formattedDate;
  }
}
