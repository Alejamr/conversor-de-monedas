
# Conversor de Monedas

Conversor de Monedas es una aplicación de consola desarrollada en **Java** utilizando **Spring Boot**, que permite realizar conversiones entre diferentes monedas, aprovechando la API de **ExchangeRate-API** para obtener las tasas de cambio en tiempo real.

Este proyecto está orientado a ayudar a los usuarios a convertir montos entre varias monedas como USD, CLP, EUR, BRL, entre otras, y guardar un historial de conversiones realizadas.

## Características

- **Conversión entre múltiples monedas**: Dólar (USD), Euro (EUR), Real Brasileño (BRL), Peso Chileno (CLP), y más.
- **Historial de conversiones**: Guarda y muestra el historial de conversiones realizadas.
- **Manejo de excepciones**: Detecta entradas incorrectas y errores de conexión con la API.
- **Fácil de usar**: Interfaz de consola amigable para el usuario.

## Tecnologías Utilizadas

- **Java 17+**: Lenguaje de programación utilizado.
- **Spring Boot**: Framework para el desarrollo rápido de aplicaciones Java.
- **ExchangeRate-API**: API para obtener tasas de cambio en tiempo real.
- **Gson**: Biblioteca para el manejo de JSON.
- **HttpClient**: Para realizar solicitudes HTTP a la API.

## Requisitos

Para ejecutar el proyecto en tu entorno local, necesitas tener instalados los siguientes programas:

- **Java 17+**: Puedes descargarlo desde [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) o usar OpenJDK.
- **Maven**: Para gestionar las dependencias y compilar el proyecto. [Instalar Maven](https://maven.apache.org/install.html).

## Instalación

Sigue los siguientes pasos para instalar y ejecutar el proyecto en tu máquina local:

### 1. Clonar el Repositorio

Primero, clona el repositorio en tu máquina local:

```bash
git clone https://github.com/tu_usuario/nombre_del_repositorio.git
```

### 2. Acceder al Proyecto

Entra al directorio del proyecto:

```bash
cd nombre_del_repositorio
```

### 3. Configurar las Dependencias

Asegúrate de que tienes todas las dependencias necesarias. Si no tienes Maven instalado, puedes ejecutar:

```bash
mvn clean install
```

### 4. Configurar la API Key

Para que la aplicación pueda realizar las conversiones, necesitas obtener una API Key de [ExchangeRate-API](https://www.exchangerate-api.com/).

Una vez que tengas la API Key, crea un archivo `application.properties` en el directorio `src/main/resources` y agrega los siguientes valores:

```properties
api.key=TU_API_KEY
api.url=https://v6.exchangerate-api.com/v6
```

### 5. Ejecutar la Aplicación

Para ejecutar la aplicación, puedes hacerlo desde tu IDE (IntelliJ IDEA, Eclipse, etc.) o usando el siguiente comando de Maven:

```bash
mvn spring-boot:run
```

## Uso

Cuando ejecutes la aplicación, se mostrará un menú con las opciones disponibles para convertir entre monedas. Elige una opción e ingresa el monto que deseas convertir. El resultado se mostrará en la consola.

Ejemplo de ejecución:

```txt
**********************************************
**** Bienvenido/a al conversor de monedas ****
******************* MENU *********************
* 1.- Dólar (USD) a Peso Chileno (CLP)       *
* 2.- Peso Chileno a Dólar                   *
* 3.- Euro (EUR) a Peso Chileno (CLP)        *
* 4.- Peso Chileno a Euro (EUR)              *
* 5.- Real Brasileño (BRL) a Peso Chileno    *
* 6.- Peso Chileno a Real Brasileño (BRL)    *
* 0.- Ver historial                          *
* 9.- Salir                                  *
**********************************************
Seleccione una opción: 1
Ingrese el monto a convertir: 100
Resultado: Monto convertido: 96924.49 CLP
```

Al seleccionar la opción `0`, podrás ver el historial de conversiones realizadas.

## Historial de Conversiones

Cada vez que realices una conversión, el resultado se guarda en un historial. Puedes ver este historial seleccionando la opción **0** del menú.

## Contribución

¡Tu ayuda es bienvenida! Si deseas contribuir a este proyecto, sigue estos pasos:

1. Haz un **fork** del repositorio.
2. Crea una rama nueva para tu funcionalidad o corrección de errores (`git checkout -b feature-nueva`).
3. Realiza tus cambios y asegúrate de probar que todo funcione correctamente.
4. Haz un **commit** de tus cambios (`git commit -am 'Añadir nueva funcionalidad'`).
5. Empuja tus cambios a tu repositorio remoto (`git push origin feature-nueva`).
6. Crea un **Pull Request** para integrar tus cambios al repositorio principal.

## Licencia

Este proyecto está bajo la licencia **MIT**. Para más detalles, consulta el archivo [LICENSE](LICENSE).

