package com.modelo;

import com.modelo.Alumno;
import com.modelo.Materia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-11T12:02:54")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, Alumno> idAlumno;
    public static volatile SingularAttribute<Matricula, Materia> idMateria;
    public static volatile SingularAttribute<Matricula, Date> fechaM;
    public static volatile SingularAttribute<Matricula, Integer> idMatricula;

}