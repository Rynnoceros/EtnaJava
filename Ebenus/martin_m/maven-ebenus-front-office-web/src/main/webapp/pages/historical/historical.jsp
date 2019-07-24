<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<!DOCTYPE HTML>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
                                                        
                                                        var id = 0;
                                                        var idSelect = 0;
$(function(){

//Récupération au chargement de la page.
selected_year=$('#select-commandes-ship').val();

//Récupération au changement de valeur du select.
$("#select-commandes-ship").on('change',function(){
selected_year=$("#select-commandes-ship").val();
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
						<li><a href="PersonnalInformationServlet?id=<c:out value="${loggedUser.getIdUtilisateur()}"/>">Mon Compte</a></li>
						<li class="guest">
                                                    <c:choose>
                                                        <c:when test="${connected == 'true'}">
                                                            <a href="LogoutServlet">Logout</a> 
                                                        </c:when>    
                                                        <c:otherwise>
                                                            <c:set var="connected" value="false" />
                                                            <a href="LoginServlet">Login</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    
                                                    
						</li>
						<li class="logged">
                                                    <%--<c:out value="${connected} "/>--%>
                                                    <c:if test="${connected = true}">
							<a href="PersonnalInformationServlet?id=<c:out value="${loggedUser.getIdUtilisateur()}"/>"><strong><c:out value="${loggedUser.getCivilite()} ${loggedUser.getNom()} ${loggedUser.getPrenom()}"/></strong></a>
                                                     </c:if>    
                                                        
                                                </li>
						<li><a href="BasketServlet">Panier</a></li>
                                                <c:if test="${connected = false}">
							<li><a href="creer-compte-client.html">Créer Compte</a></li>
                                                </c:if> 
						</ul>
						</li>
						<li class="header-icon-cart">
    <a class="menu-cart-icon" href="BasketServlet"><i class="icon-cart"></i></a>
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
	<h1>Compte Client</h1>
	<div class="account-container row no-gutters">
		<div class="facet-navigation col-md-3">
	<ul>
		<li><a href="PersonnalInformationServlet?id=<c:out value="${loggedUser.getIdUtilisateur()}"/>">Information personnelles</a></li>
		<li><a href="ClientAdresseServlet?id=<c:out value="${loggedUser.getIdUtilisateur()}"/>">Gérer mon carnet d'adresses</a></li>
		<li><a href="HistoricalServlet?id=<c:out value="${loggedUser.getIdUtilisateur()}"/>">Historique des commandes</a></li>
		
	</ul>
</div>
		<div class=" common-form-controls order-history col-md-9">
		
		<h1>Historique des Commandes</h1>
		<div class="row no-gutters">
			<div class="col-md-12">
                            <p> <span>commandes N°: </span>
                                
                                <!--<b><c:forEach items="${allCommandesId}" var="commande"><c:out value="${commande.getCommande().getIdCommande()}"/>  </c:forEach></b>--> 
                            <select name="select-commandes" id="select-commandes-ship" >
                                              
                                <option id="-1" value="Mes commandes" disabled selected="selected">Mes commandes</option>
                                            <c:forEach var="i" begin="1" end="${compteurCommande}">
                            
                                                <%--<c:if test="${adressesL.getUtilisateur().getIdUtilisateur() == utilisateurToUpdate.idUtilisateur && adressesL.getTypeAdresse() == 'L'}">--%>
                                                     <%--<c:set var="cpt" value="${cpt + 1}" scope="page"/>--%>
                                                    <option id = "${cpt}" value="${i}">${i}</option>
                                                <%--</c:if>--%>  
                                            </c:forEach>
                                                   
					  </select>
                            
                            </p>
				<p><span>transporteur :</span> Livraison en magasin sous 6 à 7 joursouvrès</p>
				<p><span>méthode de paiement :</span> carte de crédit visa</p>
			</div>
                            
			<div class="billing-adress col-md-5">
				<h3>Facture</h3>
				<p>
                                <c:out value="${loggedUser.getPrenom()} ${loggedUser.getNom()}"/>    
				<c:out value="${adresseFacturation}"/>
				</p>
			</div>
			<div class="offset-md-2"></div>
			<div class="shipping-adress col-md-5">
				<h3>Livraison</h3>
				<p>
				<c:out value="${loggedUser.getPrenom()} ${loggedUser.getNom()}"/>    
				<c:out value="${adresseLivraisonPrincipale}"/>
				</p>
			</div>
			<div class="col-md-12">
                            
                            <c:forEach items="${allCommandesId}" var="commandeId" varStatus="theCount">
                                
                                <div id="ma_div_${theCount.count}" class ="mes_divs" style="display:none" >
                                    <%--<c:out value="${commandeId.getCommande().getIdCommande()}" />--%>
<%--<c:out value="${allCommandesId.get(theCount.count-1).getCommande().getIdCommande()}" />--%>
                                  <div class="column-labels">
                                    <label class="product-image">Image</label>
                                    <label class="product-details">Produit</label>
                                    <label class="product-price">Prix</label>
                                    <label class="product-quantity">Quantité</label>
                                    <label class="product-line-price">Total</label>
                                  </div>
                                  
                                  <c:forEach items="${allCommandesUser}" var="commandeUser" varStatus="theCount2">
                                     
                                      <c:if test="${commandeUser.getCommande().getIdCommande() == commandeId.getCommande().getIdCommande() }">
                                         
                                        
                                <!-- ////////////////////////////////////////////  Row   /////////////////////////////////////// -->
                                  <div class="product">
                                     <div class="product-image">
                                      <img src="https://www.materiel.net/live/360365.350.350.jpg">
                                    </div>
                                    <div class="product-details">
                                        <h2 class="product-title">
                                          <a href="detail-produit-1.html">
                                              <%--<c:out value="${allCommandesId.get(theCount2.count-1).getCommande().getIdCommande()}" />--%>
                                              <c:out value="${commandeUser.getProduit().getNom()}" />
                                        <!--Smartphone Apple iPhone 7 (or) - 32 Go-->
                                          </a>
                                        </h2>
                                        <div class="product-description">
                                          <ul>
                                            <li><c:out value="${commandeUser.getProduit().getDescription()}" escapeXml="false"/></li>
                                            
                                          </ul>
                                        </div>
                                    </div>
                                    <div class="product-price"><c:out value="${commandeUser.getProduit().getPrix()}" /></div>
                                    <div class="product-quantity">
                                      <span><c:out value="${commandeUser.getQuantite()}" /></span>
                                    </div>
                                    <c:set var="prixTT" value="${commandeUser.getProduit().getPrix() * commandeUser.getQuantite()}" />
                                    <c:set var="prixTTCom" value="${commandeUser.getTotalArticleCommande()}" />
                                    <div class="product-line-price"><c:out value="${prixTT}" />€</div>
                                  </div>
                                        </c:if>

                                <!-- ////////////////////////////////////////////  Row   /////////////////////////////////////// -->
                                </c:forEach>
                                <c:set var="test" value="0" />


                                  <div class="totals">

                                    <div class="totals-item totals-item-total">
                                      <label>Total</label>
                                      <div class="totals-value" id="cart-total"><c:out value="${commandeId.getCommande().getTotalCommande()}" /> </div>
                                    </div>
                                  </div>



                                </div> 

                                </c:forEach>
			</div>
		</div>
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
