package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


public class PagoActividad {
  @Getter @Setter
  private int Id_Pago_Act;

  @Getter @Setter
  private String Descripcion;

  @Getter @Setter
  private int Monto;

  @Getter @Setter
  private int Comision_Profesional;

  @Getter @Setter
  private Date Fecha_Creacion;

  @Getter @Setter
  private Date Fecha_Pago;

  @Getter @Setter
  private Date Fecha_Limite;

  @Getter @Setter
  private int Id_Actividad_Fk;
}
