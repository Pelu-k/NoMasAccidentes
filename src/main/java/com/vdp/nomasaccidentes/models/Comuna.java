package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Comuna {
  @Getter @Setter
  private int id;

  @Getter @Setter
  private String nombreComuna;

  @Getter @Setter
  private int idRegionFK;
}
