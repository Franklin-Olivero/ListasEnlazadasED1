"""2. Implementación Básica de una Lista Enlazada Dobles:
ListaDoble:

	clase NodoDoble
		String danto 
		NodoDoble sig
	 	NodoDoble ant
         
        metodo NodoDoble(dato)
            me.dato ← dato
            me.sig ← nulo
            me.ant ← nulo
        FinMetodo
         
	clase ListaDoble
		PTR ← null
	 	FINAL ← null
        
        Proceso insertarInicio(dato)
            NodoDoble nuevo ← nuevo NodoDoble(dato)

            si (esVacia()) ent
                PTR ← nuevo
                FINAL ← nuevo
            si no
                nuevo.sig ← PTR
                PTR.ant ← nuevo
                PTR ← nuevo
        
        Proceso insertarFinal(dato)
            NodoDoble nuevo ← nuevo NodoDoble(dato)

            Si (esVacia())
                PTR ← nuevo
                FINAL ← nuevo
            Si no
                FINAL.sig ← nuevo
                nuevo.ant ← FINAL
                FINAL ← nuevo
            Fin si
        Fin

        Proceso mostrarLista()
            Si (esVacia())
                Escribir "Lista vacia"
            Si no
                NodoDoble actual ← PTR

                MQ (actual <> nulo) hacer
                    Escribir (actual.dato) 
                    actual ← actual.sig
                Fin MQ
            FinSi
        Fin

        Funcion Nodo buscar(dato)
            NodoDoble actual ← PTR

            MQ (actual <> nulo)
                Si(actual.dato == dato)
                    retornar actual
                Si no
                    actual ← actual.sig
                Fin Si
            Fin MQ
            retornar falso
        Fin

        Proceso modificar(datoViejo, datoNuevo)
            NodoDoble actual ← PTR

            MQ (actual <> nulo)
                Si(actual.dato == datoViejo)
                    actual.dato ← datoNuevo
                Si no
                    actual ← actual.sig
                Fin Si
            Fin MQ
        Fin

    Proceso eliminar(dato)
        Si(esVacia())
            Escribir "Lista vacia"
            romper
        FinSi

        NodoDoble actual ← PTR
        MQ (actual <> nulo)
            Si(actual.dato = dato)
                Si (PTR = FINAL)
                    PTR ← nulo
                    FINAL ← nulo
                Si no Si(actual = PTR)
                    PTR ← actual.sig
                    PTR.ant ← nulo
                Si no Si(actual = FINAL)
                    FINAL ← actual.ant
                    FINAL.sig ← nulo
                Si no
                    actual.ant.sig ← actual.sig
                    actual.sig.ant ← actual.ant
                Fin Si
                romper
            FinSi
            actual ← actual.sig
        Fin MQ
    Fin
"""

class NodoDoble:
    def __init__(self, dato):
        self.dato = dato
        self.sig = None
        self.ant = None


class ListaDoble:
    def __init__(self):
        self.PTR = None
        self.FINAL = None

    def es_vacia(self):
        return self.PTR is None

    def insertar_inicio(self, dato):
        nuevo = NodoDoble(dato)

        if self.es_vacia():
            self.PTR = nuevo
            self.FINAL = nuevo
        else:
            nuevo.sig = self.PTR
            self.PTR.ant = nuevo
            self.PTR = nuevo

    def insertar_final(self, dato):
        nuevo = NodoDoble(dato)

        if self.es_vacia():
            self.PTR = nuevo
            self.FINAL = nuevo
        else:
            self.FINAL.sig = nuevo
            nuevo.ant = self.FINAL
            self.FINAL = nuevo

    def mostrar(self):
        actual = self.PTR

        while actual is not None:
            print(actual.dato)
            actual = actual.sig

    def eliminar(self, valor):
        if self.es_vacia():
            return

        actual = self.PTR

        while actual is not None:

            if actual.dato == valor:

                if self.PTR == self.FINAL:
                    self.PTR = None
                    self.FINAL = None

                elif actual == self.PTR:
                    self.PTR = actual.sig
                    self.PTR.ant = None

                elif actual == self.FINAL:
                    self.FINAL = actual.ant
                    self.FINAL.sig = None

                else:
                   actual.ant.sig = actual.sig
                   actual.sig.ant = actual.ant
                return

            actual = actual.sig    
