package com.vdp.nomasaccidentes.controllers;

import com.vdp.nomasaccidentes.connection.Conn;
import com.vdp.nomasaccidentes.implementation.ActividadImp;
import com.vdp.nomasaccidentes.models.Actividad;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://nmafront.herokuapp.com"},
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ActividadController {

  private Connection config() throws SQLException {
    Conn conn = new Conn();
    return conn.getConnect();
  }

  @RequestMapping(value = "api/register-activity", method = RequestMethod.POST)
  public String registerActivity(@RequestHeader("Authorization") String token,
                                 @RequestBody Map<String, String> actividad) throws SQLException, ParseException {
    if (token == null) {
      return "Ño";
    }
    if (!Jwts.parser().isSigned(token)) {
      return "Ño";
    }
    return new ActividadImp().registerActivity(config(), actividad);
  }

  @RequestMapping(value = "api/update-activity", method = RequestMethod.PUT)
  public String updateActivity(@RequestHeader("Authorization") String token,
                               @RequestBody Map<String, String> actividad) throws SQLException, ParseException {
    if (token == null) {
      return "Ño";
    }
    if (!Jwts.parser().isSigned(token)) {
      return "Ño";
    }
    return new ActividadImp().updateActvity(config(), actividad);
  }

  @RequestMapping(value = "api/end-activity/{id}", method = RequestMethod.PUT)
  public String endActivityById(@RequestHeader("Authorization") String token,
                                @PathVariable int id) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new ActividadImp().endActivity(config(), id);
  }

  @RequestMapping(value = "api/all-activities", method = RequestMethod.GET)
  public List<Map<String, String>> getAllActivity(@RequestHeader("Authorization") String token) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new ActividadImp().getAllActivities(config());
  }

  @RequestMapping(value = "api/activity/{id}", method = RequestMethod.GET)
  public Map<String, String> getActivityById(@RequestHeader("Authorization") String token,
                                             @PathVariable int id) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new ActividadImp().getActivityById(config(), id);
  }

  @RequestMapping(value = "api/all-activity/{id}", method = RequestMethod.GET)
  public List<Map<String, String>> getAllActivityByIdAsesoria(@RequestHeader("Authorization") String token,
                                                              @PathVariable int id) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new ActividadImp().getAllActivitiesByIdAsesoria(config(), id);
  }

  @RequestMapping(value = "api/delete-activity/{id}", method = RequestMethod.DELETE)
  public String deleteActivity(@RequestHeader("Authorization") String token,
                               @PathVariable int id) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new ActividadImp().deleteActivity(config(), id);
  }

}
