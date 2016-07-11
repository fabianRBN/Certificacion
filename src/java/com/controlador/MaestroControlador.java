/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Maestro;
import com.servicio.MaestroDAO;
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
 * @author Francisco Rubio
 */
@Controller
@RequestMapping("maestro")
public class MaestroControlador {

    @Autowired
    private MaestroDAO dao;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model m) {
        try {
            List<Maestro> resultado = dao.listar();
            m.addAttribute("resultado", resultado);
            return "Maestro/listar";

        } catch (ServicioExcepcion e) {
            m.addAttribute("err", e.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String crear() {
        return "Maestro/crear";
    }
    
    @RequestMapping(value="/crear",method = RequestMethod.POST)
    public String guardar(@RequestParam("txtNombre") String nom, @RequestParam("txtApellido") String ape, @RequestParam("txtCedula") String ced, Model m) {
        try {
            Maestro maestro = new Maestro(nom, ape, ced);
            dao.crear(maestro);
            return listar(m);
        } catch (ServicioExcepcion ex) {
            m.addAttribute("err", ex.getMessage());
            return "error";
        }
    }
}