""" PRUEBA PUNTO 2"""

lista = ListaDoble()

lista.insertar_final("A")
lista.insertar_final("B")
lista.insertar_final("C")
lista.insertar_final("D")
lista.insertar_final("E")

print("Mostrar lista:")
lista.mostrar()

print("\nEliminar C:")
lista.eliminar("C")
lista.mostrar()

print("\nEliminar A:")
lista.eliminar("A")
lista.mostrar()

print("\nEliminar E:")
lista.eliminar("E")
lista.mostrar()
""" SALIDA 
Mostrar lista:
A
B
C
D
E

Eliminar C:
A
B
D
E

Eliminar A:
B
D
E

Eliminar E:
B
D
"""

""" 
4. Implementación Básica de una Lista Enlazada Circular Doble:

clase NodoDoble
    String dato
    NodoDoble sig
    NodoDoble ant

    metodo NodoDoble(dato)
        me.dato ← dato
        me.sig ← nulo
        me.ant ← nulo
    FinMetodo


clase ListaDobleCircular
    PTR ← null
    FINAL ← null

    Proceso insertarInicio(dato)
        NodoDoble nuevo ← nuevo NodoDoble(dato)

        Si (PTR = nulo)
            PTR ← nuevo
            FINAL ← nuevo
            PTR.sig ← PTR
            PTR.ant ← PTR
        Si no
            nuevo.sig ← PTR
            nuevo.ant ← FINAL
            PTR.ant ← nuevo
            FINAL.sig ← nuevo
            PTR ← nuevo
        FinSi
    Fin

    Proceso insertarFinal(dato)
        NodoDoble nuevo ← nuevo NodoDoble(dato)

        Si (PTR = nulo)
            PTR ← nuevo
            FINAL ← nuevo
            PTR.sig ← PTR
            PTR.ant ← PTR
        Si no
            nuevo.sig ← PTR
            nuevo.ant ← FINAL
            FINAL.sig ← nuevo
            PTR.ant ← nuevo
            FINAL ← nuevo
        FinSi
    Fin

    Proceso mostrarLista()
        Si (PTR = nulo)
            Escribir "Lista vacia"
        Si no
            NodoDoble actual ← PTR

            MQ (verdadero)
                Escribir(actual.dato)
                actual ← actual.sig
                Si (actual = PTR)
                    romper
                FinSi
            Fin MQ
        FinSi
    Fin

"""
class NodoDoble:
    def __init__(self, dato):
        self.dato = dato
        self.sig = None
        self.ant = None


class ListaEnlazadaCircularDoble:
    def __init__(self):
        self.PTR = None
        self.FINAL = None

    def es_vacia(self):
        return self.PTR is None

    def insertar_inicio(self, dato):
        nuevo = NodoDoble(dato)

        if self.es_vacia():
            self.PTR = nuevo
            self.FINAL = nuevo
            self.PTR.sig = self.PTR
            self.PTR.ant = self.PTR
        else:
            nuevo.sig = self.PTR
            nuevo.ant = self.FINAL
            self.PTR.ant = nuevo
            self.FINAL.sig = nuevo
            self.PTR = nuevo

    def insertar_final(self, dato):
        nuevo = NodoDoble(dato)

        if self.es_vacia():
            self.PTR = nuevo
            self.FINAL = nuevo
            self.PTR.sig = self.PTR
            self.PTR.ant = self.PTR
        else:
            nuevo.sig = self.PTR
            nuevo.ant = self.FINAL
            self.FINAL.sig = nuevo
            self.PTR.ant = nuevo
            self.FINAL = nuevo

    def mostrar(self):
        if self.es_vacia():
            print("Lista vacia")
            return

        actual = self.PTR

        while True:
            print(actual.dato)
            actual = actual.sig
            if actual == self.PTR:
                break

    def buscar(self, dato):
        if self.es_vacia():
            return None

        actual = self.PTR

        while True:
            if actual.dato == dato:
                return actual

            actual = actual.sig

            if actual == self.PTR:
                break

        return None

    def modificar(self, viejo, nuevo):
        if self.es_vacia():
            return

        actual = self.PTR

        while True:
            if actual.dato == viejo:
                actual.dato = nuevo
                return

            actual = actual.sig

            if actual == self.PTR:
                break

    def eliminar(self, dato):
        if self.es_vacia():
            return

        actual = self.PTR

        while True:

            if actual.dato == dato:

                if self.PTR == self.FINAL:
                    self.PTR = None
                    self.FINAL = None

                elif actual == self.PTR:
                    self.PTR = actual.sig
                    self.PTR.ant = self.FINAL
                    self.FINAL.sig = self.PTR

                elif actual == self.FINAL:
                    self.FINAL = actual.ant
                    self.FINAL.sig = self.PTR
                    self.PTR.ant = self.FINAL

                else:
                    actual.ant.sig = actual.sig
                    actual.sig.ant = actual.ant

                return

            actual = actual.sig

            if actual == self.PTR:
                break

