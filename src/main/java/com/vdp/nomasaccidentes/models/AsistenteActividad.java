package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class AsistenteActividad {
  @Getter @Setter
  private int idAsistenteActividad;

  @Getter @Setter
  private int idAsistenteFk;

  @Getter @Setter
  private int idActividadFk;
}
