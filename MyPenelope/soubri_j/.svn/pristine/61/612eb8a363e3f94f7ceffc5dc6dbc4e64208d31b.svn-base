-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 18 fév. 2019 à 17:52
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `base_penelope`
--

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idUtilisateur` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prenom` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `motPasse` char(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idUtilisateur`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `nom`, `prenom`, `motPasse`, `mail`, `admin`) VALUES
(1, 'Julien', 'Marshall', 'mdpAdmin', 'marshall@gmail.com', 1),
(2, 'Julien', 'Claire', 'mdpAdmin', 'claire@gmail.com', 1),
(3, 'Jacques', 'Dupont', 'mdpAdmin', 'dupontj@gmail.com', 1),
(4, 'Dupont', 'Dupont', 'mdpAdmin', 'dupontdpt@gmail.com', 1),
(5, 'Dupond', 'Dupond', 'mdpAdmin', 'dupontdpd@gmail.com', 1),
(6, 'Charles', 'Hallyday', 'mdpAdmin', 'hallyday@gmail.com', 1),
(7, 'Serge', 'Lama', 'mdpAdmin', 'lama@gmail.com', 1),
(8, 'Vincent', 'Thomas', 'mdpUser', 'thomas@gmail.com', 0),
(9, 'Eric', 'Dummat', 'mdpUser', 'dummat@gmail.com', 0),
(10, 'Nicolas', 'Samuel', 'mdpUser', 'samuel@gmail.com', 0),
(11, 'Rémy', 'Guerry', 'mdpUser', 'guerry@gmail.com', 0),
(12, 'Nicolas', 'Drapeau', 'mdpUser', 'drapeau@gmail.com', 0),
(13, 'Gaelle', 'Letourneau', 'mdpUser', 'letourneau@gmail.com', 0),
(14, 'Anne', 'Claire', 'mdpUser', 'claire@gmail.com', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
