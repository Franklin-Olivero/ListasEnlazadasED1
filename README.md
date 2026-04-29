# ListasEnlazadasED1

## PUNTO 1

```
publico ListaEnlazadaSimple

    primerNodo = Nodo
    ultimoNodo = Nodo

    FUNCION insertar(dato)
        nuevoNodo = Nodo(dato)
        SI primerNodo == NULO
            primerNodo = nuevoNodo
            ultimoNodo = nuevoNodo
        SINO
            SI primerNodo <> NULO
                ultimoNodo.siguiente = nuevoNodo
                ultimoNodo = nuevoNodo
            FIN SI
        FIN SI
    FIN FUNCION

    FUNCION buscar(dato)
        actualNodo = primerNodo
        MIENTRAS actualNodo <> NULO
            SI actualNodo.dato == dato
                retornar VERDADERO
            FIN SI
            actualNodo = actualNodo.siguiente
        FIN MIENTRAS
        retornar FALSO
    FIN FUNCION

    FUNCION modificar(viejo, nuevo)
        actualNodo = primerNodo
        MIENTRAS actualNodo <> NULO
            SI actualNodo.dato == viejo
                actualNodo.dato = nuevo
                retornar VERDADERO
            FIN SI
            actualNodo = actualNodo.siguiente
        FIN MIENTRAS
        retornar FALSO
    FIN FUNCION

    FUNCION eliminar(dato)
        SI primerNodo == NULO
            retornar FALSO
        FIN SI

        SI primerNodo.dato == dato
            primerNodo = primerNodo.siguiente
            SI primerNodo == NULO
                ultimoNodo = NULO
            FIN SI
            retornar VERDADERO
        FIN SI

        actualNodo = primerNodo
        anterior = NULO

        MIENTRAS actualNodo <> NULO
            SI actualNodo.dato == dato
                anterior.siguiente = actualNodo.siguiente
                SI actualNodo == ultimoNodo
                    ultimoNodo = anterior
                FIN SI
                retornar VERDADERO
            FIN SI
            anterior = actualNodo
            actualNodo = actualNodo.siguiente
        FIN MIENTRAS

        retornar FALSO
    FIN FUNCION

    FUNCION print()
        actualNodo = primerNodo
        imprimir "Lista: [ "
        MIENTRAS actualNodo <> NULO
            imprimir actualNodo.dato
            SI actualNodo.siguiente <> NULO
                imprimir " | "
            FIN SI
            actualNodo = actualNodo.siguiente
        FIN MIENTRAS
        imprimir " ]"
    FIN FUNCION
```
## PUNTO 3
```
publico ListaEnlazadaCircular

    primerNodo = Nodo
    ultimoNodo = Nodo

    FUNCION insertar(dato)
        nuevoNodo = Nodo(dato)
        SI primerNodo == NULO
            primerNodo = nuevoNodo
            ultimoNodo = nuevoNodo
            nuevoNodo.siguiente = nuevoNodo
        SINO
            SI primerNodo <> NULO
                nuevoNodo.siguiente = primerNodo
                ultimoNodo.siguiente = nuevoNodo
                ultimoNodo = nuevoNodo
            FIN SI
        FIN SI
    FIN FUNCION

    FUNCION buscar(dato)
        SI primerNodo == NULO
            retornar FALSO
        FIN SI

        actualNodo = primerNodo
        HACER
            SI actualNodo.dato == dato
                retornar VERDADERO
            FIN SI
            actualNodo = actualNodo.siguiente
        MIENTRAS actualNodo <> primerNodo

        retornar FALSO
    FIN FUNCION

    FUNCION modificar(viejo,nuevo)
        SI primerNodo == NULO
            retornar FALSO
        FIN SI

        actualNodo = primerNodo

        MIENTRAS actualNodo.siguiente <> primerNodo
            SI actualNodo.dato == viejo
                actualNodo.dato = nuevo
                retornar VERDADERO
            FIN SI
            actualNodo = actualNodo.siguiente
        FIN MIENTRAS

        SI actualNodo.dato == viejo
            actualNodo.dato = nuevo
            retornar VERDADERO
        FIN SI

        retornar FALSO
    FIN FUNCION

    FUNCION eliminar(dato)
        SI primerNodo == NULO
            retornar FALSO
        FIN SI

        actualNodo = primerNodo
        anteriorNodo = NULO

        HACER
            SI actualNodo.dato == dato

                SI primerNodo == ultimoNodo
                    primerNodo = NULO
                    ultimoNodo = NULO
                    retornar VERDADERO
                FIN SI

                SI actualNodo == primerNodo
                    primerNodo = primerNodo.siguiente
                    ultimoNodo.siguiente = primerNodo
                    retornar VERDADERO
                FIN SI

                SI actualNodo == ultimoNodo
                    anteriorNodo.siguiente = primerNodo
                    ultimoNodo = anteriorNodo
                    retornar VERDADERO
                FIN SI

                anteriorNodo.siguiente = actualNodo.siguiente
                retornar VERDADERO
            FIN SI

            anteriorNodo = actualNodo
            actualNodo = actualNodo.siguiente
        MIENTRAS actualNodo <> primerNodo

        retornar FALSO
    FIN FUNCION

    FUNCION print()
        SI primerNodo == NULO
            imprimir "Lista: [ ]"
            retornar
        FIN SI

        actualNodo = primerNodo
        imprimir "Lista: [ "

        HACER
            imprimir actualNodo.dato
            actualNodo = actualNodo.siguiente
            SI actualNodo <> primerNodo
                imprimir " | "
            FIN SI
        MIENTRAS actualNodo <> primerNodo

        imprimir " ]"
    FIN FUNCION
```
## PUNTO 5

