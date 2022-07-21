package com.agrotechfields.measureshelter.repository;

import com.agrotechfields.measureshelter.model.Medicao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicaoRepository extends MongoRepository<Medicao, String> {

}
