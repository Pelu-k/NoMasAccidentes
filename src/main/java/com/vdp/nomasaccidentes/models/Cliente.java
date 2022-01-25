package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

public class Cliente {
  @Getter @Setter
  private int idCliente;

  @Getter @Setter
  private String nombreEmpresa;

  @Getter @Setter
  private String razonSocial;

  @Getter @Setter
  private String rubro;

  @Getter @Setter
  private int rolEmpresa;

  @Getter @Setter
  private String rolDv;

  @Getter @Setter
  private String nombreRepresentante;

  @Getter @Setter
  private int rutRepresentante;

  @Getter @Setter
  private String rutDvRepresentante;

  @Getter @Setter
  private int cantidadEmpleados;

  @Getter @Setter
  private int idUsuarioFk;
}
