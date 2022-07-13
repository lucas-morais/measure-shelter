package com.agrotechfields.measureshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrotechfields.measureshelter.model.Ilha;
import com.agrotechfields.measureshelter.repository.IlhaRepository;

@Service
public class IlhaService {
  @Autowired
  private IlhaRepository ilhaRepository;
  public List<Ilha> listar() {
    return ilhaRepository.findAll();
  }
}
