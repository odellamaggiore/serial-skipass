# Introduction
A completer, présentation générale du sujet

# Instructions générales
- Repository à cloner pour le module backend (spring-boot) :
```https://github.com/odellamaggiore/serial-skipass```

- Repository à cloner pour le module frontend (angular) :
```https://github.com/ccasenove/serial-skipass-frontend```

- Les tests unitaires doivent être inclus dans la solution transmise.

# Exercice 1 : Liste des stations
**Objectif** : Créér un endpoint REST permettant d'obtenir la liste des stations configurées dans le système et exploiter ce endpoint dans l'interface utilisateur.

- Le endpoint doit respecter l'interface suivante : 
```java
List<ResortDto> listResort()
```
- L'objet **ResortDto** encapsulant les caractéristiques d'une station à exposer est déjà présent dans les sources et contient les attributs suivants :
```java
	private Long idResort;
	private String resortName;
	private BigDecimal hourlyGrossPrice;
```
- La table resort doit être créée, et alimentée avec quelques données de test à ajouter dans le fichier 
```sh
src/main/resources/data.sql
```

- Exploiter ce endpoint REST dans le projet front pour alimenter le dropdown **select-station** de la page **home** (MainComponent).

# Exercice 2 : calcul de la facture du mois
**Objectif** : Exposer en REST un service permettant de calculer et d'obtenir la facture du mois courant pour un forfait.

- L'objet **SkiPassInvoiceDto** encapsulant les caractéristiques d'une facture à exposer est déjà présent dans les sources et contient les attributs suivants : 
```java
 	private Long idSkiPass;
 	private List<SkiSessionDto> invoiceSessions;
 	private Instant invoicePeriodStartDate;
 	private Instant invoicePeriodEndDate;
 	private BigDecimal invoiceGrossAmount;
 	private BigDecimal invoiceNetAmount;
```
- Le montant brut de la facture doit être calculé en fonction de la durée de chaque session et du prix brut par heure de chaque station (modélisé dans l'exerice 1).
- Le montant net de la facture doit être calculé à partir du taux de TVA qui sera stocké dans une property à ajouter dans le fichier application.properties.

# Exercice 3 : Affichage de la facture du mois
**Objectifs** : Exploiter le service REST développé dans l'exercice 2 pour afficher la facture détaillée du mois courant dans l'interface utilisateur.

- Dans l'application front, créér une nouvelle page permettant de visualiser la facture du mois courant en exploitant le enpoint developpé dans l'exercice 2.
***<ajout instructions Cédric, composant à utiliser, maquette ?>***

# Exercice 4 : Pull requests

- A completer PR front
- A completer PR back
