package com.agrotechfields.measureshelter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agrotechfields.measureshelter.model.Ilha;

public interface ilhaRepository  extends MongoRepository<Ilha, String> {
  
}