"""PRUEBA PUNTO 4"""
lista = ListaEnlazadaCircularDoble()

lista.insertar_inicio("B")
lista.insertar_inicio("A")
lista.insertar_final("C")
lista.insertar_final("D")
lista.insertar_final("E")

print("Mostrar lista:")
lista.mostrar()

print("\nBuscar C:")
nodo = lista.buscar("C")
if nodo is not None:
    print("Encontrado:", nodo.dato)
else:
    print("No encontrado")

print("\nModificar C por X:")
lista.modificar("C", "X")
lista.mostrar()

print("\nEliminar A:")
lista.eliminar("A")
lista.mostrar()

print("\nEliminar E:")
lista.eliminar("E")
lista.mostrar()

print("\nEliminar X:")
lista.eliminar("X")
lista.mostrar()

"""SALIDA
Mostrar lista:
A
B
C
D
E

Buscar C:
Encontrado: C

Modificar C por X:
A
B
X
D
E

Eliminar A:
B
X
D
E

Eliminar E:
B
X
D

Eliminar X:
B
D
"""

"""
6. Optimización de Búsquedas en Listas Enlazadas:

clase Nodo
    entero dato
    Nodo sig
FinClase


clase ListaEnlazada

    PTR ← null

    Proceso insertarFinal(dato)
        Nodo nuevo ← Nodo(dato)

        Si PTR = null
            PTR ← nuevo
        Si no
            Nodo actual ← PTR

            Mientras actual.sig != null
                actual ← actual.sig
            FinMientras

            actual.sig ← nuevo
        FinSi
    FinProceso


    Funcion busquedaLineal(n)
        Nodo actual ← PTR

        Mientras actual != null
            Si actual.dato == n
                retornar actual
            FinSi
            actual ← actual.sig
        FinMientras

        retornar null
    FinFuncion


    Funcion busquedaSaltos(n)
        Si PTR = null
            retornar null
        FinSi

        salto ← 2
        Nodo actual ← PTR

        Mientras actual != null

            contador ← 0
            Nodo bloque ← actual

            Mientras contador < salto Y bloque != null

                Si bloque.dato == n
                    retornar bloque
                FinSi

                bloque ← bloque.sig
                contador ← contador + 1

            FinMientras

            actual ← bloque

        FinMientras

        retornar null
    FinFuncion

FinClase
"""
class Nodo:
    def __init__(self, dato):
        self.dato = dato
        self.sig = None


class ListaEnlazada:
    def __init__(self):
        self.PTR = None

    def insertar_final(self, dato):
        nuevo = Nodo(dato)

        if self.PTR is None:
            self.PTR = nuevo
        else:
            actual = self.PTR
            while actual.sig is not None:
                actual = actual.sig
            actual.sig = nuevo

    def busqueda_lineal(self, n):
        actual = self.PTR

        while actual is not None:
            if actual.dato == n:
                return actual
            actual = actual.sig

        return None

    def busqueda_saltos(self, n):
        if self.PTR is None:
            return None

        salto = 2
        actual = self.PTR

        while actual is not None:

            bloque = actual
            contador = 0

            while contador < salto and bloque is not None:

                if bloque.dato == n:
                    return bloque

                bloque = bloque.sig
                contador += 1

            actual = bloque

        return None

"""PRUEBA PUNTO 6"""
lista = ListaEnlazada()

