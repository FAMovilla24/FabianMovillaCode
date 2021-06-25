# FabianMovillaCode
Código desarrollado por Fabian Movilla, Bogotá D.C. Colombia

#Tecnologias

Gradle 7.0.2

Spring Boot versión 2.5.1

Eclipse IDE for Enterprise Java and Web Developers versión 4.20.0

Swagger

Data Base Mongo DB Atlas que es Cloud

****


1.	Ejecutando el artefacto desde Eclipse:
 
![image](https://user-images.githubusercontent.com/86450207/123366998-d8fbc780-d53e-11eb-82cb-12eb4b3831c8.png)
![image](https://user-images.githubusercontent.com/86450207/123367024-e1540280-d53e-11eb-91b6-f01e0e2add35.png)

2.	Se valida que suba correctamente la aplicación:

![image](https://user-images.githubusercontent.com/86450207/123367032-e4e78980-d53e-11eb-9e7a-249ce0a2c9dd.png)
![image](https://user-images.githubusercontent.com/86450207/123367036-e749e380-d53e-11eb-8521-46def809979a.png)
  
3.	Generando el artefacto con Graddle ejecutando un CLEAN al proyecto:

![image](https://user-images.githubusercontent.com/86450207/123367057-edd85b00-d53e-11eb-9a11-f385b84f0c13.png)
 
4.	Generando el artefacto con Graddle ejecutando un TEST al proyecto:

![image](https://user-images.githubusercontent.com/86450207/123367073-f466d280-d53e-11eb-94f6-28cee7b39144.png)

5.	Validando el log de los TEST:

![image](https://user-images.githubusercontent.com/86450207/123367082-f7fa5980-d53e-11eb-8b9d-ce7ca8e1da90.png)

6.	Examinando los resultados generados:

![image](https://user-images.githubusercontent.com/86450207/123367092-fcbf0d80-d53e-11eb-83a7-56538e5a78fd.png)
![image](https://user-images.githubusercontent.com/86450207/123367103-ffb9fe00-d53e-11eb-8ca0-a24d4be73cd7.png)
![image](https://user-images.githubusercontent.com/86450207/123367108-00eb2b00-d53f-11eb-8db5-92aa513a5624.png)
![image](https://user-images.githubusercontent.com/86450207/123367111-034d8500-d53f-11eb-841a-5dbbb07efc0c.png)
 
7.	Generando el artefacto con Graddle ejecutando un BUILD al proyecto:

![image](https://user-images.githubusercontent.com/86450207/123367123-0779a280-d53f-11eb-9b38-b15c3751ab5e.png)
![image](https://user-images.githubusercontent.com/86450207/123367128-0a749300-d53f-11eb-9c71-c70c619ffbd5.png)

8.	Se construye el Dockerfile:

![image](https://user-images.githubusercontent.com/86450207/123367135-0f394700-d53f-11eb-9898-eaeda547d495.png)

9.	Se valida la versión Docker del equipo:

![image](https://user-images.githubusercontent.com/86450207/123367148-12ccce00-d53f-11eb-8a2a-c859eabf616f.png)

10.	Se visualizan las imágenes:

![image](https://user-images.githubusercontent.com/86450207/123367264-4576c680-d53f-11eb-816c-d41ae5b71243.png)

11.	Se visualizan los contenedores:

![image](https://user-images.githubusercontent.com/86450207/123367268-4871b700-d53f-11eb-8c9e-c5e92115b0d5.png)

12.	Se crea la imagen:

![image](https://user-images.githubusercontent.com/86450207/123367273-4b6ca780-d53f-11eb-8bb0-6665afb0eea1.png)
![image](https://user-images.githubusercontent.com/86450207/123367282-4dcf0180-d53f-11eb-8863-473e4e164e6d.png)

13.	Se visualizan las imágenes, para validar la nueva creada:

![image](https://user-images.githubusercontent.com/86450207/123367292-50c9f200-d53f-11eb-922f-a73d63a62959.png)
 
14.	Se crea el contenedor:

![image](https://user-images.githubusercontent.com/86450207/123367298-53c4e280-d53f-11eb-8348-51c9cbee7874.png)
![image](https://user-images.githubusercontent.com/86450207/123367302-558ea600-d53f-11eb-9f72-2d6735d25f46.png)
 
15.	Se visualizan los contenedores:

![image](https://user-images.githubusercontent.com/86450207/123367313-5a535a00-d53f-11eb-98ec-e4cf09724706.png)
 
16.	Se consulta la documentación del servicio con Swagger: http://localhost:3052/swagger-ui.html

![image](https://user-images.githubusercontent.com/86450207/123367325-5e7f7780-d53f-11eb-924e-d8a7bcdb55a3.png)
![image](https://user-images.githubusercontent.com/86450207/123367331-60e1d180-d53f-11eb-8a31-c7721685a017.png)
 
17.	Se realizan pruebas E2E con cliente de POSTMAN:
Api Rest Meli Controller:
Se consume el API REST consultarInfo: Se encarga de la información de un país, su(s) moneda(s) y su conversión a Euros y Dólares, verifica que sea una IPV4 valida y que no exista en la base de datos de BlackList:
a.	Para una IP valida, que tenga más de una moneda local y que NO se encuentra en la Base de datos de BlackList:
http://localhost:3052/ip/consultarInfo/?direccion=200.14.48.0

![image](https://user-images.githubusercontent.com/86450207/123367370-722ade00-d53f-11eb-8881-acc7f179949c.png) 

b.	Para una IP valida, que tenga solo una moneda local y que NO se encuentra en la Base de datos de BlackList:
http://localhost:3052/ip/consultarInfo/?direccion=201.185.108.234

![image](https://user-images.githubusercontent.com/86450207/123367489-a0a8b900-d53f-11eb-8636-f01ca3051b1a.png)
	 
c.	Para una IP valida y que SI se encuentra en la Base de datos de BlackList:
http://localhost:3052/ip/consultarInfo/?direccion=8.8.8.8

![image](https://user-images.githubusercontent.com/86450207/123367493-a43c4000-d53f-11eb-8af6-e98ebb905f97.png)

d.	Para una IP invalida
http://localhost:3052/ip/consultarInfo/?direccion=8.x.8.8

![image](https://user-images.githubusercontent.com/86450207/123367505-aacab780-d53f-11eb-8e57-82596f8197fc.png)

Api Rest Ban List Controller:
Se consume el API REST queryAll: Se encarga de devolver el arreglo de colleciones de las IP que están en el BlackList:
http://localhost:3052/banList/queryAll

![image](https://user-images.githubusercontent.com/86450207/123367522-b1592f00-d53f-11eb-945a-36cbc8e342d4.png)

Se consume el API REST queryOneByIp: Se encarga de devolver informar si una IP está en el BlackList o no, también realiza validaciones de ser una IPV4 valida:
a.	Para una IP que SI se encuentra en la Base de DATOS:
http://localhost:3052/banList/queryOneByIp?direccion=8.8.8.8

![image](https://user-images.githubusercontent.com/86450207/123367565-c3d36880-d53f-11eb-94ec-c22aa6d64125.png)}

b.	Para una IP que NO se encuentra en la Base de DATOS:
http://localhost:3052/banList/queryOneByIp?direccion=3.3.3.3

![image](https://user-images.githubusercontent.com/86450207/123367587-cfbf2a80-d53f-11eb-8f30-22ccceb2a75a.png)

c.	Para una IP invalida IPV4:
http://localhost:3052/banList/queryOneByIp?direccion=8.8.8.8

![image](https://user-images.githubusercontent.com/86450207/123367605-d77ecf00-d53f-11eb-9c93-c4ea32be862b.png)

Se consume el API REST addOne: Se encarga de insertar una IP en el BlackList, también realiza validaciones en caso tal de la IP a insertar ya exista para evitar duplicidad y también realiza validaciones de ser una IPV4 valida:
a.	Para una IP que NO se encuentra en la Base de DATOS:
http://localhost:3052/banList/addOne

![image](https://user-images.githubusercontent.com/86450207/123367621-dfd70a00-d53f-11eb-91be-3ff487792673.png)
 
b.	Para una IP que YA se encuentra en la Base de DATOS:
http://localhost:3052/banList/addOne

![image](https://user-images.githubusercontent.com/86450207/123367629-e49bbe00-d53f-11eb-897f-9397451e5b1e.png)

c.	Para una IP invalida IPV4:
http://localhost:3052/banList/addOne

![image](https://user-images.githubusercontent.com/86450207/123367636-e82f4500-d53f-11eb-9b6f-38952f722ab7.png)


Se consume el API REST deleteOneByIp: Se encarga de eliminar una IP que este en el BlackList, informa si la IP NO existe en la base de datos y también realiza validaciones de ser una IPV4 valida:
a.	Para una IP que SI se encuentra en la Base de DATOS:
http://localhost:3052/banList/deleteOneByIp

![image](https://user-images.githubusercontent.com/86450207/123367656-f1201680-d53f-11eb-9725-ebc9f5e21d75.png)

b.	Para una IP que NO se encuentra en la Base de DATOS:
http://localhost:3052/banList/deleteOneByIp

![image](https://user-images.githubusercontent.com/86450207/123367666-f54c3400-d53f-11eb-8bd0-793502d33685.png)

c.	Para una IP invalida IPV4:
http://localhost:3052/banList/deleteOneByIp

![image](https://user-images.githubusercontent.com/86450207/123367672-f8472480-d53f-11eb-8e18-b4bee3888266.png)
