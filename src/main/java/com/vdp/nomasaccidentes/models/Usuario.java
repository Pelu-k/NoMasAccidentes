package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Usuario {
  @Getter @Setter
  private int Id_Usuario;

  @Getter @Setter
  private String Username;

  @Getter @Setter
  private String HashPW;

  @Getter @Setter
  private int Rol;
}
