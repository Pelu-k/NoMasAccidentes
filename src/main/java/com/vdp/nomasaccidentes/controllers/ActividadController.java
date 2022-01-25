package com.vdp.nomasaccidentes.controllers;

import com.vdp.nomasaccidentes.connection.Conn;
import com.vdp.nomasaccidentes.models.Actividad;
import com.vdp.nomasaccidentes.models.Usuario;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"},
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ActividadController {

  private Connection config() throws SQLException {
    Conn conn = new Conn();
    return conn.getConnect();
  }

  @RequestMapping(value = "api/all-client", method = RequestMethod.GET)
  public List<Map<String, String>> getAllClient(@RequestHeader("Authorization") String token) throws SQLException {
    // validar token
    if(token == null) { return null; }
    // validar rol
    if(!Jwts.parser().isSigned(token)) { return null;}
    // obtener lista de actividades
    return new Usuario().getAllClient(config());
  }

  @RequestMapping(value = "api/register-activity", method = RequestMethod.POST)
  public String registerActivity(@RequestHeader("Authorization") String token, @RequestBody Actividad actividad) throws SQLException{
    if (token == null) {return "Ño";}
    if (!Jwts.parser().isSigned(token)) { return "Ño";}
    return new Actividad().registerActivity(config(), actividad);
  }

  @RequestMapping(value = "api/update-activity", method = RequestMethod.PUT)
  public String updateActivity(@RequestHeader("Authorization") String token, @RequestBody Actividad actividad) throws SQLException {
    if (token == null) {return "Ño";}
    if (!Jwts.parser().isSigned(token)) { return "Ño";}
    return new Actividad().updateActvity(config(), actividad);
  }

  @RequestMapping(value = "api/all-activities", method = RequestMethod.GET)
  public List<Actividad> updateActivity(@RequestHeader("Authorization") String token) throws SQLException {
    if (token == null) {return null;}
    if (!Jwts.parser().isSigned(token)) { return null;}
    return new Actividad().getAllActivities(config());
  }

  @RequestMapping(value = "api/all-activity/{id}", method = RequestMethod.GET)
  public List<Actividad> updateActivity(@RequestHeader("Authorization") String token, @PathVariable int id) throws SQLException {
    if (token == null) {return null;}
    if (!Jwts.parser().isSigned(token)) { return null;}
    return new Actividad().getAllActivitiesByIdAsesoria(config(), id);
  }

  @RequestMapping(value = "api/delete-activity/{id}", method = RequestMethod.DELETE)
  public String deleteActivity(@RequestHeader("Authorization") String token, @PathVariable int id) throws SQLException {
    if (token == null) {return null;}
    if (!Jwts.parser().isSigned(token)) { return null;}
    return new Actividad().deleteActivity(config(), id);
  }

}
