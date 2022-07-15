package com.agrotechfields.measureshelter.service;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.agrotechfields.measureshelter.model.Imagem;
import com.agrotechfields.measureshelter.repository.ImagemRepository;

@Service
public class ImagemService {
  @Autowired
  private ImagemRepository imagemRepository;

  public String addImagem(String nome, MultipartFile file) throws IOException {
    Imagem imagem = new Imagem(nome);
    imagem.setImagem(
        new Binary(BsonBinarySubType.BINARY, file.getBytes()));
    imagem = imagemRepository.insert(imagem);
    return imagem.getId();
  }

  public Imagem buscarImagem(String id) {
    return imagemRepository.findById(id).get();
  }
}
