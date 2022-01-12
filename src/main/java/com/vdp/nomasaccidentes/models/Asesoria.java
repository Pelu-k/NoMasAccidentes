package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Asesoria {
  @Getter @Setter
  private int Id_Asesoria;

  @Getter @Setter
  private String Nombre;

  @Getter @Setter
  private int Numero;

  @Getter @Setter
  private String Desc_Asesoria;

  @Getter @Setter
  private Date Fecha_Creacion;

  @Getter @Setter
  private Date Fecha_Termino;

  @Getter @Setter
  private Date Fecha_Limite;

  @Getter @Setter
  private int Id_Cliente_Fk;

  @Getter @Setter
  private int Id_Profesional_Fk;
}
