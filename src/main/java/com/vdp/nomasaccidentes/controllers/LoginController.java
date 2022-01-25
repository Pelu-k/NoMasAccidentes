package com.vdp.nomasaccidentes.controllers;

import com.vdp.nomasaccidentes.connection.Conn;
import com.vdp.nomasaccidentes.models.Usuario;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/", "http://192.168.100.21:3000"}, methods = {RequestMethod.POST})
public class LoginController {

  private Connection config() throws SQLException {
    Conn conn = new Conn();
    return conn.getConnect();
  }

  @RequestMapping(value = "api/login", method = RequestMethod.POST)
  public Map<String, String> login(@RequestBody Map<String, String> login) throws SQLException {
    // Obtener al usuario
    Usuario usuario = new Usuario().getUserByUsername(config(), login.get("username"));
    // Validar usuario
    if (usuario == null) { return null; }
    // Validar contraseña
    if (!usuario.getHashPw().equals(login.get("password"))) { return null; }
    // Generar token
    Map<String, String> map = new HashMap<>();
    map.put("token", usuario.createToken(usuario.getUsername(), usuario.getRol()));
    map.put("rol", Integer.toString(usuario.getRol()));
    return map;
  }

}
