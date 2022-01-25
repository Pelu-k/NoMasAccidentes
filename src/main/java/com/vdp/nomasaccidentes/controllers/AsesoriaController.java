package com.vdp.nomasaccidentes.controllers;

import com.vdp.nomasaccidentes.connection.Conn;
import com.vdp.nomasaccidentes.implementation.AsesoriaImp;
import com.vdp.nomasaccidentes.models.Asesoria;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@RestController
@CrossOrigin(value = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AsesoriaController {

  private Connection config() throws SQLException {
    Conn conn = new Conn();
    return conn.getConnect();
  }

  @RequestMapping(value = "api/create-advisory", method = RequestMethod.POST)
  public String createAdvisory(@RequestHeader("Authorization") String token,@RequestBody Asesoria asesoria) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new AsesoriaImp().createAdvisory(config(), asesoria);
  }

  @RequestMapping(value = "api/update-advisory", method = RequestMethod.PUT)
  public String updateAdvisory(@RequestHeader("Authorization") String token, @RequestBody Map<String, String> obj) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new AsesoriaImp().updateAdvisory(config(), obj);
  }
}
