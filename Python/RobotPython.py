from pickle import FALSE, TRUE
import re
from tokenize import triple_quoted

#Lectura del archivo
f= open("Example2.rob", "r")

text=""
for x in f:
    text+=x

#Eliminación de espacios y tabulaciones
text= text.replace(" ", "")
text= text.replace("\t", "")

#Ejemplo
""" text="PROG\nVAR z;\nPROC hola()\n{\nz:=2\n}\nCORP\n{\nz:=3;hola()\n}\nGORP" """

#Reemplazo filas
text=text.replace("PROG", "P")
text=text.replace("GORP", "G")
text=text.replace("var", "A")
text=text.replace("PROC", "R")
text=text.replace("CORP", "C")
text=text.replace("canWalk", "N")
text=text.replace("walk(", "K(")
text=text.replace("jumpTo", "J")
text=text.replace("jump(", "W(")
text=text.replace("drop(", "W(")
text=text.replace("grab(", "W(")
text=text.replace("get", "W")
text=text.replace("free(", "W(")
text=text.replace("pop(", "W(")
text=text.replace("veer", "V")
text=text.replace("look", "L")
text=text.replace("isfacing", "S")
text=text.replace("isValid", "I")
text=text.replace("not", "T")

#Arreglo por saltos de lineas
arreglo=list(map(str, text.split("\n")))

arreglo=list(filter(None, arreglo))

#Estado
prog=False
gorp=False
error=False
print(arreglo)

#Variables
variables=[]

#Metodos
metodos=[]

#Dir
dir=["north", "south", "east", "west"]
dir2=["front", "right", "left", "back"]
dir3=["right", "left", "around"]
ins=["walk", "jump", "grab", "pop", "pick", "free", "drop"]


#Funciones para revisar sintaxis
#Retornan True si todo está bien

#Revisa la declaración de variables
def checkA(fila):

    retorno=True
    #Espacio después de la A
    if not (fila.startswith("A")):
        return False
    fila= fila[1:]

    #Nombres de las variables separados por coma
    nombres= fila.split(",")
    for i in range(len(nombres)):
        if i== (len(nombres)-1):
            nombres.append(nombres[i][1:])
            nombres[i]=nombres[i][:1]
            #Termina por un ;
            if not (nombres[i+1]==";"):
                retorno=False
        #Son caracteres alfanuméricos
        if not(nombres[i].isalnum()):
            retorno=False
            break
        #El primer caracter es una letra
        if not(nombres[i][:1].isalpha()):
            retorno=False
            break

        #Agrega variables al arreglo
        variables.append(nombres[i])
    return retorno

#Revisa la declaración de los métodos
def checkC(bloque):
    print(bloque)

    #Espacio después de la R
    if not (bloque.startswith("R")):
        return False
    
    #Paréntesis apertura
    paren= bloque.find("(")
    if not(paren>0):
        return False
    else:
        nomFun=bloque[1:paren]
        #Son caracteres alfanuméricos
        if not(nomFun.isalnum()):
            return False
        #El primer caracter es una letra
        if not(nomFun[:1].isalpha()):
            return False

    #Termina con paréntesis
    paren2= bloque.find(")")
    if not(paren2>0):
        return False

    param=bloque[paren+1: paren2+1]
    #Agrega al arreglo de métodos el nombre y la cantidad de parémtros
    if param.startswith(")"):
        metodos.append((nomFun, 0))
    else:
        param=param[:len(param)-1]
        param= param.split(",")

        #Agregar método
        metodos.append((nomFun, len(param)))
    
    #Quita la declaración del método y lo saltos de linea
    ajustado=bloque[paren2+1:]
    ajustado=ajustado[:-1]
    ajustado= ajustado.replace("\n", "")

    #Hace splits por ;
    ajustado=ajustado.split(";")
    
    return checkBloque(ajustado, param)

#Revisa los comandos K
def checkK(valor, param):

    #Paréntesis
    paren= valor.find("(")
    if not(paren>0):
        return False
    if not(valor.endswith(")")):
        return False
    
    #Parámetros
    param2= valor[paren+1:(len(valor)-1)]
    param2=param2.split(",")

    #Casos del walk
    if(len(param2)==1):
        param2= param2[0]
        return checkn(param2, param)
    elif len(param2)==2:
        if activado2==True:
            if not((param2[0] in dir) or (param2[0] in dir2)) :
                return False
        #Revisa los parámetros
        if (not(checkn(param2[1], param))):
            return False
    else:
        return False
    
    return True

