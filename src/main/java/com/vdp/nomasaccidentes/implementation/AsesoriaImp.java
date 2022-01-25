package com.vdp.nomasaccidentes.implementation;

import com.vdp.nomasaccidentes.models.Asesoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

  public List<Asesoria> getAllAdvisory(Connection con) throws SQLException {
    CallableStatement statement = con.prepareCall("{? = call FNALLASESORIA()}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    List<Asesoria> list = new ArrayList<>();
    while (resultSet.next()) {
      Asesoria asesoria = new Asesoria();
      asesoria.setIdAsesoria(resultSet.getInt(1));
      asesoria.setNombre(resultSet.getString(2));
      asesoria.setNumero(resultSet.getInt(3));
      asesoria.setDescChecklist(resultSet.getString(4));
      asesoria.setFechaCreacion(resultSet.getDate(5));
      asesoria.setFechaLimite(resultSet.getDate(6));
      asesoria.setFechaTermino(resultSet.getDate(7));
      asesoria.setValor(resultSet.getInt(8));
      asesoria.setIdClienteFk(resultSet.getInt(9));
      asesoria.setIdProfesionalFk(resultSet.getInt(10));
      asesoria.setEstado(resultSet.getString(11));
      list.add(asesoria);
    }
    return list;
  }
}
