package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DATOS_CONTACTO")
public class DatosContacto {

  @Id
  @Getter @Setter @Column(name = "ID_DATOS") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Datos;

  @Getter @Setter @Column(name = "CODIGO_AREA")
  private String Codigo_Area;

  @Getter @Setter @Column(name = "NUMERO")
  private int Numero;

  @Getter @Setter @Column(name = "DIRECCION")
  private String Direccion;

  @Getter @Setter @Column(name = "NUMERO_DIRECCION")
  private int Numero_Direccion;

  @Getter @Setter @Column(name = "NUMERO_DEPARTAMENTO")
  private int Numero_Departamento;

  @Getter @Setter @Column(name = "LETRA_DEPARTAMENTO")
  private String Letra_Departamento;

  @Getter @Setter @Column(name = "COMENTARIO")
  private String Comentario;

  @Getter @Setter @Column(name = "ID_CIUDAD_FK")
  private int Id_Ciudad_Fk;

  @Getter @Setter @Column(name = "ID_USUARIO_FK")
  private int Id_Usuario_Fk;
}
