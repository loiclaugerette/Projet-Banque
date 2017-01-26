<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bankroute - Gestion de banque</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
		<div id="wrapper">


		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar">
			<div class="sidebar-nav navbar-collapse";>
				<ul class="nav" id="side-menu">

					<li style="color: #b4e4b4;"><a href="toHome"><i
							class="fa fa-home fa-fw"></i> Accueil <span class="fa arrow"></span></a></li>


					<li><a href="#"><i class="fa fa-bank fa-fw"></i> Banque <span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="toAddBanque">Ajouter une banque</a></li>
							<li><a href="toGestionBanque">Gestion banque </a></li>
							</a></li>
				</ul>
				<!-- /.nav-second-level -->
				</li>
				<li><a href="tables.html"><i class="fa fa-user fa-fw"></i>Client<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="toAddClient">Ajouter un client</a></li>
						<li><a href="toGestionClient">Gestion clients</a></li>

					</ul> <!-- /.nav-second-level --></li>



				<li><a href="#"><i class="fa fa-users fa-fw"></i> Employé <span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="toAddEmploye">Ajouter un employe</a></li>
						<li><a href="toGestionEmploye">Gestion d'employes</a></li>

					</ul> <!-- /.nav-second-level --></li>
				<li><a href="#"><i class="fa fa-code-fork fa-fw"></i>
						Groupe <span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="toAddGroupe">Ajouter un groupe</a></li>
						<li><a href="toGestionGroupe">Gestion groupe</a></li>
					</ul> <!-- /.nav-second-level --></li>

				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side -->
		</nav>


        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Gestion des comptes</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           <p>Informations des comptes</p>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                
                                
                                
                                <div class="form-group">
                                    <table class="table table-striped">
                                    
	                                    <tr>
	                                    	<th>Code</th>
	                                    	<th>Nom</th>
	                                    	<th>Prénom</th>
	                                    	<th>Adresse</th>
	                                    	<th>Date d'adhésion</th>
	                                    </tr>
	                                    
	                                    <tr>
	                                    	<td>${comptesClientModel.client.code}</td>
	                                    	<td>${comptesClientModel.client.nom}</td>
	                                    	<td>${comptesClientModel.client.prenom}</td>
	                                    	<td>${comptesClientModel.client.adresse}</td>
	                                    	<td>${comptesClientModel.client.dateEntree}</td>
	                                    </tr>
                                    
                                    </table>
                                </div>
                                    
                                
                                  
                                  
                                <c:if test="${fn:length(comptesClientModel.comptes) > 0}">  

                                <div class="form-group">
                                	<h3>Comptes : </h3>
                                </div>

                                <div class="form-group">
                                    <table class="table table-striped">
                                    
	                                    <tr>
	                                    	<th>Numéro de Compte</th>
	                                    	<th>Solde</th>
	                                    	<th>Date de création</th>
	                                    	<th>Banque</th>
	                                    	<th>Créé par</th>
	                                    </tr>
	                                    
	                                    <c:forEach items="${comptesClientModel.comptes}" var="compte">
		                                    <tr>
		                                    	<td><a href="toCompte/${compte.idCompte}">${compte.numeroCompte}</a></td>
		                                    	<td>${compte.solde}</td>
		                                    	<td>${compte.dateCreation}</td>
		                                    	<td>${compte.banque}</td>
		                                    	<td>${compte.employe}</td>
		                                    </tr>
	                                    </c:forEach>
                                    
                                    </table> 
                                </div>
                                </c:if>
                                
                                <form action="toAddCompte/${comptesClientModel.client.idClient}" method="get">
                                	<div class="form-group">
                                		<input type="submit" value="Créer un nouveau compte" class="btn btn-info">	                                	
                                	</div>
                                </form>
                                    
                                    
                                    
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>



</body>
</html>