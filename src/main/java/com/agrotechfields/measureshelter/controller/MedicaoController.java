package com.agrotechfields.measureshelter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
