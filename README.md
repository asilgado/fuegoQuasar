PASOS PARA EJECUTAR EL PROGRAMA: 

Preferiblementes utilizar un ide con intellij o eclipse

1. git clone git@github.com:asilgado/fuegoQuasar.git
2. configurar variable de entorno JAVA_HOME
3. Configurarar variable de entorno M2_HOME
4. mvn exec:java -Dexec.mainClass="com.desafio.fuegoQuasar.FuegoQuasarApplication"

URL DONDE ESTA HOSTEADO EL SERVICIO

NIVEL 1
POST https://operacion-fuego-quasar.herokuapp.com/api/v1/fuegoQuasar/topsecret 
{
"satellites": [
	{
	"name": "kenobi",
	"distance": 485.7,
	"message": ["este", "", "", "mensaje", ""]
	},
	{
	"name": "skywalker",
	"distance": 266.1,
	"message": ["", "es", "", "", "secreto"]
	},
	{
	"name": "sato",
	"distance": 600.5,
	"message": ["este", "", "un", "", ""]
	}
 ]
}

NIVEL 2
POST https://operacion-fuego-quasar.herokuapp.com/api/v1/fuegoQuasar/topsecret_split/{satellite_name}
{
	"distance": 600.5,
	"message": ["este", "", "un", "", ""]
}

NIVEL 3
GET https://operacion-fuego-quasar.herokuapp.com/api/v1/fuegoQuasar/topsecret_split
