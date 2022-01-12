package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


public class Contrato {
  @Getter @Setter
  private int Id_Contrato;

  @Getter @Setter
  private String Estado_Contrato;

  @Getter @Setter
  private Date Fecha_Inicio;

  @Getter @Setter
  private Date Fecha_Termino;

  @Getter @Setter
  private int Id_Usuario_Fk;
}
