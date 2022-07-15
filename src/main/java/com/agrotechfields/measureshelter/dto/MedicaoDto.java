package com.agrotechfields.measureshelter.dto;

import com.agrotechfields.measureshelter.model.Medicao;

public class MedicaoDto {
  private String id;
  private float temperatura;
  private float umidadeAr;
  private float umidadeSolo;

  public MedicaoDto(Medicao medicao) {
      this.id = medicao.getId();
      this.temperatura = medicao.getTemperatura();
      this.umidadeAr = medicao.getUmidadeAr();
      this.umidadeSolo = medicao.getUmidadeSolo();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

}
