package com.vdp.nomasaccidentes.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PAGO_ASESORIA")
public class PagoAsesoria {

  @Id
  @Getter @Setter @Column(name = "ID_PAGO_ASESORIA") @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id_Pago_Asesoria;

  @Getter @Setter @Column(name = "DESCRIPCION")
  private String Descripcion;

  @Getter @Setter @Column(name = "MONTO")
  private int Monto;

  @Getter @Setter @Column(name = "FECHA_CREACION")
  private Date Fecha_Creacion;

  @Getter @Setter @Column(name = "FECHA_PAGO")
  private Date Fecha_Pago;

  @Getter @Setter @Column(name = "FECHA_LIMITE")
  private Date Fecha_Limite;

  @Getter @Setter @Column(name = "ID_CLIENTE_FK")
  private int Id_Cliente_Fk;
}
