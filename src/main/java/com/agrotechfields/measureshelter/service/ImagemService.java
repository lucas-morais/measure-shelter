package com.agrotechfields.measureshelter.service;

import com.agrotechfields.measureshelter.dto.ImagemDto;
import com.agrotechfields.measureshelter.error.NotFoundException;
import com.agrotechfields.measureshelter.model.Imagem;
import com.agrotechfields.measureshelter.repository.ImagemRepository;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImagemService {
  @Autowired
  private ImagemRepository imagemRepository;

  /** Adiciona imagem. */
  public ImagemDto adicionar(String nome, MultipartFile file) throws IOException {
    Imagem imagem = new Imagem(nome);
    imagem.setImagem(
        new Binary(BsonBinarySubType.BINARY, file.getBytes()));
    imagem = imagemRepository.insert(imagem);
    return new ImagemDto(imagem);
  }

  public Imagem buscarImagem(String id) {
    try {
      return imagemRepository.findById(id).get();
    } catch (Exception e) {
      throw new NotFoundException("Imagem não encontrada");
    }
  }


  public List<ImagemDto> listarImagens() {
    List<Imagem> imagens = imagemRepository.findAll();
    return imagens.stream().map(i -> new ImagemDto(i)).collect(Collectors.toList());
  }
}