```
publico ListaEnlazadaSimpleLog

    primerNodo = NodoLog
    ultimoNodo = NodoLog

    FUNCION insertar(log)
        nuevoNodo = NodoLog(log)
        SI primerNodo == NULO
            primerNodo = nuevoNodo
            ultimoNodo = nuevoNodo
        SINO
            ultimoNodo.siguiente = nuevoNodo
            ultimoNodo = nuevoNodo
        FIN SI
    FIN FUNCION

    FUNCION errorRegistro(mensaje)
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            SI actual.dato.mensaje == mensaje
                imprimir actual.dato
            FIN SI
            actual = actual.siguiente
        FIN MIENTRAS
    FIN FUNCION

    FUNCION eliminar30Day()
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        anterior = NULO
        MIENTRAS actual <> NULO
            dias = diferencia en dias entre actual.dato.fechaHora y ahora
            SI dias > 30
                SI actual == primerNodo
                    primerNodo = primerNodo.siguiente
                SINO
                    anterior.siguiente = actual.siguiente
                FIN SI
            SINO
                anterior = actual
            FIN SI
            actual = actual.siguiente
        FIN MIENTRAS
    FIN FUNCION

    FUNCION print()
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            imprimir actual.dato
            actual = actual.siguiente
        FIN MIENTRAS
    FIN FUNCION
```
		
## PUNTO 7

