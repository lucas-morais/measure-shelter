package com.agrotechfields.measureshelter.repository;

import com.agrotechfields.measureshelter.model.Ilha;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IlhaRepository  extends MongoRepository<Ilha, String> {
  
}
