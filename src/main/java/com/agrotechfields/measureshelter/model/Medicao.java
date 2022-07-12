package com.agrotechfields.measureshelter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Medicao")
public class Medicao {
  
  @Id
  private String id;
  private float valor;
  private TipoDeMedicao tipoDeMedicao;
  
  public Medicao(String id, float valor, TipoDeMedicao tipoDeMedicao) {
    super();
    this.id = id;
    this.valor = valor;
    this.tipoDeMedicao = tipoDeMedicao;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public float getValor() {
    return valor;
  }

  public void setValor(float valor) {
    this.valor = valor;
  }

  public TipoDeMedicao getTipoDeMedicao() {
    return tipoDeMedicao;
  }

  public void setTipoDeMedicao(TipoDeMedicao tipoDeMedicao) {
    this.tipoDeMedicao = tipoDeMedicao;
  }
  
}