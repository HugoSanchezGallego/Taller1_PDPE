# Taller 1

Enlace al repositorio --> https://github.com/HugoSanchezGallego/Taller1_PDPE.git

## Descripción

Este proyecto es una aplicación de Android desarrollada en **Kotlin** utilizando **Jetpack Compose**. La aplicación tiene tres pantallas principales:

1. **Pantalla de Inicio**: Muestra un saludo personalizado que cambia según la hora del día (Buenos días, Buenas tardes, Buenas noches) junto con una imagen correspondiente. Incluye un botón para navegar a la pantalla principal.
   
2. **Pantalla Principal**: Permite al usuario introducir su nombre, guardar el nombre y mostrar un mensaje personalizado. También tiene un botón para navegar a la pantalla de configuración.

3. **Pantalla de Configuración**: Permite al usuario cambiar el color de fondo de las pantallas mediante botones de selección de color. Los colores disponibles son: rojo, verde, azul, y blanco (predeterminado). La configuración de color se guarda usando `SharedPreferences`.

## Características

- **Saludo Dinámico**: El saludo cambia dependiendo de la hora del día (mañana, tarde o noche).
- **Personalización de Color**: El usuario puede personalizar el color de fondo de la aplicación y se guarda la selección para futuras sesiones.
- **Persistencia de Datos**: Se utilizan `SharedPreferences` para guardar el color de fondo seleccionado.
- **Navegación**: La aplicación navega entre pantallas de manera fluida con botones.

## Estructura del Proyecto

### Pantallas

- **PantallaInicio.kt**: Contiene la lógica para mostrar un saludo basado en la hora y una imagen asociada, además de permitir la navegación a la actividad principal.
- **MainActivity.kt**: Permite al usuario ingresar su nombre, guardarlo y navegar a la pantalla de configuración.
- **TerceraPantalla.kt**: Pantalla de configuración que permite cambiar el color de fondo de las pantallas y guardar la configuración.

### Funcionalidades Principales

#### Saludo Personalizado

El saludo en la `PantallaInicio` cambia de acuerdo con la hora del día:
- **Buenos días**: Entre las 0:00 y las 11:59.
- **Buenas tardes**: Entre las 12:00 y las 17:59.
- **Buenas noches**: A partir de las 18:00.

#### Cambiar Color de Fondo

En la `TerceraPantalla`, el usuario puede cambiar el color de fondo de la aplicación usando los siguientes botones:
- Cambiar a **rojo**.
- Cambiar a **verde**.
- Cambiar a **azul**.
- Restablecer a **blanco** (predeterminado).

### Código de Utilidad

- `saveColor(context: Context, color: Color)`: Guarda el color de fondo seleccionado en `SharedPreferences`.
- `getSavedColor(context: Context): Color`: Recupera el color de fondo guardado en `SharedPreferences`.

### Taller 2
- A partir de la rama "Asincrono" empieza el Taller 2

- Se creó una nueva clase CombinedTask que extiende AsyncTask para simular una operación de red y mostrar el progreso.
- Se modificó MainActivity para usar CombinedTask en un solo botón para iniciar la tarea en segundo plano.
