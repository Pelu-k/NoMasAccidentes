package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Asistente {
  @Getter @Setter
  private int idAsistente;

  @Getter @Setter
  private String nombre;

  @Getter @Setter
  private String apellido;

  @Getter @Setter
  private int rut;

  @Getter @Setter
  private String rutDv;
}