#Revisa los comandos W
def checkW(valor,param):

    #Paréntesis
    paren= valor.find("(")
    if not(paren>0):
        return False
    if not(valor.endswith(")")):
        return False

    #Parámetros
    param2= valor[paren+1:(len(valor)-1)]
    param2=param2.split(",")
    param2= param2[0]

    return checkn(param2, param)

#Revisa los parámetros
def checkn(valor, param):

    #Es un número, Es un parámetro de la fun original, Es una variable
    if not(valor.isnumeric() or valor in param or valor in variables):
        return False

    return True

#Revisa los comandos J
def checkJ(valor, param):

    #Paréntesis
    paren= valor.find("(")
    if not(paren>0):
        return False
    if not(valor.endswith(")")):
        return False

    #Parámetros
    param2= valor[paren+1:(len(valor)-1)]
    param2=param2.split(",")

    #Revisa que tenga 2 parámetros 
    if not(len(param2)==2):
        return False
    else:
        #Revisa los parámetros
        return (checkn(param2[0], param) and checkn(param2[1], param))

#Revisa los comandos V
def checkV(valor):
    #Paréntesis
    paren= valor.find("(")
    if not(paren>0):
        return False
    if not(valor.endswith(")")):
        return False

    #Parámetros
    param2= valor[paren+1:(len(valor)-1)]
    param2=param2.split(",")
    param2= param2[0]

    #Si se está revisando el bloque de instrucciones se debe verificar que los parámetros
    #sean válidos.
    if activado2==True:
        if not(param2 in dir3):
            return False
    return True

#Revisa los comandos L
def checkL(valor):
    #Paréntesis
    paren= valor.find("(")
    if not(paren>0):
        return False
    if not(valor.endswith(")")):
        return False

    #Parámetros
    param2= valor[paren+1:(len(valor)-1)]
    param2=param2.split(",")
    param2= param2[0]

    #Si se está revisando el bloque de instrucciones se debe verificar que los parámetros
    #sean válidos.
    if activado2==True:
        if not(param2 in dir):
            return False
    return True

#Revisa los comandos I
def checkI(valor):

    #Paréntesis
    paren= valor.find("(")
    if not(paren>0):
        return False
    if not(valor.endswith(")")):
        return False
    
    #Parámetros
    param2= valor[paren+1:(len(valor)-1)]
    param2=param2.split(",")

    lista=[]
    #Casos
    #Revisa que haya 2 parámetros
    if not(len(param2))==2:
        return False
    else:
        #Si se está revisando el bloque de instrucciones se debe verificar que los parámetros
        #sean válidos.
        if activado2==True:
            if not(param2[0] in ins) :
                return False
        #Revisa los parámetros
        if not(checkn(param2[1], lista)):
            return False
    
    return True

#Revisa las estructuras de control If
def checkIf(valor, param):
    
    #Encontrar paréntesis
    paren= valor.find("(")
    cor= valor.find("{")
    paren2=cor-2
    if (paren<0 or paren2<0):
        return False

    #Condición
    cond= valor[paren+1: paren2 +1]
    if not(checkCond(cond, param)):
        return False
    
    #fi
    if not(valor.endswith("fi")):
        return False
    
    #Revisa los corchetes
    cor= valor.find("{")
    cor2= valor.rfind("}")
    if (cor<0 or cor2<0):
        return False
    blo=valor[cor:cor2+1]
    blo= blo.replace("\n", "")

    #Revisa el caso de que sea un if con else
    if("else" in valor):
        blo=blo.split("else")
        #Revisa el bloque de instrucciones del if y del else
        if (not(checkBloque(blo[0].split(";"), param) and checkBloque(blo[1].split(";"), param))):
            return False
    #Revisa el caso de que sea un if sin else
    else:
        blo=blo.split(";")
        #Revisa el bloque de instrucciones del if
        if(not checkBloque(blo, param)):
            return False
    return True

#Revisa las condiciones
def checkCond(valor, param):
    #Revisa las condiciones que pueden ir dentro de los if's y los while's
    if(valor.startswith("S")):
        return checkK(valor, param)
    elif(valor.startswith("I")):
        return  checkI(valor)
    elif(valor.startswith("N")):
        return checkK(valor, param)
    elif(valor.startswith("T")):
        valor= valor[2: len(valor)-1]
        return checkCond(valor, param)
    else:
        return False

