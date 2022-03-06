package com.vdp.nomasaccidentes.controllers;

import com.vdp.nomasaccidentes.connection.Conn;
import com.vdp.nomasaccidentes.implementation.AccidenteImp;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://nmafront.herokuapp.com"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AccidenteController {

    private Connection config() throws SQLException {
        Conn conn = new Conn();
        return conn.getConnect();
    }

    @RequestMapping(value = "api/report-accident", method = RequestMethod.POST)
    public String registerActivity(@RequestHeader("Authorization") String token,
                                   @RequestBody Map<String, String> accidente) throws SQLException, ParseException {
        if (token == null) {
            return "Ño";
        }
        if (!Jwts.parser().isSigned(token)) {
            return "Ño";
        }
        return new AccidenteImp().reportAccident(config(), accidente);
    }
}
