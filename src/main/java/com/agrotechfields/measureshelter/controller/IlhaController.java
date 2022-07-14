package com.agrotechfields.measureshelter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agrotechfields.measureshelter.dto.IlhaDto;
import com.agrotechfields.measureshelter.dto.IlhaStatusDto;
import com.agrotechfields.measureshelter.form.IlhaForm;
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

  @GetMapping("/{id}")
  public ResponseEntity<IlhaDto> buscarPorId(@RequestParam String id) {
    IlhaDto ilha = ilhaService.buscarPorId(id);

    return ResponseEntity.ok(ilha);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deletar(@RequestParam String id ) {
    ilhaService.deletar(id);
  }

  @PostMapping("/{id}")
  public ResponseEntity<IlhaDto> atualizar(@RequestBody Ilha ilha, @RequestParam String id) {
    IlhaDto ilhaAtualizada = ilhaService.Atualizar(ilha, id);

    return ResponseEntity.ok(ilhaAtualizada);
  }

  @PostMapping("/{id}/status")
  public ResponseEntity<IlhaStatusDto> status(@RequestBody boolean status, @RequestParam String id) {
    IlhaStatusDto ilhaStatus = ilhaService.status(status, id);

    return ResponseEntity.ok(ilhaStatus);
  }
}
