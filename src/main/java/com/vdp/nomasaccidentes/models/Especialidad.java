package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Especialidad {
  @Getter @Setter
  private int Id_Especialidad;

  @Getter @Setter
  private String Nombre;

  @Getter @Setter
  private String Desc_Especialidad;

  @Getter @Setter
  private int Id_Profesional_Fk;
}
