/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;
import com.modelo.Alumno;
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
public class AlumnoDAO {
     @PersistenceContext
    private EntityManager em;
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void crear(Alumno c) throws ServicioExcepcion{
        em.persist(c);
    }

    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void eliminar(Alumno c) throws ServicioExcepcion{
        em.remove(c);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  void actualizar (Alumno c) throws ServicioExcepcion{
        em.merge(c);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public  List<Alumno> listar() throws ServicioExcepcion{
        return em.createNamedQuery("Alumno.findAll").getResultList();
    }
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public Alumno consultar(int id) {
       return em.find(Alumno.class, id);
    }
    
}
