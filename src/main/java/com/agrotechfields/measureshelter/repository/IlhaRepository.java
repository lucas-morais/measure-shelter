package com.agrotechfields.measureshelter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agrotechfields.measureshelter.model.Ilha;
@Repository
public interface IlhaRepository  extends MongoRepository<Ilha, String> {
  
}
