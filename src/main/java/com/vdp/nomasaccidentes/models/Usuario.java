package com.vdp.nomasaccidentes.models;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuario {
  @Getter @Setter
  private int idUsuario;

  @Getter @Setter
  private String username;

  @Getter @Setter
  private String hashPw;

  @Getter @Setter
  private int rol;

  @Getter @Setter
  private int idEstadoFk;

  @Getter @Setter
  private int idDatosFk;

  // Obtener usuario por el nombre de usuario
  public Usuario getUserByUsername(Connection con, String username) throws SQLException {
    Usuario usuario = new Usuario();
    CallableStatement statement = con.prepareCall("{? = call getUserByUsername(?)}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.setString(2, username);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    while (resultSet.next()) {
      usuario.setIdUsuario(resultSet.getInt(1));
      usuario.setUsername(resultSet.getString(2));
      usuario.setHashPw(resultSet.getString(3));
      usuario.setRol(resultSet.getInt(4));
      usuario.setIdEstadoFk(resultSet.getInt(5));
      usuario.setIdDatosFk(resultSet.getInt(6));
    }
    return usuario;
  }

  // Validar contraseña

  // Generar token
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

  // Obteber todos los usuarios
  public List<Map<String, String>> getAllClient(Connection con) throws SQLException{
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
