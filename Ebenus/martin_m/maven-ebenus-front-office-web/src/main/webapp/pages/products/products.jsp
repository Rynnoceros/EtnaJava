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
                <div class="products-container">
	<h1>PRODUCTS</h1>
	<div class="row no-gutters products-box">
		<div class="side-bar col-md-3 col-sm-12">
			<dl class="filter-layers">
				<dt>Prix</dt>
				<dd> 
					<div class="text-box">
					<span>De</span> 
					<input type="text" name="min" id="minPrice" class="priceTextBox minPrice" value="5.9" /> 
					<span>à</span> 
					<input type="text" name="max" id="maxPrice" class="priceTextBox maxPrice" value="48.9" />
					<input type="button" value="FILTER" name="go" class="go" />

					</div>
				</dd>
			
				<dt>Produit</dt>
				<dd>
					<div class="text-box">
					<input type="text" name="min" id="minPrice" class="priceTextBox minPrice" placeholder="Filtrer par produit" value="" /> 
					<input type="button" value="FILTER" name="go" class="go" />
					</div>
				</dd>
			
				<dt>Description</dt>
				<dd>
					<div class="text-box">
					<input type="text" name="min" id="minPrice" class="priceTextBox minPrice" placeholder="Filtrer par description" value="" /> 
					<input type="button" value="FILTER" name="go" class="go" />
					</div>
				</dd>
			</dl>
		</div>
		<div class="products col-md-9">
			<div class="row no-gutters sort-by align-items-center justify-content-end">
				<!-- <div class="col-sm-6 col-md-4 col-lg-3">
					<span>Trier par</span>
				</div> -->
				<div class="col-sm-12 col-md-4 col-lg-3">
					<div class="sel-container">
						<div class="sel">
						  <select name="select-adress" id="select-adress">
						    <option value="Trier Par" disabled>Trier Par</option>
						    <option value="Prix">Prix</option>
						    <option value="Nom">Nom</option>
						    <option value="Ascendant">Ascendant</option>
						    <option value="Descendant">Descendant</option>
						  </select>
						</div>
					</div>
				</div>
			</div>
		<ul class="row no-gutters justify-content-between">
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://media.ldlc.com/ld/products/00/03/82/84/LD0003828453_2_0003828545_0003828620.jpg" alt="">
						<a href="detail-produit-1.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-1.html">
							Smartphone Apple iPhone 7 (or) - 32 Go
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">639,00€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://static.fnac-static.com/multimedia/Images/FR/NR/e0/66/85/8742624/1540-1/tsp20170425134533/Apple-iPhone-6-32-Go-4-7-Gris-Sideral.jpg" alt="">
						<a href="detail-produit-2.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-2.html">
							Smartphone Apple iPhone 6s (or) - 32 Go
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">529,00€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://boltmobile.ca/wp-content/uploads/2016/05/caseco-mfi-approved-lightning-cable-3-meter-white.png" alt="">
						<a href="detail-produit-3.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-3.html">
							Apple Câble Lightning / USB
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">27,95€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://i2.cdscdn.com/pdt2/7/8/5/1/700x700/bel0745883706785/rw/belkin-mini-chargeur-secteur-2-1a-avec-cabe-usb-a.jpg" alt="">
						<a href="detail-produit-4.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-4.html">
							Chargeur secteur Belkin Chargeur secteur USB 2,1A
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">27,95€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://media.ldlc.com/ld/products/00/04/52/55/LD0004525511_2.jpg" alt="">
						<a href="detail-produit-5.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-5.html">
							Ordinateur portable Asus Zenbook Flip 58256-B - i5 - 8 Go - 256 Go SSD
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">1 039,92€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://media.ldlc.com/ld/products/00/04/12/47/LD0004124748_2_0004428236.jpg" alt="">
						<a href="detail-produit-6.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-6.html">
							PC portable gamer MSI GS73 7RE-006FR - i7 - 8 Go - SSD - GTX 1050 Ti
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">1 299,90€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://dyw7ncnq1en5l.cloudfront.net/optim/produits/38/38349/acer-aspire-e5-575-50q4_0eff047069452594__450_400.jpg" alt="">
						<a href="detail-produit-7.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-7.html">
							Ordinateur portable Acer Aspire E5-774-36WT - i3 - 4 Go - 1 To
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">424,92€</span>
						</div>
					</div>
					
					
			</li>
			
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://dyw7ncnq1en5l.cloudfront.net/optim/produits/151/42217/msi-gt75-vr-7rf-titan-pro_a40abd709a72b84f__450_400.jpg" alt="">
						<a href="detail-produit-9.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-9.html">
							Appareil photo Compact Canon Ixus 185 Noir
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">99,00€</span>
						</div>
					</div>
					
					
			</li>

			<li class="col-sm-6 col-md-4 col-lg-3">
				<div class="image-wrapper">
					<img src="https://static.fnac-static.com/multimedia/Images/FR/NR/e0/66/85/8742624/1540-1/tsp20170425134533/Apple-iPhone-6-32-Go-4-7-Gris-Sideral.jpg" alt="">
					<a href="detail-produit-2.html" class="add-to-cart-btn">
						<button  class="addtocart" title="Add to Cart" >
							<i class="icon-cart"></i>
							<span>Ajouter au panier</span>
						</button>
					</a> 
				</div>
				<div class="product-info">
					<h2 class="product-name">
						<a href="detail-produit-2.html">
						Smartphone Apple iPhone 6s (or) - 32 Go
						</a>
					</h2>
					<div class="price-box">
						<span class="regular-price">529,00€</span>
					</div>
				</div>
				
				
		</li>

			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://i2.cdscdn.com/pdt2/3/5/4/1/700x700/fuj5474102917354/rw/fujifilm-instax-appareil-photo-instantane-wide-300.jpg" alt="">
						<a href="detail-produit-10.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-10.html">
							Appareil photo instantané Fujifilm Instax WIDE 300
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">119,00€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://asset.conrad.com/media10/isa/160267/c1/-/fr/1561298_AB_00_FB/fujifilm-instax-mini-9-appareil-photo-a-developpement-instantane-fumee-blanc.jpg?x=520&y=520" alt="">
						<a href="detail-produit-11.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-11.html">
							Appareil photo instantané Fujifilm Instax MINI 9 Blanc
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">89,00€ </span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://i2.cdscdn.com/pdt2/0/9/5/1/700x700/can8714574648095/rw/appareil-photo-numerique-canon-ixus-185-rouge-pack.jpg" alt="">
						<a href="detail-produit-12.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-12.html">
							Appareil photo Compact Canon Ixus 185 Rouge
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">99,00€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://media.materiel.net/r550/oproducts/AR201703160005_g1.jpg" alt="">
						<a href="detail-produit-13.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-13.html">
							PC Gamer MSI Vortex G25 8RD-028FR - i5 - 8 Go - GTX 1060 - SSD
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">1 349,90€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://media.materiel.net/r550/oproducts/AR201809110048_g1_0005161481.jpg" alt="">
						<a href="detail-produit-14.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-14.html">
							PC Gamer Materiel.net Level One XI par Canard PC [ Win10 - PC Gamer ]
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">689,99€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://images-na.ssl-images-amazon.com/images/I/41%2BenJA6eZL._SX355_.jpg" alt="">
						<a href="detail-produit-15.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-15.html">
							Souris gamer The G-Lab KULT#100
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">19,90€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://www.rueducommerce.fr/medias/6703e98af1e33b739c8a839b49c7d05a/p_580x580/9887806849054.png" alt="">
						<a href="detail-produit-16.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-16.html">
							Souris gamer The G-Lab KULT#100
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">19,90€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://www.materielmaroc.com/wp-content/uploads/2017/11/asus-cerberus-artic-2500-dpi-gaming.jpg" alt="">
						<a href="detail-produit-17.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-17.html">
							Souris gamer Asus Cerberus Mouse - Noir
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">29,90€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://www.plot-it.co.uk/images/3dconnexion_cadmouse_icreatia-540x300_large.png" alt="">
						<a href="detail-produit-18.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-18.html">
							Souris PC 3DConnexion SpaceNavigator
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">139,90€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://i2.cdscdn.com/pdt2/8/8/2/1/700x700/auc2009783379882/rw/coque-samsung-galaxy-a5-2017-noir.jpg" alt="">
						<a href="detail-produit-19.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-19.html">
							Smartphone Samsung Galaxy A5 2017 (noir)
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">349,00€ </span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://www.rueducommerce.fr/medias/bd5c4d9151443f239fc822ff5243b5ca/p_580x580/sgh-galaxy-a5-2017-rose.jpg" alt="">
						<a href="detail-produit-20.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-20.html">
							Smartphone Samsung Galaxy A5 2017 (rose)
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">349,00€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://i2.cdscdn.com/pdt2/3/7/o/1/700x700/samgalaxyj37o/rw/samsung-galaxy-j3-2017-or.jpg" alt="">
						<a href="detail-produit-21.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-21.html">
							Smartphone Samsung Galaxy J3 2017 (noir)
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">199,00€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://image.darty.com/audio_mp3_mp4/enceinte_ipod_ipad_iphone_mp3-chaine_hi-fi/chaine_micro/denon_n9_white_s1410174042310A_160425414.png" alt="">
						<a href="detail-produit-22.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-22.html">
							Mini-chaine Hi-Fi Bluetooth Denon CEOL Piccolo N4 Blanc
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">349,00€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://image.darty.com/audio_mp3_mp4/enceinte_ipod_ipad_iphone_mp3-chaine_hi-fi/chaine_micro/denon_dm41_bkbk_noir_s1706224328795A_161240667.jpg" alt="">
						<a href="detail-produit-23.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-23.html">
							Mini-chaine Hi-Fi Bluetooth Denon CEOL Piccolo N4 Noire
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">349,00€</span>
						</div>
					</div>
					
					
			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://i2.cdscdn.com/pdt2/3/6/0/1/400x400/lgcm8360/rw/lg-cm8360-mini-chaine-hi-fi.jpg" alt="">
						<a href="detail-produit-24.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-24.html">
							Mini-chaine Hi-Fi USB Philips BTB2370 Bluetooth Tuner FM Numérique et DAB
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">159,00€</span>
						</div>
					</div>
					
					
			</li>

			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="./assets/images/products/refrigerateurs/refrigerateur-1_1.jpg" alt="">
						<a href="detail-produit-25.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-25.html">
							BEKO Réfrigérateur 2 portes RED45DXP, 400L, Froid No Frost
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">599.00 €</span>
						</div>
					</div>

			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="./assets/images/products/refrigerateurs/refrigerateur-1_2.jpg" alt="">
						<a href="detail-produit-26.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-26.html">
							BEKO Réfrigérateur 2 portes RED45DXP, 400L, Froid No Frost
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">599.00 €</span>
						</div>
					</div>

			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="./assets/images/products/refrigerateurs/refrigerateur-1_3.jpg" alt="">
						<a href="detail-produit-27.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-27.html">
							BEKO Réfrigérateur 2 portes RED45DXP, 400L, Froid No Frost
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">599.00 €</span>
						</div>
					</div>

			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="./assets/images/products/refrigerateurs/refrigerateur-1_4.jpg" alt="">
						<a href="detail-produit-28.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-28.html">
							BEKO Réfrigérateur 2 portes RED45DXP, 400L, Froid No Frost
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">599.00 €</span>
						</div>
					</div>

			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="./assets/images/products/refrigerateurs/refrigerateur-2_1.jpg" alt="">
						<a href="detail-produit-29.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-29.html">
							BEKO Réfrigérateur 2 portes RED45DXP, 400L, Froid No Frost
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">599.00 €</span>
						</div>
					</div>

			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="./assets/images/products/refrigerateurs/refrigerateur-2_2.jpg" alt="">
						<a href="detail-produit-30.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-30.html">
							BEKO Réfrigérateur 2 portes RED45DXP, 400L, Froid No Frost
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">599.00 €</span>
						</div>
					</div>

			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="./assets/images/products/refrigerateurs/refrigerateur-2_3.jpg" alt="">
						<a href="detail-produit-31.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-31.html">
							BEKO Réfrigérateur 2 portes RED45DXP, 400L, Froid No Frost
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">599.00 €</span>
						</div>
					</div>

			</li>
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="./assets/images/products/tv/1.jpg" alt="">
						<a href="detail-produit-32.html" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
					</div>
					<div class="product-info">
						<h2 class="product-name">
							<a href="detail-produit-32.html">
							TV HD 32M4005, 100 PQI
							</a>
						</h2>
						<div class="price-box">
							<span class="regular-price">599.00 €</span>
						</div>
					</div>
			</li>
			
			
			

			
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

