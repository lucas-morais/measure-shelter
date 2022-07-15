package com.agrotechfields.measureshelter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agrotechfields.measureshelter.dto.MedicaoDto;
import com.agrotechfields.measureshelter.form.MedicaoForm;
import com.agrotechfields.measureshelter.model.Medicao;


import com.agrotechfields.measureshelter.repository.MedicaoRepository;

@Service
public class MedicaoService {

  @Autowired
  MedicaoRepository medicaoRepository;

  public List<Medicao> listar() {
    return medicaoRepository.findAll();
  }

  @Transactional
  public MedicaoDto cadastrar(MedicaoForm medicaoForm) {
    Medicao medicao = medicaoRepository.save(medicaoForm.converter());

    return new MedicaoDto(medicao);
  }

  public MedicaoDto buscarPorId(String id) {
    Optional<Medicao> medicao = medicaoRepository.findById(id);

    return new MedicaoDto(medicao.get());
  }

  @Transactional
  public void deletar(String id) {
    medicaoRepository.deleteById(id);
  }

  @Transactional
  public MedicaoDto atualizar(Medicao medicao, String id) {
    Medicao medicaoEncontrada = medicaoRepository.findById(id).get();
    medicaoEncontrada.setTemperatura(medicao.getTemperatura());
    medicaoEncontrada.setUmidadeAr(medicao.getTemperatura());
    medicaoEncontrada.setUmidadeSolo(medicao.getUmidadeSolo());

    return new MedicaoDto(medicaoEncontrada);
  }
}
