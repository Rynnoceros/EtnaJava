<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        
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
    <div class="site-container">
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
                <div id="slider" class="owl-carousel owl-theme">
                    <c:forEach items="${articlesPlusVendu}" var="articles"  begin="1" end="5">
                        <div class="item">
                               <a href="DetailProductServlet?id=${articles.getProduit().getIdProduit()}"><img src="./assets/images/slider/${articles.getReference()}.jpg"/></a>
                         </div>

<!--                         <div class="item">
                               <a href="#"><img src="./assets/images/slider/ebenus-matelas_1.jpg"/></a>
                         </div>-->
                    </c:forEach>
                </div>
                <div class="products-container">
	<h1>Les produits les plus achetés</h1>
        
	<div class="row no-gutters products-box">
		
		<div class="products col-md-12">
			
		<ul class="row no-gutters justify-content-between">
                    
                    <c:forEach items="${articlesPlusVendu}" var="articles"  begin="6" end="15">
                        <%--<c:out value="stock: ${articles.getProduit().getStock()}"/>--%>
                        <%--<c:out value="${articles.getTotalCommande()} "/>--%>
                        <li class="col-sm-6 col-md-3 col-lg-2">
				<div class="image-wrapper">
					<img src="./assets/images/products/${articles.getReference()}.jpg"/>
					<a href="DetailProductServlet?id=${articles.getProduit().getIdProduit()}" class="add-to-cart-btn">
                                            
                                            <c:choose>
                                                <c:when test="${articles.getProduit().getStock() > 0}">
                                                    <button  class="addtocart" title="Add to Cart" >
							<i class="icon-cart"></i>
							<span href="BasketServlet">Ajouter au panier</span>
                                                    </button>
                                                </c:when>    
                                                <c:otherwise>
                                                    <p class="footer-container"> Nous nous excusons de l’indisponibilité du produit, il sera bientôt disponible sous X semaines</p>
                                                </c:otherwise>
                                            </c:choose>
                                                            
						
					</a> 
				</div>
                            
				<div class="product-info">
					<h2 class="product-name">
                                            
						<a href="DetailProductServlet?id=${articles.getIdArticleCommande()}">
                                                    
                                                    <c:out value="${articles.getProduit().getNom()}"/>
						
						</a>

					</h2>
					<div class="price-box">
						<span class="regular-price"><c:out value="${articles.getProduit().getPrix()}€"/></span>
					</div>
				</div>
                        </li>
                    </c:forEach>
		</ul>
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

