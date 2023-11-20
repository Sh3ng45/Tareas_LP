import re
import numpy as np 
from PIL import Image 

def ancho(N,matriz):
    a = ""
    for i in range(N):
        matriz.append([a]*N)

'''
La Funcion define el ancho de la matriz

    Parametros:
        N (int): Entero que determina el ancho
        matriz (lista): Lista vacía que se utiliza para crear la matriz

    Retorno:
        No tiene retorno.
'''

def color_de_fondo(color,matriz,N):

    for i in range(N):
        for j in range(N):
            matriz[i][j] = color

'''
Define el color de fondo del pixelart

    Parametros:
        color (tupla): tupla con valores RGB
        matriz (lista): Matriz del pixelart
        N (int): Ancho de la matriz

    Retorno:
        No tiene retorno.
'''

def parametro_de_color(x):
    if x == "Blanco":
        color = (255,255,255)
    elif x == "Negro":
        color = (0,0,0)
    elif x == "Rojo":
        color = (255,0,0)
    elif x == "Verde":
        color = (0,255,0)
    elif x == "Azul":
        color = (0,0,255)
    elif x == "Blanco":
        color = (255,255,255)
    else:
        color = eval(x)
    return color

'''
Determina la tupla de valor RGB que le corresponde al color(string) evaluado

    Parametros:
        x (string): Color especificado

    Retorno:
        color (tupla): Tupla con correspondientes valores RGB.
'''

def derecha(parametros):
    if parametros[0] == "c" and parametros[1] == "r":
        parametros[0] = "f"
        parametros[1] = "d"
    elif parametros[0] == "f" and parametros[1] == "d":
        parametros[0] = "c"
        parametros[1] = "l"
    elif parametros[0] == "c" and parametros[1] == "l":
        parametros[0] = "f"
        parametros[1] = "u"
    elif parametros[0] == "f" and parametros[1] == "u":
        parametros[0] = "c"
        parametros[1] = "r"

'''
Gira hacia la derecha en la matriz

    Parametros:
        parametros (lista): Lista que contiene los parametros de fila o columna, sentido de avance y posicion de la matriz

    Retorno:
        No tiene retorno.
'''

def izquierda(parametros):
    if parametros[0] == "c" and parametros[1] == "r":
        parametros[0] = "f"
        parametros[1] = "u"
    elif parametros[0] == "f" and parametros[1] == "u":
        parametros[0] = "c"
        parametros[1] = "l"
    elif parametros[0] == "c" and parametros[1] == "l":
        parametros[0] = "f"
        parametros[1] = "d"
    elif parametros[0] == "f" and parametros[1] == "d":
        parametros[0] = "c"
        parametros[1] = "r"

'''
Gira hacia la izquierda en la matriz

    Parametros:
        parametros (lista): Lista que contiene los parametros de fila o columna, sentido de avance y posicion de la matriz

    Retorno:
        No tiene retorno.
'''
    
def avanzar(parametros, n):
    if parametros[0] == "c":
        if parametros[1] == "r":
            parametros[3] += n
        elif parametros[1] == "l":
            parametros[3] -= n

    elif parametros[0] == "f":
        if parametros[1] == "d":
            parametros[2] += n
        elif parametros[1] == "u":
            parametros[2] -= n

'''
Avanza en la matriz la posiciones indicadas

    Parametros:
        parametros (lista): Lista que contiene los parametros de fila o columna, sentido de avance y posicion de la matriz
        n (int): Cantidad de posiciones a avanzar

    Retorno:
        No tiene retorno.
'''

def pintar(matriz, parametros, color):
    matriz[parametros[2]][parametros[3]] = color

'''
Pinta, en la posicion actual de la matriz, el color indicado

    Parametros:
        matriz (lista): Matriz del pixelart
        parametros (lista): Lista que contiene los parametros de fila o columna, sentido de avance y posicion de la matriz
        color (tupla): Tupla con valores RGB

    Retorno:
        No tiene retorno.
'''

Matriz = []
parametros = ["c", "r", 0 , 0]
repetir_instrucciones = []

code = open("codigo.txt", 'r')
errores = open("errores.txt", "w")

error = False
repetir = False
lista_instrucciones = []

for linea in code:
    x = linea.strip() 
    lista_instrucciones.append(x) 

   
lista_instrucciones = list(enumerate(lista_instrucciones, 1))

