package com.sooft.challenge.infrastructure.repository.mongo;

import com.sooft.challenge.infrastructure.document.CompanyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyMongoRepository extends MongoRepository<CompanyDocument, UUID> {

  List<CompanyDocument> findAll();

  Optional<CompanyDocument> findById(UUID id);

  List<CompanyDocument> findByRegistrationDateAfter(Date date);
}
