# Práctico 7
El objetivo de este práctico es el de poder guardar eventos
en una base de datos. Esto se debe realizar de una manera
estratégica y global para cualquier tipo de eventos.

## Porque guardar eventos
Una propiedad esencial de cualquier programa es el
de poder ser auditado. Esto quiere decir poder
trasparentar las operaciones que se han realizado
en el programa, cuando, y porquien.

Esta propiedad es bastante util al momento que surgen
problemas por el uso de la herramienta.

## Evento

Un evento es cualquier cosa que pase en nuestro programa
que pueda ser comunicada y entendida por los usuarios
del programa. Notar la diferencia con eventos que a lo 
mejor solamente son de interes del programador.

La estructura de un evento en este practico sera:

* id: Identificador entero del evento
* fechahora: momento en que ocurrio el evento
* usuario: nombre del usuario bajo el cual se registro el evento,
si no se tiene usuario escribir sistema.
* tipo: el codigo de tipo del evento, generalmente una palabra
de 5 a 15 caracteres que identifica al evento en una palabra.
* descripcion: lo que paso realmente en un formato entendible
para un ser humano.

## Tarea a realizar 1: registrar eventos
Modificar un programa que hayan realizado anteriormente e 
insertar lineas de auditoria para que se registren los eventos 
a medida que pasen. Por ej: cuando se cargue una imagen, el evento
que se registre podria ser:

```
EventoLogger evlogger = EventoLogger.GetOrCreate();
evlogger.Reegistrar("sistems","CARGARIMAGEN","SE cargo el archivo xxxx");
```
## Tarea a realizar 2: Visor de eventos
Crear un programa aparte que sirve para visualizar los eventos.
Idealmente deberia poder buscar por tipo de eventos y siempre
nos perrmite mirar los ultimos 50 eventos.

## Patron DAO
Es obligatorio el uso del patron DAO para este practico. Tomar 
la implementacion del curso y solamente la del curso para inspirarse. 
