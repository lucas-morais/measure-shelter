package com.agrotechfields.measureshelter.error;

public class InternalServerErrorException extends RuntimeException{

  public InternalServerErrorException(String message) {
    super(message);
  }
}
