package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ASISTENTE")
public class Asistente {

  @Id
  @Getter @Setter @Column(name = "ID_ASISTENTE") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Asistente;

  @Getter @Setter @Column(name = "NOMBRE_A")
  private String Nombre_A;

  @Getter @Setter @Column(name = "APELLIDO_A")
  private String Apellido_A;

  @Getter @Setter @Column(name = "RUT")
  private int Rut;

  @Getter @Setter @Column(name = "RUTDV")
  private String RutDV;

  @Getter @Setter @Column(name = "ID_ACTIVIDAD_FK")
  private int Id_Actividad_Fk;
}
