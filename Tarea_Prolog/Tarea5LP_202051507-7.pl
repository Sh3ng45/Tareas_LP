%%%%%%%%%%POSICIONES PARES E IMPARES%%%%%%%%%%
%Evalua una lista y retorna en P todos los elementos en posiciones pares de la lista y 
%en I todos los en posiciones impares
%% L: Lista a evaluar
%% P: Lista con numeros en posiciones pares de L
%% I: Lista con numeros en posiciones impares de L
%%%%
sepparimpar([],[],[]).
sepparimpar([Car|Cdr],[Car|P],I):-pos(X),A is X mod 2,A=0,i_pos,sepparimpar(Cdr,P,I),!.
sepparimpar([Car|Cdr],P,[Car|I]):-pos(X),B is X mod 2,B>0,i_pos,sepparimpar(Cdr,P,I),!.
:-dynamic pos/1.
pos(0).
%i_pos: Incrementa el numero de la posicion.
i_pos:-pos(X),Y is X + 1,retractall(pos(_)),assert(pos(Y)).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%%%%%%%%%%TODOS LOS NUMEROS EN UN RANGO%%%%%%%%%%
%Evalua que la lista contenga todos los numeros en el intervalo [X, Y)
%% L: Lista a evaluar.
%% X: Cota inferior del rango.
%% Y: Cota superior del rango.
%%%%
todosrango(L,X,Y):- Y1 is Y-1, between(X,Y1,M), \+member(M,L),!,fail.
todosrango(L,X,Y):- Y1 is Y-1, between(X,Y1,M), member(M,L),!.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%%%%%%%%%%RANGO MAXIMO%%%%%%%%%%
%[X, Y) es el intervalo mas grande posible para el cual se cumple que todos 
%los elementos en este intervalo estan en la lista L.
%% L: Lista a evaluar
%% X: Cota inferior del rango.
%% Y: Cota superior del rango.
%%%%

%pertenece: funcion auxiliar que evalua si X es miembro de la lista
pertenece(X,L):-member(X,L);(X1 is X-1,member(X1,L)).
%dentro: funcion auxiliar racursiva que evalua que los numeros de L esten dentro del rango
dentro([],_,_,_).
dentro([Car|Cdr],X,Y,L):-Car<Y,X1 is X+1,pertenece(X1,L),dentro(Cdr,X1,Y,L).
rangomax(L,X,Y):-member(X,L),max_list(L,M),M1 is M+1,Y = M1,dentro(L,X,Y,L),!.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%%%%%%%%%%CHICO GRANDE CHICO%%%%%%%%%%
%L es una lista de largo Y-X en donde todos sus elementos en posiciones pares estan 
%en el intervalo[X,(Y+X)/2) y todos sus elementos en posiciones impares estan en el intervalo
%[(Y+X)/2, Y).
%% L: Lista a evaluar
%% X: Cota inferior del rango.
%% Y: Cota superior del rango.
%%%%
chicograndechico([Car|Cdr],X,Y) :-Size is Y-X,length([Car|Cdr], Size),chicograndechico_help([Car|Cdr],X,Y,0),chicograndechico_help([Car|Cdr],X,Y,0).
%chicograndechico_help: funcion auxiliar recursiva que verifica si la posicion del elemento de L es par o impar
chicograndechico_help([], _, _,_).                                                                                           
chicograndechico_help([Car|Cdr],X,Y,Z) :-0 is mod(Z, 2),W is Z+1,Mayor is ceil(((Y+X)/2)-1),between(X,Mayor,Car),chicograndechico_help(Cdr,X,Y,W).
chicograndechico_help([Car|Cdr],X,Y,Z) :-1 is mod(Z, 2),W is Z+1,Menor is ceil((Y+X)/2),Y1 is Y-1,between(Menor,Y1,Car),chicograndechico_help(Cdr,X,Y,W).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%