package com.modelo;

import com.modelo.Alumno;
import com.modelo.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-11T14:24:22")
@StaticMetamodel(Notas.class)
public class Notas_ { 

    public static volatile SingularAttribute<Notas, Alumno> idAlumno;
    public static volatile SingularAttribute<Notas, Double> nota;
    public static volatile SingularAttribute<Notas, Materia> idMateria;
    public static volatile SingularAttribute<Notas, Integer> idNotas;

}