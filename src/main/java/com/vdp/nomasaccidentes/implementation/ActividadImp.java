package com.vdp.nomasaccidentes.implementation;

import com.vdp.nomasaccidentes.models.Actividad;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

  public List<Actividad> getAllActivities(Connection con) throws SQLException {
    CallableStatement statement = con.prepareCall("{? = call fnAllActividad}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    List<Actividad> list = new ArrayList<>();
    while (resultSet.next()) {
      Actividad actividad = new Actividad();
      actividad.setIdActividad(resultSet.getInt(1));
      actividad.setNombre(resultSet.getString(2));
      actividad.setFolio(resultSet.getInt(3));
      actividad.setValor(resultSet.getString(4));
      actividad.setInsumoChecklist(resultSet.getString(5));
      actividad.setEstado(resultSet.getString(6));
      actividad.setTipo(resultSet.getString(7));
      actividad.setFechaCreacion(resultSet.getDate(8));
      actividad.setFechaLimite(resultSet.getDate(9));
      actividad.setFechaTermino(resultSet.getDate(10));
      actividad.setDescActividad(resultSet.getString(11));
      actividad.setIdAsesoriaFk(resultSet.getInt(12));
      list.add(actividad);
    }
    return list;
  }

  public List<Actividad> getAllActivitiesByIdAsesoria(Connection con, int idAsesoria) throws SQLException {
    CallableStatement statement = con.prepareCall("{? = call fnActividadByIdAsesoria(?)}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.setInt(2, idAsesoria);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    List<Actividad> list = new ArrayList<>();
    while (resultSet.next()) {
      Actividad actividad = new Actividad();
      actividad.setIdActividad(resultSet.getInt(1));
      actividad.setNombre(resultSet.getString(2));
      actividad.setFolio(resultSet.getInt(3));
      actividad.setValor(resultSet.getString(4));
      actividad.setEstado(resultSet.getString(5));
      actividad.setTipo(resultSet.getString(6));
      actividad.setFechaCreacion(resultSet.getDate(7));
      actividad.setFechaLimite(resultSet.getDate(8));
      actividad.setFechaTermino(resultSet.getDate(9));
      actividad.setDescActividad(resultSet.getString(10));
      actividad.setIdAsesoriaFk(resultSet.getInt(11));
      list.add(actividad);
    }
    return list;
  }

  public String deleteActivity(Connection con, int idActividad) throws SQLException {
    CallableStatement statement = con.prepareCall("{call spUpdateEstadoAct(?,?)}");
    statement.setInt(1, idActividad);
    statement.setString(2, "Cancelada");
    statement.execute();
    return "Actividad cancelada";
  }
}
