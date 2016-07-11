<%-- 
    Document   : crear
    Created on : 11/07/2016, 01:07:19 PM
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix= "sp" uri="http://www.springframework.org/tags/form" %>
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
                                Nueva Materia
                            </h1>
                        </div>
                    </div>
                    <!-- /.row -->

                    <!-- Page Content-->
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/materia/crear.htm" method="POST">
                        <hr/>
                        <div class="form-group">
                            <label for="txtNombre" class="col-lg-2 control-label">Nombre de la Materia:</label>
                            <div class="col-lg-6">
                                <input type="text" class="form-control" name="txtNombre">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtApellido" class="col-lg-2 control-label">Numero de Creditos</label>
                            <div class="col-lg-6">
                                <input type="text" class="form-control" name="txtApellido">
                            </div>
                        </div>
                        <sp:select id="cmbMaestros"  items="${maestros}" itemLabel="nombre" itemValue="idMaestro" path="maestros" multiple="true"></sp:select>
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-10">
                                <input type="submit" value="Guardar" class="btn btn-success" />
                                <a href="${pageContext.request.contextPath}/materia.htm" class="btn btn-danger">Cancelar</a>
                            </div>
                        </div>
                    </form>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->
        </div>
    </body>
</html>