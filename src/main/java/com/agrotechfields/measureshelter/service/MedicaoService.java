package com.agrotechfields.measureshelter.service;

import com.agrotechfields.measureshelter.dto.MedicaoDto;
import com.agrotechfields.measureshelter.error.NotFoundException;
import com.agrotechfields.measureshelter.form.MedicaoForm;
import com.agrotechfields.measureshelter.model.Ilha;
import com.agrotechfields.measureshelter.model.Medicao;
import com.agrotechfields.measureshelter.repository.IlhaRepository;
import com.agrotechfields.measureshelter.repository.MedicaoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicaoService {

  @Autowired
  MedicaoRepository medicaoRepository;

  @Autowired
  IlhaRepository ilhaRepository;

  public List<Medicao> listar() {
    return medicaoRepository.findAll();
  }

  /** Cadastra a medicao. */
  @Transactional
  public MedicaoDto cadastrar(MedicaoForm medicaoForm) {
    Ilha ilha = ilhaRepository.findById(medicaoForm.getIlhaId()).get();
    Medicao medicao = medicaoRepository.save(medicaoForm.converter());
    ilha.addMedicao(medicao);
    ilhaRepository.save(ilha);
    return new MedicaoDto(medicao);
  }

  /**Busca medicao por id.*/
  public MedicaoDto buscarPorId(String id) {
    try {
      Optional<Medicao> medicao = medicaoRepository.findById(id);
      return new MedicaoDto(medicao.get());
    } catch (Exception e) {
      throw new NotFoundException("Medição não encontrada.");
    }
  }

  /**Deleta medicao.*/
  @Transactional
  public void deletar(String id) {
    try {
      medicaoRepository.deleteById(id);
    } catch (Exception e) {
      throw new NotFoundException("Medição não encontrada.");
    }
  }

  /** Atualiza a medicao. */
  @Transactional
  public MedicaoDto atualizar(Medicao medicao, String id) {
    try {
      Medicao medicaoEncontrada = medicaoRepository.findById(id).get();
      medicaoEncontrada.setTemperatura(medicao.getTemperatura());
      medicaoEncontrada.setUmidadeAr(medicao.getUmidadeAr());
      medicaoEncontrada.setUmidadeSolo(medicao.getUmidadeSolo());
  
      medicaoRepository.save(medicaoEncontrada);
  
      return new MedicaoDto(medicaoEncontrada);
    } catch (Exception e) {
      throw new NotFoundException("Medição não encontrada.");
    }

  }
}
