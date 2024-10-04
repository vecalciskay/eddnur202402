# Práctico 4 - Undo

En este práctico se trata de implementar una lista en 
el programa de manejo de imágenes. El objetivo de la
lista es el de poder manejar un historial de las acciones
que se realizaron en una imágen.

## Trabajo a realizar

Cada una de las siguientes actividades forma parte del
práctico:

* Implementar una lista que permita almacenar las acciones
  realizadas sobre una imagen.
* Cuando el usuario carga un imagen a partir de un archivo
  se debe limpiar la lista.
* Cuando el usuario aplica un filtro sobre una imagen se
  debe agregar a la lista la acción realizada y guardar la
  imagen original para que se pueda revertir.
* Cuando el usuario hace un trazo, hace un cuadrado, o cuando
  hace un circulo entonces se debe agregar a la lista la acción.
* Debe haber una opción fácil de utilizar que permite al
  usuario deshacer la última acción realizada. Esto saca el 
  último elemento de la lista y lo aplica a la imagen.

## Condiciones
Se debe utilizar el patrón Command para poder deshacer las
acciones realizadas. Se debe implementar Observer para poder
actualizar la lista de acciones realizadas.

Como siempre se debe implementar tests, y también se debe
implementar logs de las acciones realizadas.

## Fecha de presentación
La fecha de presentación es el martes 15 de octubre de 2024.