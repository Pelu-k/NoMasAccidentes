package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Cliente {
  @Getter @Setter
  private int Id_Cliente;

  @Getter @Setter
  private String Razon_Social;

  @Getter @Setter
  private String Rubro;

  @Getter @Setter
  private int Rol_Emp;

  @Getter @Setter
  private int Rut_Rep;

  @Getter @Setter
  private String RutDV_Rep;

  @Getter @Setter
  private String Indice_Accidentabilidad;

  @Getter @Setter
  private int Id_Usuario_Fk;
}
