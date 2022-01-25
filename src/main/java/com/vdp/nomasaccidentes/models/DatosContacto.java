package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class DatosContacto {
  @Getter @Setter
  private int idDatos;

  @Getter @Setter
  private String codigoArea;

  @Getter @Setter
  private int telefono;

  @Getter @Setter
  private String email;

  @Getter @Setter
  private String calleDireccion;

  @Getter @Setter
  private int numeroDireccion;

  @Getter @Setter
  private int numeroDepartamento;

  @Getter @Setter
  private String torre;

  @Getter @Setter
  private String comentario;

  @Getter @Setter
  private int idComunaFk;
}
