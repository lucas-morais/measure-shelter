package com.agrotechfields.measureshelter.form;

import com.agrotechfields.measureshelter.model.Medicao;

public class MedicaoForm {
  
  private String ilhaId;
  private float temperatura;
  private float umidadeAr;
  private float umidadeSolo;
  
  public MedicaoForm(String ilhaId, float temperatura, float umidadeAr, float umidadeSolo) {
    this.ilhaId = ilhaId;
    this.temperatura = temperatura;
    this.umidadeAr = umidadeAr;
    this.umidadeSolo = umidadeSolo;
  }

  public String getIlhaId() {
    return ilhaId;
  }

  public void setIlhaId(String ilhaId) {
    this.ilhaId = ilhaId;
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

    /**
   * Converte.
   * @return medicao
   */
  public Medicao converter() {
    Medicao medicao = new Medicao();
    medicao.setTemperatura(temperatura);
    medicao.setUmidadeAr(umidadeAr);
    medicao.setUmidadeSolo(umidadeSolo);
    return medicao;
  }
}