if re.fullmatch(r"(Ancho [0-9]{1,})", lista_instrucciones[0][1]):
    Ancho = int(re.search(r"[0-9]{1,}", lista_instrucciones[0][1])[0])
    ancho(Ancho, Matriz)
    if re.fullmatch(r"(Color de fondo (Blanco|Negro|Rojo|Verde|Azul|RGB\((([0-1]?[0-9]{1,2}|2[0-5]{1,2}),){2}([0-1]?[0-9]{1,2}|2[0-5]{1,2})\)))", lista_instrucciones[1][1]):
        cdf = re.search(r"Blanco|Negro|Rojo|Verde|Azul|\((([0-1]?[0-9]{1,2}|2[0-5]{1,2}),){2}([0-1]?[0-9]{1,2}|2[0-5]{1,2})\)", lista_instrucciones[1][1])[0]
        color_de_fondo(parametro_de_color(cdf), Matriz, Ancho)
        if lista_instrucciones[2][1] == "":
            for linea in range(3,len(lista_instrucciones)):                
                if re.search(r"Repetir [0-9]{1,} veces", lista_instrucciones[linea][1]):
                    repeticiones = int(re.search(r"[0-9]{1,}", lista_instrucciones[linea][1])[0])
                    repetir = True 

                instrucciones = re.findall(r"(Avanzar [0-9]{1,})|(Avanzar)|(Derecha)|(Izquierda)|(Pintar (Negro|Rojo|Verde|Azul|Blanco|RGB\((([0-1]?[0-9]{1,2}|2[0-5]{1,2}),){2}([0-1]?[0-9]{1,2}|2[0-5]{1,2})\)))", lista_instrucciones[linea][1])
                if repetir == True:   
                    for i in instrucciones:
                        for j in i:
                            repetir_instrucciones.append(j)

                if repetir == True and re.search(r"}", lista_instrucciones[linea][1]):
                    repetir = False
                    x = 0
                    while x < repeticiones:
                        for i in repetir_instrucciones:
                            if re.search(r"Avanzar [0-9]{1,}", i):
                                avance = int(re.search(r"[0-9]{1,}", i)[0])
                                avanzar(parametros, avance)
                            elif re.search(r"Avanzar", i):
                                avance = 1
                                avanzar(parametros, avance)
                            if re.search(r"Derecha|Izquierda", i):
                                sentido = re.search(r"Derecha|Izquierda", i)[0]
                                if sentido == "Derecha":
                                    derecha(parametros)
                                elif sentido == "Izquierda":
                                    izquierda(parametros)
                            if re.search(r"(Pintar (Negro|Rojo|Verde|Azul|Blanco|RGB\((([0-1]?[0-9]{1,2}|2[0-5]{1,2}),){2}([0-1]?[0-9]{1,2}|2[0-5]{1,2})\)))", i):
                                color = re.search(r"Negro|Rojo|Verde|Azul|Blanco|\((([0-1]?[0-9]{1,2}|2[0-5]{1,2}),){2}([0-1]?[0-9]{1,2}|2[0-5]{1,2})\)", i)[0]
                                pintar(Matriz, parametros, parametro_de_color(color))
                        x += 1
                    repeticiones = 0
                    repetir_instrucciones = []
                    
                if repetir == False:
                    for i in instrucciones:
                        for j in i:
                            if re.search(r"Avanzar [0-9]{1,}", j):
                                avance = int(re.search(r"[0-9]{1,}", j)[0])
                                avanzar(parametros, avance)
                            elif re.search(r"Avanzar", j):
                                avance = 1
                                avanzar(parametros, avance)
                            if re.search(r"Derecha|Izquierda", j):
                                sentido = re.search(r"Derecha|Izquierda", j)[0]
                                if sentido == "Derecha":
                                    derecha(parametros)
                                elif sentido == "Izquierda":
                                    izquierda(parametros)
                            if re.search(r"(Pintar (Negro|Rojo|Verde|Azul|Blanco|RGB\((([0-1]?[0-9]{1,2}|2[0-5]{1,2}),){2}([0-1]?[0-9]{1,2}|2[0-5]{1,2})\)))", j):
                                color = re.search(r"Negro|Rojo|Verde|Azul|Blanco|\((([0-1]?[0-9]{1,2}|2[0-5]{1,2}),){2}([0-1]?[0-9]{1,2}|2[0-5]{1,2})\)", j)[0]
                                pintar(Matriz, parametros, parametro_de_color(color))

                if parametros[2] > Ancho or parametros[3] > Ancho:
                    print("Se produjo un error en " + lista_instrucciones[linea][1])
                    error = True
                    exit()

        else:
            errores.write(str(lista_instrucciones[2][0]) + " " +  lista_instrucciones[2][1] + "\n")
            error = True
    else:
        errores.write(str(lista_instrucciones[1][0]) + " " +  lista_instrucciones[1][1] + "\n")
        error = True
else:
    errores.write(str(lista_instrucciones[0][0]) + " " +  lista_instrucciones[0][1] + "\n")
    error = True

if not re.fullmatch(r"(Color de fondo (Blanco|Negro|Rojo|Verde|Azul|RGB\((([0-1]?[0-9]{1,2}|2[0-5]{1,2}),){2}([0-1]?[0-9]{1,2}|2[0-5]{1,2})\)))", lista_instrucciones[1][1]):
    errores.write(str(lista_instrucciones[1][0]) + " " +  lista_instrucciones[1][1] + "\n")
    error = True

if lista_instrucciones[2][1] != "":
    errores.write(str(lista_instrucciones[2][0]) + " " +  lista_instrucciones[2][1] + "\n")
    error = True

for v in range(len(lista_instrucciones)):
    if re.search(r" {2,}", lista_instrucciones[v][1]):
        errores.write(str(lista_instrucciones[v][0]) + " " +  lista_instrucciones[v][1] + "\n")
        error = True

if error == False:
    errores.write("No hay errores!")


print(Matriz)


code.close()
errores.close()


def MatrizAImagen(matriz, filename='pixelart.png', factor=10):

    matriz = np.array(matriz, dtype=np.uint8)
    np.swapaxes(matriz, 0, -1)

    N = np.shape(matriz)[0]

    img = Image.fromarray(matriz, 'RGB')
    img = img.resize((N*10, N*10), Image.Resampling.BOX)
    img.save(filename)

MatrizAImagen(Matriz)



