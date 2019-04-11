# Prueba_Conexia

En este repositorio se encuentra el proyecto para la prueba de ingreso a CONEXIA

Para la instalación del proyecto es necesario seguir los siguientes pasos.
	
	1. Se debe ejecutar el script de base de datos script.sql, en un motor de base de datos MySQL 5. Este script realiza la creación del esquema de base de datos de las tablas y hace la inserción de datos paramétricos, tales como clientes, camareros, cocineros y mesas. Se recomienda realizar esta ejecución con el usuario root del motor MySQL
	
	2. Luego, se debe realizar la configuracion del usuario de conexión a la BD. Para esto, se debe acceder al archivo Mejor_cocina_app/web/src/main/webapp/WEB-INF/cocina-ds.xml y modificar los tags security/user y security/password por las credenciales del usuario root configurado en la instancia de MySQL. Asi mismo se debe configurar el archivo Mejor_cocina_app/web/src/main/resources/META-INF/persistence.xml, para cambiar loas propiedades hibernate.connection.username y hibernate.connection.password con las respectivas credenciales.
		En caso de ser necesario, se deben cambiar las propiedades de URL de acceso a la base de datos de acuerdo a si la base de datos es local o no.
	
	3. Después se debe realizar la compilación y empaquetamiento de la app. Para esto es necesario hacer uso de la Herramienta MAVEN: se debe ejecutar el commando mvn clean install o mvn clean package en el directorio Mejor_cocina_app/. Esto realizará la compilación y empaquetamiento de todos los proyectos que conforman la app.
	
	4. Una vez se generen los paquetes, se procede con la instalación de la aplicación. Para esto se recomienda el uso del servidor wildfly 16.0.0.Final. Para la instalación en este servidor, debemos acceder a la carpeta Mejor_cocina_app/web/target/ y localizar el archivo Mejor_cocina-app.war; este es el archivo de WAR de instalación; se debe copiar este archivo en el directorio standalone/deployments del servidor WILDFLY. Luego se inicia el servidor accediento al directorio bin/ del servidor; se localiza el archivo standalone.bat para windows o standalone.sh para linux, se ejecuta este archivo. De esta forma se ejecuta el servidor y se despliega la aplicación previamente copiada.
	
	5. Una vez termine el despliegue se accede a la dirección http://localhost:8080/Mejor_cocina_app. La interfaz consta de un menu en la parte izquierda que permite acceder a las opciones solicitadas en los requerimientos 
		a. Crear factura: permite crear la factura con los datos requeridos.
		b. Reporte Camareros: permite acceder a la consulta de cantidad facturada por los camareros por mes.
		c. Reporte Clientes: permite acceder a la consulta de clientes que han facturado más de $100.000.
		d. Home: permite volver a la página principal.
	
La visualización de las consultas (Reportes) va cambiando de acuerdo a las facturas que se vayan ingresando.

		
		
		


