package com.agrotechfields.measureshelter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Medicao")
public class Medicao {

  @Id
  private String id;
  private float temperatura;
  private float umidadeAr;
  private float umidadeSolo;

  public Medicao(String id, float temperatura, float umidadeAr, float umidadeSolo) {
    super();
    this.id = id;
    this.temperatura = temperatura;
    this.umidadeAr = umidadeAr;
    this.umidadeSolo = umidadeSolo;
  }

  public float getTemperatura() {
    return temperatura;
  }

  public void setTemperatura(float temperatura) {
    this.temperatura = temperatura;
  }

  public float getUmidadeAr() {
    return umidadeAr;
  }

  public void setUmidadeAr(float umidadeAr) {
    this.umidadeAr = umidadeAr;
  }

  public float getUmidadeSolo() {
    return umidadeSolo;
  }

  public void setUmidadeSolo(float umidadeSolo) {
    this.umidadeSolo = umidadeSolo;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}