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
                    <h1 class="page-header">Ajout d'une banque</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Coordonnées de la banque
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="addBanque" method="get">
                                        <div class="form-group">
                                            <label>Nom</label>
                                            <input class="form-control" name="nom" placeholder="Entrer le nom de la banque">
                                            <p class="help-block">Exemple : BNP</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Adresse</label>
                                            <input class="form-control" placeholder="Entrer l'adresse" name="adresse">
                                        </div>
                                        <div class="form-group">
                                            <label>Code postal</label>
                                            <input class="form-control" placeholder="Entrer le code postal" name="codePostal">
                                        </div>
                                        <div class="form-group">
                                            <input type="submit" class="btn btn-info" value="Enregister">
                                        </div>
                                        
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
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