package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class EspecialidadProfesional {
  @Getter @Setter
  private int idEspecialidadProfecional;

  @Getter @Setter
  private int idProfesionalFk;

  @Getter @Setter
  private int idEspecialidadFk;
}
