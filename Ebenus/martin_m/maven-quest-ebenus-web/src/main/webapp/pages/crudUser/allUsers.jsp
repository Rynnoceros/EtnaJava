<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Ebenus</title>
        <!-- CSS files -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800|Oswald:300,400,500,600,700" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/master.css"> 
    </head>
    <body>
        <div class="outer">
            <div class="header-outer" id="header-outer">
                <!-- Header -->
                <header id="header"  class="header">
                    <div class="header padd-top">
                        <a href="${pageContext.request.contextPath}" title="Ebenus" class="logo"> 
                            <img src="./assets/images/logo/logo.png" alt="Ebenus"> 
                        </a>
                    </div>
                </header>
            </div>
            <!-- Section -->
            <section>
                <div class="content">
                    <div class="User export">
                        <h2 style="margin-top: 20px;display: inline-block;"> Bonjour <strong> <c:out value="${loggedUser.getCivilite()} ${loggedUser.getNom()}"/> </strong> avec le rôle <c:out value="${loggedUser.getRole().getIdentifiant()}"/>.</h2>

                        <h1 class="logout"> <a href="LogoutServlet" role="button">Se Deconnecter</a></h1> 
                        <ul class="User f-left">
                            <li>
                                <a href="ExportServlet?export=csv" role="button">Export des Utilisateurs au format Csv</a>
                            </li>
                            <li>
                                <a href="ExportServlet?export=xml" role="button">Export des Utilisateurs au format XML</a>
                            </li>
                            <li>
                                <a href="ExportServlet?export=json" role="button">Export des Utilisateurs au format Json</a>
                            </li>
                        </ul>
                        <h1 class="clearfix">liste des utilisateurs</h1>


                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Civilite</th>
                                        <th>Prénom</th>
                                        <th>Nom</th>
                                        <th>Identifiant</th>
                                        <th>Date naissance</th>
                                        <th>Date création</th>
                                        <th>Date modification</th>
                                        <th>Identifiant rôle</th>
                                        <th>Description rôle</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${allUsers}" var="utilisateur">
                                        <tr> 
                                            <td><c:out value="${utilisateur.getCivilite()}"/></td>
                                            <td><c:out value="${utilisateur.getPrenom()}"/></td>
                                            <td><c:out value="${utilisateur.getNom()}"/></td>
                                            <td><c:out value="${utilisateur.getIdentifiant()}"/></td>
                                            <td><c:out value="${utilisateur.getDateNaissance()}"/></td>
                                            <td><c:out value="${utilisateur.getDateCreation()}"/></td>
                                            <td><c:out value="${utilisateur.getDateModification()}"/></td>
                                            <td><c:out value="${utilisateur.getRole().getIdentifiant()}"/></td>
                                            <td><c:out value="${utilisateur.getRole().getDescription()}"/></td>
                                            <td>
                                                <c:if test="${isAdministrateur}">
                                                    <a href="AddUserServlet?id=<c:out value="${utilisateur.getIdUtilisateur()}"/>"><i class="fa fa-edit"></i></a>
                                                    <c:if test="${loggedUser.getIdUtilisateur() != utilisateur.getIdUtilisateur()}"> 
                                                    <a <c:out value="id='${utilisateur.getIdUtilisateur()}'"/> href="#" class="no-style-btn"><i class="fa fa-trash-o"></i></a>
                                                    </c:if>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <form method="POST" action="ImportServlet" enctype="multipart/form-data">
                                <ul class="User">
                                    <li>
                                        <div class="col-lg-12 no-padding">
                                            <a href="AddUserServlet" role="button">Ajouter Utilisateur</a>
                                            <!-- Select Basic -->
                                            <div class="form-group selectexport-box">
                                                <div class="input-file-box">
                                                    <input type="file" name="file-2[]" id="file-2" class="inputfile inputfile-2" multiple/>
                                                    <label for="file-2"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Parcourir</span></label>
                                                </div>
                                                <button type="submit" class="btn btn-default">Import d'utilisateurs à partir d'un fichier CSV</button>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </form>
                        </div>

                    </div> 
                </div>
            </section>
            <!-- Footer -->
            <footer>
                <div class="footer-container ">
                    <div class="footer">
                        <div class="footer-middle">
                            <div class="footer-container_">
                                <div class="row no-gutters"> 
                                    <div class="col-sm-6 col-md-3">
                                        <div class="block">
                                            <div class="block-title"><strong><span>Contactez Nous</span></strong></div>
                                            <div class="block-content">
                                                <ul class="contact-info">
                                                    <li><i class="icon-location">&nbsp;</i><p><b>Addresse:</b><br>123 Rue la victoire, 75000 Paris, France</p></li>
                                                    <li><i class="icon-phone">&nbsp;</i><p><b>Tél:</b><br>(+33) 00 11 00 11 00</p></li>
                                                    <li><i class="icon-mail">&nbsp;</i><p><b>Email:</b><br><a href="mailto:mail@example.com">mail@example.com</a></p></li>
                                                    <li><i class="icon-clock">&nbsp;</i><p><b>Horaire : </b><br>Lundi au Samedi</p></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3"><div class="block">
                                            <div class="block-title"><strong><span>Mon compte</span></strong></div>
                                            <div class="block-content">
                                                <ul class="links">
                                                    <li><i class="icon-right-dir theme-color"></i><a href="#" title="A propos de nous">Mon compte</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>                
                                    <div class="col-sm-6 col-md-3"><div class="block">
                                            <div class="block-title"><strong><span>Information</span></strong></div>
                                            <div class="block-content">
                                                <ul class="features">
                                                    <li><i class="icon-ok theme-color"></i><a href="#">Les informations</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3">
                                        <div class="block">
                                            <div class="block-title"><strong><span>Nos Services</span></strong></div>
                                            <div class="block-content">
                                                <ul class="features">
                                                    <li><i class="icon-ok  theme-color"></i><a href="#">Service Client</a></li>
                                                    <li><i class="icon-ok  theme-color"></i><a href="#">Politique d'Utilisation</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>              
                                </div>
                            </div>
                        </div>
                        <div class="footer-bottom">
                            <div class="footer-container_">                
                                <address>© Ebenus. 2019. Tous droit réservé</address>
                            </div>
                        </div>
                    </div>
                </div>   
            </footer>
            <!-- JS files -->
            <script src="./assets/js/bower.js" type="text/javascript"></script>
            <script src="./assets/js/application.js" type="text/javascript"></script>
        </div>   
    </body>
</html>
