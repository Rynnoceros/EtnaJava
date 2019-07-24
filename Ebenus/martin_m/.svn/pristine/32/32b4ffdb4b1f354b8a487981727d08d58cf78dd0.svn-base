<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
  <title>Ebenus Admin</title>
  <!-- Custom Fonts -->
  <!-- <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> -->

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800|Oswald:300,400,500,600,700" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
  <link rel="stylesheet" href="./assets/css/master.css">
  
</head>
<body>
    <div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar" role="navigation">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar">Menu</span>
        </button>
        <a class="navbar-brand" href="dashboard.html">Ebenus Admin</a>
      </div>
      <!-- Top Menu Items -->
      <ul class="nav navbar-right top-nav"> 
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i><c:out value="${loggedUser.getCivilite()} ${loggedUser.getNom()}"/><b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li>
              <a href="LogoutServlet"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
            </li>
          </ul>
        </li>
      </ul>
      <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
      <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav">
          <li class="active">
            <a href="dashboard.html"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
          </li>
          <li>
            <a href="CrudUserServlet"><i class="fa fa-users"></i> Utilisateurs</a>
          </li>
          <li>
            <a href="CrudRoleServlet"><i class="fa fa-user"></i> Rôles</a>
          </li>
          <li>
            <a href="CrudProductServlet"><i class="fa fa-money"></i> Produits</a>
          </li>
          
          <li>
            <a href="ListOrderServlet"><i class="fa fa-shopping-cart"></i> Commandes</a>
          </li>

        </ul>
      </div>
    <!-- /.navbar-collapse -->
    </nav>
    <div id="page-wrapper">
      <div class="container-fluid">
         <!-- Page Heading -->
        <div class="row">
          <div class="col-lg-12">
            <h1 class="page-header">
              Produits
            </h1>
            <ol class="breadcrumb">
              <li>
                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
              </li>
              <li class="active">
                <i class="fa fa-edit"></i> Produits
              </li>
            </ol>
          </div>
        </div>
        <!-- /.row -->
         <div class="row">
            <div class="well well-lg clearfix">
                <a href="AddProductServlet" role="button">Ajouter Produit</a>
            </div>
         </div>
          <!-- /.row -->
          <div class="row">
            <div class="panel panel-default">
              
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-users"></i> Liste des Produits</h3>
              </div>
              <div class="panel-body">
                <div class="well well-sm">
                  <form action="#" method="get">
                  <div class="input-group">
                      <input class="form-control" id="system-search" name="q" placeholder="Rechercher un produit" required>
                      <span class="input-group-btn">
                          <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                      </span>
                  </div>
                  </form>
                </div>
                <div class="table-responsive">
                  <table class="table table-bordered table-hover table-striped">
                    <thead>
                      <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Reference</th>
                        <th>Prix</th>
                        <th>Quantité</th>
                        <th>Editer</th>
                        <th>Supprimer</th>
                      </tr>
                    </thead>
                    <tbody id="test">
                        <c:forEach items="${allProducts}" var="product">
                        <tr>
                          <td><c:out value="${product.getIdProduit()}"/></td>
                          <td><c:out value="${product.getNom()}"/></td>
                          <td><c:out value="${product.getReference()}"/></td>
                          <td><c:out value="${product.getPrix()}"/></td>
                          <td><c:out value="${product.getStock()}"/></td>
                          <td><a href="AddProductServlet?id=<c:out value="${product.getIdProduit()}"/>"><i class="fa fa-edit"></i></a></td>
                          <td>
                              <c:if test="${loggedUser.getIdUtilisateur() != utilisateur.getIdUtilisateur()}"> 
                                <a <c:out value="id='${product.getIdProduit()}'"/> href="#" class="no-style-btn"><i class="fa fa-trash-o trash-product"></i></a>
                              </c:if>
                          </td>
                        </tr>
                      </c:forEach>                        
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>          
      </div>
      <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
  </div>
  <!-- /#wrapper -->
  <script src="./assets/js/bower.js" type="text/javascript" charset="utf-8"></script>
  <script src="./assets/js/application.js" type="text/javascript" charset="utf-8"></script>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" crossorigin="anonymous"></script>
</body>
</html>