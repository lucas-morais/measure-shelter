package com.agrotechfields.measureshelter.dto;

public class ErrorDto {
  
  private String mensagem;
  private int status;
  
  public ErrorDto(String mensagem) {
    this.mensagem = mensagem;
  }

  public String getMensagem() {
    return mensagem;
  }

  public int getStatus() {
    return status;
  }
  
}
