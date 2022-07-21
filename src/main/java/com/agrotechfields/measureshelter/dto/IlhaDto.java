package com.agrotechfields.measureshelter.dto;

import com.agrotechfields.measureshelter.model.Ilha;
import com.agrotechfields.measureshelter.model.Medicao;
import java.util.List;


public class IlhaDto {

  private String id;
  private String nome;
  private String latitude;
  private String longitude;
  private boolean operante;
  
  private List<Medicao> medicoes;

  /** Construct. */
  public IlhaDto(Ilha ilha) {
    this.id = ilha.getId();
    this.nome = ilha.getNome();
    this.latitude = ilha.getLatitude();
    this.longitude = ilha.getLongitude();
    this.medicoes = ilha.getMedicoes();
    this.operante = ilha.isOperante();
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
  
  public boolean isOperante() {
    return operante;
  }

  public void setOperante(boolean operante) {
    this.operante = operante;
  }
}
