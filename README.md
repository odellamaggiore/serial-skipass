# serial-skipass

Installation (spring-boot) :

Build : `mvn clean install`
Run : `mvn spring-boot:run`

Database console available at `http://localhost:8080/h2/`

Database preloaded with skipass #200

Démarrer une session de ski pour un forfait et une station : 

PUT http://localhost:8080/rest/api/v1/forfaits/200/start
Request Body (JSON) : idResort (Long)

Le démarrage d'une nouvelle session de ski arrête automatiquement les sessions en cours pour le même forfait.
Le démarrage d'une nouvelle session de ski alors qu'une session est déjà en cours pour le forfait et la station ne fait rien.

Stops arréter toutes les sessions de ski en cours pour un forfait.

PUT http://localhost:8080/rest/api/v1/forfaits/200/stop
Request Body (JSON) : empty
 
