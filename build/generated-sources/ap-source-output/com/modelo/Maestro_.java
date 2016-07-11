package com.modelo;

import com.modelo.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-11T15:05:53")
@StaticMetamodel(Maestro.class)
public class Maestro_ { 

    public static volatile SingularAttribute<Maestro, Integer> idMaestro;
    public static volatile SingularAttribute<Maestro, String> nombre;
    public static volatile SingularAttribute<Maestro, String> apellido;
    public static volatile CollectionAttribute<Maestro, Materia> materiaCollection;
    public static volatile SingularAttribute<Maestro, Double> sueldo;
    public static volatile SingularAttribute<Maestro, String> cedula;

}