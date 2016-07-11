package com.modelo;

import com.modelo.Maestro;
import com.modelo.Matricula;
import com.modelo.Notas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-11T15:05:53")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, String> nombre;
    public static volatile SingularAttribute<Materia, Maestro> idmaestro;
    public static volatile CollectionAttribute<Materia, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Materia, Integer> idMateria;
    public static volatile SingularAttribute<Materia, Integer> nCreditos;
    public static volatile CollectionAttribute<Materia, Notas> notasCollection;

}