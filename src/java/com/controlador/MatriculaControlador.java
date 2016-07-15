/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Alumno;
import com.modelo.Materia;
import com.modelo.Matricula;
import com.servicio.AlumnoDAO;
import com.servicio.MateriaDAO;
import com.servicio.MatriculaDAO;
import com.servicio.ServicioExcepcion;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
@RequestMapping("matricula")
public class MatriculaControlador {
     @Autowired
    private MateriaDAO daomateria;
    
    @Autowired
    private AlumnoDAO daoalumno;
    
    @Autowired
    private MatriculaDAO dao;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model m) {
        try {
            List<Matricula> resultado = dao.listar();
            m.addAttribute("resultado", resultado);
            return "Matricula/listar";

        } catch (ServicioExcepcion e) {
            m.addAttribute("err", e.getMessage());
            return "error";
        }
    }
     @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String crear(Model m) throws ParseException {
        try {
           
            List<Alumno> alumno = daoalumno.listar();
            Alumno seleccion = new Alumno(0,"-- Seleccione --","","");
            alumno.add(0, seleccion);
            List<Materia> materia = daomateria.listar();
           
            Materia seleccionmateria = new Materia(0,"--Seleccione--",0  );
            materia.add(0, seleccionmateria);
            m.addAttribute("alumnos",alumno);
            m.addAttribute("materias",materia);
            return "Matricula/crear";
        } catch (ServicioExcepcion e) {
            m.addAttribute("err", e.getMessage());
            return "error";
        }

    }
    
    @RequestMapping(value="/crear",method = RequestMethod.POST)
    public String guardar( @RequestParam("cboalumno") String alumno, @RequestParam("cbomateria") String materia ,@RequestParam("txtfecha") String f, Model m) throws ParseException {
        try {
            int idmateria = Integer.parseInt(materia);
            int idalumno = Integer.parseInt(alumno);
            DateFormat formato = new SimpleDateFormat("mm/dd/yyyy", Locale.getDefault());
            Date fecha = formato.parse(f);
            Materia resultado_materia = this.daomateria.consultar(idmateria);
            Alumno resultado_alumno = this.daoalumno.consultar(idalumno);
            Matricula matricula = new Matricula(resultado_materia,resultado_alumno,fecha);
            dao.crear(matricula);
            return listar(m);
        } catch (ServicioExcepcion ex) {
            m.addAttribute("err", ex.getMessage());
            return "error";
        }
    }
   
}
