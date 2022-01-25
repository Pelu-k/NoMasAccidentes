package com.vdp.nomasaccidentes.implementation;

import com.vdp.nomasaccidentes.models.Asesoria;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class AsesoriaImp {
  public String createAdvisory(Connection con, Asesoria asesoria) throws SQLException {
    CallableStatement statement = con.prepareCall("{call SPADDASESORIA(?,?,?,?,?,?,?,?,?)}");
    statement.setString(1, asesoria.getNombre());
    statement.setString(2, asesoria.getDescChecklist());
    statement.setDate(3, asesoria.getFechaCreacion());
    statement.setDate(4, asesoria.getFechaLimite());
    statement.setDate(5, asesoria.getFechaTermino());
    statement.setInt(6, asesoria.getValor());
    statement.setInt(7, asesoria.getIdClienteFk());
    statement.setInt(8, asesoria.getIdProfesionalFk());
    statement.setString(9, asesoria.getEstado());
    statement.execute();
    return "Asesoria creada";
  }

  public String updateAdvisory(Connection con, Map<String, String> obj) throws SQLException {
    CallableStatement statement = con.prepareCall("{call SPUPDATEESTADOASES(?,?)}");
    statement.setInt(1, Integer.parseInt(obj.get("id")));
    statement.setString(2, obj.get("estado"));
    statement.execute();
    return "Estado asesoria modificado";
  }
}
