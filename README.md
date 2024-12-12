
# Multithreading

El multithreading se refiere a una técnica de programación en la que existen múltiples hilos de ejecución dentro de una sola aplicación.

El multihilo es solo una forma de lograr la concurrencia en Java. La concurrencia también se puede lograr a través de otros medios, como el multiprocesamiento, la programación asincrónica o la programación basada en eventos.

## Terminología y conceptos

1. Thread: Un thread es la unidad de ejecución más pequeña dentro de un proceso. Pueden existir varios "hilos" dentro de un solo proceso y compartir el mismo espacio de memoria.

2. Proceso: Un proceso es un programa independiente que se ejecuta en su espacio de memoria. Puede constar de uno o varios subprocesos.

3. Concurrencia: La simultaneidad se refiere a la ejecución de varios hilos en intervalos de tiempo superpuestos. Permite que las tareas parezcan estar ejecutándose simultáneamente.

4. Sincronización: La sincronización es un mecanismo que se utiliza para coordinar y controlar el acceso a recursos compartidos. Evita las "race conditions" al permitir que solo un hilo acceda a un recurso a la vez.

## Ciclo de vida de un thread

Un hilo puede estar en uno de los siguientes estados. Utilice Thread.getState() para obtener el estado actual del hilo.

- NEW: creado pero no ha comenzado la ejecución
- RUNNABLE: ejecución iniciada
- BLOCKED: esperando adquirir un bloqueo
- WAITING: esperando que otro hilo realice una tarea
- TIMED_WAITING: esperando durante un período de tiempo específico
- TERMINATED: ejecución completada o abortada

## Sincronización

La sincronización en Java es la capacidad de controlar el acceso de múltiples hilos a cualquier recurso compartido. En el concepto de hilos múltiples, varios subprocesos intentan acceder a los recursos compartidos a la vez y producen resultados inconsistentes. La sincronización es necesaria para una comunicación confiable entre hilo.

### Thread Synchronization

La sincronización de hilos es de dos tipos, que son:

1. Mutual Exclusive: Ayuda a que solo un hilo acceda a los recursos compartidos. No permitirá el acceso a todos los recursos compartidos a la vez. Se puede lograr de las siguientes maneras.

    - Synchronized Method
    - Synchronized block
    - Static Synchronization

2. Cooperation (Inter Thread Communication in java): Es un mecanismo de comunicación entre dos hilos o múltiples hilos que actúan sobre el objeto común (propietario). Para realizar las múltiples acciones a la vez necesitamos comunicación entre hilos.

    Métodos en la clase de objeto para realizar la comunicación entre hilos:

    - wait(): Este método se utiliza para hacer que el hilo en particular
    espere hasta que reciba una notificación. Este método pausa el
    subproceso actual en la sala de espera de forma dinámica.
    - notify(): Este método se utiliza para enviar la notificación a uno de los hilo en espera para que ese hilo entre en un estado de
    ejecución y ejecute la tarea restante. Este método activa un solo
    hilo y lo pone en estado activo (que actúa sobre el objeto común).
    - notifyAll(): Este método se utiliza para enviar la notificación a todos los hilos en espera para que todos los hilos entren en estado
    de ejecución y se ejecuten simultáneamente. Este método activa todos
    los hilos en espera que actúan sobre los objetos comunes.

### Bloqueos en Java

La sincronización se basa en una entidad interna conocida como bloqueo o bloqueo de monitor. (La especificación de API a menudo se refiere a esta entidad simplemente como un "monitor"). Los bloqueos desempeñan un papel en ambos aspectos de la sincronización: imponen acceso exclusivo al estado de un objeto y establecen relaciones de "sucede antes" que son esenciales para la visibilidad.

Cada objeto tiene un bloqueo asociado. Por convención, un hilo que necesita acceso exclusivo y consistente a los campos de un objeto tiene que adquirir el bloqueo del objeto antes de acceder a ellos y luego liberar el bloqueo cuando termina con ellos. Se dice que un hilo posee el bloqueo entre el momento en que ha adquirido el bloqueo y lo ha liberado. Mientras un hilo posea un bloqueo, ningún otro hilo puede adquirir el mismo bloqueo. El otro hilo se bloqueará cuando intente adquirir el bloqueo.

### Variables volátiles

Java provee dos mecanismos básicos para asegurar la consistencia de datos cuando se comparte datos con múltiples hilos: los métodos sincronizados con synchronized y las variables compartidas con volatile.

Las variable volátiles en el lenguaje Java son declaradas anteponiendo el modificador de visibilidad de memoria volatile. Estas no son guardadas en el caché del procesador, es decir, toda lectura/escritura de la misma se realiza directamente contra la memoria principal.

Las variables volátiles pueden no ser suficientes

El uso de variables volátiles nos asegura que todos los hilos conocen el valor real de las mismas en todo momento, pero no nos asegura que nuestras operaciones sobre las mismas sean atómicas.

Una variable volátil es útil siempre y cuando un sólo hilo escriba en ella y los demás sólo lean su valor, o el valor a ser escrito en la variable no depende del valor anterior.

Cuando más de un hilo modifica el valor de una variable volátil, pueden originarse inconsistencias en la memoria, esto se debe a que modificarla generalmente consta de 3 pasos:

- Leer el valor de la variable.
- Cambiar el valor y guardarlo en una variable temporal.
- Persistir el nuevo valor en la variable.

Estos pasos al no ser ejecutados de manera atómica, pueden ser interrumpidos por el procesador y ejecutar otras instrucciones que podrían afectar el valor original de dicha variable.

En casos en donde se necesite modificar el valor de una variable compartida podemos recurrir, por ejemplo, al uso de métodos sincronizados.
