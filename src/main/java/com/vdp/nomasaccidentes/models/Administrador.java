package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Administrador {
  @Getter @Setter
  private int Id_Adminn;

  @Getter @Setter
  private String Nombre;

  @Getter @Setter
  private String Apellido;

  @Getter @Setter
  private String Cargo;

  @Getter @Setter
  private long Rut;

  @Getter @Setter
  private String RutDV;

  @Getter @Setter
  private int Id_Usuario_Fk;
}
