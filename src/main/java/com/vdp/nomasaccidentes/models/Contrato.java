package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "CONTRATO")
public class Contrato {
  @Id
  @Getter @Setter @Column(name = "ID_CONTRATO") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Contrato;

  @Getter @Setter @Column(name = "ESTADO_CONTRATO")
  private String Estado_Contrato;

  @Getter @Setter @Column(name = "FECHA_INICIO")
  private Date Fecha_Inicio;

  @Getter @Setter @Column(name = "FECHA_TERMINO")
  private Date Fecha_Termino;

  @Getter @Setter @Column(name = "ID_USUARIO_FK")
  private int Id_Usuario_Fk;
}
