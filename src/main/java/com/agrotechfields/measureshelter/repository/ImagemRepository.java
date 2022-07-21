package com.agrotechfields.measureshelter.repository;

import com.agrotechfields.measureshelter.model.Imagem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagemRepository extends MongoRepository<Imagem, String> {

}
