;Kevin Ponek
;May 24, 2016
;CS 122 - Architecture/Assembly Language
;Project 3
;while.pep
;Description: This project describes what the program would do.  We had to implement PEP8 assembly code to match
         ;the description.  The description was of a while loop that uses branch and compare to control the loop.
         ;Every loop through adds 1 to the value until it is greater than/equal to.

         BR      main
conditio:.BLOCK  2
inc:     .WORD   0

main:    STRO    msg1,d      ;ask for user input of condition value
         DECI    conditio,d  ;user input the condition value

while:   LDA     inc,d       ;Start of while ( true/false ) test
         CPA     conditio,d  ;End of true/false test
         BRGE    loopEnd
         DECO    inc,d       ;Start of code loop body
         STRO    msg2,d      
         DECO    conditio,d
         CHARO   "\n",i
         ADDA    1,i         ;code to change the variable that controls the loop
         STA     inc,d 
         BR      while       ;End of code loop body

loopEnd: DECO    inc,i       ;loop end, jump here when loop done
         STRO    msg3,d
         DECO    conditio,d
         STOP         

msg1:    .ASCII  "Input the condition value: \x00"
msg2:    .ASCII  " inside the loop is Less Than \x00"
msg3:    .ASCII  " equal or exceeds \x00"

         .END