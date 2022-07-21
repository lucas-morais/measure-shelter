package com.agrotechfields.measureshelter.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("imagem")
public class Imagem {
  @Id
  private String id;

  private String nome;

  private Binary imagem;

  public Imagem(String nome) {
    this.nome = nome;
  }

  public Imagem() {
  }
  
  /** constructor. */
  public Imagem(String id, String nome, Binary imagem) {
    this.id = id;
    this.nome = nome;
    this.imagem = imagem;
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

  public Binary getImagem() {
    return imagem;
  }

  public void setImagem(Binary imagem) {
    this.imagem = imagem;
  }
  
}
