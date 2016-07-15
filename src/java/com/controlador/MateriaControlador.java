/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Materia;
import com.modelo.Maestro;
import com.servicio.MaestroDAO;
import com.servicio.MateriaDAO;
import com.servicio.ServicioExcepcion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Fabian
 */
@Controller
@RequestMapping("materia")
public class MateriaControlador {
    @Autowired
    private MateriaDAO dao;
    
    @Autowired
    private MaestroDAO daomaestro;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model m) {
        try {
            List<Materia> resultado = dao.listar();
            m.addAttribute("resultado", resultado);
            return "Materia/listar";

        } catch (ServicioExcepcion e) {
            m.addAttribute("err", e.getMessage());
            return "error";
        }
    }
     @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String crear(Model m) {
        try {
            List<Maestro> maestro = daomaestro.listar();
            Maestro seleccion = new Maestro(0,"-- Seleccione --","", "",0.0);
            maestro.add(0, seleccion);
            m.addAttribute("maestros",maestro);
            return "Materia/crear";
        } catch (ServicioExcepcion e) {
            m.addAttribute("err", e.getMessage());
            return "error";
        }

    }
    
    @RequestMapping(value="/crear",method = RequestMethod.POST)
    public String guardar(@RequestParam("txtNombre") String nom, @RequestParam("txtApellido") String n_credito, @RequestParam("cbomaestros") String maestro , Model m) {
        try {
            int idmaestro = Integer.parseInt(maestro);
            Maestro resultado = this.daomaestro.consultar(idmaestro);
            Materia materia = new Materia(nom, Integer.parseInt(n_credito),resultado);
            dao.crear(materia);
            return listar(m);
        } catch (ServicioExcepcion ex) {
            m.addAttribute("err", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value = "/editar/{idMateria}", method = RequestMethod.GET)
    public String editarVista(@PathVariable("idMateria") String id, Model m) {
        try {
            List<Materia> materia = dao.listar();
            Materia seleccionmateria = new Materia(0,"--Seleccione--",0  );
            materia.add(0, seleccionmateria);
            m.addAttribute("alumnos",materia);

            int idmateria = Integer.parseInt(id);
            Materia resultado = this.dao.consultar(idmateria);
            m.addAttribute("resultado", resultado);
            return "Materia/editar";
        } catch (ServicioExcepcion ex) {
            m.addAttribute("err", ex.getMessage());
            return "error";
        }
    }

    //Vicular Materia y ID
    
    
}
