Reponse question 1 :
A quoi sert la méthode toString() ?
Elle permet de redéfinir la description de l'objet. 
Par exemple lorsque l'on fait un System.out.println d'un objet, 
par défaut ce qui est affiché est le nom de la classe ainsi que son hashCode.
Le fait de définir la méthode toString() permet de remplacer cet affichage oar défaut.

A quoi sert la méthode equals() ?
La méthode equals permet de définir ce qui fait que 2 objets sont considérés comme égaux.
Par défaut en l'égalité entre 2 objets se fait avec leur adresse mémoire.
Si l'on souhaite que 2 objets soient considérés comme égaux par leur contenu, on peut surcharger cette méthode.


A quoi sert la méthode hashCode() ?
La méthode hashCode est une représentation numérique d'une instance d'un objet.
Cela permet de savoir notamment si le contenu d'un objet a été altéré durant l'exécution d'un programme.


Reponse question 2 :
List et Tableau ?
List est une interface définissant une liste à taille variable d'objet.
Un tableau est une liste à dimension fixe. C'est une structure de données dont les éléments sont généralement stockés les uns à la suite des autres en mémoire.

List et ArrayList ?
List est une interface et ArrayList est une des multiples implémentation de cette interface.

Map et HashMap ?
Map est une interface définissant une liste de type <Clé, Valeur>. La clé est généralement l'id de l'élément stocké et la valeur est l'objet en lui-même.
Une HashMap est une des multiples implémentation de l'interface Map.

Set et HashSet ?
Set est une interface définissant une liste non ordonnées d'objet. On ne peut pas par exemple insérer un élément dans un Set à une position précise.
De plus un Set ne peut pas contenir 2 fois le même objet.
Un HashSet est une des multiples implementation de l'interface Set.

List et Set ?
Une liste de type List contient des objets que l'on peut insérer à la position que l'on souhaite.
Une liste de type Set contient des objets qui sont ajoutés les uns à la suite des autres.
De plus un Set ne peut pas contenir 2 fois le même objet alors qu'une List si.

Reponse question 3 :
L'avantage de l'utilisation du design pattern DAO est qu'il ajoute une couche d'abstraction entre la manipulation des objets et leur persistence en base de données.
Cela permet notamment de pouvoir modifier facilement la manière de persister les données sans changer le code (passer d'une base Oracle à une base in memory ou même à un fichier texte).





