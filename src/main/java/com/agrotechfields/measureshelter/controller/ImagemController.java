package com.agrotechfields.measureshelter.controller;

import java.io.IOException;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agrotechfields.measureshelter.model.Imagem;
import com.agrotechfields.measureshelter.service.ImagemService;

@RestController
public class ImagemController {
  @Autowired
  private ImagemService imagemService;

  @PostMapping("/imagens/{nome}")
  public String addPhoto(@PathVariable("nome") String nome,
      @RequestParam("imagem") MultipartFile imagem)
      throws IOException {
    String id = imagemService.addImagem(nome, imagem);
    return id;
  }

  @GetMapping(
    value = "/imagens/{id}",
    produces = MediaType.IMAGE_JPEG_VALUE
  )
  public ResponseEntity<byte[]> getPhoto(@PathVariable String id) {
    Imagem imagem = imagemService.buscarImagem(id);
    
    return ResponseEntity.ok().body(imagem.getImagem().getData());
  }

}
