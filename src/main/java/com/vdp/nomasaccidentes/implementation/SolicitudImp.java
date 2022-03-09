package com.vdp.nomasaccidentes.implementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolicitudImp {
    public String sendRequest(Connection con, Map<String, String> solicitud) throws SQLException {
        CallableStatement statement = con.prepareCall("{call spAgregarSolicitud(?,?,?,?)}");
        statement.setString(1, solicitud.get("descripcion"));
        statement.setString(2, solicitud.get("estado"));
        statement.setString(3, solicitud.get("categoria"));
        statement.setInt(4, Integer.parseInt(solicitud.get("idCliente")));
        statement.execute();
        return "Solicitud enviada";
    }

    public List<Map<String, String>> getAllRequest(Connection con) throws SQLException {
        CallableStatement statement = con.prepareCall("{? = call fnObtenerTodasLasSolicitudes}");
        statement.registerOutParameter(1, Types.REF_CURSOR);
        statement.execute();
        ResultSet resultSet = (ResultSet) statement.getObject(1);
        List<Map<String, String>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, String> solicitud = new HashMap<>();
            solicitud.put("descripcion", resultSet.getString(1));
            solicitud.put("estado", resultSet.getString(2));
            solicitud.put("categoria", resultSet.getString(3));
            solicitud.put("razonSocial", resultSet.getString(4));
            list.add(solicitud);
        }
        return list;
    }

    public List<Map<String, String>> getAllRequestClient(Connection con, int idClient) throws SQLException {
        CallableStatement statement = con.prepareCall("{? = call fnObtenerSolicitudesCliente(?)}");
        statement.registerOutParameter(1, Types.REF_CURSOR);
        statement.setInt(2, idClient);
        statement.execute();
        ResultSet resultSet = (ResultSet) statement.getObject(1);
        List<Map<String, String>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, String> solicitud = new HashMap<>();
            solicitud.put("descripcion", resultSet.getString(1));
            solicitud.put("estado", resultSet.getString(2));
            solicitud.put("categoria", resultSet.getString(3));
            solicitud.put("razonSocial", resultSet.getString(4));
            list.add(solicitud);
        }
        return list;
    }
}
