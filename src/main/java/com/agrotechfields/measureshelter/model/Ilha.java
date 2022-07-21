package com.agrotechfields.measureshelter.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ilha")
public class Ilha {

  @Id
  private String id;
  private String nome;
  private String latitude;
  private String longitude;
  private boolean operante;
  @DBRef
  private List<Medicao> medicoes;

  public Ilha() {
    this.operante = true;
    this.medicoes = new ArrayList<>();
  }

  /** Constructor. */
  public Ilha(
      String id,
      String nome,
      String latitude,
      String longitude,
      boolean operante,
      List<Medicao> medicoes) {
    this.id = id;
    this.nome = nome;
    this.latitude = latitude;
    this.longitude = longitude;
    this.operante = operante;
    this.medicoes = medicoes;
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

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public boolean isOperante() {
    return operante;
  }

  public void setOperante(boolean operante) {
    this.operante = operante;
  }

  public List<Medicao> getMedicoes() {
    return medicoes;
  }

  public void setMedicoes(List<Medicao> medicoes) {
    this.medicoes = medicoes;
  }

  public void addMedicao(Medicao medicao) {
    this.medicoes.add(medicao);
  }

}