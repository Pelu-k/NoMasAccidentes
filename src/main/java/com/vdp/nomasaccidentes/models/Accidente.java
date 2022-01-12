package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class Accidente {
  @Getter @Setter
  private int Id_Accidente;

  @Getter @Setter
  private String Descripcion;

  @Getter @Setter
  private Date Fecha_Accidente;

  @Getter @Setter
  private int Id_Cliente_Fk;
}
