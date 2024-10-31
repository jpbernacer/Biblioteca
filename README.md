# APLICACIÓN PARA LA GESTIÓN DE UNA BIBLIOTECA

Esta aplicación permite dar de alta habitantes y mostrarlos. Incluye también una ayuda. En los siguientes apartados se muestra cómo compilar el programa, cómo utilizarlo y cuál es su estructura interna.

## COMPILACIÓN DEL PROGRAMA

### Requisitos previos

Debe tener instalado el siguiente software:

- Make.
- Jar.
- El entorno JDK.

### Compilación y generación del `.jar`

Para compilar y generar el `.jar`, se ejecutará la siguiente instrucción:

```console
make jar
```

El _script_ definido en el fichero `makefile` está pensado para funcionar en Linux. En caso de que utilice Windows, debería invocar directamente el compilador de Java.

### Generación de Javadoc

Para generar la documentación HTML a partir de los comentarios en Javadoc, se ejecuta la sentencia que se muestra a continuación:

```console
make javadoc
```

## EJECUCIÓN DEL PROGRAMA

Si ejecuta la siguiente instrucción aparecerá la ayuda necesaria para utilizar la aplicación:

```console
java -jar biblioteca.jar ayuda
```

## ESTRUCTURA INTERNA DEL SISTEMA

El siguiente diagrama UML muestra los paquetes y las clases. El paquete `negocio` contiene las clases `Libro.java`, `Biblioteca.java`, `InterfazUsuario.java` y `Principal.java`. 

### Libro
La clase `Libro` se encarga de declarar las características de cada libro, el título, autor, fecha de publicación, número de identificador y si está disponible o no. Cada característica esta definida por objetos de tipo Strings 
