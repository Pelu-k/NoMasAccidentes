package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class Actividad {
  @Getter @Setter
  private int Id_Actividad;

  @Getter @Setter
  private String Nombre;

  @Getter @Setter
  private String Tipo;

  @Getter @Setter
  private Date Fecha_Creacion;

  @Getter @Setter
  private Date Fecha_Termino;

  @Getter @Setter
  private Date Fecha_Limite;

  @Getter @Setter
  private String Desc_Actividad;

  @Getter @Setter
  private String Insumos;

  @Getter @Setter
  private int Id_Asesoria_Fk;
}
