package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Profesional {
  @Getter @Setter
  private int idProfesional;

  @Getter @Setter
  private String nombre;

  @Getter @Setter
  private String apellido;

  @Getter @Setter
  private int rut;

  @Getter @Setter
  private String rutDv;

  @Getter @Setter
  private int idUsuarioFk;
}
