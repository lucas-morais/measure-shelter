package com.agrotechfields.measureshelter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agrotechfields.measureshelter.model.Medicao;
@Repository
public interface MedicaoRepository  extends MongoRepository<Medicao, String> {
  
}
