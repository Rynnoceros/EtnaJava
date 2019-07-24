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
        <link rel="stylesheet" href="assets/css/master.css"> 
    </head>
    <body>
        <div class="outer">
            <div class="header-outer" id="header-outer">
                <!-- Header -->
                <header id="header"  class="header">
                    <div class="header padd-top">
                        <a href="index.html" title="Ebenus" class="logo"> 
                            <img src="./assets/images/logo/logo.png" alt="Ebenus"> 
                        </a>
                    </div>
                </header>
            </div>
            <!-- Section -->
            <section>
                    <div class="content">
                        <div class="User quest">
                            <h1>                                
                                <c:if test="${produitToUpdate.getIdProduit() == null}">
                                    Créer un produit
                                </c:if>
                                <c:if test="${produitToUpdate.getIdProduit() != null}">
                                    Mettre à jour un produit
                                </c:if>
                            </h1>
                            <h2>
                                <c:if test="${error != null}"><div style="color:red;"><c:out value="${error}"/></div></c:if>
                            </h2>
                            <form  method="post" id="customer-info-form" class="no-gutters">
                                <div class="account-container row">
                                    <fieldset class=" common-form-controls col-md-6">
                                        <div >
                                            <p>Informations Produit</p>
                                            <div class="input-wrapper">
                                                <label for="nomProduit">Nom du produit</label>
                                                <input  autocomplete="off"  name="nomProduit" id="nomProduit" type="text" value="<c:out value="${produitToUpdate.getNom()}"/>">
                                            </div>
                                            <div class="input-wrapper">
                                                <input  name="active" id="active" type="checkbox" <c:out value="${produitToUpdate.getActive() == true ? 'checked' : ''}"/>>
                                                <label for="active">Activer produit</label>
                                            </div>
                                            <div class="input-wrapper">
                                                <label for="reference">Reference</label>
                                                <input  autocomplete="off"  name="reference" id="reference" type="text" value="<c:out value="${produitToUpdate.getReference()}"/>">
                                            </div>
                                            <div class="input-wrapper">
                                                <label for="description">Description du produit</label>
                                                <input  autocomplete="off" name="description" id="description" type="text" value="<c:out value="${produitToUpdate.getDescription()}"/>">
                                            </div>
                                            <div class="input-wrapper">
                                                <label for="stock">Quantité en stock</label>
                                                <input  autocomplete="off" name="stock" id="stock" type="number" value="<c:out value="${produitToUpdate.getStock()}"/>">
                                            </div>
                                            <div class="input-wrapper">
                                                <label for="prix">Prix</label>
                                                <input  autocomplete="off" name="prix" id="prix" type="number" value="<c:out value="${produitToUpdate.getPrix()}"/>">
                                            </div>
                                        </div>
                                    </fieldset>
                                </div>
                                <div class="row">
                                    <div class="actions col-md-4">
                                        <button type="submit">
                                            <c:if test="${produitToUpdate.getIdProduit() == null}">Ajouter</c:if>
                                            <c:if test="${produitToUpdate.getIdProduit() != null}">Modifier</c:if>
                                        </button>
                                    </div>
                                </div>
                            </form>
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
        </div>
        <!-- JS files -->
        <script src="assets/js/bower.js" type="text/javascript"></script>
        <script src="assets/js/application.js" type="text/javascript"></script>
    </body>
</html>
