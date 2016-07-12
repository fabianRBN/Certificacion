/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.modelo.Matricula;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fabian
 */
@Service
public class MatriculaDAO {
     @PersistenceContext
    private EntityManager em;
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void crear(Matricula c) throws ServicioExcepcion{
        em.persist(c);
    }

    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void eliminar(Matricula c) throws ServicioExcepcion{
        em.remove(c);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void actualizar (Matricula c) throws ServicioExcepcion{
        em.merge(c);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  List<Matricula> listar() throws ServicioExcepcion{
        return em.createNamedQuery("Matricula.findAll").getResultList();
    }
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public Matricula consultar(int id) {
       return em.find(Matricula.class, id);
    }
    
}
