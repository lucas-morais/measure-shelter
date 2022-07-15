package com.agrotechfields.measureshelter.dto;

import com.agrotechfields.measureshelter.model.Imagem;

public class ImagemDto {
  private String id;
  private String nome;
  
  public ImagemDto(Imagem imagem) {
    this.id = imagem.getId();
    this.nome = imagem.getNome();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  
}
