package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class PagoAsesoria {
  @Getter @Setter
  private int Id_Pago_Asesoria;

  @Getter @Setter
  private String Descripcion;

  @Getter @Setter
  private int Monto;

  @Getter @Setter
  private Date Fecha_Creacion;

  @Getter @Setter
  private Date Fecha_Pago;

  @Getter @Setter
  private Date Fecha_Limite;

  @Getter @Setter
  private int Id_Cliente_Fk;
}
