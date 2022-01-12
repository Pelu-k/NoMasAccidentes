package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADMNISTRADOR")
public class Administrador {

  @Id
  @Getter @Setter @Column(name = "ID_ADMIN") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Adminn;

  @Getter @Setter @Column(name = "NOMBRE")
  private String Nombre;

  @Getter @Setter @Column(name = "APELLIDO")
  private String Apellido;

  @Getter @Setter @Column(name = "CARGO")
  private String Cargo;

  @Getter @Setter @Column(name = "RUT")
  private long Rut;

  @Getter @Setter @Column(name = "RUTDV")
  private String RutDV;

  @Getter @Setter @Column(name = "ID_USUARIO_FK")
  private int Id_Usuario_Fk;
}
