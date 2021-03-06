<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>

    <head>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
                                                        
                                                        var id = 0;
                                                        var idSelect = 0;
$(function(){

//Récupération au chargement de la page.
selected_year=$('#select-adress-ship').val();

//Récupération au changement de valeur du select.
$("#select-adress-ship").on('change',function(){
selected_year=$("#select-adress-ship").val();
idSelect = $(this).val();
  id = "ma_div_" + $(this).val();
    // Je cache toutes les divs grâce à une classe qui va sélectionner le tout
    $('div.mes_divs').hide();
    // Et j'affiche seulement le Div que je souhaite
    $('#'+id).show();
    document.getElementById('ALid').value = idSelect;
//alert (idSelect);
});

});


</script>
        <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ebenus</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/logo/favicon.png">
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
		<div class="header">
			<a href="IndexServlet" title="Ebenus Commerce" class="logo"> 
				<img src="./assets/images/logo/logo.png" alt="Ebenus Commerce"> 
			</a>
		    <ul class="main-menu">
		    	<li><a href="IndexServlet">Accueil</a></li>
		    	<li><a href="ProductsServlet">Produits</a></li>
		    	<li><a href="WhoAreWeServlet">Qui sommes-nous</a></li>
		    	<li><a href="ContactServlet">Contactez-nous</a></li>
		    	<li class="last">
		    		<a href="#" class="account-link">Mon Compte</a>
					<ul class="sub-menu">
						<li><a href="PersonnalInformationServlet">Mon Compte</a></li>
						<li class="guest">
                                                    <a href="LogoutServlet">Logout</a> 
						</li>
						<li class="logged">
                                                    <a href="PersonnalInformationServlet"><strong><c:out value="${loggedUser.getCivilite()} ${loggedUser.getNom()} ${loggedUser.getPrenom()}"/></strong></a>
                                                </li>
						<li><a href="BasketServlet">Panier</a></li>
                                                
						</ul>
						</li>
                                                <li class="header-icon-cart">
    <a class="menu-cart-icon" href="panier.html"><i class="icon-cart"></i></a>
</li>
						</ul>
				
		    	
		    <div class="phone-block">
		    	<i class="icon-phone"></i>
		    	Appelez nous<br>
		    	<b>+33 5678 890</b>
		    </div>
	
		    <div class="search-area">
		    	<a href="javascript:void(0)" class="search-icon">
		    		<!-- <i class="fa fa-search"></i> -->
		    		<i class="icon-search"></i>
		    	</a>
		    	<form id="search_mini_form" action="" method="get">
				    <div class="form-search">
		                <input id="search" placeholder="Rechercher un produit" type="text" name="q" class="input-text" autocomplete="off">
		                <button type="submit" title="Search" class="button"><i class="icon-search"></i></button>
				    </div>
				</form>
		    </div>
		</div>
	</header>
</div>

        <!-- Section -->
        <section>
            <div class="content">
                <div class="customer-acount">
	<h1>Adresse Client</h1>
	<div class="account-container row no-gutters">
		<div class="facet-navigation col-md-3">
	<ul>
		<li><a href="PersonnalInformationServlet?id=<c:out value="${loggedUser.getIdUtilisateur()}"/>">Information personnelles</a></li>
		<li><a href="ClientAdresseServlet?id=<c:out value="${loggedUser.getIdUtilisateur()}"/>">Gérer mon carnet d'adresses</a></li>
		<li><a href="HistoricalServlet?id=<c:out value="${loggedUser.getIdUtilisateur()}"/>">Historique des commandes</a></li>
		
	</ul>
