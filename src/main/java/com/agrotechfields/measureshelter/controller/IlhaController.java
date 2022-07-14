package com.agrotechfields.measureshelter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrotechfields.form.IlhaForm;
import com.agrotechfields.measureshelter.dto.IlhaDto;
import com.agrotechfields.measureshelter.model.Ilha;
import com.agrotechfields.measureshelter.service.IlhaService;

@RestController
@RequestMapping("/ilhas")
public class IlhaController {

  @Autowired
  private IlhaService ilhaService;

  @GetMapping
  public ResponseEntity<List<Ilha>> listar() {
    List<Ilha> ilhas = ilhaService.listar();
    return ResponseEntity.ok(ilhas);
  }

  @PostMapping
  public ResponseEntity<IlhaDto> cadastrar(@RequestBody IlhaForm ilhaForm) {
    IlhaDto ilha = ilhaService.cadastrar(ilhaForm);
    return ResponseEntity.status(201).body(ilha);
  }
}
