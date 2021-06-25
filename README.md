# FabianMovillaCode
Código desarrollado por Fabian Movilla, Bogotá D.C. Colombia

#Tecnologias

Gradle 7.0.2
Spring Boot versión 2.5.1
Eclipse IDE for Enterprise Java and Web Developers versión 4.20.0
Data Base Mongo DB Atlas que es Cloud
****


1.	Ejecutando el artefacto desde Eclipse:
 
 
2.	Se valida que suba correctamente la aplicación:
 
 
3.	Generando el artefacto con Graddle ejecutando un CLEAN al proyecto:
 
 
4.	Generando el artefacto con Graddle ejecutando un TEST al proyecto:
 
5.	Validando el log de los TEST:
 
6.	Examinando los resultados generados:
 
 
 
 
7.	Generando el artefacto con Graddle ejecutando un BUILD al proyecto:
 
 
8.	Se construye el Dockerfile:
 
9.	Se valida la versión Docker del equipo:
 
10.	Se visualizan las imágenes:
 
11.	Se visualizan los contenedores:
 
12.	Se crea la imagen:
 
 
13.	Se visualizan las imágenes, para validar la nueva creada:
 
14.	Se crea el contenedor:
 
 
15.	Se visualizan los contenedores:
 
16.	Se consulta la documentación del servicio con Swagger: http://localhost:3052/swagger-ui.html

 
 
17.	Se realizan pruebas E2E con cliente de POSTMAN:
Api Rest Meli Controller:
Se consume el API REST consultarInfo: Se encarga de la información de un país, su(s) moneda(s) y su conversión a Euros y Dólares, verifica que sea una IPV4 valida y que no exista en la base de datos de BlackList:
a.	Para una IP valida, que tenga más de una moneda local y que NO se encuentra en la Base de datos de BlackList:
http://localhost:3052/ip/consultarInfo/?direccion=200.14.48.0
	 

a.	Para una IP valida, que tenga solo una moneda local y que NO se encuentra en la Base de datos de BlackList:
http://localhost:3052/ip/consultarInfo/?direccion=201.185.108.234
	 
a.	Para una IP valida y que SI se encuentra en la Base de datos de BlackList:
http://localhost:3052/ip/consultarInfo/?direccion=8.8.8.8

 ![image](https://user-images.githubusercontent.com/86450207/123366965-c71a2480-d53e-11eb-9e1c-07a517cc6dfb.png)


a.	Para una IP invalida
http://localhost:3052/ip/consultarInfo/?direccion=8.x.8.8
 

Api Rest Ban List Controller:
Se consume el API REST queryAll: Se encarga de devolver el arreglo de colleciones de las IP que están en el BlackList:
http://localhost:3052/banList/queryAll
 

Se consume el API REST queryOneByIp: Se encarga de devolver informar si una IP está en el BlackList o no, también realiza validaciones de ser una IPV4 valida:
b.	Para una IP que SI se encuentra en la Base de DATOS:
http://localhost:3052/banList/queryOneByIp?direccion=8.8.8.8
 

c.	Para una IP que NO se encuentra en la Base de DATOS:
http://localhost:3052/banList/queryOneByIp?direccion=3.3.3.3
 
d.	Para una IP invalida IPV4:
http://localhost:3052/banList/queryOneByIp?direccion=8.8.8.8
 

Se consume el API REST addOne: Se encarga de insertar una IP en el BlackList, también realiza validaciones en caso tal de la IP a insertar ya exista para evitar duplicidad y también realiza validaciones de ser una IPV4 valida:
e.	Para una IP que NO se encuentra en la Base de DATOS:
http://localhost:3052/banList/addOne

 
f.	Para una IP que YA se encuentra en la Base de DATOS:
http://localhost:3052/banList/addOne
 
g.	Para una IP invalida IPV4:
http://localhost:3052/banList/addOne
 

Se consume el API REST deleteOneByIp: Se encarga de eliminar una IP que este en el BlackList, informa si la IP NO existe en la base de datos y también realiza validaciones de ser una IPV4 valida:
h.	Para una IP que SI se encuentra en la Base de DATOS:
http://localhost:3052/banList/deleteOneByIp

 

i.	Para una IP que NO se encuentra en la Base de DATOS:
http://localhost:3052/banList/deleteOneByIp
 
j.	Para una IP invalida IPV4:
http://localhost:3052/banList/deleteOneByIp
 

