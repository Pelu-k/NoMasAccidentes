package com.vdp.nomasaccidentes.controllers;

import com.vdp.nomasaccidentes.connection.Conn;
import com.vdp.nomasaccidentes.implementation.UsuarioImp;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/", "https://nmafront.herokuapp.com"}, methods = {RequestMethod.POST})
public class LoginController {

  private Connection config() throws SQLException {
    Conn conn = new Conn();
    return conn.getConnect();
  }

  @RequestMapping(value = "api/login", method = RequestMethod.POST)
  public Map<String, String> login(@RequestBody Map<String, String> login) throws SQLException {
    // Obtener al usuario
    Map<String, String> usuario = new UsuarioImp().getUserByUsername(config(), login.get("username"));
    // Validar usuario
    if (usuario == null) {
      return null;
    }
    // Validar contraseña
    if (!usuario.get("hashPw").equals(login.get("password"))) {
      return null;
    }
    // Generar token
    Map<String, String> map = new HashMap<>();
    map.put("token", new UsuarioImp().createToken(usuario.get("username"), Integer.parseInt(usuario.get("rol"))));
    map.put("rol", usuario.get("rol"));
    map.put("idUsuario", usuario.get("idProfesional"));
    map.put("nombre", usuario.get("nombre") + " " + usuario.get("apellido"));
    return map;
  }

}