for i in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]:
    lista.insertar_final(i)

print("BUSQUEDA LINEAL")
r = lista.busqueda_lineal(7)
if r:
    print(r.dato)
else:
    print("No encontrado")

print("\nBUSQUEDA SALTOS")
r = lista.busqueda_saltos(7)
if r:
    print(r.dato)
else:
    print("No encontrado")

print("\nBUSQUEDA ELEMENTO INEXISTENTE")
r = lista.busqueda_saltos(99)
if r:
    print(r.dato)
else:
    print("No encontrado")

""" SALIDA 

BUSQUEDA LINEAL
7

BUSQUEDA SALTOS
7

BUSQUEDA ELEMENTO INEXISTENTE
No encontrado

"""

"""8. Implementación de un Historial de Navegación con Listas Doblemente
Enlazadas:

clase Nodo
    texto url
    Nodo sig
    Nodo ant
FinClase


clase Historial

    PTR ← null
    FINAL ← null
    ACTUAL ← null


    Proceso visitar(url)
        Nodo nuevo ← Nodo(url)

        Si PTR = null
            PTR ← nuevo
            FINAL ← nuevo
            ACTUAL ← nuevo
        Si no
            ACTUAL.sig ← nuevo
            nuevo.ant ← ACTUAL
            ACTUAL ← nuevo
            FINAL ← nuevo
        FinSi
    FinProceso


    Funcion atras()
        Si ACTUAL != PTR
            ACTUAL ← ACTUAL.ant
        FinSi
        retornar ACTUAL.url
    FinFuncion


    Funcion adelante()
        Si ACTUAL != FINAL
            ACTUAL ← ACTUAL.sig
        FinSi
        retornar ACTUAL.url
    FinFuncion


    Proceso eliminar(url)
        Nodo actual ← PTR

        Mientras actual != null

            Si actual.url == url

                Si actual == PTR
                    PTR ← actual.sig
                    Si PTR != null
                        PTR.ant ← null
                    FinSi

                Si no Si actual == FINAL
                    FINAL ← actual.ant
                    FINAL.sig ← null

                Si no
                    actual.ant.sig ← actual.sig
                    actual.sig.ant ← actual.ant
                FinSi

                FinSi

            actual ← actual.sig

        FinMientras
    FinProceso


    Proceso guardarArchivo()
        abrir archivo "historial.txt"

        Nodo actual ← PTR

        Mientras actual != null
            escribir archivo actual.url
            actual ← actual.sig
        FinMientras

        cerrar archivo
    FinProceso


    Proceso cargarArchivo()
        abrir archivo "historial.txt"

        Mientras hay lineas
            leer url
            visitar(url)
        FinMientras

        cerrar archivo
    FinProceso

FinClase
"""

class Nodo:
    def __init__(self, url):
        self.url = url
        self.sig = None
        self.ant = None


class Historial:
    def __init__(self):
        self.PTR = None
        self.FINAL = None
        self.ACTUAL = None

    def visitar(self, url):
        nuevo = Nodo(url)

        if self.PTR is None:
            self.PTR = nuevo
            self.FINAL = nuevo
            self.ACTUAL = nuevo
        else:
            self.ACTUAL.sig = nuevo
            nuevo.ant = self.ACTUAL
            self.ACTUAL = nuevo
            self.FINAL = nuevo

    def atras(self):
        if self.ACTUAL is not None and self.ACTUAL.ant is not None:
            self.ACTUAL = self.ACTUAL.ant
        return self.ACTUAL.url

    def adelante(self):
        if self.ACTUAL is not None and self.ACTUAL.sig is not None:
            self.ACTUAL = self.ACTUAL.sig
        return self.ACTUAL.url

    def eliminar(self, url):
        actual = self.PTR

        while actual is not None:

            if actual.url == url:

                if actual == self.PTR:
                    self.PTR = actual.sig
                    if self.PTR is not None:
                        self.PTR.ant = None

                elif actual == self.FINAL:
                    self.FINAL = actual.ant
                    self.FINAL.sig = None

                else:
                    actual.ant.sig = actual.sig
                    actual.sig.ant = actual.ant

            actual = actual.sig

    def guardar(self):
        with open("historial.txt", "w") as f:
            actual = self.PTR

            while actual is not None:
                f.write(actual.url + "\n")
                actual = actual.sig

    def cargar(self):
        with open("historial.txt", "r") as f:
            for linea in f:
                self.visitar(linea.strip())

