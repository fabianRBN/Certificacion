package com.modelo;

import com.modelo.Matricula;
import com.modelo.Notas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-11T15:05:53")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, String> nombre;
    public static volatile SingularAttribute<Alumno, String> apellido;
    public static volatile SingularAttribute<Alumno, Integer> idAlumno;
    public static volatile CollectionAttribute<Alumno, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Alumno, Date> fechaN;
    public static volatile CollectionAttribute<Alumno, Notas> notasCollection;
    public static volatile SingularAttribute<Alumno, Double> deuda;
    public static volatile SingularAttribute<Alumno, Integer> cedula;

}