package com.agrotechfields.measureshelter.controller;

import java.io.IOException;
import java.util.Base64;

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

  @PostMapping("/imagem/{nome}")
  public String addPhoto(@PathVariable("nome") String nome,
      @RequestParam("image") MultipartFile image, Model model)
      throws IOException {
    String id = imagemService.addImagem(nome, image);
    return id;
  }

  @GetMapping("/imagem/{id}")
  public ResponseEntity<Imagem> getPhoto(@PathVariable String id, Model model) {
    Imagem imagem = imagemService.buscarImagem(id);
    model.addAttribute("nome", imagem.getNome());
    model.addAttribute("image",imagem.getImagem().getData());
    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagem);
  }

}
