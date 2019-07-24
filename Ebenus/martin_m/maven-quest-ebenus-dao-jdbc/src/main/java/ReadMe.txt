Reponse question 1 :
Une injection SQL et une attaque par laquelle on injecte du code SQL dans un champ d'un formulaire.
Si j'ai par exemple un champ dans lequel un "pirate" rentre une requete du type "SELECT * FROM Users".
Ce genre d'attaque est possible lorsque les developpeurs font de la concaténation de string pour construire une requête SQL en dynamique.



Reponse question 2 :
Un statement est un statement utilisé pour des requêtes sans paramètres. 
Un prepared statement est utilisé pour faire des requêtes paramétrées (ex : "INSERT INTO table VALUES(?, ?, ?)")

L'avantage d'un statement c'est qu'il est plus rapide qu'un prepared statement. L'inconvénient c'est qu'il ne permet pas de faire des requêtes paramétrées.
Un prepared statement est moins rapide, mais il est plus sécurisé. Il permet de faire des requêtes paramétrées et SURTOUT il permet de "sanitariser" les paramètres passés à la requête.


Reponse question 3 :
Une jointure type INNER JOIN est une jointure entre deux tables qui permet de retourner uniquement les éléments qui existent dans les 2 tables jointes.
Une jointure type LEFT JOIN est une jointure entre deux tables qui permet de retourner tous les éléments de la table de "gauche" + les éléments existants à la fois dans la table de gauche et la table de "droite"
Une jointure type RIGHT JOIN est une jointure entre deux tables qui permet de retourner tous les éléments de la table de "droite" + les éléments existants à la fois dans la table de gauche et la table de "droite"
Une jointure type FULL OUTER JOIN est une jointure entre deux tables qui permet de retourner uniquement les éléments qui n'existent pas dans les 2 tables.





