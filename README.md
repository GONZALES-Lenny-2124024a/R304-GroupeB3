# R304 | Groupe B3
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

## Sujet

Vous devez écrire la spécification fonctionnelle technique et coder l’implémentation d’une
application en Java et ses tests, qui doit utiliser les concepts vus lors de cet enseignement.

Le sujet porte sur les réalisations des TD TD3 : Java, cas pratique et TD4 :
Algorithmique « avancée ».

La partie « graphique » de votre application peut être minimaliste (affichage en ligne de commande
par exemple).

Vous devez utiliser le plus possible d’algorithmique, de structures de données, de particularités
du langage Java et de modèles de conception, notamment ceux vus dans cet enseignement. En
particulier, votre application doit comporter des classes abstraites, des interfaces, des collections,
avec des itérateurs, des exceptions, des threads, de la généricité, et au moins un algorithme de tri.

Vous devez apporter un soin tout particulier à la présentation du code source (indentation, respect
d’une convention de nommage, commentaires, etc.) et à l’architecture des répertoires.
Votre application doit être évolutive, modulaire et professionnelle (robuste, fiable et intégralement
fonctionnelle).

## Présentation de l'application

Notre applcation est un jeu où l'utilisateur créer sa propre équipe de personnages parmi :
    - Mage
    - Archer
    - Healer

L'utilisateur peut combattre une équipe adverse généré automatiquement par rapport à l'équipe de l'utilisateur.
Lors d'un combat, l'utilisateur peut perdre un ou plusieurs de ses personnages, mais lorsque l'utilisateur gagne, chaque personnage de son équipe gagne de l'expérience et de l'argent (gold).
Avec cet argent, il peut acheter d'autres personnages et des équipements augmenteront les statistiques de ses personnages.

Pour finir, lorsque l'utilisateur a perdu un combat, la partie est finie puisqu'il ne possède plus aucun personnage.

## Lancement de l'application

Pour commencer, télécharger l'application en exécutant la commande :
```bash
git clone https://github.com/LennyGonzales/R304-GroupeB3.git
```

Puis à partir d'un IDE, exécuter simplement cette ligne du fichier Main.java
```java
    public static void main(String[] args) throws InterruptedException, EmptyNameForCharactersTeamException {
```

## Membres

- GANASSI Alexandre
- GONZALES Lenny
- SAUVA Mathieu
