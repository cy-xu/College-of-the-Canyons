(define (caar x) (car (car x)))
(define (cadr x) (car (cdr x)))
(define (cdar x) (cdr (car x)))
(define (cddr x) (cdr (cdr x)))

; Some utility functions that you may find useful to implement.
(define (map proc items)
  (if (null? items) nil
    (cons (proc (car items)) (map proc (cdr items))))
)

(define (cons-all first rests)
  (cond
    ((null? rests) nil)
    (else (cons (append (cons first nil) (car rests)) (cons-all first (cdr rests))))
  )
)
  

(define (zip pairs)
  (list 
    (map (lambda (x) (car x)) pairs)
    (map (lambda (y) (cadr y)) pairs)
  )
)

;; Problem 17
;; Returns a list of two-element lists
(define (enumerate s)
  ; BEGIN PROBLEM 17
  (define original-len (length s))
    (define (recursive-enum s)
      (if (null? s) nil
        (cons (cons (- original-len (length s)) (cons (car s) nil)) (recursive-enum (cdr s)))))
    (recursive-enum s)
)
  ; END PROBLEM 17

;; Problem 18
;; List all ways to make change for TOTAL with DENOMS
(define (list-change total denoms)
  ; BEGIN PROBLEM 18
  (cond
    ((or (null? denoms) (< total 0)) nil)
    ((= total 0) (list nil))
    ((> (car denoms) total) (list-change total (cdr denoms)))
    (else (let ((denom (car denoms)) (rest (cdr denoms))) (append (cons-all denom (list-change (- total denom) denoms)) (list-change total rest))))
  )
)
  ; END PROBLEM 18

;; Problem 19
;; Returns a function that checks if an expression is the special form FORM
(define (check-special form)
  (lambda (expr) (equal? form (car expr))))

(define lambda? (check-special 'lambda))
(define define? (check-special 'define))
(define quoted? (check-special 'quote))
(define let?    (check-special 'let))

;; Converts all let special forms in EXPR into equivalent forms using lambda
(define (let-to-lambda expr)
  (cond ((atom? expr)
         ; BEGIN PROBLEM 19
         expr
         ; END PROBLEM 19
         )
        ((quoted? expr)
         ; BEGIN PROBLEM 19
         expr
         ; END PROBLEM 19
         )
        ((or (lambda? expr)
             (define? expr))
         (let ((form   (car expr))
               (params (cadr expr))
               (body   (cddr expr)))
           ; BEGIN PROBLEM 19
           (cons form (cons params (let-to-lambda body)))
           ; END PROBLEM 19
           ))
        ((let? expr)
         (let ((values (cadr expr))
               (body   (cddr expr)))
           ; BEGIN PROBLEM 19
           (cons (cons (quote lambda)
            (cons (car (zip (let-to-lambda values)))
            (let-to-lambda body)))
           (cadr (zip (let-to-lambda values))))

           ; END PROBLEM 19
           ))
        (else
         ; BEGIN PROBLEM 19
         (map let-to-lambda expr)
         ; END PROBLEM 19
         )))
