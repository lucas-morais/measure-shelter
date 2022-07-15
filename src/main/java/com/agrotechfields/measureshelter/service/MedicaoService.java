package com.agrotechfields.measureshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agrotechfields.measureshelter.model.Medicao;


import com.agrotechfields.measureshelter.repository.MedicaoRepository;

@Service
public class MedicaoService {

  @Autowired
  MedicaoRepository medicaoRepository;

  public List<Medicao> listar() {
    return medicaoRepository.findAll();
  }
}
