# APLICACIÓN PARA LA GESTIÓN DE UNA BIBLIOTECA

Esta aplicación permite dar de libros y mostrarlos. Incluye también una ayuda. En los siguientes apartados se muestra cómo compilar el programa, cómo utilizarlo y cuál es su estructura interna.

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
### Ayuda
Si ejecuta la siguiente instrucción aparecerá la ayuda necesaria para utilizar la aplicación:

```console
java -jar biblioteca.jar ayuda
```
### Añadir libro a la biblioteca
Para añadir un libro a la lista de la biblioteca se deberá ejecutar el siguiente comando rellenando la información deseada en los corchetes:

```console
java -jar biblioteca.jar añadir [Título del libro] [Autor] [Fecha de publicación] [Número de identificador] [Disponible / No disponible]
```
Si alguno de los datos es compuesto (es decir, está formado por varias palabras) deberá ir entre comillas `""`.

### Mostrar libros

Para mostrar los libros registrados en la biblioteca se deberá ejecutar el siguiente programa:

```console
java -jar biblioteca.jar mostrar
```

## ESTRUCTURA INTERNA DEL SISTEMA

El siguiente diagrama UML muestra los paquetes y las clases. El paquete `negocio` contiene las clases `Libro.java`, `Biblioteca.java`, `InterfazUsuario.java` y `Principal.java`. 
### Diagrama de clases
![Diagrama de clases](https://github.com/jpbernacer/Biblioteca/blob/53335f58c65671d428d89ec85da5967132980e71/Biblioteca%20Diagrama.png?raw=true)

### Libro
La clase `Libro` se encarga de declarar las características de cada libro: 
- Título
- Autor
- Fecha de publicación
- Número de identificador 
- Su disponibilidad

Cada característica esta definida por atributos de tipo Strings. La classe esta formada por `setters` y `getters`.

### Biblioteca
La clase `Biblioteca` se encarga de:

- **Cargar los libros** desde el archivo biblioteca.csv utilizando el método `cargarLibros()`.

- **Volcar los libros** desde el fichero utilizando el método `volcarLibros()`.

- **Añadir libros** a la biblioteca utilizando el método `annadirLibros()`.
- **Obtiene una representación en cadena de la lista de libros** sobreescribiendo el método `toString()`.

### Interfaz Usuario
La clase `InterfazUsuario` gestiona las instrucciones del usuario.

### Principal
La clase `Principal` se encarga de inicializar el programa y las clases.

