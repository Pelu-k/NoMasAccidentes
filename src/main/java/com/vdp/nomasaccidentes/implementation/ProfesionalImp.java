package com.vdp.nomasaccidentes.implementation;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ProfesionalImp {

  public Map<String, String> getProfessionalById(Connection con, int idProfesional) throws SQLException {
    CallableStatement statement = con.prepareCall("{? = call fnProfesionalById(?)}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.setInt(2, idProfesional);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    Map<String,String> profesional = new HashMap<>();
    while (resultSet.next()) {
      profesional.put("idProfesional", Integer.toString(resultSet.getInt(1)));
      profesional.put("nombre", resultSet.getString(2));
      profesional.put("apellido", resultSet.getString(3));
      profesional.put("rut", Integer.toString(resultSet.getInt(4)));
      profesional.put("rutDv", resultSet.getString(5));
      profesional.put("idUsuarioFk", Integer.toString(resultSet.getInt(6)));
    }
    return profesional;
  }
}
