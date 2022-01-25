package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class Contrato {
  @Getter @Setter
  private int id;

  @Getter @Setter
  private Date fechaInicio;

  @Getter @Setter
  private Date fechaTermino;

  @Getter @Setter
  private int idEstadoFK;

  @Getter @Setter
  private int idUsuarioFK;
}
