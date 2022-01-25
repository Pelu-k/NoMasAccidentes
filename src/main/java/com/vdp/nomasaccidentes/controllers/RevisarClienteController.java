package com.vdp.nomasaccidentes.controllers;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"}, methods = {RequestMethod.GET})
@Transactional
public class RevisarClienteController {
  @PersistenceContext
  EntityManager entityManager;

  @RequestMapping(value = "api/cliente/{id}", method = RequestMethod.GET)
  @Transactional
  public List getInfoClient(@PathVariable int id) throws SQLException {
    StoredProcedureQuery query = entityManager
        .createStoredProcedureQuery("SPGETCLIENTBYID")
        .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR)
        .setParameter(1, id);
    query.execute();

    return query.getResultList();
  }
}
