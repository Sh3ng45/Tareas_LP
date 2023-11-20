#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include "certamen.h"
#define correcta true
#define incorrecta false

/*
Crea un nuevo certamen vacio

    Parametros :
        n_preguntas (int) : Cantidad de preguntas

    Retorno :
        certamen (tCertamen*) : Estructura tipo tCertamen
*/

tCertamen* crearCertamen(int n_preguntas){
    tCertamen* certamen = malloc(sizeof(tCertamen));
    certamen->n_preguntas = n_preguntas;
    certamen->preguntas = (tPregunta*) malloc(sizeof(tPregunta) * n_preguntas);

    return certamen;
}

/*
Crea una pregunta con el enunciado y funcion de revision dados

    Parametros :
        tipo (char*) : Tipo de pregunta
        enunciado (void*) : enunciado de la pregunta
        revisar(void*, void*) (bool) : funcion de revision de la pregunta

    Retorno :
        pregunta (tPregunta*) : Estructura tipo tPregunta
*/

tPregunta* crearPregunta(char* tipo, void* enunciado, bool revisar(void*, void*)){
    tPregunta* pregunta;
    *pregunta->tipo = *tipo;
    pregunta->enunciado = enunciado;
    pregunta->revisar = revisar;

    if(tipo == "AlternativaSimple"){
        tEnunciadoAlternativa* a_simple = (tEnunciadoAlternativa*) malloc(sizeof(tEnunciadoAlternativa));
        *a_simple->enunciado = *(char*)enunciado;
    }
    else if(tipo == "AlternativaMulltiple"){
        tEnunciadoAlternativaMultiple* a_multiple = (tEnunciadoAlternativaMultiple*) malloc(sizeof(tEnunciadoAlternativaMultiple));
        *a_multiple->enunciado = *(char*)enunciado;
    }
    else if(tipo == "VerdaderoFalso"){
        tEnunciadoVerdaderoFalso* vf = (tEnunciadoVerdaderoFalso*) malloc(sizeof(tEnunciadoVerdaderoFalso));
        *vf->enunciado = *(char*)enunciado;
    }
    else if(tipo == "Completar"){
        tEnunciadoCompletar* comp = (tEnunciadoCompletar*) malloc(sizeof(tEnunciadoCompletar));

    }

    return pregunta;
}

/*
Asigna la pregunta a la posicion n_pregunta del certamen

    Parametros :
        certamen (tCertamen*) : Estructura del certamen
        n_pregunta (int) : numero de pregunta
        pregunta (tPregunta*) : Estructura de la pregunta a asignar

    Retorno :
        (void) : no tiene retorno
*/

void asignarPregunta(tCertamen* certamen, int n_pregunta, tPregunta* pregunta){
    certamen->preguntas[n_pregunta] = *pregunta;                              
}

/*
Retorna la pregunta en la posicion n_pregunta del certamen

    Parametros :
        certamen (tCertamen*) : Estructura del certamen
        n_pregunta (int) : numero de pregunta a leer

    Retorno :
        pregunta (tPregunta) : pregunta a leer
*/

tPregunta leerPregunta(tCertamen* certamen, int n_pregunta){
    return certamen->preguntas[n_pregunta];
}

/*
Retorna el numero de respuestas correctas que tiene el certamen

    Parametros :
        certamen (tCertamen) : Estructura del certamen

    Retorno :
        correctas (int) : cantidad de respuestas correctas del certamen
*/

int nCorrectasCertamen(tCertamen certamen){
    int correctas;
    for(int i = 1; i <= certamen.n_preguntas; i++){
        if(certamen.preguntas[i].revisar == correcta){correctas++;}
    }
    return correctas;
}

/*
Retorna el numero de preguntas en un certamen

    Parametros :
        certamen (tCertamen) : Descripcion del parametro a

    Retorno :
        n_preguntas (int) : numero de preguntas en el certamen
*/

int largoCertamen(tCertamen certamen){
    return certamen.n_preguntas;
}

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros :
        enunciado (void*) : enunciado a revisar
        respuesta (void*) : respuesta a revisar

    Retorno :
        (bool) : booleano True o False
*/

bool revisarAlternativaSimple(void* enunciado, void* respuesta);

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros :
        enunciado (void*) : enunciado a revisar
        respuesta (void*) : respuesta a revisar

    Retorno :
        (bool) : booleano True o False
*/

bool revisarAlternativaMultiple(void* enunciado, void* respuesta);

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros :
        enunciado (void*) : enunciado a revisar
        respuesta (void*) : respuesta a revisar

    Retorno :
        (bool) : booleano True o False
*/

bool revisarVerdaderoFalso(void* enunciado, void* respuesta);

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros :
        enunciado (void*) : enunciado a revisar
        respuesta (void*) : respuesta a revisar

    Retorno :
        (bool) : booleano True o False
*/

bool revisarCompletar(void* enunciado, void* respuesta);