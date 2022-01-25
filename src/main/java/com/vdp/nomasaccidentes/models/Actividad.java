package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class Actividad {
  @Getter @Setter
  private int idActividad;

  @Getter @Setter
  private String nombre;

  @Getter @Setter
  private int folio;

  @Getter @Setter
  private String valor;

  @Getter @Setter
  private String insumoChecklist;

  @Getter @Setter
  private String estado;

  @Getter @Setter
  private String tipo;

  @Getter @Setter
  private Date fechaCreacion;

  @Getter @Setter
  private Date fechaLimite;

  @Getter @Setter
  private Date fechaTermino;

  @Getter @Setter
  private String descActividad;

  @Getter @Setter
  private int idAsesoriaFk;

  public Actividad() {}
}
