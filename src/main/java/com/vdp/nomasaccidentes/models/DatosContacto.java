package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class DatosContacto {
  @Getter @Setter
  private int Id_Datos;

  @Getter @Setter
  private String Codigo_Area;

  @Getter @Setter
  private int Numero;

  @Getter @Setter
  private String Direccion;

  @Getter @Setter
  private int Numero_Direccion;

  @Getter @Setter
  private int Numero_Departamento;

  @Getter @Setter
  private String Letra_Departamento;

  @Getter @Setter
  private String Comentario;

  @Getter @Setter
  private int Id_Ciudad_Fk;

  @Getter @Setter
  private int Id_Usuario_Fk;
}
