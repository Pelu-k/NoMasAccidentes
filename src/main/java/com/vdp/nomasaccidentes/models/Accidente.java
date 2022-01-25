package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class Accidente {
  @Getter @Setter
  private int id;

  @Getter @Setter
  private String descripcion;

  @Getter @Setter
  private Date fechaAccidente;

  @Getter @Setter
  private int idClienteFk;
}
