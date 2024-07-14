# Proyecto de Consulta de Resultados de Constructores y Conductores

Este proyecto es una aplicación de JavaFX que realiza consultas a una base de datos para mostrar los resultados de conductores y constructores en dos interfaces similares.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- `ConstructorMain.java`: Clase principal para la interfaz de resultados de constructores.
- `Main.java`: Clase principal para la interfaz de resultados de conductores.
- `ConstructorMaxPointMain.java`: Clase principal para la interfaz de resultados de puntos máximos de constructores.
- `DriverMaxPointMain.java`: Clase principal para la interfaz de resultados de puntos máximos de conductores.
- `ConstructorResult.java`: Modelo para los resultados de constructores.
- `DriverResult.java`: Modelo para los resultados de conductores.
- `ConstructorMaxPoint.java`: Modelo para los resultados de puntos máximos de constructores.
- `DriverMaxPoint.java`: Modelo para los resultados de puntos máximos de conductores.
- `ConstructorsRepository.java`: Repositorio para consultar los resultados de constructores.
- `DriversRepository.java`: Repositorio para consultar los resultados de conductores.
- `QueryRepository.java`: Repositorio para consultar los resultados de puntos máximos de conductores y constructores.
- `SeasonRepository.java`: Repositorio para consultar las temporadas disponibles.

## Ejecución

1. Asegúrate de tener Java 8 o una versión superior instalada.
2. Clona este repositorio.
3. Configura la conexión a la base de datos en el archivo `database.properties`.
4. Ejecuta `ConstructorMain` para ver los resultados de constructores o `Main` para los resultados de conductores.
5. Ejecuta `ConstructorMaxPointMain` para ver los resultados de los puntos máximos de constructores o `DriverMaxPointMain` para ver los resultados de los puntos máximos de conductores.

## Dependencias

- **JavaFX**: Utilizado para la interfaz gráfica.
- **PostgreSQL Connector**: Para la conexión a la base de datos.

¡Explora las nuevas funcionalidades y disfruta de tu proyecto!

## Vista de las aplicaciones
#### Resultado de drivers y constructors

![Captura de pantalla 2024-07-07 150121](https://github.com/AdrianPozoT/InterfazGrafica_ConsultasF1/assets/168159379/9ed1c44a-5fd5-4d5b-8179-82d63c2161cb)


![Captura de pantalla 2024-07-07 150032](https://github.com/AdrianPozoT/InterfazGrafica_ConsultasF1/assets/168159379/05d8745c-321c-48d1-94b3-77ba08c13517)

#### Resultado de puntos maximos de drivers y constructors

![Captura de pantalla 2024-07-14 140741](https://github.com/user-attachments/assets/66a5bbe0-a60f-41ec-8d15-501ae426d84e)


![Captura de pantalla 2024-07-14 140604](https://github.com/user-attachments/assets/37532c22-a924-4544-8799-f4d18c89f29d)
