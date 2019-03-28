# serial-skipass
Skipass

Build : mvn clean install
Run : mvn spring-boot:run

Database console available at http://localhost:8080/h2/
Database preloaded with skipass #200

Starts ski session for a skipass and resort : 
PUT http://localhost:8080/forfaits/200/start
Request Body (JSON) : idResort (Long)

Stops all opened ski sessions for a skipass: 
PUT http://localhost:8080/forfaits/200/stop
Request Body (JSON) : empty


 