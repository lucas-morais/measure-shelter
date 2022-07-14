package com.agrotechfields.measureshelter.dto;

public class IlhaStatusDto {
  private String id;
  private boolean status;

  public IlhaStatusDto(String id, boolean status) {
    this.id = id;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isStatus() {
    return status;
  }
  
  public void setStatus(boolean status) {
    this.status = status;
  }

}