"""PRUEBA PUNTO 8"""
h = Historial()

h.visitar("google.com")
h.visitar("youtube.com")
h.visitar("github.com")
h.visitar("chatgpt.com")
h.visitar("stackoverflow.com")

print("ATRAS")
print(h.atras())
print(h.atras())

print("\nADELANTE")
print(h.adelante())

print("\nELIMINAR youtube.com")
h.eliminar("youtube.com")

actual = h.PTR
while actual is not None:
    print(actual.url)
    actual = actual.sig

h.guardar()

print("\nCARGAR HISTORIAL")
h2 = Historial()
h2.cargar()

actual = h2.PTR
while actual is not None:
    print(actual.url)
    actual = actual.sig

""" SALIDA

ATRAS
github.com
youtube.com

ADELANTE
github.com

ELIMINAR youtube.com
google.com
github.com
chatgpt.com
stackoverflow.com

CARGAR HISTORIAL
google.com
github.com
chatgpt.com
stackoverflow.com
"""

""" 10. Implementación de una Lista Enlazada de Tareas Prioritarias:

clase Nodo
    texto tarea
    entero prioridad
    texto fecha
    Nodo sig
FinClase


clase ListaTareas

    PTR ← null


    Proceso insertarOrdenado(tarea, prioridad, fecha)
        Nodo nuevo ← Nodo(tarea, prioridad, fecha)

        Si PTR = null O nuevo.prioridad > PTR.prioridad
            nuevo.sig ← PTR
            PTR ← nuevo
        Si no
            Nodo actual ← PTR

            Mientras actual.sig != null Y actual.sig.prioridad >= nuevo.prioridad
                actual ← actual.sig
            FinMientras

            nuevo.sig ← actual.sig
            actual.sig ← nuevo
        FinSi
    FinProceso


    Proceso mostrar()
        Nodo actual ← PTR

        Mientras actual != null
            Escribir actual.tarea, actual.prioridad, actual.fecha
            actual ← actual.sig
        FinMientras
    FinProceso

FinClase

"""

class Nodo:
    def __init__(self, tarea, prioridad, fecha):
        self.tarea = tarea
        self.prioridad = prioridad
        self.fecha = fecha
        self.sig = None


class ListaTareas:
    def __init__(self):
        self.PTR = None

    def insertar_ordenado(self, tarea, prioridad, fecha):
        nuevo = Nodo(tarea, prioridad, fecha)

        if self.PTR is None or nuevo.prioridad > self.PTR.prioridad:
            nuevo.sig = self.PTR
            self.PTR = nuevo
        else:
            actual = self.PTR

            while actual.sig is not None and actual.sig.prioridad >= nuevo.prioridad:
                actual = actual.sig

            nuevo.sig = actual.sig
            actual.sig = nuevo

    def mostrar(self):
        actual = self.PTR

        while actual is not None:
            print(actual.tarea, actual.prioridad, actual.fecha)
            actual = actual.sig

""" PRUEBA PUNTO 10"""
lista = ListaTareas()

lista.insertar_ordenado("Diseñar base de datos", 2, "2026-05-10")
lista.insertar_ordenado("Arreglar bug login", 5, "2026-04-30")
lista.insertar_ordenado("Documentar proyecto", 1, "2026-05-15")
lista.insertar_ordenado("Implementar API", 4, "2026-05-01")
lista.insertar_ordenado("Pruebas unitarias", 3, "2026-05-05")

print("LISTA ORDENADA POR PRIORIDAD:")
lista.mostrar()

""" SALIDA 

LISTA ORDENADA POR PRIORIDAD:
Arreglar bug login 5 2026-04-30
Implementar API 4 2026-05-01
Pruebas unitarias 3 2026-05-05
Diseñar base de datos 2 2026-05-10
Documentar proyecto 1 2026-05-15
"""

