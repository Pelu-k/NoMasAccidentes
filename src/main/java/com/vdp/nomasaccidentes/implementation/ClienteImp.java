package com.vdp.nomasaccidentes.implementation;

import com.vdp.nomasaccidentes.models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteImp {

  public Cliente getClientByUserId(Connection con, int id) throws SQLException {
    CallableStatement statement = con.prepareCall("{? = call FNCLIENTEBYIDUSUARIO(?)}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.setInt(2, id);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    Cliente cliente = new Cliente();
    while (resultSet.next()) {
      cliente.setIdCliente(resultSet.getInt(1));
      cliente.setNombreEmpresa(resultSet.getString(2));
      cliente.setRazonSocial(resultSet.getString(3));
      cliente.setRubro(resultSet.getString(4));
      cliente.setRolEmpresa(resultSet.getInt(5));
      cliente.setRolDv(resultSet.getString(6));
      cliente.setNombreRepresentante(resultSet.getString(7));
      cliente.setRutRepresentante(resultSet.getInt(8));
      cliente.setRutDvRepresentante(resultSet.getString(9));
      cliente.setCantidadEmpleados(resultSet.getInt(10));
      cliente.setIdUsuarioFk(resultSet.getInt(11));
    }
    return cliente;
  }

  public List<Map<String, String>> getAllClient(Connection con) throws SQLException {
    CallableStatement statement = con.prepareCall("{? = call fnAllCliente}");
    statement.registerOutParameter(1, Types.REF_CURSOR);
    statement.execute();
    ResultSet resultSet = (ResultSet) statement.getObject(1);
    List<Map<String, String>> list = new ArrayList<>();
    while (resultSet.next()) {
      Map<String,String> cliente = new HashMap<>();
      cliente.put("id", Integer.toString(resultSet.getInt(1)));
      cliente.put("nombre", resultSet.getString(2));
      list.add(cliente);
    }
    return list;
  }
}
