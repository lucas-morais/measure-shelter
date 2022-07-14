package com.agrotechfields.measureshelter.form;

public class IlhaStatusForm {
  private boolean status;

  public IlhaStatusForm( boolean status) {
    this.status = status;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

}