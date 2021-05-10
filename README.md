## Environment 🛠️:
- Ubuntu 20
- Java version: 11
- Maven version: 3.*
- Spring Boot version: 2.2.1.RELEASE`

## Requirements:
Desarrollar una API ​que retorne la fuente y contenido del mensaje de auxilio​ . Para esto, cuentas con tres satélites que te permitirán triangular la posición.

**Posición de los satélites actualmente en servicio:**
* Kenobi: [-500, -200]
* Skywalker: [100, -100]
* Sato: [500, 100]

`POST` request to `/topsecret` :
* Body request { "satellites": [ { “name”: "kenobi", “distance”: 100.0, “message”: ["este", "", "", "mensaje", ""] }, { “name”: "skywalker", “distance”: 115.5 “message”: ["", "es", "", "", "secreto"] }, { “name”: "sato", “distance”: 142.7 “message”: ["este", "", "un", "", ""] } ] }
* En caso que se detemine la posicion y el mensaje, se retorna 200 y el body de la respuesta es {"position":{"x":-100,"y":75.5},"message":"este es un mensaje secreto"}
* En caso que no se pueda determinar la posición o el mensaje, retorna 404.

`POST` request to `/topsecret/topsecret_split/<satellite_name>` :
* Body request { “distance”: 100.0, “message”: ["este", "", "", "mensaje", ""]}
* En el header se debe agregar la key "username" con el value deseado. No es requerido.
* Se guarda el registro en cache con el value de la key "username". Caso contrario se guarda con el value "anonymous"
* retorna 200

`GET` request to `/topsecret/topsecret_split` :
* En el header se debe agregar la key "username" con el value deseado. No es requerido.
* Se recupera la informacion del "username" en cache. En caso que se detemine la posicion y el mensaje, se retorna 200 y el body de la respuesta es {"position":{"x":-100,"y":75.5},"message":"este es un mensaje secreto"}
* En caso de no tener suficiente información se retorna 404.

## URLs 💻

**Amazon Web Services**

[Production](http://apifuegoquazar-env.eba-s4adgjy4.us-east-2.elasticbeanstalk.com/swagger/swagger-ui/index.html?configUrl=/swagger/api-docs/swagger-config)


## Commands for local environment
- run: 
mvn clean package; java -jar target/api-fuego-quazar-1.0.jar

- install: 
mvn clean install

- test: 
mvn clean test


## Author ✒️

- **Veon Juan Pablo** 
