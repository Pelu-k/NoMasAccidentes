package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ACCIDENTE")
public class Accidente {

  @Id
  @Getter @Setter @Column(name = "ID_ACCIDENTE") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Accidente;

  @Getter @Setter @Column(name = "DESCRIPCION")
  private String Descripcion;

  @Getter @Setter @Column(name = "FECHA_ACCIDENTE")
  private Date Fecha_Accidente;

  @Getter @Setter @Column(name = "ID_CLIENTE_FK")
  private int Id_Cliente_Fk;
}
