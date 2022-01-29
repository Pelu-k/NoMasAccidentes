package com.vdp.nomasaccidentes.implementation;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioImp {
  /**
   * Obtener usuario por nombre de usuario
   */
  public Map<String, String> getUserByUsername(Connection con, String username) throws SQLException {
    //Usuario usuario = new Usuario();
    Map<String, String> usuario = new HashMap<>();
    CallableStatement statement = con.prepareCall("{? = call getUserByUsername(?)}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.setString(2, username);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    while (resultSet.next()) {
      //usuario.put("id", Integer.toString(resultSet.getInt(1)));
      usuario.put("username", resultSet.getString(1));
      usuario.put("hashPw", resultSet.getString(2));
      usuario.put("rol", Integer.toString(resultSet.getInt(3)));
      usuario.put("idProfesional", Integer.toString(resultSet.getInt(4)));
      //usuario.put("idEstadoFk", Integer.toString(resultSet.getInt(5)));
      //usuario.put("idDatoFk", Integer.toString(resultSet.getInt(6)));
    }
    return usuario;
  }

  /**
   * Generar token de usuario
   */
  public String createToken(String username, int rol) {
    String key = "clavesita_bonita";
    long time = System.currentTimeMillis();
    return Jwts.builder()
        .signWith(SignatureAlgorithm.HS256, key)
        .setSubject(username)
        .setIssuedAt(new Date(time))
        .setExpiration(new Date(time + 604800000))
        .claim("rol", rol)
        .compact();
  }

  /**
   * Obtener una lista con todos los usuarios
   */
  public List<Map<String, String>> getAllClient(Connection con) throws SQLException {
    List<Map<String, String>> usuarios = new ArrayList<>();
    CallableStatement statement = con.prepareCall("{? = call getAllClient}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    while (resultSet.next()) {
      Map<String, String> map = new HashMap<>();
      map.put("id", Integer.toString(resultSet.getInt(1)));
      map.put("nombre", resultSet.getString(2));
      usuarios.add(map);
    }
    return usuarios;
  }
}
