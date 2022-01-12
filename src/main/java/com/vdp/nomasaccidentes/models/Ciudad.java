package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CIUDAD")
public class Ciudad {

  @Id
  @Getter @Setter @Column(name = "ID_CIUDAD") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Ciudad;

  @Getter @Setter @Column(name = "NOMBRE_CIUDAD")
  private String Nombre_Ciudad;
}