```
publico ListaDoblementeEnlazadaUsuario

    primerNodo = NodoUsuario
    ultimoNodo = NodoUsuario

    FUNCION insertar(usuario)
        nuevoNodo = NodoUsuario(usuario)
        SI primerNodo == NULO
            primerNodo = nuevoNodo
            ultimoNodo = nuevoNodo
        SINO
            nuevoNodo.anterior = ultimoNodo
            ultimoNodo.siguiente = nuevoNodo
            ultimoNodo = nuevoNodo
        FIN SI
    FIN FUNCION

    FUNCION eliminar(id)
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            SI actual.dato.id == id
                SI actual == primerNodo && actual == ultimoNodo
                    primerNodo = NULO
                    ultimoNodo = NULO
                SINO SI actual == primerNodo
                    primerNodo = actual.siguiente
                    primerNodo.anterior = NULO
                SINO SI actual == ultimoNodo
                    ultimoNodo = actual.anterior
                    ultimoNodo.siguiente = NULO
                SINO
                    actual.anterior.siguiente = actual.siguiente
                    actual.siguiente.anterior = actual.anterior
                FIN SI
                imprimir "Usuario con ID " + id + " eliminado"
                retornar
            FIN SI
            actual = actual.siguiente
        FIN MIENTRAS
        imprimir "Usuario con ID " + id + " no encontrado"
    FIN FUNCION

    FUNCION buscarPorId(id)
        SI primerNodo == NULO
            retornar NULO
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            SI actual.dato.id == id
                retornar actual.dato
            FIN SI
            actual = actual.siguiente
        FIN MIENTRAS
        retornar NULO
    FIN FUNCION

    FUNCION buscarPorNombre(nombre)
        SI primerNodo == NULO
            retornar NULO
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            SI actual.dato.nombre == nombre
                retornar actual.dato
            FIN SI
            actual = actual.siguiente
        FIN MIENTRAS
        retornar NULO
    FIN FUNCION

    FUNCION ordenarPorNombre()
        SI primerNodo == NULO
            retornar
        FIN SI
        REPETIR
            intercambio = FALSO
            actual = primerNodo
            MIENTRAS actual.siguiente <> NULO
                SI actual.dato.nombre > actual.siguiente.dato.nombre
                    temp = actual.dato
                    actual.dato = actual.siguiente.dato
                    actual.siguiente.dato = temp
                    intercambio = VERDADERO
                FIN SI
                actual = actual.siguiente
            FIN MIENTRAS
        HASTA QUE intercambio == FALSO
    FIN FUNCION

    FUNCION ordenarPorId()
        SI primerNodo == NULO
            retornar
        FIN SI
        REPETIR
            intercambio = FALSO
            actual = primerNodo
            MIENTRAS actual.siguiente <> NULO
                SI actual.dato.id > actual.siguiente.dato.id
                    temp = actual.dato
                    actual.dato = actual.siguiente.dato
                    actual.siguiente.dato = temp
                    intercambio = VERDADERO
                FIN SI
                actual = actual.siguiente
            FIN MIENTRAS
        HASTA QUE intercambio == FALSO
    FIN FUNCION

    FUNCION print()
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            imprimir actual.dato
            actual = actual.siguiente
        FIN MIENTRAS
    FIN FUNCION
```
## PUNTO 9

