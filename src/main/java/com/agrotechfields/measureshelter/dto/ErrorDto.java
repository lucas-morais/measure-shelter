package com.agrotechfields.measureshelter.dto;

public class ErrorDto {
  
  private String mensagem;
  private int status;
  
  public ErrorDto(String mensagem, int status) {
    this.mensagem = mensagem;
    this.status = status;
  }

  public String getMensagem() {
    return mensagem;
  }

  public int getStatus() {
    return status;
  }

  
  
}