""" 12. Estructura de Datos para una Agenda de Contactos:

clase Nodo
    texto nombre
    texto telefono
    texto correo
    Nodo sig
    Nodo ant
FinClase


clase Agenda

    PTR ← null
    FINAL ← null


    Proceso agregar(nombre, telefono, correo)
        Nodo nuevo ← Nodo(nombre, telefono, correo)

        Si PTR = null
            PTR ← nuevo
            FINAL ← nuevo
        Si no
            FINAL.sig ← nuevo
            nuevo.ant ← FINAL
            FINAL ← nuevo
        FinSi
    FinProceso


    Proceso eliminar(telefono)
        Nodo actual ← PTR

        Mientras actual != null

            Si actual.telefono == telefono

                Si actual == PTR
                    PTR ← actual.sig
                    Si PTR != null
                        PTR.ant ← null
                    FinSi

                Si no Si actual == FINAL
                    FINAL ← actual.ant
                    FINAL.sig ← null

                Si no
                    actual.ant.sig ← actual.sig
                    actual.sig.ant ← actual.ant
                FinSi

            FinSi

            actual ← actual.sig

        FinMientras
    FinProceso


    Funcion buscarPorTelefono(telefono)
        Nodo actual ← PTR

        Mientras actual != null
            Si actual.telefono == telefono
                retornar actual
            FinSi
            actual ← actual.sig
        FinMientras

        retornar null
    FinFuncion


    Proceso ordenarAlfabetico()
        Nodo i ← PTR

        Mientras i != null
            Nodo j ← i.sig

            Mientras j != null

                Si i.nombre > j.nombre
                    intercambiar i.nombre, j.nombre
                    intercambiar i.telefono, j.telefono
                    intercambiar i.correo, j.correo
                FinSi

                j ← j.sig

            FinMientras

            i ← i.sig

        FinMientras
    FinProceso


    Proceso mostrar()
        Nodo actual ← PTR

        Mientras actual != null
            Escribir actual.nombre, actual.telefono, actual.correo
            actual ← actual.sig
        FinMientras
    FinProceso

FinClase
"""

class Nodo:
    def __init__(self, nombre, telefono, correo):
        self.nombre = nombre
        self.telefono = telefono
        self.correo = correo
        self.sig = None
        self.ant = None


class Agenda:
    def __init__(self):
        self.PTR = None
        self.FINAL = None

    def agregar(self, nombre, telefono, correo):
        nuevo = Nodo(nombre, telefono, correo)

        if self.PTR is None:
            self.PTR = nuevo
            self.FINAL = nuevo
        else:
            self.FINAL.sig = nuevo
            nuevo.ant = self.FINAL
            self.FINAL = nuevo

    def eliminar(self, telefono):
        actual = self.PTR

        while actual is not None:

            if actual.telefono == telefono:

                if actual == self.PTR:
                    self.PTR = actual.sig
                    if self.PTR is not None:
                        self.PTR.ant = None

                elif actual == self.FINAL:
                    self.FINAL = actual.ant
                    self.FINAL.sig = None

                else:
                    actual.ant.sig = actual.sig
                    actual.sig.ant = actual.ant

            actual = actual.sig

    def buscar_por_telefono(self, telefono):
        actual = self.PTR

        while actual is not None:
            if actual.telefono == telefono:
                return actual
            actual = actual.sig

        return None

    def ordenar_alfabetico(self):
        i = self.PTR

        while i is not None:
            j = i.sig

            while j is not None:

                if i.nombre > j.nombre:
                    i.nombre, j.nombre = j.nombre, i.nombre
                    i.telefono, j.telefono = j.telefono, i.telefono
                    i.correo, j.correo = j.correo, i.correo

                j = j.sig

            i = i.sig

    def mostrar(self):
        actual = self.PTR

        while actual is not None:
            print(actual.nombre, actual.telefono, actual.correo)
            actual = actual.sig

"""PRUEBA PUNTO 12"""
agenda = Agenda()

agenda.agregar("Carlos", "3001", "carlos@mail.com")
agenda.agregar("Ana", "3002", "ana@mail.com")
agenda.agregar("Luis", "3003", "luis@mail.com")
agenda.agregar("Maria", "3004", "maria@mail.com")
agenda.agregar("Pedro", "3005", "pedro@mail.com")

print("CONTACTOS:")
agenda.mostrar()

