package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Asistente {
  @Getter @Setter
  private int Id_Asistente;

  @Getter @Setter
  private String Nombre_A;

  @Getter @Setter
  private String Apellido_A;

  @Getter @Setter
  private int Rut;

  @Getter @Setter
  private String RutDV;

  @Getter @Setter
  private int Id_Actividad_Fk;
}
