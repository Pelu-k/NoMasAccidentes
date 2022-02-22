package com.vdp.nomasaccidentes.controllers;

import com.vdp.nomasaccidentes.connection.Conn;
import com.vdp.nomasaccidentes.implementation.ProfesionalImp;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://nmafront.herokuapp.com"}, methods = {RequestMethod.GET})
public class ProfesionalController {
  private Connection config() throws SQLException {
    Conn conn = new Conn();
    return conn.getConnect();
  }

  @RequestMapping(value = "api/professional/{id}", method = RequestMethod.GET)
  public Map<String, String> getProfessionalById(@RequestHeader("Authorization") String token, @PathVariable int id) throws SQLException {
    Map<String, String> map = new HashMap<>();
    if (token == null) {
      map.put("error", "El token no existe");
      return map;
    }
    if (!Jwts.parser().isSigned(token)) {
      map.put("error", "Token no valido");
      return map;
    }
    return new ProfesionalImp().getProfessionalById(config(), id);
  }
}
