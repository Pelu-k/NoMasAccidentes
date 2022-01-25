package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Administrador {
  @Getter @Setter
  private int id;

  @Getter @Setter
  private String nombre;

  @Getter @Setter
  private String apellido;

  @Getter @Setter
  private String cargo;

  @Getter @Setter
  private int rut;

  @Getter @Setter
  private String dv;

  @Getter @Setter
  private int idUsuarioFK;
}
