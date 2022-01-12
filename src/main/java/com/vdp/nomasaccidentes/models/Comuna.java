package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COMUNA")
public class Comuna {

  @Id
  @Getter @Setter @Column(name = "ID_COMUNA") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Comuna;

  @Getter @Setter @Column(name = "NOMBRE_COMUNA")
  private String Nombre_Comuna;

  @Getter @Setter @Column(name = "ID_CIUDAD_FK")
  private int Id_Ciudad_Fk;
}