print("\nORDENANDO ALFABETICAMENTE:")
agenda.ordenar_alfabetico()
agenda.mostrar()

print("\nBUSCAR TELEFONO 3003:")
c = agenda.buscar_por_telefono("3003")
if c:
    print(c.nombre, c.telefono, c.correo)

print("\nELIMINAR 3002:")
agenda.eliminar("3002")
agenda.mostrar()

"""SALIDA

CONTACTOS:
Carlos 3001 carlos@mail.com
Ana 3002 ana@mail.com
Luis 3003 luis@mail.com
Maria 3004 maria@mail.com
Pedro 3005 pedro@mail.com

ORDENANDO ALFABETICAMENTE:
Ana 3002 ana@mail.com
Carlos 3001 carlos@mail.com
Luis 3003 luis@mail.com
Maria 3004 maria@mail.com
Pedro 3005 pedro@mail.com

BUSCAR TELEFONO 3003:
Luis 3003 luis@mail.com

ELIMINAR 3002:
Carlos 3001 carlos@mail.com
Luis 3003 luis@mail.com
Maria 3004 maria@mail.com
Pedro 3005 pedro@mail.com

"""

"""14. Modelo de Datos para un Servicio de Streaming:   

clase Nodo
    texto titulo
    entero duracion
    Nodo sig
FinClase


clase ColaReproduccion

    PTR ← null
    FINAL ← null
    ACTUAL ← null


    Proceso agregar(titulo, duracion)
        Nodo nuevo ← Nodo(titulo, duracion)

        Si PTR = null
            PTR ← nuevo
            FINAL ← nuevo
            PTR.sig ← PTR
            ACTUAL ← PTR
        Si no
            FINAL.sig ← nuevo
            nuevo.sig ← PTR
            FINAL ← nuevo
        FinSi
    FinProceso


    Funcion siguiente()
        ACTUAL ← ACTUAL.sig
        retornar ACTUAL.titulo
    FinFuncion


    Proceso eliminarActual()
        Si PTR = null
            retornar
        FinSi

        Si PTR = FINAL
            PTR ← null
            FINAL ← null
            ACTUAL ← null
            retornar
        FinSi

        Nodo temp ← PTR

        Mientras temp.sig != ACTUAL
            temp ← temp.sig
        FinMientras

        temp.sig ← ACTUAL.sig

        Si ACTUAL = PTR
            PTR ← ACTUAL.sig
        FinSi

        Si ACTUAL = FINAL
            FINAL ← temp
        FinSi

        ACTUAL ← ACTUAL.sig
    FinProceso


    Proceso mostrar()
        Si PTR = null
            Escribir "Cola vacia"
        Si no
            Nodo actual ← PTR

            Mientras verdadero
                Escribir actual.titulo
                actual ← actual.sig

                Si actual = PTR
                    romper
                FinSi
            FinMientras
        FinSi
    FinProceso

FinClase
"""
class Nodo:
    def __init__(self, titulo, duracion):
        self.titulo = titulo
        self.duracion = duracion
        self.sig = None


class ColaReproduccion:
    def __init__(self):
        self.PTR = None
        self.FINAL = None
        self.ACTUAL = None

    def agregar(self, titulo, duracion):
        nuevo = Nodo(titulo, duracion)

        if self.PTR is None:
            self.PTR = nuevo
            self.FINAL = nuevo
            nuevo.sig = self.PTR
            self.ACTUAL = self.PTR
        else:
            self.FINAL.sig = nuevo
            nuevo.sig = self.PTR
            self.FINAL = nuevo

    def siguiente(self):
        if self.ACTUAL is not None:
            self.ACTUAL = self.ACTUAL.sig
            return self.ACTUAL.titulo

    def eliminar_actual(self):
        if self.PTR is None:
            return

        if self.PTR == self.FINAL:
            self.PTR = None
            self.FINAL = None
            self.ACTUAL = None
            return

        temp = self.PTR

        while temp.sig != self.ACTUAL:
            temp = temp.sig

        temp.sig = self.ACTUAL.sig

        if self.ACTUAL == self.PTR:
            self.PTR = self.ACTUAL.sig

        if self.ACTUAL == self.FINAL:
            self.FINAL = temp

        self.ACTUAL = self.ACTUAL.sig

    def mostrar(self):
        if self.PTR is None:
            print("Cola vacia")
            return

        actual = self.PTR

        while True:
            print(actual.titulo, actual.duracion)
            actual = actual.sig

            if actual == self.PTR:
                break
            
