package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PROFESIONAL")
public class Profesional {

  @Id
  @Getter @Setter @Column(name = "ID_PROFESIONAL") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Profesional;

  @Getter @Setter @Column(name = "NOMBRE")
  private String Nombre;

  @Getter @Setter @Column(name = "APELLIDO")
  private String Apellido;

  @Getter @Setter @Column(name = "RUT")
  private int Rut;

  @Getter @Setter @Column(name = "RUTDV")
  private String RutDV;

  @Getter @Setter @Column(name = "ID_USUARIO_FK")
  private int Id_Usuario_Fk;
}
