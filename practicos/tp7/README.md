# Práctico 7
El objetivo de este práctico es el de poder guardar eventos
en una base de datos. Esto se debe realizar de una manera
estratégica y global para cualquier tipo de eventos.

## Estrategia y estructura
La estructura que se debe realizar tiene que trabajar con
eventos como si fuera una interfaz. Esto permite que los 
usuarios de nuestra librería puedan definir los eventos de 
la manera que ellos deseen. Las operaciones de la interfaz
IEvento debería ser:

* getDatetime(): Obtiene la fecha y hora del evento.
* getEventType(): Obtiene el tipo de evento.
* getEventDescription(): Obtiene la descripción del evento.
* getEventId(): Obtiene el identificador del evento.
* getEventSource(): Obtiene la fuente del evento. Esto generalmente
  es el nombre de la clase que generó el evento o de la aplicación
  o sistema que generó el evento.
* getEventUser(): Obtiene el usuario que generó el evento. 
  Puede estar vacío o puede ser SYSTEM para indicar que es algo
  automático.
* getEventTargetType(): Si el evento fue en una imagen 
  entonces se colocará IMAGEN aca.
* getEventTargetId(): Si el evento fue en una imagen entonces
  se colocará el identificador de la imagen.