"""PRUEBA PUNTO 14"""
cola = ColaReproduccion()

cola.agregar("Cancion A", 3)
cola.agregar("Cancion B", 4)
cola.agregar("Cancion C", 5)
cola.agregar("Cancion D", 2)

print("COLA DE REPRODUCCION:")
cola.mostrar()

print("\nSIGUIENTE CANCION:")
print(cola.siguiente())
print(cola.siguiente())

print("\nELIMINAR ACTUAL:")
cola.eliminar_actual()
cola.mostrar()

print("\nREPETICION DE COLA:")
for i in range(6):
    print(cola.siguiente())

"""   SALIDA

COLA DE REPRODUCCION:
Cancion A 3
Cancion B 4
Cancion C 5
Cancion D 2

SIGUIENTE CANCION:
Cancion B
Cancion C

ELIMINAR ACTUAL:
Cancion A 3
Cancion C 5
Cancion D 2

REPETICION DE COLA:
Cancion C
Cancion D
Cancion A
Cancion C
Cancion D
Cancion A

"""

""" 16. Comparación de Modelos de Predicción:

clase Nodo
    texto modelo
    real prediccion
    real error
    Nodo sig
FinClase


clase ListaModelos

    PTR ← null


    Proceso insertar(modelo, prediccion, error)
        Nodo nuevo ← Nodo(modelo, prediccion, error)

        Si PTR = null
            PTR ← nuevo
        Si no
            Nodo actual ← PTR

            Mientras actual.sig != null
                actual ← actual.sig
            FinMientras

            actual.sig ← nuevo
        FinSi
    FinProceso


    Funcion mejorModelo()
        Si PTR = null
            retornar null
        FinSi

        Nodo actual ← PTR
        Nodo mejor ← PTR

        Mientras actual != null

            Si actual.error < mejor.error
                mejor ← actual
            FinSi

            actual ← actual.sig

        FinMientras

        retornar mejor
    FinFuncion


    Proceso mostrar()
        Nodo actual ← PTR

        Mientras actual != null
            Escribir actual.modelo, actual.prediccion, actual.error
            actual ← actual.sig
        FinMientras
    FinProceso

FinClase
"""
class Nodo:
    def __init__(self, modelo, prediccion, error):
        self.modelo = modelo
        self.prediccion = prediccion
        self.error = error
        self.sig = None


class ListaModelos:
    def __init__(self):
        self.PTR = None

    def insertar(self, modelo, prediccion, error):
        nuevo = Nodo(modelo, prediccion, error)

        if self.PTR is None:
            self.PTR = nuevo
        else:
            actual = self.PTR
            while actual.sig is not None:
                actual = actual.sig
            actual.sig = nuevo

    def mejor_modelo(self):
        if self.PTR is None:
            return None

        actual = self.PTR
        mejor = self.PTR

        while actual is not None:

            if actual.error < mejor.error:
                mejor = actual

            actual = actual.sig

        return mejor

    def mostrar(self):
        actual = self.PTR

        while actual is not None:
            print(actual.modelo, actual.prediccion, actual.error)
            actual = actual.sig

"""PRUEBA PUNTO 16"""
lista = ListaModelos()

lista.insertar("Modelo A", 0.85, 0.15)
lista.insertar("Modelo B", 0.90, 0.10)
lista.insertar("Modelo C", 0.88, 0.05)
lista.insertar("Modelo D", 0.92, 0.20)
lista.insertar("Modelo E", 0.87, 0.08)

print("MODELOS:")
lista.mostrar()

print("\nMEJOR MODELO:")
mejor = lista.mejor_modelo()
print(mejor.modelo, mejor.prediccion, mejor.error)

"""     SALIDA

MODELOS:
Modelo A 0.85 0.15
Modelo B 0.9 0.1
Modelo C 0.88 0.05
Modelo D 0.92 0.2
Modelo E 0.87 0.08

MEJOR MODELO:
Modelo C 0.88 0.05

"""