```
publico ListaCircularJugador

    ultimoNodo = NodoJugador
    size = entero

    FUNCION insertar(jugador)
        nuevoNodo = NodoJugador(jugador)
        SI ultimoNodo == NULO
            nuevoNodo.siguiente = nuevoNodo
            ultimoNodo = nuevoNodo
        SINO
            nuevoNodo.siguiente  = ultimoNodo.siguiente
            ultimoNodo.siguiente = nuevoNodo
            ultimoNodo = nuevoNodo
        FIN SI
        size = size + 1
    FIN FUNCION

    FUNCION eliminarJugador(nombre)
        SI ultimoNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = ultimoNodo.siguiente
        anterior = ultimoNodo
        REPETIR size veces
            SI actual.dato.nombre == nombre
                SI size == 1
                    ultimoNodo = NULO
                SINO
                    anterior.siguiente = actual.siguiente
                    SI actual == ultimoNodo
                        ultimoNodo = anterior
                    FIN SI
                FIN SI
                size = size - 1
                imprimir nombre + " eliminado"
                retornar
            FIN SI
            anterior = actual
            actual = actual.siguiente
        FIN REPETIR
        imprimir "Jugador " + nombre + " no encontrado"
    FIN FUNCION

    FUNCION eliminarPerdedores()
        SI ultimoNodo == NULO
            retornar
        FIN SI
        nombres = arreglo de texto [size]
        actual = ultimoNodo.siguiente
        REPETIR size veces
            SI actual.dato.puntuacion <= 0
                nombres[i] = actual.dato.nombre
            FIN SI
            actual = actual.siguiente
        FIN REPETIR
        PARA CADA nombre EN nombres
            SI nombre <> NULO
                eliminarJugador(nombre)
            FIN SI
        FIN PARA
    FIN FUNCION

    FUNCION simularRonda(puntosResta)
        SI ultimoNodo == NULO  size == 1
            retornar
        FIN SI
        actual = ultimoNodo.siguiente
        REPETIR size veces
            actual.dato.puntuacion = actual.dato.puntuacion - puntosResta
            imprimir actual.dato.nombre + " ahora tiene " + actual.dato.puntuacion
            actual = actual.siguiente
        FIN REPETIR
        eliminarPerdedores()
    FIN FUNCION

    FUNCION jugarHastaGanador(puntosRestaPorRonda)
        imprimir "INICIO DEL JUEGO"
        ronda = 1
        MIENTRAS size > 1
            imprimir "RONDA " + ronda
            simularRonda(puntosRestaPorRonda)
            SI size > 1
                imprimir jugadores restantes
            FIN SI
            ronda = ronda + 1
        FIN MIENTRAS
        imprimir "FIN DEL JUEGO"
        SI ultimoNodo <> NULO
            imprimir "GANADOR: " + ultimoNodo.dato
        SINO
            imprimir "Sin ganador, todos eliminados en la misma ronda"
        FIN SI
    FIN FUNCION

    FUNCION print()
        SI ultimoNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = ultimoNodo.siguiente
        REPETIR size veces
            imprimir actual.dato
            actual = actual.siguiente
        FIN REPETIR
    FIN FUNCION
```
## PUNTO 11

```
publico ListaDoblementeEnlazadaTransaccion

    primerNodo = NodoTransaccion
    ultimoNodo = NodoTransaccion
    size = entero

    FUNCION insertar(transaccion)
        nuevoNodo = NodoTransaccion(transaccion)
        SI primerNodo == NULO
            primerNodo = nuevoNodo
            ultimoNodo = nuevoNodo
        SINO
            nuevoNodo.anterior = ultimoNodo
            ultimoNodo.siguiente = nuevoNodo
            ultimoNodo = nuevoNodo
        FIN SI
        size = size + 1
    FIN FUNCION

    FUNCION calcularSaldo()
        SI primerNodo == NULO
            imprimir "No hay transacciones registradas"
            retornar 0
        FIN SI
        saldo = 0
        actual = primerNodo
        MIENTRAS actual <> NULO
            SI actual.dato.tipo == "DEPOSITO"
                saldo = saldo + actual.dato.monto
            SINO SI actual.dato.tipo == "RETIRO"
                saldo = saldo - actual.dato.monto
            FIN SI
            actual = actual.siguiente
        FIN MIENTRAS
        retornar saldo
    FIN FUNCION

    FUNCION resumenUltimasN(n)
        SI ultimoNodo == NULO
            imprimir "No hay transacciones registradas"
            retornar
        FIN SI
        actual = ultimoNodo
        contador = 0
        MIENTRAS actual <> NULO && contador < n
            imprimir actual.dato
            actual = actual.anterior
            contador = contador + 1
        FIN MIENTRAS
        imprimir "Saldo actual: $" + calcularSaldo()
    FIN FUNCION

    FUNCION revertirUltimaTransaccion()
        SI ultimoNodo == NULO
            imprimir "No hay transacciones para revertir"
            retornar
        FIN SI
        ultima = ultimoNodo.dato
        SI ultimoNodo == primerNodo
            primerNodo = NULO
            ultimoNodo = NULO
        SINO
            ultimoNodo = ultimoNodo.anterior
            ultimoNodo.siguiente = NULO
        FIN SI
        size = size - 1
        imprimir "Transaccion revertida: " + ultima
    FIN FUNCION

    FUNCION print()
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            imprimir actual.dato
            actual = actual.siguiente
        FIN MIENTRAS
    FIN FUNCION
```
## PUNTO 13

