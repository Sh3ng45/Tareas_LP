#lang scheme
(define (inverso lista n)
  (inverso_help lista (res n))
  )
;; Con el llamado a inverso_help encuentra todos los numeros menores a n y que no se encuentren en lista
;;
;; lista: lista con los numeros que no deben aparecer en la lista final
;; n: numero a evaluar 

(define (inverso_help lista n_list)
  (cond
    ((null? lista) n_list)
    ((eqv? (car lista) (car n_list)) (inverso_help (cdr lista) (cdr n_list)))
    (else (cons (car n_list) (inverso_help lista (cdr n_list))))
    )
  )
;; Utiliza recursion para encontrar todos los numeros que no estan en el parametro lista y retornarlos como una lista
;;
;; lista: lista con los numeros que no deben aparecer en la lista final
;; n_list: lista con todos los numeros menores al parametro n de la funcion inverso


(define (res n)
  (let resta((x 0))
    (cond
      ((= x n) '())
      (else (cons x (resta (+ x 1)))))
    )
  )
;; Retorna una lista con todos los numeros menores a n
;;
;; n: numero a evaluar


(define (umbral_simple lista umbral tipo)
  (cond
    ((eqv? tipo #\M) (umbral_simple_may lista umbral 0))
    ((eqv? tipo #\m) (umbral_simple_men lista umbral 0))
      )
  )
;; Dependiendo del tipo asignado, retorna una lista con las posiciones de los elementos mayores o menores que umbral,
;; usando la recursion simple
;;
;; lista: lista de numeros a evaluar
;; umbral: numero a comparar con elementos de la lista
;; tipo: instruccion que define si se quieren mayores o menores

(define (umbral_simple_may lista umbral n)
  (if (null? lista) '()
      (if (<= (car lista) umbral)
          (umbral_simple_may (cdr lista) umbral (+ n 1))
          (cons n (umbral_simple_may (cdr lista) umbral (+ n 1)))
          )
      )
  )
;; Funcion auxiliar usada en umbral_simple que retorna una lista con las posiciones de los elementos mayores a umbral
;;
;; lista: lista de elementos a evaluar
;; umbral: numero a comparar con elementos de la lista
;; n: contador que guarda la posicion actual

(define (umbral_simple_men lista umbral n)
  (if (null? lista) '()
      (if (>= (car lista) umbral)
          (umbral_simple_men (cdr lista) umbral (+ n 1))
          (cons n (umbral_simple_men (cdr lista) umbral (+ n 1)))
          )
      )
  )
;; Funcion auxiliar usada en umbral_simple que retorna una lista con las posiciones de los elementos menores a umbral
;;
;; lista: lista de elementos a evaluar
;; umbral: numero a comparar con elementos de la lista
;; n: contador que guarda la posicion actual


(define (umbral_cola lista umbral tipo)
  (filter number?(umbral_cola_aux lista umbral tipo 0))
  )
;; Hace el llamado a umbral_cola_aux y filtra la lista retornada de este
;;
;; lista: lista de numeros a evaluar
;; umbral: numero a comparar con elementos de la lista
;; tipo: instruccion que define si se quieren mayores o menores

(define (umbral_cola_aux lista umbral tipo n)
  (let ((i 0))
    (cond
      ((eqv? tipo #\M) (if (null? lista) '()
        (cons (verificar_may (car lista) umbral n i) (umbral_cola_aux (cdr lista) umbral tipo (+ n 1)))))
      ((eqv? tipo #\m) (if (null? lista) '()
        (cons (verificar_men (car lista) umbral n i) (umbral_cola_aux (cdr lista) umbral tipo (+ n 1)))))
  )))
;; Dependiendo del tipo asignado, retorna una lista con las posiciones de los elementos mayores o menores que umbral,
;; usando la recursion de cola
;;
;; lista: lista de numeros a evaluar
;; umbral: numero a comparar con elementos de la lista
;; tipo: instruccion que define si se quieren mayores o menores
;; n: contador que guarda la posicion actual en la lista

(define (verificar_men a b c d)
  (if (< a b)  (+ d c)
      '()))
;; funcion auxiliar que verifica los elementos de la lista menores a umbral
;;
;; a: cabeza de la lista
;; b: umbral
;; c: n
;; d: guarda la posicion del elemento que cumpla la condicion

(define (verificar_may a b c d)
  (if (> a b)  (+ d c)
      '()))
;; funcion auxiliar que verifica los elementos de la lista mayores a umbral
;;
;; a: cabeza de la lista
;; b: umbral
;; c: n
;; d: guarda la posicion del elemento que cumpla la condicion

(define (modsel_simple lista seleccion f)
  (modsel_simple_aux lista seleccion f 0)
  )
;; Con el llamado a modsel_simple_aux aplica f a un elemento de la lista si el indice de este esta en seleccion
;;
;; lista: lista de elementos a evaluar
;; seleccion: lista con indices de elementos del parametro lista que deben ser evaluados
;; f: funcion lambda a aplicar
  
(define (modsel_simple_aux lista seleccion f n)
  (if (null? lista) '()
      (if (= n (car seleccion)) (cons (verf_simple lista seleccion f n) (modsel_simple_aux (cdr lista) (cdr seleccion) f (+ n 1)))
          (cons (verf_simple lista seleccion f n) (modsel_simple_aux (cdr lista) seleccion f (+ n 1)))
          )
      )
  )
;; funcion auxiliar que aplica f a un elemento de la lista si el indice de este esta en seleccion, ademas crea 
;; una lista tanto con los elementos que cumplen como los que no, todo esto con recursion simple
;;
;; lista: lista de elementos a evaluar
;; seleccion: lista con indices de elementos del parametro lista que deben ser evaluados
;; f: funcion lambda a aplicar
;; n: contador que guarda el indice actual de la lista
      
(define (verf_simple lista seleccion f n)
  (if (= n (car seleccion)) (f (car lista))
      (car lista)
      )
  )
;; verifica si el indice de la lista esta en seleccion
;;
;; lista: lista de elementos a evaluar
;; seleccion: lista con indices de elementos del parametro lista que deben ser evaluados
;; f: funcion lambda a aplicar
;; n: contador que guarda el indice actual de la lista


(define (modsel_cola lista seleccion f)
  (modsel_cola_aux lista seleccion f 0)
  )
;; Con el llamado a modsel_cola_aux aplica f a un elemento de la lista si el indice de este esta en seleccion
;;
;; lista: lista de elementos a evaluar
;; seleccion: lista con indices de elementos del parametro lista que deben ser evaluados
;; f: funcion lambda a aplicar

(define (modsel_cola_aux lista seleccion f n)
   (if (null? lista) '()
       (cons (verf_cola lista seleccion f n) (modsel_cola_aux (cdr lista) seleccion f (+ n 1)))
    )
  )
;; funcion auxiliar que aplica f a un elemento de la lista si el indice de este esta en seleccion, ademas crea una lista tanto 
;; con los elementos que cumplen como los que no, todo esto con recursion de cola
;;
;; lista: lista de elementos a evaluar
;; seleccion: lista con indices de elementos del parametro lista que deben ser evaluados
;; f: funcion lambda a aplicar
;; n: contador que guarda el indice actual de la lista

(define (verf_cola lista seleccion f n)
  (if (null? seleccion) (car lista)
      (if (= n (car seleccion)) (f (car lista))
          (verf_cola lista (cdr seleccion) f n)
          )
      )
  )
;; verifica si el indice de la lista esta en seleccion
;;
;; lista: lista de elementos a evaluar
;; seleccion: lista con indices de elementos del parametro lista que deben ser evaluados
;; f: funcion lambda a aplicar
;; n: contador que guarda el indice actual de la lista


(define (estables lista umbral fM fm)
  (let ((M (umbral_cola_mod lista umbral #\M)) (m (umbral_cola_mod lista umbral #\m)))
    (list (may M umbral fM 0) (men m umbral fm 0))
    )
  )
;; retorna una lista con dos numeros, en donde el primero es la cantidad de numeros
;; mayores que el umbral que al aplicarles fM siguen siendo mayores que el umbral, y el
;; segundo es la cantidad de numeros menores que el umbral que al aplicarles fm siguen
;; siendo menores que el umbral.
;;
;; lista: lista de numeros a evaluar
;; umbral: numero a comparar
;; fM: funcion aplicada a numeros mayores que umbral
;; fm: funcion aplicada a numeros menores que umbral

(define (may M umbral fM n)
  (if (null? M) n
      (if (> (fM (car M)) umbral) (may (cdr M) umbral fM (+ n 1))
          (may (cdr M) umbral fM n)
          )
      )
  )
;; funcion auxiliar que evalua que numeros mayores a umbral siguen siendo mayores despues de aplicar fM
;;
;; M: lista de numeros mayores a umbral a los que se les aplicara fM
;; umbral: numero a evaluar
;; fM: funcion lambda aplicar
;; n: contador que cuenta los numeros mayores a umbral despues de que a estos se les aplicara fM

(define (men m umbral fm n)
  (if (null? m) n
      (if (< (fm (car m)) umbral) (men (cdr m) umbral fm (+ n 1))
          (men (cdr m) umbral fm n)
          )
      )
  )
;; funcion auxiliar que evalua que numeros menores a umbral siguen siendo menores despues de aplicar fM
;;
;; m: lista de numeros menores a umbral a los que se les aplicara fm
;; umbral: numero a comparar
;; fm: funcion lambda aplicar
;; n: contador que cuenta los numeros menores a umbral despues de que a estos se les aplicara fm


(define (umbral_cola_mod lista umbral tipo)
  (filter number?(umbral_cola_aux_mod lista umbral tipo))
  )
;; funcion umbral de cola que retorna los numeros de la lista mayores o menores a umbral, dependiendo del tipo que se especifique,
;; esto lo hace con el llamado a la funcion auxiliar umbral_cola_aux_mod
;;
;; lista: lista de numeros a evaluar
;; umbral: numero a comparar
;; tipo: instruccion que define si se quieren mayores o menores

  
(define (umbral_cola_aux_mod lista umbral tipo)
  (let ((i 0))
    (cond
      ((eqv? tipo #\M) (if (null? lista) '()
        (cons (verificar_may_mod (car lista) umbral) (umbral_cola_aux_mod (cdr lista) umbral tipo))))
      ((eqv? tipo #\m) (if (null? lista) '()
        (cons (verificar_men_mod (car lista) umbral) (umbral_cola_aux_mod (cdr lista) umbral tipo))))
  )))
;; funcion auxiliar umbral de cola modificada que retorna los numeros de la lista mayores o menores a umbral, dependiendo del tipo 
;; que se especifique
;;
;; lista: lista de numeros a evaluar
;; umbral: numero a comparar
;; tipo: instruccion que define si se quieren mayores o menores

(define (verificar_men_mod a b)
  (if (< a b) a
      '()))
;; retorna los numeros mayores a umbral 
;;
;; a: cabeza de lista
;; b: umbral

(define (verificar_may_mod a b)
  (if (> a b) a
      '()))
;; retorna los numeros menores a umbral 
;;
;; a: cabeza de lista
;; b: umbral


(define (query lista pos op params)
  (let ((select (get_list lista pos 0)))
    (cond
      ((= op 1) (umbral_simple select (car params) (cadr params)))
      ((= op 2) (modsel_simple select (car params) (eval (cadr params))))
      ((= op 3) (estables select (car params) (eval (cadr params)) (eval (caddr params))))
      )
    )
  )
;; Aplica op con los parametros necesarios de params en la lista en la posicion pos del parametro lista
;;
;; lista: lista de listas que contiene las listas sobre las que se trabajara
;; pos: posicion de la lista que se quiere trabajar
;; op: operacion que se realizara sobre la lista en la posicion pos del parametro lista
;; params: parametros necesarios para aplicar op

(define (get_list lista pos i)
  (if (= i pos) (car lista)
      (get_list (cdr lista) pos (+ i 1))
      )
  )
;; Funcion auxiliar de query que retorna la lista en la posicion pos del parametro lista
;;
;; lista: lista sobre la que se busca la lista interna que se quiere
;; pos: posicion de la lista en el parametro lista
;; i: contador que evalua cuando se esta en la posicion pos de la lista

 