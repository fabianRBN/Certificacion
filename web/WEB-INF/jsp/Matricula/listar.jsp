<%-- 
    Document   : listar
    Created on : 12/07/2016, 05:19:24 PM
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/Recursos/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Recursos/css/sb-admin.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Recursos/css/plugins/morris.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Recursos/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <script src="${pageContext.request.contextPath}/Recursos/js/jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Recursos/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Recursos/js/plugins/morris/raphael.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Recursos/js/plugins/morris/morris.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Recursos/js/plugins/morris/morris-data.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.htm">SB Admin</a>
                </div>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li class="active">
                            <a href="index.htm"><i class="fa fa-fw"></i> Indice</a>
                        </li>
                        <li>
                            <a href="maestro.htm"><i class="fa fa-fw"></i> Maestros</a>
                        </li>
                        <li>
                            <a href="materia.htm"><i class="fa fa-fw"></i> Materia</a>
                        </li>
                        <li>
                            <a href="matricula.htm"><i class="fa fa-fw"></i> Matricula</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>

            <!-- Page -->
            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Matriculas
                            </h1>
                            <ol class="breadcrumb">
                                <li class="active">
                                    <i class="fa"></i> Lista de Matriculados
                                </li>
                            </ol>
                        </div>
                    </div>
                    <!-- /.row -->

                    <!-- Page Content-->
                    <div class="row">
                        <p>
                            <a href="${pageContext.request.contextPath}/matricula/crear.htm" class="btn btn-ls btn-default">Nuevo</a>
                        </p>
                    </div>
                        
                    <!-- Table -->
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Alumno</th>
                                        <th>Materia</th>
                                        <th>fecha</th>
                                       
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.resultado}" var="a">
                                        <tr>
                                            <td>${a.getIdMatricula()}</td>                            
                                            <td>${a.idAlumno.nombre}</td>
                                            <td>${a.idMateria.nombre}</td>
                                            <td>${a.getFechaM()}</td> 
                                           
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->
        </div>
    </body>
</html>

