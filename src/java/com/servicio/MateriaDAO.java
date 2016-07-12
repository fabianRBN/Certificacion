/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.modelo.Materia;
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
public class MateriaDAO {

    @PersistenceContext
    private EntityManager em;
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void crear(Materia c) throws ServicioExcepcion{
        em.persist(c);
    }

    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void eliminar(Materia c) throws ServicioExcepcion{
        em.remove(c);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void actualizar (Materia c) throws ServicioExcepcion{
        em.merge(c);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  List<Materia> listar() throws ServicioExcepcion{
        return em.createNamedQuery("Materia.findAll").getResultList();
    }
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public Materia consultar(int id) {
       return em.find(Materia.class, id);
    }
}
