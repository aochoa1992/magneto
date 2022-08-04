# magneto

Ejecución backend Magneto: 

Este proyecto está construido en spring boot con gradle.

     1. Para su ejecución es necesario ubicarse en la clase MagnetoApplication donde se encuentra el main, desde allí podremos arrancar la aplicación
     2. en el archivo application.properties se encuentra la configuración de base de datos la cual se encentra configurada de manera local para efectos de seguridad,
        también podremos encontrar el puerto de ejecución de la aplicación
     3. Se adjunta al proyecto el respectivo script de base de datos llamado DB.sql

Nota: En el archivo build.gradle se importan las librerías utilizadas para la conexión a la base de datos, evaluación de la cobertura de pruebas, 
        documentación swagger de las api,  las pruebas unitarias entre otras. 

#La aplicación se encuentra desplegada en un Elastic Beanstalk de aws y para probar los diferentes endpoins debemos tener en cuenta lo siguiente:

Servicio post "/user"

Este servicio se encarga de generar un token y recibe como parámetro el siguiente json:

#request

{
	"userName": "xxx"
}

#Response 

{
    "userName": "xxx",
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiQWxlam8iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjU5NTc4MDQ0LCJleHAiOjE2NTk1Nzg2NDR9.llXZttOtSdq0nmgASM7p7nab_lIAFqXVVy-kRtDzPV3JI9L1vefzzkuAGUeodvkfdbG8Y0YAEPHbrMT5NtmGLg"
}
 
Se debe incluir el token generado en los header de todas las peticiones que se hagan 
  
#Ejemplo Header:
 Key: Authorization
 Value: Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiQWxlam8iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjU5NTc3OTIyLCJleHAiOjE2NTk1Nzg1MjJ9.Qk-eQx_pahCQMiZQfsDrVjlOHp0fiRq8m2vmKSeNPycGqyot9Jg58aJwjBYgl0u4ViqlOHWNUo3NcRbooYAj3A

Servicio post "/mutant": 
 
valida si una secuencia de ADN ingresada pertenece a un mutante o un humano y guarda el registro en la base de datos, 
es necesario enviar un Json con el siguiente formato: 

Ejemplo: 

[
   "ATGCGA",
   "CAGTGC",
   "TTATGT",
   "AGAAGG",
   "CCCCTA",
   "TCACTG"
]

La url expuesta para la creación y validación de la secuencia es: 

http://magneto-env.eba-srwupzga.sa-east-1.elasticbeanstalk.com/mutant

Servicios get "/stats":

Retorna las estadisticas de los ADN's evaluados y no requiere parámetros 

URL expuesta es: http://magneto-env.eba-srwupzga.sa-east-1.elasticbeanstalk.com/stats

#Otras características: 

Para validar la cobertura del proyecto se utilizó la librería jacoco, la cual nos permite hacer una evaluación rápida del proyecto, para ello es necesario 
ubicarnos en el paquete de la aplicación llamado test -> java aquí damos clic derecho y seleccionamos la opción "Run test with Coverage".

También podremos ver otras métricas del proyecto configuradas en Sonarcloud accediendo al siguiente link :

https://sonarcloud.io/summary/overall?id=aochoa1992_magneto

Para ver la documentación swagger de los servicios expuestos podemos dirigirnos al siguiente link:

http://magneto-env.eba-srwupzga.sa-east-1.elasticbeanstalk.com/swagger-ui/index.html 

#Colletion postman

Dentro del proyecto encontraremos un archivo llamado "MagnetoCollection.postman_collection.json" el cual podremos importar en la aplicación postman, 
este archivo contiene una colección de request, las cuales nos ayudaran a consumir los servicios expuestos y hacer algunos casos de prueba. 

#Flutuaciones 

Para las fluctuaciones o prubas de carga se adjunta un archivo llamado "Mutant.jmx" el cual contiene configurado un plan de pruebas realizado en Jmeter, 
este se podrá importa en la aplicación Jmeter y verificar las pruebas de estrés realizadas. 


 