package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Profesional {
  @Getter @Setter
  private int Id_Profesional;

  @Getter @Setter
  private String Nombre;

  @Getter @Setter
  private String Apellido;

  @Getter @Setter
  private int Rut;

  @Getter @Setter
  private String RutDV;

  @Getter @Setter
  private int Id_Usuario_Fk;
}
