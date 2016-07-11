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
    public String guardar(@RequestParam("txtNombre") String nom, @RequestParam("txtApellido") String n_credito, @RequestParam("txtCedula") String maestro , Model m) {
        try {
            Materia materia = new Materia(nom, Integer.parseInt(n_credito));
            dao.crear(materia);
            return listar(m);
        } catch (ServicioExcepcion ex) {
            m.addAttribute("err", ex.getMessage());
            return "error";
        }
    }
   
    
}
