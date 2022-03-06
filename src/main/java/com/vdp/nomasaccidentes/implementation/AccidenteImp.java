package com.vdp.nomasaccidentes.implementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class AccidenteImp {
    public String reportAccident(Connection con, Map<String, String> accidente) throws SQLException, ParseException {
        CallableStatement statement = con.prepareCall("{call spAddAccidente(?,?,?)}");
        statement.setString(1, accidente.get("descripcion"));
        statement.setDate(2, new Date(new SimpleDateFormat("yyyy-MM-dd").parse(accidente.get("fecha")).getTime()));
        statement.setInt(3, Integer.parseInt(accidente.get("idCliente")));
        statement.execute();
        return "Accidente reportado";
    }
}
