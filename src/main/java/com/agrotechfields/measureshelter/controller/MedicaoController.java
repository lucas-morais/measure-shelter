package com.agrotechfields.measureshelter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agrotechfields.measureshelter.dto.MedicaoDto;
import com.agrotechfields.measureshelter.form.MedicaoForm;
import com.agrotechfields.measureshelter.model.Medicao;
import com.agrotechfields.measureshelter.service.MedicaoService;

@RestController
@RequestMapping("/medicao")
public class MedicaoController {

  @Autowired
  MedicaoService medicaoService;

  @GetMapping
  public ResponseEntity<List<Medicao>> listar() {
    List<Medicao> medicoes = medicaoService.listar();

    return ResponseEntity.ok(medicoes);
  }

  @PostMapping
  public ResponseEntity<MedicaoDto> cadastrar(@RequestBody MedicaoForm medicaoForm) {
    MedicaoDto medicao = medicaoService.cadastrar(medicaoForm);

    return ResponseEntity.status(201).body(medicao);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MedicaoDto> buscarPorId(@PathVariable String id) {
    MedicaoDto medicao = medicaoService.buscarPorId(id);

    return ResponseEntity.ok(medicao);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deletar(@PathVariable String id) {
    medicaoService.deletar(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<MedicaoDto> cadastrar(@RequestBody Medicao medicao, @PathVariable String id) {
    MedicaoDto medicaoAtualizada = medicaoService.atualizar(medicao, id);

    return ResponseEntity.ok(medicaoAtualizada);
  }
}
