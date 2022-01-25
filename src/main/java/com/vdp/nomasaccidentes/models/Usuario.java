package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Usuario {
  @Getter @Setter
  private int idUsuario;

  @Getter @Setter
  private String username;

  @Getter @Setter
  private String hashPw;

  @Getter @Setter
  private int rol;

  @Getter @Setter
  private int idEstadoFk;

  @Getter @Setter
  private int idDatosFk;
}
