package com.sooft.challenge.infrastructure.repository.mongo;

import com.sooft.challenge.infrastructure.document.TransferDocument;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransferMongoRepository extends MongoRepository<TransferDocument, UUID> {

  List<TransferDocument> findAll();

  @Aggregation(pipeline = {
      "{ $match: { transferDate: { $gt: ?0 } } }",
      "{ $group: { _id: '$companyId', doc: { $first: '$$ROOT' } } }",
      "{ $replaceWith: '$doc' }"
  })
  List<TransferDocument> findByTransferDateAfterDistinctByCompanyId(Date transferDate);
}
