package com.vdp.nomasaccidentes.dao;

import com.vdp.nomasaccidentes.models.Usuario;

import java.util.List;

public interface UsuarioDao {

  void createUser();
  void updateUser();
  List<Usuario> getAllUsers();
  Usuario getUser();
  void deleteUser();
}
