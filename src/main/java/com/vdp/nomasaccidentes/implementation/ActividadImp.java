package com.vdp.nomasaccidentes.implementation;

import com.vdp.nomasaccidentes.models.Actividad;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActividadImp {
  public String registerActivity(Connection con, Map<String, String> actividad) throws SQLException, ParseException {
    CallableStatement statement = con.prepareCall("{call spAddActividad(?,?,?,?,?,?,?,?,?)}");
    statement.setString(1, actividad.get("nombre").toUpperCase());
    statement.setString(2, actividad.get("valor"));
    statement.setString(3, "EN APROBACION"); // enviar estado por defecto EN APROBACION
    statement.setString(4, actividad.get("tipo").toLowerCase());
    statement.setDate(5, new Date(new SimpleDateFormat("yyyy-MM-dd").parse(actividad.get("fechaCreacion")).getTime()));
    statement.setDate(6, new Date(new SimpleDateFormat("yyyy-MM-dd").parse(actividad.get("fechaLimite")).getTime()));
    statement.setDate(7, new Date(new SimpleDateFormat("yyyy-MM-dd").parse(actividad.get("fechaTermino")).getTime()));
    statement.setString(8, actividad.get("descActividad"));
    statement.setInt(9, Integer.parseInt(actividad.get("idAsesoria")));
    statement.execute();
    return "Actividad registrada";
  }

  public String updateActvity(Connection con, Actividad actividad) throws SQLException {
    CallableStatement statement = con.prepareCall("{call spUpdateActividad(?,?,?,?,?,?,?)}");
    statement.setInt(1, actividad.getIdActividad());
    statement.setString(2, actividad.getNombre().toUpperCase());
    statement.setString(3, actividad.getValor());
    statement.setString(4, actividad.getInsumoChecklist());
    statement.setString(5, actividad.getEstado());
    statement.setDate(6, actividad.getFechaLimite());
    statement.setString(7, actividad.getDescActividad());
    statement.execute();
    return "Actividad actualizada";
  }

  public List<Map<String, String>> getAllActivities(Connection con) throws SQLException {
    CallableStatement statement = con.prepareCall("{? = call fnAllActividad}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    return convertToMap(resultSet);
  }

  public List<Map<String, String>> getAllActivitiesByIdAsesoria(Connection con, int idAsesoria) throws SQLException {
    CallableStatement statement = con.prepareCall("{? = call fnActividadByIdAsesoria(?)}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.setInt(2, idAsesoria);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    return convertToMap(resultSet);
  }

  public String deleteActivity(Connection con, int idActividad) throws SQLException {
    CallableStatement statement = con.prepareCall("{call spUpdateEstadoAct(?,?)}");
    statement.setInt(1, idActividad);
    statement.setString(2, "Cancelada");
    statement.execute();
    return "Actividad cancelada";
  }

  private List<Map<String, String>> convertToMap(ResultSet resultSet) throws SQLException {
    List<Map<String, String>> list = new ArrayList<>();
    while (resultSet.next()) {
      Map<String, String> actividad = new HashMap<>();
      actividad.put("idActividad", Integer.toString(resultSet.getInt(1)));
      actividad.put("nombre", resultSet.getString(2));
      actividad.put("folio", Integer.toString(resultSet.getInt(3)));
      actividad.put("valor", resultSet.getString(4));
      actividad.put("estado", resultSet.getString(5));
      actividad.put("tipo", resultSet.getString(6));
      actividad.put("fechaCreacion", resultSet.getDate(7).toString());
      actividad.put("fechaLimite", resultSet.getDate(8).toString());
      actividad.put("fechaTermino", resultSet.getDate(9).toString());
      actividad.put("descActividad", resultSet.getString(10));
      actividad.put("idAsesoriaFk", Integer.toString(resultSet.getInt(11)));
      list.add(actividad);
    }
    return list;
  }
}