#Revisa las estructuras de control While
def checkWhile(valor, param):

    #Encontrar paréntesis
    paren= valor.find("(")
    paren2=valor.find(")")
    if (paren<0 or paren2<0):
        return False

    #Condición
    cond= valor[paren+1: paren2 +1]
    if not(checkCond(cond, param)):
        return False
    
    #od
    if not(valor.endswith("od")):
        return False
    
    #Revisa los corchetes
    cor= valor.find("{")
    cor2= valor.rfind("}")
    if (cor<0 or cor2<0):
        return False
    blo=valor[cor:cor2+1]
    blo= blo.replace("\n", "")

    #Revisa el bloque de instrucciones
    blo=blo.split("do")
    if (not(checkBloque(blo[0].split(";"), param))):
        return False

    return True

#Revisa las estructuras de control Repeat
def checkRepeat(valor, param):

    #Revisa que termine por per
    if not(valor.endswith("per")):
        return False
    
    #Revisa los corchetes
    cor= valor.find("{")
    cor2= valor.rfind("}")
    if (cor<0 or cor2<0):
        return False

    n=valor[cor-1:cor]

    #Revisa los parámetros
    if(not checkn(n, param)):
        return False

    blo=valor[cor:cor2+1]
    blo= blo.replace("\n", "")
    blo=blo.split(";")

    #Revisa el bloque de instrucciones
    if(not checkBloque(blo, param)):
        return False
        
    return True

#Revisa los llamados a los métodos
def checkMetodos(valor):

    #Paréntesis apertura
    paren= valor.find("(")
    if not(paren>0):
        return False
    #Termina con paréntesis
    paren2= valor.find(")")
    if not(paren2>0):
        return False
    
    param=valor[paren+1: paren2]

    cant=0
    #Separados por comas
    if not(param == ""):
        param= param.split(",")
        cant= len(param)
    
    #Genera una tupla con la cantidad de parámetros y el nombre del método
    nombre= valor[:paren]
    tupla=(nombre, cant)

    #Revisa que el método llamado ya haya sido declarado y que tenga
    #la cantidad de parámetros correcta
    if not(tupla in metodos):
        return False
    
    return True

#Revisa las asignaciones
def checkAsig(valor):

    #Dos puntos, igual
    puntos= valor.find(":")
    igual=valor.find("=")

    if not(puntos==igual-1):
        return False

    if (puntos==-1 or igual ==-1):
        return False
    
    #Obtiene el valor al que se le asigna a la variable
    valorsito= valor[igual+1:]

    #Revisa que el valor sea numérico
    if not ( valorsito.isnumeric()):
        return False

    return True    

