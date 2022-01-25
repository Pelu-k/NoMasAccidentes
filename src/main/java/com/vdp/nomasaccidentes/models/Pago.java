package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class Pago {
  @Getter @Setter
  private int idPago;

  @Getter @Setter
  private String descripcion;

  @Getter @Setter
  private int monto;

  @Getter @Setter
  private int comisionProfesional;

  @Getter @Setter
  private Date fechaCreacion;

  @Getter @Setter
  private Date fechaPago;

  @Getter @Setter
  private Date fechaLimite;

  @Getter @Setter
  private int idAsesoriaFk;
}
