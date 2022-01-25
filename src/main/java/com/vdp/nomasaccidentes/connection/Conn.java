package com.vdp.nomasaccidentes.connection;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
  @Getter @Setter
  private String url;

  @Getter @Setter
  private String usuario;

  @Getter @Setter
  private String contrasena;

  public Conn() {}

  public Connection getConnect() throws SQLException {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return DriverManager.getConnection(
        "jdbc:oracle:thin:@3.18.78.138:49161:XE",
        "NMA",
        "claseculia"
    );
  }
}