</div>
                
		<div class=" common-form-controls col-md-9">
			<div class="row no-gutters top-block">
				 <div class="sel-container col-md-6">
					 <div class="sel">
                                             <c:set var="id" value="0" scope="page"/>
					  <select name="select-adress" id="select-adress-ship" >
                                              
                                              <option id="-1" value="Mes adresses" disabled selected="selected">Mes adresses</option>
                                            <c:forEach items="${allAdresses}" var="adressesL">
                            
                                                <c:if test="${adressesL.getUtilisateur().getIdUtilisateur() == utilisateurToUpdate.idUtilisateur && adressesL.getTypeAdresse() == 'L'}">
                                                     <c:set var="cpt" value="${cpt + 1}" scope="page"/>
                                                    <option id = "${cpt}" value="${cpt}">${adressesL.getRue()} ${adressesL.getCodePostal()} ${adressesL.getVille()}</option>
                                                </c:if>  
                                            </c:forEach>
                                                   
					  </select>
                                            
                                            
					</div>
					
				</div>
<!--AddUserServlet-->

				<div class="col-md-6 adress-right-block">
                                        <div class="sel-container col-md-6">
					<form action="AddUserServlet" >
                                            <input type="hidden" value="${loggedUser.getIdUtilisateur()}" id="id" name ="id" />
                                            <button type="submit" name="Button" value="Ajouter">Ajouter adresse de livraison </button>
                                        </form>
                                            </div>
                                            <div class="row no-gutters top-block">
                                                <div class="sel-container col-md-6">
                                        <form id="customer-info-form" method="post" action="#" class="row validate no-gutters" >
                                            <input type="hidden" value="${loggedUser.getIdUtilisateur()}" id="id" name ="id" />
                                            <input type="hidden" value="" id="ALid" name ="ALid" />
                                            <button type="submit" name="Button" value="Retirer">Retirer</button>
					</form>
				  </div>
                                            </div>
				</div>


			</div>
                        <form id="customer-info-form" method="post" action="#" class="row validate no-gutters">
		<div id="customer-info-form" class="row no-gutters">
			<div class="row">
				<fieldset class="col-md-6">
                                    <h2>Adresse de facturation</h2>
					
                                             <c:forEach items="${allAdresses}" var="adresses">
                             
                                                    <c:if test="${adresses.getUtilisateur().getIdUtilisateur() == utilisateurToUpdate.idUtilisateur && adresses.typeAdresse == 'F'}">

                                                            <c:set var="rue" value="${adresses.getRue()}" />
                                                            <c:set var="codePostal" value="${adresses.getCodePostal()}" />
                                                            <c:set var="ville" value="${adresses.getVille()}" />
                                                            <c:set var="pays" value="${adresses.getPays()}" />
                                                    </c:if>
                                            </c:forEach>
						<label for="street">Rue</label>
						<input value="${rue}" name="street" id="street" type="text">
						<label for="postalcode">Code Postale</label>
						<input value="${codePostal}" name="postalcode" id="postalcode" type="text">
						<label for="city">Ville</label>
						<input value="${ville}" name="city" id="city" type="text">
						<label for="country">Pays</label>
						<input value="${pays}" name="country" id="country" type="text">
					<!--</form>-->
				</fieldset>

				<fieldset class="col-md-6">
			<div class="shipAddr">
				<h2>Adresse de livraison</h2>
					
                                        <input type="hidden" value="" id="ALid" name ="ALid" />
                                        <c:set var="AL" value="ALid" />
                                        
                                            <c:forEach items="${allAdressesLivraisonUser}" var="adressesL" varStatus="theCount">
                                                
                                                <div id="ma_div_${theCount.count}" class ="mes_divs" style="display:none" >
                                                    <c:out value="${theCount.count}" />
                                                    <%--<c:set var="AL" value="${adressesL.getIdAdresse()}" />--%>
                                                    <!--<input type="hidden" value="${adressesL.getIdAdresse()}" id="ALid" name ="ALid" />-->
                                                    <label for="streetShip">Rue</label>
                                                    <input value="${allAdressesLivraisonUser.get(theCount.count-1).getRue()}" name="streetShip${theCount.count}" id="streetShip" type="text">
                                                    <label for="postalcodeShip">Code Postale</label>
						<input value="${allAdressesLivraisonUser.get(theCount.count-1).getCodePostal()}" name="postalcodeShip${theCount.count}" id="postalcodeShip" type="text">
						<label for="cityShip">Ville</label>
						<input value="${allAdressesLivraisonUser.get(theCount.count-1).getVille()}" name="cityShip${theCount.count}" id="cityShip" type="text">
						<label for="countryShip">Pays</label>
						<input value="${allAdressesLivraisonUser.get(theCount.count-1).getPays()}" name="countryShip${theCount.count}" id="countryShip" type="text">
						<p>
                                                    <c:choose>
                                                        <c:when test="${allAdressesLivraisonUser.get(theCount.count-1).getPrincipale() == 'true'}">
                                                            <input class="princ_adr" type="checkbox" id="principal_adress${theCount.count}" name="principal_adress${theCount.count}" checked>
                                                        </c:when>    
                                                        <c:otherwise>
                                                            <input  class="princ_adr" type="checkbox" id="principal_adress${theCount.count}" name="principal_adress${theCount.count}">
                                                        </c:otherwise>
                                                    </c:choose>
						    
						    <label for="principal_adress">Adresse Principale</label>
						  </p>
                                                </div>
                                            </c:forEach>
                                                    
                                             
			</div>
			</fieldset>
			</div>
			

                <div class="actions">
                	<button type="submit" name="Button" value="Modifier">Modifier</button>
               	</div>

			
			

		</div>
                </form>

		</div>
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
                        <li><i class="icon-phone">&nbsp;</i><p><b>Tél:</b><br>(123) 456-7890</p></li>
                        <li><i class="icon-mail">&nbsp;</i><p><b>Email:</b><br><a href="mailto:mail@example.com">mail@example.com</a></p></li>
                        <li><i class="icon-clock">&nbsp;</i><p><b>Horaire Jours/Heures:</b><br>Lun - Dim / 9:00AM - 8:00PM</p></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-md-3"><div class="block">
            <div class="block-title"><strong><span>Mon compte</span></strong></div>
                <div class="block-content">
                    <ul class="links">
                        <li><i class="icon-right-dir theme-color"></i><a href="PersonnalInformationServlet?id=<c:out value="${loggedUser.getIdUtilisateur()}"/>" title="About us">Mon compte</a></li>
                        <li><i class="icon-right-dir theme-color"></i><a href="WhoAreWeServlet" title="About us">A props de nous</a></li>
                        <li><i class="icon-right-dir theme-color"></i><a href="ContactServlet" title="Contact us">Contacez nous</a></li>
                        <li><i class="icon-right-dir theme-color"></i><a href="BasketServlet" title="Advanced search">Mon pannier</a></li>
                    </ul>
                </div>
            </div>
        </div>                

        <div class="col-sm-6 col-md-3"><div class="block">
            <div class="block-title"><strong><span>Information</span></strong></div>
            <div class="block-content">
                <ul class="features">
                    <li><i class="icon-ok theme-color"></i><a href="HistoricalServlet?id=<c:out value="${loggedUser.getIdUtilisateur()}"/>">Historique des commandes</a></li>
                    <li><i class="icon-ok theme-color"></i><a href="#">Site Map</a></li>
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
                            <li><i class="icon-ok theme-color"></i><a href="#">Les Options de Transport</a></li>
                            <li><i class="icon-ok  theme-color"></i><a href="#">Avoir et Change</a></li>
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
        <div class="custom-block f-right"><div class="block-bottom">
            <div class="custom-block" >
            <img src="./assets/images/payment-icon.png" alt=""></div>

        </div>
        </div>                
    <address>© Ebenus eCommerce. 2018. Tous droit réservé</address>
    </div>
</div>
</div>
</div>   
</footer>

    </div>


        <!-- JS files -->
    <script src="./assets/js/bower.js" type="text/javascript"></script>
    
    <script src="./assets/js/application.js" type="text/javascript"></script>


















</body>
</html>
