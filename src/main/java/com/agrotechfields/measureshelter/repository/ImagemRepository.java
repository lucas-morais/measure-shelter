package com.agrotechfields.measureshelter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agrotechfields.measureshelter.model.Imagem;

public interface ImagemRepository extends MongoRepository<Imagem, String>{
  
}
