package com.agrotechfields.measureshelter.form;

import com.agrotechfields.measureshelter.model.Ilha;

public class IlhaForm {
  private String nome;
  private String latitude;
  private String longitude;
  
  
  public IlhaForm(String nome, String latitude, String longitude) {
    this.nome = nome;
    this.latitude = latitude;
    this.longitude = longitude;
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

  /**
   * Convete.
   * @return ilha
   */
  public Ilha converter() {
    Ilha ilha = new Ilha();
    ilha.setNome(nome);
    ilha.setLatitude(latitude);
    ilha.setLongitude(longitude);
    return ilha;
  }
  
}
