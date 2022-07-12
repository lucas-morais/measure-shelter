package com.agrotechfields.measureshelter.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Ilha")
public class Ilha {
  
    @Id
    private String id;
    private String name;
    private String latitude;
    private String longitude;
    private boolean operante;
    @DBRef
    private List<Medicao> medicoes;
    
    public Ilha(String id, String name, String latitude, String longitude, boolean operante,
        List<Medicao> medicoes) {
      super();
      this.id = id;
      this.name = name;
      this.latitude = latitude;
      this.longitude = longitude;
      this.operante = operante;
      this.medicoes = medicoes;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
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

    public boolean isOperante() {
      return operante;
    }

    public void setOperante(boolean operante) {
      this.operante = operante;
    }

    public List<Medicao> getMedicoes() {
      return medicoes;
    }

    public void setMedicoes(List<Medicao> medicoes) {
      this.medicoes = medicoes;
    }
    
}