# Guía de Instalación y Configuración

Esta guía te ayudará a configurar el entorno de desarrollo para trabajar con los proyectos de este repositorio.

## Requisitos Previos

### Java Development Kit (JDK)
1. Descarga e instala JDK 17 o superior
2. Configura JAVA_HOME
3. Añade Java al PATH

### Node.js y npm
1. Descarga Node.js desde nodejs.org
2. Instala la última versión LTS
3. Verifica la instalación:
   ```bash
   node --version
   npm --version
   ```

### .NET SDK
1. Descarga .NET SDK 8.0 o superior
2. Instala el SDK
3. Verifica la instalación:
   ```bash
   dotnet --version
   ```

### IDEs Recomendados
- Visual Studio Code
- Eclipse
- IntelliJ IDEA
- Visual Studio 2022

## Configuración del Entorno

### Visual Studio Code
1. Instala las extensiones recomendadas:
   - Java Extension Pack
   - C# Dev Kit
   - Angular Language Service
   - ESLint
   - Prettier

### Base de Datos
1. Instala MySQL Server
2. Configura el usuario root
3. Importa los scripts de base de datos

### Angular CLI
```bash
npm install -g @angular/cli
```

## Ejecución de Proyectos

### Proyectos Java
1. Importa el proyecto en tu IDE
2. Actualiza las dependencias Maven/Gradle
3. Ejecuta la aplicación

### Proyectos Angular
1. Navega al directorio del proyecto
2. Ejecuta:
   ```bash
   npm install
   ng serve
   ```

### Proyectos .NET
1. Abre la solución en Visual Studio
2. Restaura los paquetes NuGet
3. Ejecuta la aplicación

## Solución de Problemas

### Problemas Comunes
1. Error de puertos en uso
2. Problemas de dependencias
3. Conflictos de versiones

### Contacto
Para ayuda adicional, abre un issue en el repositorio.