#Revisa los bloques de instrucciones
def checkBloque(ajustado, param):

    #Corchete apertura
    if not (ajustado[0].startswith("{")):
        return False
    
    #Corchete cierre
    if not (ajustado[len(ajustado)-1].endswith("}")):
        return False
    
    ajustado[0]=ajustado[0][1:]
    ajustado[len(ajustado)-1]=ajustado[len(ajustado)-1][:-1]

    parte=""
    control=[False, ""]
    cantidadIf=0
    cantidadWhi=0
    cantidadRe=0

    for i in range(len(ajustado)):

        #Cantidades
        if( "if" in ajustado[i]):
            ifs=ajustado[i].count("if")
            cantidadIf=cantidadIf +ifs
        if("fi" in ajustado[i]):
            ifs=ajustado[i].count("fi")
            cantidadIf=cantidadIf -ifs
        if( "while" in ajustado[i]):
            whis=ajustado[i].count("while")
            cantidadWhi=cantidadWhi +whis
        if("od" in ajustado[i]):
            whis=ajustado[i].count("od")
            cantidadWhi=cantidadWhi -whis
        if("repeatTimes" in ajustado[i]):
            res=ajustado[i].count("repeatTimes")
            cantidadRe=cantidadRe + res
        if("per" in ajustado[i]):
            res=ajustado[i].count("per")
            cantidadRe=cantidadRe - res

        #Comandos
        if (control[0]==False):
            """ if ( (i< len(ajustado)-3) and ( len(ajustado) >1)):
                if not(ajustado[i].endswith(";")):
                    return False
                ajustado[i]=ajustado[i][:-1] """
            if(ajustado[i].startswith("K")):
                if not(checkK(ajustado[i], param)):
                    return False
            elif(ajustado[i].startswith("W")):
                if not(checkW(ajustado[i], param)):
                    return False
            elif(ajustado[i].startswith("J")):
                if not(checkJ(ajustado[i], param)):
                    return False
            elif(ajustado[i].startswith("V")):
                if not(checkV(ajustado[i])):
                    return False
            elif(ajustado[i].startswith("L")):
                if not( checkL(ajustado[i])):
                    return False
            elif(ajustado[i].startswith("I") or ajustado[i].startswith("S") or ajustado[i].startswith("N") or ajustado[i].startswith("T")):
                if not( checkCond(ajustado[i], param)):
                    return False
            elif (ajustado[i].startswith("if")):
                control=[True, "if"]
            elif (ajustado[i].startswith("while")):
                control=[True, "while"]
            elif (ajustado[i].startswith("repeatTimes")):
                control=[True, "repeat"]
            else:
                empieza=False
                for x in variables:
                    if(ajustado[i].startswith(x + ":=")):
                        empieza=True
                if(empieza==True):
                    if not(checkAsig(ajustado[i])):
                        return False
                elif not(checkMetodos(ajustado[i])):
                    return False

        if control[0]==True:
            parte=parte + ajustado[i] + ";"

            if (cantidadIf==0 and control[1]=="if"):
                parte=parte[:-1]
                if not(checkIf(parte, param)):
                    return False
                control=[False, ""]
                parte=""
                cantidadWhi=0
                cantidadRe=0

            elif (cantidadWhi==0 and control[1]=="while"):
                parte=parte[:-1]
                if not(checkWhile(parte, param)):
                    return False
                control=[False, ""]
                parte=""
                cantidadIf=0
                cantidadRe=0
            
            elif (cantidadRe==0 and control[1]=="repeat"):
                parte=parte[:-1]
                if not(checkRepeat(parte, param)):
                    return False
                control=[False, ""]
                parte=""
                cantidadIf=0
                cantidadWhi=0
    
    if not(cantidadIf==0 and cantidadWhi==0 and cantidadRe==0):
        return False
    return True

#Revisa el bloque de instrucciones
def checkIns(bloque):

    ajustado= bloque.replace("\n", "")
    ajustado=ajustado.split(";")
    
    #Revisa las instrucciones 
    return checkBloque(ajustado, [])

#Revisa el estdo del programa
def checkEstado():
    return prog==True and gorp==False

#Inicio bloque de código
activado=False
bloque=""
activado2=False

#Revisión general sintaxis
for x in range(len(arreglo)):

    fila= arreglo[x]

    #Se activa si la linea pertenece a una declaración de un método
    if(activado==True):
        bloque= bloque + "\n" + fila
    
    #Se activa si la linea pertenece al bloque de instrucciones
    if(activado2==True):
        bloque= bloque + "\n" + fila

    #Revisa PROG
    if(fila== "P"):
        if prog==True:
            error=True
            break
        prog=True
        if not checkEstado():
            error=True
            break   

    #Revisa GORP 
    elif(fila=="G"):
        if not prog==True:
            error=True
            break
        gorp=True
        prog=False

    #Revisa la declaración de variables
    elif( fila.startswith("A")):
        if not checkEstado():
            error=True
            break    
        if not checkA(fila):
            error=True
            break
    
    #Revisa el PROC
    elif(fila.startswith("R")):
        if activado==True:
            error=True
            break
        if not checkEstado():
            error=True
            break 
        activado=True
        bloque=fila

    #Revisa el CORP
    elif(fila.startswith("C")):
        if not checkEstado():
            error=True
            break 
        #Se manda a revisar el bloque
        if(activado==True):
            if not(checkC(bloque)):
                error=True
                break
        else:
            error=True
            break 
        activado=False
        bloque=""

    #Se revisa si es el comienzo del bloque de instrucciones general
    elif(fila.startswith("{") and activado==False):
        bloque=fila
        activado2=True

    #Se revisa si es el final del bloque de instrucciones general
    elif(fila.startswith("}") and activado==False):
        if not(checkIns(bloque)):
                error=True
                break

    #Revisa si la linea no cumple con ninguna condición
    elif(activado ==False and activado2==False):
        error=True
        break
        
#Revisión del estado final
if not (gorp==True and prog==False):
    error=True
if activado== True:
    error=True

#Imprime el mensaje final de la validación
if error:
    print("La sintaxis es incorrecta.")
else:
    print("Aprobado.")
