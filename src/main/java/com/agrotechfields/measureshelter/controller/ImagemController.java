package com.agrotechfields.measureshelter.controller;

import com.agrotechfields.measureshelter.dto.ImagemDto;
import com.agrotechfields.measureshelter.model.Imagem;
import com.agrotechfields.measureshelter.service.ImagemService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/imagens")
public class ImagemController {
  @Autowired
  private ImagemService imagemService;

  @PostMapping("/{nome}")
  public ResponseEntity<ImagemDto> addPhoto(@PathVariable("nome") String nome,
      @RequestParam("imagem") MultipartFile imagem)
      throws IOException {
    ImagemDto imagemDto = imagemService.adicionar(nome, imagem);
    return ResponseEntity.status(201).body(imagemDto);
  }

  @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
  public ResponseEntity<byte[]> getPhoto(@PathVariable String id) {
    Imagem imagem = imagemService.buscarImagem(id);
    return ResponseEntity.ok().body(imagem.getImagem().getData());
  }

  @GetMapping
  public ResponseEntity<List<ImagemDto>> listar() {
    List<ImagemDto> imagens = imagemService.listarImagens();
    return ResponseEntity.ok(imagens);
  }
}
