package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

  @Id
  @Getter @Setter @Column(name = "ID_CLIENTE") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Cliente;

  @Getter @Setter @Column(name = "RAZON_SOCIAL")
  private String Razon_Social;

  @Getter @Setter @Column(name = "RUBRO")
  private String Rubro;

  @Getter @Setter @Column(name = "ROL_EMP")
  private int Rol_Emp;

  @Getter @Setter @Column(name = "RUT_EMP")
  private int Rut_Rep;

  @Getter @Setter @Column(name = "RUTDV_EMP")
  private String RutDV_Rep;

  @Getter @Setter @Column(name = "INDICE_ACCIDENTABILIDAD")
  private String Indice_Accidentabilidad;

  @Getter @Setter @Column(name = "ID_USUARIO_FK")
  private int Id_Usuario_Fk;
}
