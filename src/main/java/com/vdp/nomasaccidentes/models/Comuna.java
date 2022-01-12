package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Comuna {
  @Getter @Setter
  private int Id_Comuna;

  @Getter @Setter
  private String Nombre_Comuna;

  @Getter @Setter
  private int Id_Ciudad_Fk;
}
