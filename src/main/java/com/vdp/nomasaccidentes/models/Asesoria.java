package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ASESORIA")
public class Asesoria {

  @Id
  @Getter @Setter @Column(name = "ID_ASESORIA") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Asesoria;

  @Getter @Setter @Column(name = "NOMBRE")
  private String Nombre;

  @Getter @Setter @Column(name = "NUMERO")
  private int Numero;

  @Getter @Setter @Column(name = "DESC_ASESORIA")
  private String Desc_Asesoria;

  @Getter @Setter @Column(name = "FECHA_CREACION")
  private Date Fecha_Creacion;

  @Getter @Setter @Column(name = "FECHA_TERMINO")
  private Date Fecha_Termino;

  @Getter @Setter @Column(name = "FECHA_LIMITE")
  private Date Fecha_Limite;

  @Getter @Setter @Column(name = "ID_CLIENTE_FK")
  private int Id_Cliente_Fk;

  @Getter @Setter @Column(name = "ID_PROFESIONAL_FK")
  private int Id_Profesional_Fk;
}
