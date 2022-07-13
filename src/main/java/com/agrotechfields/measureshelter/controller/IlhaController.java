package com.agrotechfields.measureshelter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrotechfields.measureshelter.model.Ilha;
import com.agrotechfields.measureshelter.service.IlhaService;

@RestController
public class IlhaController {

  @Autowired
  private IlhaService ilhaService;

  @GetMapping("/ilhas")
  public ResponseEntity<List<Ilha>> listar() {
    List<Ilha> ilhas = ilhaService.listar();
    return ResponseEntity.ok(ilhas);
  }
}
