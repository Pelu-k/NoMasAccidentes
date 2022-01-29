package com.vdp.nomasaccidentes.controllers;

import com.vdp.nomasaccidentes.connection.Conn;
import com.vdp.nomasaccidentes.implementation.ClienteImp;
import com.vdp.nomasaccidentes.models.Cliente;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"}, methods = {RequestMethod.GET})
public class ClienteController {

  private Connection config() throws SQLException {
    Conn conn = new Conn();
    return conn.getConnect();
  }

  @RequestMapping(value = "api/client/{id}", method = RequestMethod.GET)
  public Cliente getClientByUserId(@RequestHeader("Authorization") String token, @PathVariable int id) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new ClienteImp().getClientByUserId(config(), id);
  }

  @RequestMapping(value = "api/customers", method = RequestMethod.GET)
  public List<Map<String, String>> getAllCustomers(@RequestHeader("Authorization") String token) throws SQLException {
    if (token == null) {
      return null;
    }
    if (!Jwts.parser().isSigned(token)) {
      return null;
    }
    return new ClienteImp().getAllClient(config());
  }
}
