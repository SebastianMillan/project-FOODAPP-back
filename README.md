# GOURMET BURGERS - FOOD APP : API REST :plate_with_cutlery:	
Proyecto desarrollado en Spring Boot 3. Consiste en una API REST de una aplicación de gestión de pedidos a domicilio de un restaurante principalmente de hamburguesas. El proyecto dispone de dos configuraciónes en las properties: Una de desarrollo la cuál contiene datos justos de ejemplo para poder probar la API REST y una de producción la cuál contiene un número considerable de datos de ejemplo.
El modelo de datos del análisis viene representado por el siguiente diagrama de clases:

![image](https://github.com/SebastianMillan/project-FOODAPP-back/assets/114216417/3cd6f125-8d2a-439e-a830-4434a3a24ff3)

## Ejecución :computer:	
Para ejecutar este proyecto nos clonaremos el repositorio en local y ejecutaremos dentro de la ruta del proyecto estos dos comandos:
```
mvn clean
mvn intall
```
O si no es la primera vez que lo ejecuta podemos usar este:
```
mvn spring-boot:run
```
Para ejecutar el docker-compose y que se nos conecte una base de datos de Postgressql se adjunta un archivo docker compose que nos genera los tres contenedores configurados. Hay que ejecutar el siguiente comando en la raiz del proyecto:
```
docker-compose up -d
```
La API REST está documentada con Open API Y Swagger. Se puede acceder mediante esta URL:
```
localhost:8080/swagger-ui.html
```
También se adjunta una colección de Postman para probar los endpoints de la API REST.

## Funcionamiento
Para el entendimiento de la API REST se dispondrá de pautas a seguir en Postman para que los endpoints nos respondan correctamente.
- Usuarios:
  - "sebas01" -> Cliente
  - "luisma01" -> Cocinero
  - "miguel02" -> Repartidor
  - "angel02" -> Administrador
 
    los usuarios tienen todos la contraseña 1234.

- Es necesario logearte o registrarte para poder acceder a todos los endpoints de la api.
  
- Para acceder al detalle de un Cliente por su ID siendo el admin al necesitar pasarle un UUID es aconsejable por ejemplo logearte como cliente, copiar el UUID del cliente logeado, logearte de nuevo como admin, y con ese UUID que copiaste del cliene pegarlo en la petición para que nos muestre su detalle.
  
- Para añadir un Producto al carrito se podría primero conseguir el UUID de un producto con el endpoint que nos devuelve los productos en oferta y a partir de ahí añadir uno de esos productos al carrito.

  CATEGORÍAS:
  - Para poder usar los métodos de las categorías es necesario ir a loginUsuario y logearte como un usuario administrador.

  PEDIDOS:
  - Para acceder a los pedidos que tiene el cocinero asignado se deberá de logear como Trabajador y que a su vez sea Cocinero.
    
  - Para acceder a los detalles de un pedido, Te logeas como un usuario cliente, vas a la carpeta de Usuario, al método getLogginUsuario, en el Json que te devuelve, copias el uuid del pedido que quieras
    y vas a la carpeta Pedido, donde está el método getPedidoDetails, pegas el uuid del pedido en la ruta y obtienes los detalles de ese pedido.
    
  - Para acceder a los pedidos del repartidor, te tienes que logear como "pedro" que es el repartidor, y una vez logeado ir a la carpeta Pedido, al método getPedidosDelRepartidor, donde obtendras un Page de los
    pedidos del repartidor.

  PRODUCTO:

  - Para acceder a los detalles de un producto tienes que loguearte como admin y al endpoint de GetProductsCategoryByAdmin y copiar el ID de un producto para luego irte al endpoint de productDetailsByAdmin
    y copiar en la ruta el ID. Esto es así tan lioso porque este endpoint es una ayuda para el front.

  
  
