
# Jeu De Formes

## Description

C'est un projet pédagogique Java qui met en lumière l'utilisation de divers patterns de conception fondamentaux. 
À travers ce jeu, vous découvrirez comment ces patterns s'articulent pour créer une application cohérente et extensible.

### Les patterns mis en avant 
- MVC (Modèle-Vue-Contrôleur) : Ce pattern structure l'application en trois composants distincts : le modèle gère les données, la vue affiche les données et le contrôleur gère les interactions entre l'utilisateur et l'application.
- Commande : Ce pattern encapsule les actions de dessin sous forme d'objets "commande". Cela permet de les exécuter, annuler et rejouer facilement.
- Observateur : Ce pattern assure la communication entre les objets. Lorsqu'un objet change d'état, les objets observateurs en sont notifiés et mettent à jour leur affichage en conséquence.
- Stratégie : Ce pattern permet de définir différentes algorithmes de positionnement des formes, offrant ainsi une grande flexibilité à l'application.
- State : Ce pattern permet de représenter l'état interne d'un objet et de le modifier de manière contrôlée.
- Méthode Factory : Ce pattern permet de créer des objets d'une manière flexible, en cachant la complexité de l'instanciation au client.

## Utilisation

L'application démarre avec une interface graphique où vous pouvez choisir entre ajouter des formes, les déplacer, les supprimer ou modifier leurs tailles. 

Utilisez les boutons fournis dans l'interface pour interagir avec les formes.

### Structure du Projet

Le projet est organisé comme suit :


```plaintext
.
├── build  Répertoire de build contenant les fichiers .class compilés.
├── dist   Contient les archives exécutables du projet, y compris le fichier .jar.
├── doc    Documentation générée automatiquement pour le projet.
├── lib    Bibliothèques tierces nécessaires pour le projet.
├── src    Contient les sources du projet, y compris les contrôleurs, modèles et vues.
├── test   Contient les tests unitaires pour le projet.
```
### Démarrage rapide

Pour lancer l'application, suivez ces instruction

### Prérequis

- Java JDK 11 ou supérieur
- Apache Ant (pour la construction du projet si `build.xml` est utilisé)

### Installation

1. Clonez le dépôt sur votre machine locale :

```bash
git clone git@github.com:Ahmat-2000/projetAnnuel.git
```

2. Naviguez dans le dossier du projet :

```bash
cd JeuDeFormes
```

3. Compilez le projet (si vous utilisez Apache Ant) :

```bash
# Si vous avez fait des modifications, il suffit de lancer la commande ant
ant 
```

4. Exécutez le fichier JAR :

```bash
java -jar dist/JeuDeFormes-1.0.jar
```

## Diagrame

![Diagrame](src/images/Diagram.jpeg)

## Contribuer

Les contributions à ce projet sont les bienvenues.

## Licence

Ce projet est en open source

## Contact

Pour toute question ou suggestion, n'hésitez pas à contacter Ahmat à ahmatmhtlouky@gmail.com.

## Remerciements

- Merci à tous ceux qui contribuent à enrichir ce projet.
