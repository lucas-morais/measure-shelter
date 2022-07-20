package com.agrotechfields.measureshelter.service;

import com.agrotechfields.measureshelter.dto.IlhaDto;
import com.agrotechfields.measureshelter.dto.IlhaStatusDto;
import com.agrotechfields.measureshelter.form.IlhaForm;
import com.agrotechfields.measureshelter.model.Ilha;
import com.agrotechfields.measureshelter.repository.IlhaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  /** Atualiza ilha. */
  @Transactional
  public IlhaDto atualizar(Ilha ilha, String id) {
    Ilha ilhaEncontrada = ilhaRepository.findById(id).get();
    ilhaEncontrada.setLatitude(ilha.getLatitude());
    ilhaEncontrada.setLongitude(ilha.getLongitude());
    ilhaEncontrada.setMedicoes(ilha.getMedicoes());
    ilhaEncontrada.setNome(ilha.getNome());
    ilhaEncontrada.setOperante(ilha.isOperante());

    ilhaRepository.save(ilhaEncontrada);

    return new IlhaDto(ilhaEncontrada);
  }

  /** Altera status da ilha. */
  @Transactional
  public IlhaStatusDto status(boolean status, String id) {
    Ilha ilhaEncontrada = ilhaRepository.findById(id).get();
    ilhaEncontrada.setOperante(status);
    ilhaRepository.save(ilhaEncontrada);
    return new IlhaStatusDto(ilhaEncontrada.getId(), ilhaEncontrada.isOperante());
  }
}
