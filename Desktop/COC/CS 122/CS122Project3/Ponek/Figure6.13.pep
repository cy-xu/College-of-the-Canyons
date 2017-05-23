;Kevin Ponek
;May 24, 2016
;CS 122 - Architecture/Assembly Language
;Project 3
;Figure6.13.pep
;Description: Change C code into PEP8 assembly code.  This exercise uses if/else if/else statements that require
         ;the use of branch statements to navigate through each statement check

         BR      main        ;#include <iostream>
ch:      .EQUATE 0           ;using namespace std

main:    SUBSP   1,i         ;int main() {
         CHARI   ch,s        ;char ch;
         LDBYTEA ch,s        ;cin >> ch;

if:      CPA     'A',i       ;if ((ch >= \'A\')
         BRLT    elseif
         CPA     'Z',i       ;&& (ch <= \'Z\')) {
         BRGT    elseif
         CHARO    'A',i      ;cout << \'A\'; 
         BR      end         ;}

elseif:  CPA     'a',i       ;else if ((ch >= \'a\')
         BRLT    else
         CPA     'z',i       ;&& (ch <= \'z\')){
         BRGT    else
         CHARO    'a',i      ;cout << \'a\'; 
         BR      end         ;}

else:    CHARO    '$',i      ;else { cout << \'$\' };

end:     CHARO   '\n',i      ;cout << endl;
         STOP                ;return 0;
         .END