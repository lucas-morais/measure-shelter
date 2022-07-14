package com.agrotechfields.measureshelter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agrotechfields.measureshelter.dto.IlhaDto;
import com.agrotechfields.measureshelter.form.IlhaForm;
import com.agrotechfields.measureshelter.model.Ilha;
import com.agrotechfields.measureshelter.repository.IlhaRepository;

@Service
public class IlhaService {

  @Autowired
  private IlhaRepository ilhaRepository;

  public List<Ilha> listar() {
    return ilhaRepository.findAll();
  }

  @Transactional
  public IlhaDto cadastrar(IlhaForm ilhaForm) {
    Ilha ilha = ilhaRepository.save(ilhaForm.converter());
    return new IlhaDto(ilha);
  }

  public IlhaDto buscarPorId(String id) {
    Optional<Ilha> ilha = ilhaRepository.findById(id);
    return new IlhaDto(ilha.get());
  }

  @Transactional
  public void deletar(String id) {
    ilhaRepository.deleteById(id);
  }

  @Transactional
  public IlhaDto Atualizar(Ilha ilha, String id) {
    Ilha ilhaEncontrada = ilhaRepository.findById(id).get();
    ilhaEncontrada.setLatitude(ilha.getLatitude());
    ilhaEncontrada.setLongitude(ilha.getLongitude());
    ilhaEncontrada.setMedicoes(ilha.getMedicoes());
    ilhaEncontrada.setNome(ilha.getNome());
    ilhaEncontrada.setOperante(ilha.isOperante());

    return new IlhaDto(ilhaEncontrada);
  }
}
