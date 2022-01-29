package com.vdp.nomasaccidentes.implementation;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsesoriaImp {

  public String createAdvisory(Connection con, Map<String, String> asesoria) throws SQLException, ParseException {
    CallableStatement statement = con.prepareCall("{call SPADDASESORIA(?,?,?,?,?,?,?,?)}");
    statement.setString(1, asesoria.get("nombre"));
    statement.setDate(2, new Date(new SimpleDateFormat("yyyy-MM-dd").parse(asesoria.get("fechaCreacion")).getTime()));
    statement.setDate(3, new Date(new SimpleDateFormat("yyyy-MM-dd").parse(asesoria.get("fechaLimite")).getTime()));
    statement.setDate(4, new Date(new SimpleDateFormat("yyyy-MM-dd").parse(asesoria.get("fechaTermino")).getTime()));
    statement.setInt(5, Integer.parseInt(asesoria.get("valor")));
    statement.setInt(6, Integer.parseInt(asesoria.get("idClienteFk")));
    statement.setInt(7, Integer.parseInt(asesoria.get("idProfesionalFk")));
    statement.setString(8, "En aprobacion");
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

  public List<Map<String, String>> getAllAdvisory(Connection con, int id) throws SQLException, NullPointerException {
    CallableStatement statement = con.prepareCall("{? = call FNALLASESORIA(?)}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.setInt(2, id);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    List<Map<String, String>> list = new ArrayList<>();
    while (resultSet.next()) {
      Map<String, String> asesoria = new HashMap<>();
      asesoria.put("id", Integer.toString(resultSet.getInt(1)));
      asesoria.put("nombre", resultSet.getString(2));
      asesoria.put("numero",Integer.toString(resultSet.getInt(3)));
      asesoria.put("valor", Integer.toString(resultSet.getInt(4)));
      asesoria.put("estado",resultSet.getString(5));
      asesoria.put("nombreEmpresa", resultSet.getString(6));
      asesoria.put("nombreProfesional", resultSet.getString(7));
      list.add(asesoria);
    }
    return list;
  }
}
