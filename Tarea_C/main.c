#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#include "certamen.h"

int main(){

    char aux[128];
    int cont, a, marcador = 0, marcador_termino;
    
    FILE *archivo_certamen;
    archivo_certamen = fopen("certamen.txt", "r");

    if(archivo_certamen == NULL){
        printf("No se pudo abrir el archivo correctamente.\n");
        exit(1);
    }
    
    while(!feof(archivo_certamen)){
        fgets(aux,128,archivo_certamen);
        cont++;
    }
    for(int i=0; i<128; i++) aux[i] = '\0';

    rewind(archivo_certamen);

    char *registros[cont];
    char *pregunta[cont];

    for(int i = 0; !feof(archivo_certamen); i++){
        fgets(aux,128,archivo_certamen);
        if(i>1 && (aux == "AlternativaSimple" | aux == "AlternativaMultiple" | aux == "VerdaderoFalso" | aux == "Completar")){
            for(marcador; marcador<=marcador_termino; marcador++){
                if(registros[marcador] == "AlternativaSimple");
            }
                
        }
        registros[i] = aux;
        marcador_termino++;
    }

    a = strtol(registros[0], NULL, 10);

    crearCertamen(a);

    free(a);

    fclose(archivo_certamen);
    return 0;
}