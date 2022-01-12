package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ACTIVIDAD")
public class Actividad {

  @Id
  @Getter @Setter @Column(name = "ID_ACTIVIDAD") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Actividad;

  @Getter @Setter @Column(name = "NOMBRE")
  private String Nombre;

  @Getter @Setter @Column(name = "TIPO")
  private String Tipo;

  @Getter @Setter @Column(name = "FECHA_CREACION")
  private Date Fecha_Creacion;

  @Getter @Setter @Column(name = "FECHA_TERMINO")
  private Date Fecha_Termino;

  @Getter @Setter @Column(name = "FECHA_LIMITE")
  private Date Fecha_Limite;

  @Getter @Setter @Column(name = "DESC_ACTIVIDAD")
  private String Desc_Actividad;

  @Getter @Setter @Column(name = "INSUMOS")
  private String Insumos;

  @Getter @Setter @Column(name = "ID_ASESORIA_FK")
  private int Id_Asesoria_Fk;
}
