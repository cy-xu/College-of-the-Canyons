(define (find s predicate)
	(cond
		((null? s) #f)
		((predicate (car s)) (car s))
		(else (find (cdr-stream s) predicate))
	)
)

(define (scale-stream s k)
	(if (null? s)
		s
		(cons-stream (* k (car s)) (scale-stream (cdr-stream s) k))
	)
	
)

(define (has-cycle s)
	(define (seen s2)
		(cond
			((null? s2) #f)
			((eq? s (cdr-stream s2)) #t)
			(else (seen (cdr-stream s2)))
		)
	)
	(seen s)
)
(define (has-cycle-constant s)
  'YOUR-CODE-HERE
)
