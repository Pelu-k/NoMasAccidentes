package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Especialidad {
  @Getter @Setter
  private int idEspecialidad;

  @Getter @Setter
  private String nombre;

  @Getter @Setter
  private String descEspecialidad;
}
