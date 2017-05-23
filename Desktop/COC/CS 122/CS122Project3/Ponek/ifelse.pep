;Kevin Ponek
;May 24, 2016
;CS 122 - Architecture/Assembly Language
;Project 3
;ifelse.pep
;Description: This project describes what the program would do.  We had to implement PEP8 assembly code to match
         ;the description.  The description was of an if/else statement that uses branch to navigate through the statements.


                 BR      main 
conditio:        .BLOCK 2    
input:           .BLOCK 2

main:            STRO    msg1,d       ;user input the condition value
                 DECI    conditio,d   
                 STRO    msg2,d       ;user input the input value
                 DECI    input,d      

if:              LDA     input,d      ;Start of if ( true/false ) test
                 CPA     conditio,d   
                 BRLT    else         ;End true/false test 
                 DECO    input,d      ;Start of code to execute when true
                 STRO    msg3,d
                 DECO    conditio,d
                 BR      end          ;End of code to execute when true

else:            DECO    input,d      ;Start of code to execute when false
                 STRO    msg4,d
                 DECO    conditio,d   ;End of code to execute when false

end:             STOP             
msg1:            .ASCII  "Input the condition value: \x00"
msg2:            .ASCII  "Input the user input value: \x00"
msg3:            .ASCII  " is Greater Than or Equal to \x00"
msg4:            .ASCII  " is Less Than \x00"

                 .END