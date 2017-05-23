(define (append lst1 lst2)
  (cond 
    ((null? lst1) lst2)
    (else (cons (car lst1) (append (cdr lst1) lst2)))
  )
)

(define (reverse lst)
	(cond
		((null? (cdr lst)) (car lst))
		(else (append (reverse (cdr lst)) (car lst)))
	)
)

(define (combine-streams s1 s2 combiner);s1 and s2 infinite streams....... combiner is function w/ two args that returns a stream that has elems of s1 and s2 added together 
	(cons-stream (combiner (car s1) (car s2)) (combine-streams (cdr-stream s1) (cdr-stream s2) combiner))
)

(define (loopify stream)
	(cons-stream stream (loopify stream))
)