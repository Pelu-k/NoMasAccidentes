package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class Asesoria {
  @Getter @Setter
  private int idAsesoria;

  @Getter @Setter
  private String nombre;

  @Getter @Setter
  private int numero;

  @Getter @Setter
  private String descChecklist;

  @Getter @Setter
  private Date fechaCreacion;

  @Getter @Setter
  private Date fechaLimite;

  @Getter @Setter
  private Date fechaTermino;

  @Getter @Setter
  private int valor;

  @Getter @Setter
  private int idClienteFk;

  @Getter @Setter
  private int idProfesionalFk;
}
