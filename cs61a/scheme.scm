(define (append lst1 lst2)
  (cond 
    ((null? lst1) nil)
    (cons (car lst1) (append (cdr lst1) lst2))
  )
)