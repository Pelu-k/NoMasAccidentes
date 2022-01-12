package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PAGO_ACT")
public class PagoActividad {

  @Id
  @Getter @Setter @Column(name = "ID_PAGO_ACT") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Pago_Act;

  @Getter @Setter @Column(name = "DESCRIPCION")
  private String Descripcion;

  @Getter @Setter @Column(name = "MONTO")
  private int Monto;

  @Getter @Setter @Column(name = "COMISION_PROFESIONAL")
  private int Comision_Profesional;

  @Getter @Setter @Column(name = "FECHA_CREACION")
  private Date Fecha_Creacion;

  @Getter @Setter @Column(name = "FECHA_PAGO")
  private Date Fecha_Pago;

  @Getter @Setter @Column(name = "FECHA_LIMITE")
  private Date Fecha_Limite;

  @Getter @Setter @Column(name = "ID_ACTIVIDAD_FK")
  private int Id_Actividad_Fk;
}
