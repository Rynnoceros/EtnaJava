Reponse question 1 :
La reflexivité est une méthode qui permet de parcourir une classe sans en connaître son contenu.
On appelle aussi cela faire de l'instrospection.
A partir d'une classe on peut créer une instance, accéder aux attributs public et privés, ainsi qu'aux méthodes.

Reponse question 2 :
Les avantages de la réfléxivité est que ça permet d'écrire du code générique.
A partir d'une class générique on peut récupérer et intéragir avec ses attributs et ses méthodes sans avoir besoin de connaître ce qu'elle contient.

Le gros inconvénients de la réfléxivité c'est que c'est groumand en ressources et que l'on peut perdre en performances.

Reponse question 3 :
On peut utiliser la réfléxivité dans la création d'objet générique comme un Dao.
On peut charger les attributs des classes avec les valeurs de la base de données 
(simplement si on considère que les attributs ont le même nom que les champs en bdd,
ou de manière plus approfondie en utilisant les annotations et en définissant un nom de champ pour chaque attribut)
  
Reponse question 4 :
La difference principale entre un DriverManager et un DataSource est que le datasource permet de gérer des pools de connexions.
Un DriverManager ouvre et ferme la connexion à la base de données entre les classes alors que le datasource permet de conserver une connexion active.

Un DriverManager est plus lent qu'un DataSource du fait que l'on ouvre et que l'on ferme la connexion à chaque fois.

Reponse question 5 :
Le test unitaire charge la base de données et ne va pas plus.
Cela s'explique par le fait que l'on ait limité le nombre de connexion actives à 1 et SURTOUT
au fait que l'on ne libère plus les ressources à l'aide du ConnectionHelper.
Le système considère que le process qui a chargé la base de données est encore connecté et du coup tout autre
process qui souhaiterait accéder à la base de données doit attendre que la connexion se libère.


