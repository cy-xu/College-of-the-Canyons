;Kevin Ponek
;May 24, 2016
;CS 122 - Architecture/Assembly Language
;Project 3
;Figure6.11.pep
;Description: Change C code into PEP8 assembly code.  This exercise uses if/else statements that require
         ;the use of branch statements to navigate through each statement check to print if the input value
         ;is even or odd (calculated by the modulus operator).

         BR      main        ;#include <iostream>
                             ;using namespace std;
number:  .EQUATE 0           

main:    DECI    number,s    ;int main() {
         LDA     number,s    ;int number;
                             ;cin >> number;

if:      ANDA    0x0001,i    ;if (number % 2 == 0) {
         STA     number,s
         CPA     0,i
         BRNE    else
         STRO    msg1,d      ;cout << \"Even\n\";
         CHARO   '\n',i      
         STOP                ;}

else:    STRO    msg2,d      ;else {
         CHARO   '\n',i      ;cout << \"Odd\n\";
                             ;}
         STOP                ;return 0;
msg1:    .ASCII  "Even\x00"
msg2:    .ASCII  "Odd\x00"
         .END                ;}
        