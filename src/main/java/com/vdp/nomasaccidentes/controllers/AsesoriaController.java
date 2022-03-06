package com.vdp.nomasaccidentes.controllers;

import com.vdp.nomasaccidentes.connection.Conn;
import com.vdp.nomasaccidentes.implementation.AsesoriaImp;
import com.vdp.nomasaccidentes.models.Asesoria;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(value = {"http://localhost:3000", "https://nmafront.herokuapp.com"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AsesoriaController {

  private Connection config() throws SQLException {
    Conn conn = new Conn();
    return conn.getConnect();
  }

  // PROFESIONAL

  @RequestMapping(value = "api/create-advisory", method = RequestMethod.POST)
  public String createAdvisory(@RequestHeader("Authorization") String token,
                               @RequestBody Map<String, String> asesoria) throws SQLException, ParseException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new AsesoriaImp().createAdvisory(config(), asesoria);
  }

  @RequestMapping(value = "api/update-advisory", method = RequestMethod.PUT)
  public String updateAdvisory(@RequestHeader("Authorization") String token,
                               @RequestBody Map<String, String> asesoria) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new AsesoriaImp().updateAdvisory(config(), asesoria);
  }

  @RequestMapping(value = "api/advisory/{id}", method = RequestMethod.GET)
  public List<Map<String, String>> getAllAdvisory(@RequestHeader("Authorization") String token,
                                                  @PathVariable int id) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new AsesoriaImp().getAllAdvisory(config(), id);
  }

  @RequestMapping(value = "api/trainings/{id}", method = RequestMethod.GET)
  public List<Map<String, String>> getAllTrainings(@RequestHeader("Authorization") String token,
                                                   @PathVariable int id) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new AsesoriaImp().getAllTrainings(config(), id);
  }

  // CLIENTE

  @RequestMapping(value = "api/advisory/client/{id}", method = RequestMethod.GET)
  public List<Map<String, String>> getAllAdvisoryClient(@RequestHeader("Authorization") String token,
                                                  @PathVariable int id) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new AsesoriaImp().getAllAdvisoryClient(config(), id);
  }

  @RequestMapping(value = "api/trainings/client/{id}", method = RequestMethod.GET)
  public List<Map<String, String>> getAllTrainingsClient(@RequestHeader("Authorization") String token,
                                                   @PathVariable int id) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new AsesoriaImp().getAllTrainingsClient(config(), id);
  }

}
