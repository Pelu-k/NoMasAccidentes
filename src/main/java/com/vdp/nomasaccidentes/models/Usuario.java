package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
public class Usuario {

  @Id
  @Getter @Setter @Column(name = "ID_USUARIO") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Usuario;

  @Getter @Setter @Column(name = "USERNAME")
  private String Username;

  @Getter @Setter @Column(name = "HASHPW")
  private String HashPW;

  @Getter @Setter @Column(name = "ROL")
  private int Rol;
}
