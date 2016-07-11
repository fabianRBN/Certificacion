/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francisco Rubio
 */
@Entity
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n"),
    @NamedQuery(name = "Notas.findByIdNotas", query = "SELECT n FROM Notas n WHERE n.idNotas = :idNotas"),
    @NamedQuery(name = "Notas.findByNota", query = "SELECT n FROM Notas n WHERE n.nota = :nota")})
public class Notas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_notas")
    private Integer idNotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota")
    private double nota;
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    @ManyToOne(optional = false)
    private Alumno idAlumno;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne(optional = false)
    private Materia idMateria;

    public Notas() {
    }

    public Notas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public Notas(Integer idNotas, double nota) {
        this.idNotas = idNotas;
        this.nota = nota;
    }

    public Integer getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotas != null ? idNotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.idNotas == null && other.idNotas != null) || (this.idNotas != null && !this.idNotas.equals(other.idNotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Notas[ idNotas=" + idNotas + " ]";
    }
    
}