```
publico ListaEnlazadaSimple

    primerNodo = Nodo
    ultimoNodo = Nodo

    FUNCION insertar(dato)
        nuevoNodo = Nodo(dato)
        SI primerNodo == NULO
            primerNodo = nuevoNodo
            ultimoNodo = nuevoNodo
        SINO
            ultimoNodo.siguiente = nuevoNodo
            ultimoNodo = nuevoNodo
        FIN SI
    FIN FUNCION

    FUNCION esCircular()
        SI primerNodo == NULO
            retornar FALSO
        FIN SI
        lento = primerNodo
        rapido = primerNodo
        MIENTRAS rapido <> NULO && rapido.siguiente <> NULO
            lento = lento.siguiente
            rapido = rapido.siguiente.siguiente
            SI lento == rapido
                retornar VERDADERO
            FIN SI
        FIN MIENTRAS
        retornar FALSO
    FIN FUNCION

    FUNCION convertirACircular()
        SI ultimoNodo == NULO
            imprimir "Lista vacia, no se puede convertir"
            retornar
        FIN SI
        SI esCircular()
            imprimir "La lista ya es circular"
            retornar
        FIN SI
        ultimoNodo.siguiente = primerNodo
        imprimir "Lista convertida a circular"
    FIN FUNCION

    FUNCION revertirASimple()
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        SI esCircular() == FALSO
            imprimir "La lista ya es simple"
            retornar
        FIN SI
        actual = primerNodo
        MIENTRAS actual.siguiente <> primerNodo
            actual = actual.siguiente
        FIN MIENTRAS
        actual.siguiente = NULO
        ultimoNodo = actual
        imprimir "Lista revertida a simple"
    FIN FUNCION

    FUNCION print()
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        SI esCircular()
            actual = primerNodo
            REPETIR
                imprimir actual.dato
                actual = actual.siguiente
            HASTA QUE actual == primerNodo
        SINO
            actual = primerNodo
            MIENTRAS actual <> NULO
                imprimir actual.dato
                actual = actual.siguiente
            FIN MIENTRAS
        FIN SI
    FIN FUNCION
```
## PUNTO 15
```
publico ListaEnlazadaRegistro

    primerNodo = NodoRegistro
    ultimoNodo = NodoRegistro

    FUNCION insertar(registro)
        nuevoNodo = NodoRegistro(registro)
        SI primerNodo == NULO
            primerNodo = nuevoNodo
            ultimoNodo = nuevoNodo
        SINO
            ultimoNodo.siguiente = nuevoNodo
            ultimoNodo = nuevoNodo
        FIN SI
    FIN FUNCION

    FUNCION filtrarPorRango(desde, hasta)
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        encontrado = FALSO
        MIENTRAS actual <> NULO
            fecha = actual.dato.fechaHora
            despuesDe = fecha >= desde
            antesDe = fecha <= hasta
            SI despuesDe && antesDe
                imprimir actual.dato
                encontrado = VERDADERO
            FIN SI
            actual = actual.siguiente
        FIN MIENTRAS
        SI encontrado == FALSO
            imprimir "No hay registros en ese rango"
        FIN SI
    FIN FUNCION

    FUNCION buscarIp(ips, cantidad, ip)
        PARA i = 0 HASTA cantidad - 1
            SI ips[i] == ip
                retornar i
            FIN SI
        FIN PARA
        retornar -1
    FIN FUNCION

    FUNCION contarNodos()
        contador = 0
        actual = primerNodo
        MIENTRAS actual <> NULO
            contador = contador + 1
            actual   = actual.siguiente
        FIN MIENTRAS
        retornar contador
    FIN FUNCION

    FUNCION accesosUnicosPorIp()
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        total = contarNodos()
        ips = arreglo de texto [total]
        conteos = arreglo de entero [total]
        cantidadIps = 0
        actual = primerNodo
        MIENTRAS actual <> NULO
            ipActual = actual.dato.ip
            indice = buscarIp(ips, cantidadIps, ipActual)
            SI indice == -1
                ips[cantidadIps] = ipActual
                conteos[cantidadIps] = 1
                cantidadIps = cantidadIps + 1
            SINO
                conteos[indice] = conteos[indice] + 1
            FIN SI
            actual = actual.siguiente
        FIN MIENTRAS
        PARA i = 0 HASTA cantidadIps - 1
            imprimir "IP: " + ips[i] + " | Accesos: " + conteos[i]
        FIN PARA
        maxAccesos = 0
        PARA i = 0 HASTA cantidadIps - 1
            SI conteos[i] > maxAccesos
                maxAccesos = conteos[i]
            FIN SI
        FIN PARA
        imprimir "IPs mas activas"
        PARA i = 0 HASTA cantidadIps - 1
            SI conteos[i] == maxAccesos
                imprimir "IP: " + ips[i] + " | Accesos: " + conteos[i]
            FIN SI
        FIN PARA
    FIN FUNCION

    FUNCION print()
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            imprimir actual.dato
            actual = actual.siguiente
        FIN MIENTRAS
    FIN FUNCION
```
## PUNTO 17

