package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ESPECIALIDAD")
public class Especialidad {

  @Id
  @Getter @Setter @Column(name = "ID_ESPECIALIDAD") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Especialidad;

  @Getter @Setter @Column(name = "NOMBRE")
  private String Nombre;

  @Getter @Setter @Column(name = "DESC_ESPECIALIDAD")
  private String Desc_Especialidad;

  @Getter @Setter @Column(name = "ID_PROFESIONAL_FK")
  private int Id_Profesional_Fk;
}
