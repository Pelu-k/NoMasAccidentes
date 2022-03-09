package com.vdp.nomasaccidentes.controllers;

import com.vdp.nomasaccidentes.connection.Conn;
import com.vdp.nomasaccidentes.implementation.SolicitudImp;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://nmafront.herokuapp.com"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SolicitudController {

    private Connection config() throws SQLException {
        Conn conn = new Conn();
        return conn.getConnect();
    }

    @RequestMapping(value = "api/send-request", method = RequestMethod.POST)
    public String registerActivity(@RequestHeader("Authorization") String token,
                                   @RequestBody Map<String, String> solicitud) throws SQLException {
        if (token == null) {
            return "Ño";
        }
        if (!Jwts.parser().isSigned(token)) {
            return "Ño";
        }
        return new SolicitudImp().sendRequest(config(), solicitud);
    }

    @RequestMapping(value = "api/get-request/{id}", method = RequestMethod.GET)
    public List<Map<String, String>> getAllRequestClient(@RequestHeader("Authorization") String token,
                                                      @PathVariable int id) throws SQLException {
        if (token == null) {
            return null;
        }
        if (!Jwts.parser().isSigned(token)) {
            return null;
        }
        return new SolicitudImp().getAllRequestClient(config(), id);
    }

    @RequestMapping(value = "api/get-request", method = RequestMethod.GET)
    public List<Map<String, String>> getAllRequest(@RequestHeader("Authorization") String token) throws SQLException {
        if (token == null) {
            return null;
        }
        if (!Jwts.parser().isSigned(token)) {
            return null;
        }
        return new SolicitudImp().getAllRequest(config());
    }

}
