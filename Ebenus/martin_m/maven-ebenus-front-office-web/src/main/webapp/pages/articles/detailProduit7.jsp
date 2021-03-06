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
    <div class="outer">
        <div class="header-outer" id="header-outer">
	<!-- Header -->
	<header id="header"  class="header">
		<div class="header">
			<a href="index.html" title="Ebenus Commerce" class="logo"> 
				<img src="./assets/images/logo/logo.png" alt="Ebenus Commerce"> 
			</a>
		    <ul class="main-menu">
		    	<li><a href="index.html">Accueil</a></li>
		    	<li><a href="products.html">Produits</a></li>
		    	<li><a href="qui-sommes-nous.html">Qui sommes-nous</a></li>
		    	<li><a href="contact.html">Contactez-nous</a></li>
		    	<li class="last">
		    		<a href="#" class="account-link">Mon Compte</a>
					<ul class="sub-menu">
						<li><a href="informations-personnelle.html">Mon Compte</a></li>
						<li class="guest">
							<a href="login.html">Login</a>
						</li>
						<li class="logged">
							<a href="informations-personnelle.html"><strong>Mr John Doe</strong></a>
						</li>
						<li><a href="panier.html">Panier</a></li>
						<li><a href="creer-compte-client.html">Créer Compte</a></li>
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
                                                     

<div class="product-view " >
<div class="row no-gutters">
<div class="product-img-box col-md-7 ">
    <ul>
        <li>
        <img class="detail-img" src="https://dyw7ncnq1en5l.cloudfront.net/optim/produits/38/38349/acer-aspire-e5-575-50q4_0eff047069452594__450_400.jpg" alt="" />
    </li>
     
    </ul>
   
</div>

<div class="product-shop col-md-5">
    <div class="product-name">
        <h1>Ordinateur portable Acer Aspire E5-774-36WT - i3 - 4 Go - 1 To</h1>
    </div>
    <div class="short-description">
        <div class="std">
           <ul>
               <li>Écran : 17,3</li>
               <li>Modèle : Processeur Intel® Core™ i3-6006U ( 2 GHz)</li>
               <li>Capacité mémoire : 4 Go</li>
               <li>Espace disque total : 1000 Go</li>
               <li>Version système d'exploitation : Windows 10</li>
           </ul>
        </div>
    </div>
    <div class="product-info">
        <div>
            <div class="price-box">
                <span class="regular-price" id="product-price-101">
                    <span class="price">424,92€</span>
                </span>
            </div>
            <p class="reference-product">Ref : <strong>FE48E455R</strong></p>
            <div class="availability in-stock">Availability: <span>en stock</span>
                <p>Nous nous excusons de l’indisponibilité du produit, il sera bientôt disponible sous X semaines.</p>
            </div>
        </div>
    </div>

    <div class="add-to-box">
        <div class="add-to-cart">
            <label for="qty">Qty:</label>
            <div class="qty-holder">
                <input type="text" name="qty" id="qty" class="input-text qty" value="1">
                <div class="qty-changer">
                    <a href="javascript:void(0)" class="qty_inc"><i class="icon-up-dir"><em>+</em></i></a>
                    <a href="javascript:void(0)" class="qty_dec"><i class="icon-down-dir"> <em>-</em></i></a>
                </div>
            </div>
            <button type="button" title="Add to Cart" class="button btn-cart">
                <i class="icon-cart"></i>Ajouter au panier
            </button>
            
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
                        <li><i class="icon-right-dir theme-color"></i><a href="#" title="About us">Mon compte</a></li>
                        <li><i class="icon-right-dir theme-color"></i><a href="#" title="About us">A props de nous</a></li>
                        <li><i class="icon-right-dir theme-color"></i><a href="#" title="Contact us">Contacez nous</a></li>
                        <li><i class="icon-right-dir theme-color"></i><a href="pannier.html" title="Advanced search">Mon pannier</a></li>
                    </ul>
                </div>
            </div>
        </div>                

        <div class="col-sm-6 col-md-3"><div class="block">
            <div class="block-title"><strong><span>Information</span></strong></div>
            <div class="block-content">
                <ul class="features">
                    <li><i class="icon-ok theme-color"></i><a href="#">Historique des commandes</a></li>
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