```
publico ListaDoblementeEnlazadaSensor

    primerNodo = NodoSensor
    ultimoNodo = NodoSensor

    FUNCION insertar(sensor)
        nuevoNodo = NodoSensor(sensor)
        SI primerNodo == NULO
            primerNodo = nuevoNodo
            ultimoNodo = nuevoNodo
        SINO
            nuevoNodo.anterior   = ultimoNodo
            ultimoNodo.siguiente = nuevoNodo
            ultimoNodo = nuevoNodo
        FIN SI
    FIN FUNCION

    FUNCION eliminar(id)
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            SI actual.dato.id == id
                SI actual == primerNodo && actual == ultimoNodo
                    primerNodo = NULO
                    ultimoNodo = NULO
                SINO SI actual == primerNodo
                    primerNodo = actual.siguiente
                    primerNodo.anterior = NULO
                SINO SI actual == ultimoNodo
                    ultimoNodo = actual.anterior
                    ultimoNodo.siguiente = NULO
                SINO
                    actual.anterior.siguiente = actual.siguiente
                    actual.siguiente.anterior = actual.anterior
                FIN SI
                imprimir "Sensor con ID " + id + " eliminado"
                retornar
            FIN SI
            actual = actual.siguiente
        FIN MIENTRAS
        imprimir "Sensor con ID " + id + " no encontrado"
    FIN FUNCION

    FUNCION actualizar(id, nuevaUbicacion, nuevaLectura)
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            SI actual.dato.id == id
                actual.dato.ubicacion    = nuevaUbicacion
                actual.dato.lecturaValor = nuevaLectura
                imprimir "Sensor con ID " + id + " actualizado"
                retornar
            FIN SI
            actual = actual.siguiente
        FIN MIENTRAS
        imprimir "Sensor con ID " + id + " no encontrado"
    FIN FUNCION

    FUNCION calcularMedia()
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar 0
        FIN SI
        suma = 0
        contador = 0
        actual   = primerNodo
        MIENTRAS actual <> NULO
            suma = suma + actual.dato.lecturaValor
            contador = contador + 1
            actual = actual.siguiente
        FIN MIENTRAS
        retornar suma / contador
    FIN FUNCION

    FUNCION print()
        SI primerNodo == NULO
            imprimir "Lista vacia"
            retornar
        FIN SI
        actual = primerNodo
        MIENTRAS actual <> NULO
            imprimir actual.dato
            actual = actual.siguiente
        FIN MIENTRAS
    FIN FUNCION
```
