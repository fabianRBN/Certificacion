/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.modelo.Maestro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francisco Rubio
 */
@Service
public class MaestroDAO {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void crear(Maestro c) throws ServicioExcepcion{
        em.persist(c);
    }

    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void eliminar(Maestro c) throws ServicioExcepcion{
        em.remove(c);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void actualizar (Maestro c) throws ServicioExcepcion{
        em.merge(c);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  List<Maestro> listar() throws ServicioExcepcion{
        return em.createNamedQuery("Maestro.findAll").getResultList();
    }
}
