/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Francisco Rubio
 */
@Entity
@Table(name = "maestro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maestro.findAll", query = "SELECT m FROM Maestro m"),
    @NamedQuery(name = "Maestro.findByIdMaestro", query = "SELECT m FROM Maestro m WHERE m.idMaestro = :idMaestro"),
    @NamedQuery(name = "Maestro.findByNombre", query = "SELECT m FROM Maestro m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Maestro.findByApellido", query = "SELECT m FROM Maestro m WHERE m.apellido = :apellido"),
    @NamedQuery(name = "Maestro.findByCedula", query = "SELECT m FROM Maestro m WHERE m.cedula = :cedula"),
    @NamedQuery(name = "Maestro.findBySueldo", query = "SELECT m FROM Maestro m WHERE m.sueldo = :sueldo")})
public class Maestro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_maestro")
    private Integer idMaestro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo")
    private double sueldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmaestro")
    private Collection<Materia> materiaCollection;

    public Maestro() {
    }

    public Maestro(Integer idMaestro) {
        this.idMaestro = idMaestro;
    }

    public Maestro(Integer idMaestro, String nombre, String apellido, String cedula, double sueldo) {
        this.idMaestro = idMaestro;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.sueldo = sueldo;
    }
    
    public Maestro(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public Integer getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(Integer idMaestro) {
        this.idMaestro = idMaestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @XmlTransient
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaestro != null ? idMaestro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maestro)) {
            return false;
        }
        Maestro other = (Maestro) object;
        if ((this.idMaestro == null && other.idMaestro != null) || (this.idMaestro != null && !this.idMaestro.equals(other.idMaestro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Maestro[ idMaestro=" + idMaestro + " ]";
    }
    
}
