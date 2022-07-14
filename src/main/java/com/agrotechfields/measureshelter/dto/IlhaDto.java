package com.agrotechfields.measureshelter.dto;

import java.util.ArrayList;
import java.util.List;

import com.agrotechfields.measureshelter.model.Medicao;

public class IlhaDto {

  private String id;
  private String nome;
  private String latitude;
  private String longitude;
  private List<Medicao> medicoes;

  public IlhaDto(String id, String nome, String latitude, String longitude, List<Medicao> medicoes) {
    this.id = id;
    this.nome = nome;
    this.latitude = latitude;
    this.longitude = longitude;
    this.medicoes = medicoes;
  }

  public String getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public List<Medicao> getMedicoes() {
    return medicoes;
  }

}
